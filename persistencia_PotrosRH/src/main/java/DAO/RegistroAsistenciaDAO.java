package DAO;

import Conexion.Conexion;
import Entidades.Empleado;
import Entidades.Nomina;
import Entidades.RegistroAsistencia;
import Exceptions.AccesoDatosException;
import Interfaces.IRegistroAsistenciaDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase para métodos de Persistencia con entidades RegistroAsistencia.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class RegistroAsistenciaDAO implements IRegistroAsistenciaDAO {
    
    private final MongoCollection<RegistroAsistencia> RegistroAsistenciaCollection;
    private final MongoCollection<Nomina> NominaCollection;
    public RegistroAsistenciaDAO() {
        MongoDatabase database = Conexion.getDatabase();
        this.RegistroAsistenciaCollection = database.getCollection("registro_asistencia", RegistroAsistencia.class);
        this.NominaCollection=database.getCollection("nomina", Nomina.class);
    }
    
    
    /**
     * Obtiene los días trabajados de un empleado, cuyo período de tiempo
     * se ubica entre el día de la última nómina generada, hasta
     * el día de hoy.Se utiliza para generar nuevas nóminas.
     * @param empleado Empleado del cual de desea obtener sus cantidad de días trabajados.
     * @param fechaInicio Fecha de inicio del período de trabajo.
     * @return Número de días trabajados, desde su última nómina generada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Integer obtenerDiasTrabajados(Empleado empleado, LocalDate fechaInicio) throws AccesoDatosException {
    try {
        
        ObjectId empleadoId = empleado.getId();
        
        Bson filtroAsistencias = Filters.and(
            Filters.eq("empleadoId", empleadoId),
            Filters.gte("fechaAsistencia", fechaInicio)
        );

        List<RegistroAsistencia> asistencias = RegistroAsistenciaCollection
            .find(filtroAsistencias)
            .into(new ArrayList<>());

        Set<LocalDate> diasUnicos = asistencias.stream()
            .map(RegistroAsistencia::getFechaAsistencia)
            .collect(Collectors.toSet());

        return diasUnicos.size();

    } catch (Exception e) {throw new AccesoDatosException("Error al obtener días trabajados", e);}
}

    /**
     * Obtiene las horas trabajadas de un empleado, cuyo período de tiempo
     * se ubica entre el día de la última nómina generada, hasta
     * el día de hoy.Se utiliza para generar nuevas nóminas.
     * @param empleado Empleado del cual de desea obtener sus cantidad de horas trabajadas.
     * @param fechaInicio Fecha de inicio del período de trabajo.
     * @return Horas trabajadas del empleado, desde su última nómina generada.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public Double obtenerHorasTrabajadas(Empleado empleado, LocalDate fechaInicio) throws AccesoDatosException {
        try {
            /*
                Etapa $match.
                Obtiene los registros de asistencia que coincidan con
                el id del empleado recibido, la fecha de asistencia
                sea mayor o igual que la fecha de inicio recibida, y
                el registro de asistencia cuente con una hora de salida
                existente (asistencia total del empleado).
            */
            Bson match = Aggregates.match(Filters.and(
                    Filters.eq("empleadoId", empleado.getId()),
                    Filters.gte("fechaAsistencia", fechaInicio),
                    Filters.and(
                            Filters.ne("horaSalida", null),
                            Filters.exists("horaSalida", true)
                    )
            ));
            /*
                Etapa $group.
                Resta la hora de salida menos la hora de entrada, y suma
                el resultado en un nuevo atributo llamado resta.
            */
            Bson group = new Document("$group", new Document("_id", null)
                    .append("resta", new Document("$sum", new Document("$dateDiff",
                            new Document("startDate", "$horaEntrada")
                                    .append("endDate", "$horaSalida")
                                    .append("unit", "second")
                    )))
            );
            /*
                Estapa project.
                Obtiene únicamente el atributo resta generado en la
                etapa anterior.
            */
            Bson project = Aggregates.project(
                    Projections.fields(
                            Projections.include("resta"),
                            Projections.excludeId()
                    )
            );
            // Pipeline completo con las tres estapas.
            List<Bson> pipeline = Arrays.asList(match, group, project);
            
            // Ejecuta la consulta y la guarda en un Documento. Debido a que se extrae un solo valor, no es necesario un DTO de salida.
            Document resultado = RegistroAsistenciaCollection.aggregate(pipeline, Document.class).first();
            
            if(resultado != null)
                // Retorna el resultado redondeado a 2 decimales al valor superior.
                return new BigDecimal(resultado.getLong("resta").doubleValue() / 3600).setScale(2, RoundingMode.CEILING).doubleValue();
             else
                return null;
            
        } catch (Exception e) {throw new AccesoDatosException("Error al obtener las horas trabajadas", e);}
    }
    /**
     * Obtiene la fecha del primer día de trabajo de un empleado, 
     * el cual vendría siendo su primer registro de asistencia.
     * Se utiliza para generar la primera nómina de un empleado.
     * @param empleado Empleado del cual se desea obtener la fecha de su primer día de trabajo.
     * @return Fecha del primer día de trabajo del empleado.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public LocalDate obtenerFechaPrimerDiaTrabajo(Empleado empleado) throws AccesoDatosException {
        try {
            Bson filtro = Filters.eq("empleadoId", empleado.getId());

            RegistroAsistencia primerRegistro = RegistroAsistenciaCollection
                .find(filtro)
                .sort(Sorts.ascending("fechaAsistencia"))
                .limit(1)
                .first();

            if (primerRegistro != null) {
                return primerRegistro.getFechaAsistencia();
            } else {
                return null; 
            }

        } catch (Exception e) {throw new AccesoDatosException("Error al obtener la fecha del primer día de trabajo del empleado", e);}
    }
    /**
     * Registra la entrada de un empleado.
     * @param empleado Empleado que registra su entrada.
     * @param fechaAsistencia Fecha de la asistencia.
     * @param horaEntrada Hora de entrada.
     * @return VERDADERO si se registró la entrada, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public boolean registrarEntrada(Empleado empleado, LocalDate fechaAsistencia, LocalTime horaEntrada) throws AccesoDatosException {
        try {
            Bson filtro = Filters.and(
                Filters.eq("empleadoId", empleado.getId()),
                Filters.eq("fechaAsistencia", fechaAsistencia),
                Filters.eq("horaSalida", null) 
            );
            RegistroAsistencia registroExistente = RegistroAsistenciaCollection.find(filtro).first();
            if (registroExistente != null) {
                return false;
            }
            RegistroAsistencia nuevoRegistro = new RegistroAsistencia(
                empleado.getId(),
                fechaAsistencia,
                horaEntrada,
                null
            );
            RegistroAsistenciaCollection.insertOne(nuevoRegistro);
            return true;
        } catch (Exception e) {
            throw new AccesoDatosException("Error al registrar la entrada del empleado", e);
        }
    }
    /**
     * Registra la salida de un empleado.
     * @param empleado Empleado que registra su entrada.
     * @param fechaAsistencia Fecha de la asistencia.
     * @param horaSalida Hora de salida.
     * @return VERDADERO si se registró la entrada, FALSO en caso contrario.
     * @throws AccesoDatosException Excepción del proyecto DAO.
     */
    @Override
    public boolean registrarSalida(Empleado empleado, LocalDate fechaAsistencia, LocalTime horaSalida) throws AccesoDatosException {
        try {
            Bson filtro = Filters.and(
            Filters.eq("empleadoId", empleado.getId()),
            Filters.eq("fechaAsistencia", fechaAsistencia),
            Filters.eq("horaSalida", null)  
        );

            Bson actualizacion = Updates.set("horaSalida", horaSalida);

            UpdateResult resultado = RegistroAsistenciaCollection.updateOne(filtro, actualizacion);

            return resultado.getModifiedCount() > 0;

        } catch (Exception e) {
            throw new AccesoDatosException("Error al registrar la salida del empleado", e);
        }
    }
}