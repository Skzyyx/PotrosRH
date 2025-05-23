package Pruebas;

import Conexion.Conexion;
import DAO.ContratoDAO;
import DAO.EmpleadoDAO;
import DAO.NominaDAO;
import Entidades.Contrato;
import Entidades.Direccion;
import Entidades.Empleado;
import Entidades.HorarioLaboral;
import Entidades.Nomina;
import Entidades.RegistroAsistencia;
import Enums.DiaSemana;
import Enums.EstadoEmpleado;
import Enums.ModoPago;
import Enums.PeriodoPago;
import Enums.Sexo;
import Exceptions.AccesoDatosException;
import Interfaces.IContratoDAO;
import Interfaces.IEmpleadoDAO;
import Interfaces.INominaDAO;
import com.github.javafaker.Faker;
import com.mongodb.client.MongoCollection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 * Clase para insertar empleados de prueba.
 * @author Leonardo Flores Leyva - 252390
 */
public class InsertarEmpleadosDefault {
    
    public void insertarEmpleados(){
        
        // Clases DAO requeridas.
        IContratoDAO coDAO = new ContratoDAO();
        IEmpleadoDAO emDAO = new EmpleadoDAO();
        MongoCollection rDAO = Conexion.getDatabase().getCollection("registro_asistencia", RegistroAsistencia.class);
        INominaDAO nDAO = new NominaDAO();
        
        // Clase Faker para generar datos aleatorios para un empleado.
        Faker faker = new Faker();
        
        // Empleados de Recursos Humanos.
        
        // Leonardo
        Empleado Leo = new Empleado();
        List<HorarioLaboral> horariosLeo = new ArrayList();
        horariosLeo.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosLeo.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(10, 0), LocalTime.of(18, 0)));
        horariosLeo.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(14, 0)));
        horariosLeo.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(12, 0), LocalTime.of(20, 0)));
        horariosLeo.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(15, 0)));
        
        Leo.setHorariosLaborales(horariosLeo);
        Leo.setNombre("Leonardo");
        Leo.setApellidoPaterno("Flores");
        Leo.setApellidoMaterno("Leyva");
        Leo.setSexo(Sexo.HOMBRE);
        Leo.setRfc("ABCD123456LEO");
        Leo.setEmail("leonardo.guapo252390@potros.itson.edu.mx");
        Leo.setTelefono(faker.phoneNumber().cellPhone());
        Leo.setCurp("FLOA001106HSLMNS01");
        Leo.setFechaNacimiento(LocalDate.of(2005, Month.OCTOBER, 9));
        Leo.setDepartamento("Recursos Humanos");
        Leo.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Leo.setEstado(EstadoEmpleado.ACTIVO);
        Leo.setPuesto("Administrador de Recursos Humanos");
        Leo.setSalarioBase(500.00);
        
        // Jesús Ernesto
        Empleado Neto = new Empleado();
        List<HorarioLaboral> horariosNeto = new ArrayList();
        horariosNeto.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosNeto.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosNeto.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosNeto.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosNeto.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        Neto.setHorariosLaborales(horariosNeto);
        Neto.setNombre("Jesús Ernesto");
        Neto.setApellidoPaterno("López");
        Neto.setApellidoMaterno("Ibarra");
        Neto.setSexo(Sexo.HOMBRE);
        Neto.setRfc("ABCD123456NET");
        Neto.setEmail("neto@hotmail.com");
        Neto.setTelefono(faker.phoneNumber().cellPhone());
        Neto.setCurp("NAVJ940207MDFRZS00");
        Neto.setFechaNacimiento(LocalDate.of(2005, Month.MAY, 22));
        Neto.setDepartamento("Recursos Humanos");
        Neto.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Neto.setEstado(EstadoEmpleado.ACTIVO);
        Neto.setPuesto("Despidos");
        Neto.setSalarioBase(300.00);
        
        // José Islas
        Empleado Jose = new Empleado();
        List<HorarioLaboral> horariosJose = new ArrayList();
        horariosJose.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosJose.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosJose.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosJose.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosJose.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        Jose.setHorariosLaborales(horariosJose);
        Jose.setNombre("José Luis");
        Jose.setApellidoPaterno("Islas");
        Jose.setApellidoMaterno("Molina");
        Jose.setSexo(Sexo.HOMBRE);
        Jose.setRfc("ABCD123456JOS");
        Jose.setEmail("jose.luis@gmail.com");
        Jose.setTelefono(faker.phoneNumber().cellPhone());
        Jose.setCurp("TORR951213MJCLPR06");
        Jose.setFechaNacimiento(LocalDate.of(2005, Month.AUGUST, 15));
        Jose.setDepartamento("Recursos Humanos");
        Jose.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Jose.setEstado(EstadoEmpleado.ACTIVO);
        Jose.setPuesto("Contrataciones");
        Jose.setSalarioBase(400.00);
        
        // Benjamin Soto
        Empleado Benjamin = new Empleado();
        List<HorarioLaboral> horariosBenja = new ArrayList();
        horariosBenja.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosBenja.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosBenja.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosBenja.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosBenja.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));

        Benjamin.setHorariosLaborales(horariosBenja);
        Benjamin.setNombre("Benjamin");
        Benjamin.setApellidoPaterno("Soto");
        Benjamin.setApellidoMaterno("Coronado");
        Benjamin.setSexo(Sexo.HOMBRE);
        Benjamin.setRfc("ABCD123456BEN");
        Benjamin.setEmail("benjagod@outlook.com");
        Benjamin.setTelefono(faker.phoneNumber().cellPhone());
        Benjamin.setCurp("HERN890731HDFMLL03");
        Benjamin.setFechaNacimiento(LocalDate.of(2005, Month.JUNE, 6));
        Benjamin.setDepartamento("Recursos Humanos");
        Benjamin.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Benjamin.setEstado(EstadoEmpleado.ACTIVO);
        Benjamin.setPuesto("Contrataciones");
        Benjamin.setSalarioBase(400.00);
        
        // Se regisrran los empleados
        try {
            System.out.println("----------------------------------------------------------------------------------------------------");
            
            emDAO.registrarEmpleado(Leo);
            System.out.println("\nEmpleado Leonardo registrado con éxito!");
            
            emDAO.registrarEmpleado(Neto);
            System.out.println("\nEmpleado Jesús Ernesto registrado con éxito!");
            
            emDAO.registrarEmpleado(Jose);
            System.out.println("\nEmpleado José Luis registrado con éxito!");
            
            emDAO.registrarEmpleado(Benjamin);
            System.out.println("\nEmpleado Benjamin registrado con éxito!");
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Se generan los contratos de los empleados anteriores.
        try {
            // Contrato del empleado Leonardo
            Empleado empleado = emDAO.obtenerEmpleado(Leo);
            Contrato contrato = new Contrato();
            contrato.setEmpleado(empleado);
            contrato.setDepartamento(empleado.getDepartamento());
            contrato.setFechaInicio(LocalDate.now().minusDays(14));
            contrato.setFechaFin(LocalDate.now().plusYears(1));
            contrato.setHorarios(null);
            contrato.setLugarTrabajo("ITSON");
            contrato.setSueldo(empleado.getSalarioBase());
            contrato.setModoPago(ModoPago.TRANSFERENCIA);
            contrato.setPeriodoPago(PeriodoPago.SEMANAL);
            contrato.setPuesto(empleado.getPuesto());
            
            // Contrato del empleado Jesús Ernesto
            Empleado empleado2 = emDAO.obtenerEmpleado(Neto);
            Contrato contrato2 = new Contrato();
            contrato2.setEmpleado(empleado2);
            contrato2.setDepartamento(empleado2.getDepartamento());
            contrato2.setFechaInicio(LocalDate.now().minusDays(14));
            contrato2.setFechaFin(LocalDate.now().plusYears(1));
            contrato2.setHorarios(null);
            contrato2.setLugarTrabajo("ITSON");
            contrato2.setSueldo(empleado2.getSalarioBase());
            contrato2.setModoPago(ModoPago.EFECTIVO);
            contrato2.setPeriodoPago(PeriodoPago.QUINCENAL);
            contrato2.setPuesto(empleado2.getPuesto());
            
            // Contrato del empleado José Islas
            Empleado empleado3 = emDAO.obtenerEmpleado(Jose);
            Contrato contrato3 = new Contrato();
            contrato3.setEmpleado(empleado3);
            contrato3.setDepartamento(empleado3.getDepartamento());
            contrato3.setFechaInicio(LocalDate.now().minusDays(14));
            contrato3.setFechaFin(LocalDate.now().plusYears(1));
            contrato3.setHorarios(null);
            contrato3.setLugarTrabajo("ITSON");
            contrato3.setSueldo(empleado3.getSalarioBase());
            contrato3.setModoPago(ModoPago.TRANSFERENCIA);
            contrato3.setPeriodoPago(PeriodoPago.QUINCENAL);
            contrato3.setPuesto(empleado3.getPuesto());
            
            // Contrato del empleado Benjamin
            Empleado empleado4 = emDAO.obtenerEmpleado(Benjamin);
            Contrato contrato4 = new Contrato();
            contrato4.setEmpleado(empleado4);
            contrato4.setDepartamento(empleado4.getDepartamento());
            contrato4.setFechaInicio(LocalDate.now().minusDays(14));
            contrato4.setFechaFin(LocalDate.now().plusYears(1));
            contrato4.setHorarios(null);
            contrato4.setLugarTrabajo("ITSON");
            contrato4.setSueldo(empleado4.getSalarioBase());
            contrato4.setModoPago(ModoPago.CHEQUE);
            contrato4.setPeriodoPago(PeriodoPago.MENSUAL);
            contrato4.setPuesto(empleado4.getPuesto());
            
            // Se registran los contratos.
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            
            coDAO.registrarContrato(contrato);
            System.out.println("\nContrato de Leonardo registrado con éxito!");
             
            coDAO.registrarContrato(contrato2);
            System.out.println("\nContrato de Jesús Ernesto registrado con éxito!");
            
            coDAO.registrarContrato(contrato3);
            System.out.println("\nContrato de José Luis registrado con éxito!");
            
            coDAO.registrarContrato(contrato4);
            System.out.println("\nContrato de Benjamin registrado con éxito!");
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            coDAO.registrarContrato(co);
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        // Empleados para generar sus nóminas.
        
        // María de los Ángeles
        Empleado Maria = new Empleado();
        List<HorarioLaboral> horariosMaria = new ArrayList();
        horariosMaria.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosMaria.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosMaria.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosMaria.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        horariosMaria.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
        
        Maria.setHorariosLaborales(horariosMaria);
        Maria.setNombre("María de los Ángeles");
        Maria.setApellidoPaterno("Germán");
        Maria.setApellidoMaterno("Vázquez");
        Maria.setSexo(Sexo.MUJER);
        Maria.setRfc("ABCD123456MAR");
        Maria.setEmail("maye.ge.va@gmail.com");
        Maria.setTelefono(faker.phoneNumber().cellPhone());
        Maria.setCurp("MARG010712MCMNSL05");
        Maria.setFechaNacimiento(LocalDate.of(1990, Month.FEBRUARY, 14));
        Maria.setDepartamento("TI");
        Maria.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Maria.setEstado(EstadoEmpleado.ACTIVO);
        Maria.setPuesto("Gestor de Bases de Datos");
        Maria.setSalarioBase(5000.00);
        
        // Christian Gilbran
        Empleado Gilbran = new Empleado();
        List<HorarioLaboral> horariosGilbran = new ArrayList();
        horariosGilbran.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(10, 0), LocalTime.of(22, 0)));
        horariosGilbran.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(9, 0), LocalTime.of(16, 0)));
        horariosGilbran.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(11, 0), LocalTime.of(20, 0)));
        horariosGilbran.add(new HorarioLaboral(DiaSemana.DOMINGO, LocalTime.of(5, 0), LocalTime.of(13, 0)));

        Gilbran.setHorariosLaborales(horariosGilbran);
        Gilbran.setNombre("Christian");
        Gilbran.setApellidoPaterno("Gilbran");
        Gilbran.setApellidoMaterno("Solano");
        Gilbran.setSexo(Sexo.HOMBRE);
        Gilbran.setRfc("ABCD123456SQL");
        Gilbran.setEmail("gilbran@yahoo.com");
        Gilbran.setTelefono(faker.phoneNumber().cellPhone());
        Gilbran.setCurp("GARC981221HPLVZN07");
        Gilbran.setFechaNacimiento(LocalDate.of(1984, Month.JULY, 18));
        Gilbran.setDepartamento("TI");
        Gilbran.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Gilbran.setEstado(EstadoEmpleado.ACTIVO);
        Gilbran.setPuesto("Arquitecto de Software");
        Gilbran.setSalarioBase(10000.00);
        
        // Se regisrran los empleados
        try {
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            
            emDAO.registrarEmpleado(Maria);
            System.out.println("\nEmpleada María de los Ángeles registrada con éxito!");
            
            emDAO.registrarEmpleado(Gilbran);
            System.out.println("\nEmpleado Christian Gilbran registrado con éxito!");
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Se generan los contratos de los empleados anteriores.
        try {
            // Contrato de la empleada María
            Empleado empleado5 = emDAO.obtenerEmpleado(Maria);
            Contrato contratoMaria = new Contrato();
            contratoMaria.setEmpleado(empleado5);
            contratoMaria.setDepartamento(empleado5.getDepartamento());
            contratoMaria.setFechaInicio(LocalDate.now().minusDays(14));
            contratoMaria.setFechaFin(LocalDate.now().plusYears(1));
            contratoMaria.setHorarios(null);
            contratoMaria.setLugarTrabajo("ITSON");
            contratoMaria.setSueldo(empleado5.getSalarioBase());
            contratoMaria.setModoPago(ModoPago.TRANSFERENCIA);
            contratoMaria.setPeriodoPago(PeriodoPago.SEMANAL);
            contratoMaria.setPuesto(empleado5.getPuesto());
            
            // Contrato del empleado Christian Gilbran
            Empleado empleado6 = emDAO.obtenerEmpleado(Gilbran);
            Contrato contratoGilbran = new Contrato();
            contratoGilbran.setEmpleado(empleado6);
            contratoGilbran.setDepartamento(empleado6.getDepartamento());
            contratoGilbran.setFechaInicio(LocalDate.now().minusDays(35));
            contratoGilbran.setFechaFin(LocalDate.now().plusYears(1));
            contratoGilbran.setHorarios(null);
            contratoGilbran.setLugarTrabajo("ITSON");
            contratoGilbran.setSueldo(empleado6.getSalarioBase());
            contratoGilbran.setModoPago(ModoPago.EFECTIVO);
            contratoGilbran.setPeriodoPago(PeriodoPago.QUINCENAL);
            contratoGilbran.setPuesto(empleado6.getPuesto());
            
            // Se registran los contratos.
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            
            coDAO.registrarContrato(contratoMaria);
            System.out.println("\nContrato de María de los Ángeles registrado con éxito!");
             
            coDAO.registrarContrato(contratoGilbran);
            System.out.println("\nContrato de Christian Gilbran registrado con éxito!");
            
        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Se registra una nómina para el empleado Gilbran.
        Nomina nomina = new Nomina();
        try {
            nomina.setEmpleado_id(emDAO.obtenerEmpleado(Gilbran).getId());
            nomina.setBono(0.0);
            nomina.setDiasTrabajados(14);
            nomina.setEstadoCobro(true);
            nomina.setFechaCorte(LocalDate.now().minusDays(21));
            nomina.setHorasExtra(2.0);
            nomina.setHorasTrabajadas(42.0);
            nomina.setIsr(15000.0);
            nomina.setSalarioBruto(420000.0);
            nomina.setSalarioNeto(405000.0);
            nDAO.guardarNomina(nomina);
            // Se registra la nómina.
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            System.out.println("\nNómina de Christian Gilbran guardada con éxito.");
        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Se registran distintos registros de asistencia para ambos empleados.
        
        // Asistencias de María en los últimos 14 días (desde su primer día de trabajo).
        RegistroAsistencia asistenciaMariaUno = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaDos = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaTres = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaCuatro = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaCinco = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaSeis = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaSiete = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaOcho = new RegistroAsistencia();
        RegistroAsistencia asistenciaMariaNueve = new RegistroAsistencia();
        
        // Asistencias de Gilbran
        RegistroAsistencia asistenciaGilbranUno = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranDos = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranTres = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranCuatro = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranCinco = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranSeis = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranSiete = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranOcho = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranNueve = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranDiez = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranOnce = new RegistroAsistencia();
        RegistroAsistencia asistenciaGilbranDoce = new RegistroAsistencia();
        
        try {
            ObjectId idMaria = emDAO.obtenerEmpleado(Maria).getId();
            ObjectId idGilbran = emDAO.obtenerEmpleado(Gilbran).getId();
            
            // OJO, dependiendo del día en que se ejecute ese script, los resultados van a ser diferentes
            // Esta clase se probó por primera vez el 22 de mayo de 2025, por lo que los registros fueron pensados para ese día.
            
            // Asistencias de María en las últimas 2 semanas.
            asistenciaMariaUno.setEmpleadoId(idMaria);
            asistenciaMariaUno.setFechaAsistencia(LocalDate.now().minusDays(14));
            asistenciaMariaUno.setHoraEntrada(LocalTime.of(9, 2, 46));
            asistenciaMariaUno.setHoraSalida(LocalTime.of(16, 45, 57));
            
            asistenciaMariaDos.setEmpleadoId(idMaria);
            asistenciaMariaDos.setFechaAsistencia(LocalDate.now().minusDays(13));
            asistenciaMariaDos.setHoraEntrada(LocalTime.of(9, 15, 54));
            asistenciaMariaDos.setHoraSalida(LocalTime.of(17, 2, 22));
            
            asistenciaMariaTres.setEmpleadoId(idMaria);
            asistenciaMariaTres.setFechaAsistencia(LocalDate.now().minusDays(10));
            asistenciaMariaTres.setHoraEntrada(LocalTime.of(8, 56, 21));
            asistenciaMariaTres.setHoraSalida(LocalTime.of(16, 23, 49));
            
            asistenciaMariaCuatro.setEmpleadoId(idMaria);
            asistenciaMariaCuatro.setFechaAsistencia(LocalDate.now().minusDays(9));
            asistenciaMariaCuatro.setHoraEntrada(LocalTime.of(9, 0, 34));
            asistenciaMariaCuatro.setHoraSalida(LocalTime.of(17, 26, 57));
            
            asistenciaMariaCinco.setEmpleadoId(idMaria);
            asistenciaMariaCinco.setFechaAsistencia(LocalDate.now().minusDays(8));
            asistenciaMariaCinco.setHoraEntrada(LocalTime.of(9, 5, 21));
            asistenciaMariaCinco.setHoraSalida(LocalTime.of(17, 0, 0));
            
            asistenciaMariaSeis.setEmpleadoId(idMaria);
            asistenciaMariaSeis.setFechaAsistencia(LocalDate.now().minusDays(7));
            asistenciaMariaSeis.setHoraEntrada(LocalTime.of(9, 1, 23));
            asistenciaMariaSeis.setHoraSalida(LocalTime.of(16, 57, 12));
            
            asistenciaMariaSiete.setEmpleadoId(idMaria);
            asistenciaMariaSiete.setFechaAsistencia(LocalDate.now().minusDays(3));
            asistenciaMariaSiete.setHoraEntrada(LocalTime.of(9, 5, 23));
            asistenciaMariaSiete.setHoraSalida(LocalTime.of(16, 59, 57));
            
            asistenciaMariaOcho.setEmpleadoId(idMaria);
            asistenciaMariaOcho.setFechaAsistencia(LocalDate.now().minusDays(2));
            asistenciaMariaOcho.setHoraEntrada(LocalTime.of(9, 0, 0));
            asistenciaMariaOcho.setHoraSalida(LocalTime.of(17, 0, 0));
            
            asistenciaMariaNueve.setEmpleadoId(idMaria);
            asistenciaMariaNueve.setFechaAsistencia(LocalDate.now().minusDays(1));
            asistenciaMariaNueve.setHoraEntrada(LocalTime.of(9, 0, 36));
            asistenciaMariaNueve.setHoraSalida(LocalTime.of(21, 17, 24));
            
            // Se registran las asistencias de María de los Ángeles
            rDAO.insertMany(Arrays.asList(
                    asistenciaMariaUno,
                    asistenciaMariaDos,
                    asistenciaMariaTres,
                    asistenciaMariaCuatro,
                    asistenciaMariaCinco,
                    asistenciaMariaSeis,
                    asistenciaMariaSiete,
                    asistenciaMariaOcho,
                    asistenciaMariaNueve
            ));
            
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            System.out.println("\nRegistros de asistencia de María registrados con éxito.");
            
            // Asistencias de Gilbran en las últimas 3 semanas (desde su última nómina).
            asistenciaGilbranUno.setEmpleadoId(idGilbran);
            asistenciaGilbranUno.setFechaAsistencia(LocalDate.now().minusDays(21));
            asistenciaGilbranUno.setHoraEntrada(LocalTime.of(10, 59, 56));
            asistenciaGilbranUno.setHoraSalida(LocalTime.of(21, 40, 2));
            
            asistenciaGilbranDos.setEmpleadoId(idGilbran);
            asistenciaGilbranDos.setFechaAsistencia(LocalDate.now().minusDays(18));
            asistenciaGilbranDos.setHoraEntrada(LocalTime.of(4, 54, 24));
            asistenciaGilbranDos.setHoraSalida(LocalTime.of(13, 11, 48));
            
            asistenciaGilbranTres.setEmpleadoId(idGilbran);
            asistenciaGilbranTres.setFechaAsistencia(LocalDate.now().minusDays(17));
            asistenciaGilbranTres.setHoraEntrada(LocalTime.of(10, 13, 47));
            asistenciaGilbranTres.setHoraSalida(LocalTime.of(23, 5, 30));
            
            asistenciaGilbranCuatro.setEmpleadoId(idGilbran);
            asistenciaGilbranCuatro.setFechaAsistencia(LocalDate.now().minusDays(16));
            asistenciaGilbranCuatro.setHoraEntrada(LocalTime.of(9, 0, 0));
            asistenciaGilbranCuatro.setHoraSalida(LocalTime.of(16, 0, 0));
            
            asistenciaGilbranCinco.setEmpleadoId(idGilbran);
            asistenciaGilbranCinco.setFechaAsistencia(LocalDate.now().minusDays(14));
            asistenciaGilbranCinco.setHoraEntrada(LocalTime.of(10, 49, 58));
            asistenciaGilbranCinco.setHoraSalida(LocalTime.of(21, 24, 24));
            
            asistenciaGilbranSeis.setEmpleadoId(idGilbran);
            asistenciaGilbranSeis.setFechaAsistencia(LocalDate.now().minusDays(11));
            asistenciaGilbranSeis.setHoraEntrada(LocalTime.of(5, 2, 53));
            asistenciaGilbranSeis.setHoraSalida(LocalTime.of(15, 9, 17));
            
            asistenciaGilbranSiete.setEmpleadoId(idGilbran);
            asistenciaGilbranSiete.setFechaAsistencia(LocalDate.now().minusDays(10));
            asistenciaGilbranSiete.setHoraEntrada(LocalTime.of(10, 1, 2));
            asistenciaGilbranSiete.setHoraSalida(LocalTime.of(21, 54, 34));
            
            asistenciaGilbranOcho.setEmpleadoId(idGilbran);
            asistenciaGilbranOcho.setFechaAsistencia(LocalDate.now().minusDays(9));
            asistenciaGilbranOcho.setHoraEntrada(LocalTime.of(8, 59, 20));
            asistenciaGilbranOcho.setHoraSalida(LocalTime.of(16, 16, 16));
            
            asistenciaGilbranNueve.setEmpleadoId(idGilbran);
            asistenciaGilbranNueve.setFechaAsistencia(LocalDate.now().minusDays(7));
            asistenciaGilbranNueve.setHoraEntrada(LocalTime.of(11, 10, 0));
            asistenciaGilbranNueve.setHoraSalida(LocalTime.of(21, 0, 42));
            
            asistenciaGilbranDiez.setEmpleadoId(idGilbran);
            asistenciaGilbranDiez.setFechaAsistencia(LocalDate.now().minusDays(4));
            asistenciaGilbranDiez.setHoraEntrada(LocalTime.of(8, 52, 50));
            asistenciaGilbranDiez.setHoraSalida(LocalTime.of(17, 40, 54));
            
            asistenciaGilbranOnce.setEmpleadoId(idGilbran);
            asistenciaGilbranOnce.setFechaAsistencia(LocalDate.now().minusDays(3));
            asistenciaGilbranOnce.setHoraEntrada(LocalTime.of(10, 7, 5));
            asistenciaGilbranOnce.setHoraSalida(LocalTime.of(22, 56, 12));
            
            asistenciaGilbranDoce.setEmpleadoId(idGilbran);
            asistenciaGilbranDoce.setFechaAsistencia(LocalDate.now().minusDays(2));
            asistenciaGilbranDoce.setHoraEntrada(LocalTime.of(9, 0, 23));
            asistenciaGilbranDoce.setHoraSalida(LocalTime.of(18, 23, 19));
            
            // Se registran las asistencias de María de los Ángeles
            rDAO.insertMany(Arrays.asList(
                    asistenciaGilbranUno,
                    asistenciaGilbranDos,
                    asistenciaGilbranTres,
                    asistenciaGilbranCuatro,
                    asistenciaGilbranCinco,
                    asistenciaGilbranSeis,
                    asistenciaGilbranSiete,
                    asistenciaGilbranOcho,
                    asistenciaGilbranNueve,
                    asistenciaGilbranDiez,
                    asistenciaGilbranOnce,
                    asistenciaGilbranDoce
            ));
            
            System.out.println("\n----------------------------------------------------------------------------------------------------");
            System.out.println("\nRegistros de asistencia de Gilbran registrados con éxito.");
            
        } catch (Exception e) {
             Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, e);
        }
        
        // Dos empleados extra para cualquier otra prueba..
        // María de los Ángeles
        Empleado CR7 = new Empleado();
        List<HorarioLaboral> horariosCR7 = new ArrayList();
        horariosCR7.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(7, 0), LocalTime.of(15, 0)));
        horariosCR7.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(7, 0), LocalTime.of(15, 0)));
        horariosCR7.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(7, 0), LocalTime.of(15, 0)));
        horariosCR7.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(7, 0), LocalTime.of(15, 0)));
        horariosCR7.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(7, 0), LocalTime.of(15, 0)));

        CR7.setHorariosLaborales(horariosCR7);
        CR7.setNombre("Cristiano Ronaldo");
        CR7.setApellidoPaterno("Dos Santos");
        CR7.setApellidoMaterno("Aveiro");
        CR7.setSexo(Sexo.HOMBRE);
        CR7.setRfc("ABCD123456CRS");
        CR7.setEmail("cr7@gmail.com");
        CR7.setTelefono(faker.phoneNumber().cellPhone());
        CR7.setCurp("SANC030101HNLVRC09");
        CR7.setFechaNacimiento(LocalDate.of(1985, Month.FEBRUARY, 5));
        CR7.setDepartamento("Deportes");
        CR7.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        CR7.setEstado(EstadoEmpleado.ACTIVO);
        CR7.setPuesto("Delantero Centro");
        CR7.setSalarioBase(125000.00);

        // Christian Gilbran
        Empleado Yuri = new Empleado();
        List<HorarioLaboral> horariosYuri = new ArrayList();
        horariosYuri.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(10, 0), LocalTime.of(20, 0)));
        horariosYuri.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(10, 0), LocalTime.of(20, 0)));
        horariosYuri.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(10, 0), LocalTime.of(20, 0)));
        horariosYuri.add(new HorarioLaboral(DiaSemana.DOMINGO, LocalTime.of(10, 0), LocalTime.of(20, 0)));

        Yuri.setHorariosLaborales(horariosGilbran);
        Yuri.setNombre("Yuri Germán");
        Yuri.setApellidoPaterno("García");
        Yuri.setApellidoMaterno("López");
        Yuri.setSexo(Sexo.HOMBRE);
        Yuri.setRfc("ABCD123456YUR");
        Yuri.setEmail("yuri.german@potros.itson.edu.mx");
        Yuri.setTelefono(faker.phoneNumber().cellPhone());
        Yuri.setCurp("REYE850923MDFTRN02");
        Yuri.setFechaNacimiento(LocalDate.of(2005, Month.NOVEMBER, 25));
        Yuri.setDepartamento("TI");
        Yuri.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
        Yuri.setEstado(EstadoEmpleado.ACTIVO);
        Yuri.setPuesto("Programador Junior");
        Yuri.setSalarioBase(100.00);

        // Se regisrran los empleados
        try {
            System.out.println("\n----------------------------------------------------------------------------------------------------");

            emDAO.registrarEmpleado(CR7);
            System.out.println("\nEmpleado Cristiano Ronaldo registrado con éxito!");

            emDAO.registrarEmpleado(Yuri);
            System.out.println("\nEmpleado Yuri Germán registrado con éxito!");

        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Se generan los contratos de los empleados anteriores.
        try {
            // Contrato de la empleada María
            Empleado empleado7 = emDAO.obtenerEmpleado(CR7);
            Contrato contratoCR7 = new Contrato();
            contratoCR7.setEmpleado(empleado7);
            contratoCR7.setDepartamento(empleado7.getDepartamento());
            contratoCR7.setFechaInicio(LocalDate.now().minusDays(14));
            contratoCR7.setFechaFin(LocalDate.now().plusYears(1));
            contratoCR7.setHorarios(null);
            contratoCR7.setLugarTrabajo("ITSON");
            contratoCR7.setSueldo(empleado7.getSalarioBase());
            contratoCR7.setModoPago(ModoPago.TRANSFERENCIA);
            contratoCR7.setPeriodoPago(PeriodoPago.MENSUAL);
            contratoCR7.setPuesto(empleado7.getPuesto());

            // Contrato del empleado Christian Gilbran
            Empleado empleado8 = emDAO.obtenerEmpleado(Yuri);
            Contrato contratoYuri = new Contrato();
            contratoYuri.setEmpleado(empleado8);
            contratoYuri.setDepartamento(empleado8.getDepartamento());
            contratoYuri.setFechaInicio(LocalDate.now().minusDays(14));
            contratoYuri.setFechaFin(LocalDate.now().plusYears(1));
            contratoYuri.setHorarios(null);
            contratoYuri.setLugarTrabajo("ITSON");
            contratoYuri.setSueldo(empleado8.getSalarioBase());
            contratoYuri.setModoPago(ModoPago.CHEQUE);
            contratoYuri.setPeriodoPago(PeriodoPago.QUINCENAL);
            contratoYuri.setPuesto(empleado8.getPuesto());

            // Se registran los contratos.
            System.out.println("\n----------------------------------------------------------------------------------------------------");

            coDAO.registrarContrato(contratoCR7);
            System.out.println("\nContrato de Cristiano Ronaldo mregistrado con éxito!");

            coDAO.registrarContrato(contratoYuri);
            System.out.println("\nContrato de Yuri Germán registrado con éxito!");

        } catch (AccesoDatosException ex) {
            Logger.getLogger(InsertEmpleadosNominas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}