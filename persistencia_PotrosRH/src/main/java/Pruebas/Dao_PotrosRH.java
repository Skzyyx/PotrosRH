/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Pruebas;

import DAO.CandidatoDAO;
import DAO.ContratoDAO;
import DAO.EmpleadoDAO;
import DAO.EvaluacionDAO;
import Entidades.Candidato;
import Entidades.Contrato;
import Entidades.Direccion;
import Entidades.Empleado;
import Entidades.Evaluacion;
import Entidades.HorarioLaboral;
import Entidades.Pregunta;
import Enums.DiaSemana;
import Enums.EstadoEmpleado;
import Enums.ModoPago;
import Enums.PeriodoPago;
import Enums.ResultadoEvaluacion;
import Enums.Sexo;
import Enums.TipoContrato;
import Exceptions.AccesoDatosException;
import Interfaces.ICandidatoDAO;
import Interfaces.IContratoDAO;
import Interfaces.IEmpleadoDAO;
import Interfaces.IEvaluacionDAO;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skyro
 */
public class Dao_PotrosRH {

    public static void main(String[] args) {

        ICandidatoDAO cDAO = new CandidatoDAO();
        IEvaluacionDAO eDAO = new EvaluacionDAO();
        IContratoDAO coDAO = new ContratoDAO();
        IEmpleadoDAO emDAO = new EmpleadoDAO();

        Faker faker = new Faker();

        Candidato c = new Candidato();
        c.setNombre("Jesús Ernesto");
        c.setApellidoPaterno("López");
        c.setApellidoMaterno("Ibarra");
        c.setRfc("LOIJ920315XYZ");
        c.setEmail("neto@potros.itson.edu.mx");
        c.setTelefono("6622537849");
        c.setCurp("CURPNETO1234");
        c.setSexo(Sexo.HOMBRE);
        c.setExperiencia("Experto en Pokemon.");
        c.setNivelEstudio("Universidad.");
        c.setHabilidadesClave("Juegos Interactivos.");

        try {
            c = cDAO.registrarCandidato(c);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(c.toString());

        Set<Pregunta> preguntas = new HashSet();
        preguntas.add(new Pregunta("Pregunta1?", "Respuesta1"));
        preguntas.add(new Pregunta("Pregunta2?", "Respuesta2"));
        preguntas.add(new Pregunta("Pregunta3?", "Respuesta3"));

        Evaluacion e = new Evaluacion();
        e.setFechaHoraEvaluacion(LocalDateTime.now());
        e.setCandidato(c);
        e.setPreguntas(preguntas);
        e.setResultado(ResultadoEvaluacion.APROBADO);

        try {
            eDAO.registrarEvaluacion(e);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(e.toString());

        Empleado em = new Empleado();
        List<HorarioLaboral> horarios = new ArrayList();
        horarios.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horarios.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        em.setHorariosLaborales(horarios);
        em.setNombre(faker.name().name());
        em.setApellidoPaterno(faker.name().firstName());
        em.setApellidoMaterno(faker.name().lastName());
        em.setRfc(c.getRfc());
        em.setEmail(faker.internet().emailAddress());
        em.setTelefono(faker.phoneNumber().cellPhone());
        em.setCurp(c.getCurp());
        em.setDepartamento("Producción");
        em.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        em.setEstado(EstadoEmpleado.ACTIVO);
        em.setPuesto(faker.job().title());
        em.setSalarioBase(40000.00);
        em.setFechaNacimiento(LocalDate.of(2005, 12, 29));

        try {
            emDAO.registrarEmpleado(em);
        } catch (AccesoDatosException ex) {
            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(em.toString());

//        Set<HorarioLaboral> horarios2 = new HashSet();
//        horarios2.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
//        horarios2.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
//        horarios2.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
//        horarios2.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
//        horarios2.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
//
//        Contrato co = new Contrato();
//        co.setDepartamento("Producción");
//        co.setEmpleadoId(e.getId());
//        co.setEvaluacion(e);
//        co.setFechaInicio(LocalDate.of(2020, 05, 16));
//        co.setFechaFin(LocalDate.of(2030, 05, 16));
//        co.setHorarios(horarios2);
//        co.setEmpleadoId(em.getId());
//        co.setLugarTrabajo("Obregón");
//        co.setModoPago(ModoPago.EFECTIVO);
//        co.setPeriodoPago(PeriodoPago.SEMANAL);
//        co.setPuesto("Desarrollador");
//        co.setSueldo(em.getSalarioBase());
//        co.setTipoContrato(TipoContrato.PERIODO);
//
//        try {
//            coDAO.registrarContrato(co);
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(co.toString());

        try {
            System.out.println("----------------------");
            emDAO.obtenerTodosSinContrato(new ArrayList<>())
                    .forEach((t) -> {
                        System.out.println(t.toString());
                    });
        } catch (AccesoDatosException ex) {
            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
