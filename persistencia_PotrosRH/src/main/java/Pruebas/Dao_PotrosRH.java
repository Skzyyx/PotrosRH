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
import java.time.Month;
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

//        Candidato c = new Candidato();
//        c.setNombre("Leonardo");
//        c.setApellidoPaterno("Flores");
//        c.setApellidoMaterno("Leyva");
//        c.setRfc("GUMF900101ABC");
//        c.setEmail("leonardo.flores252390@potros.itson.edu.mx");
//        c.setTelefono("6622537849");
//        c.setCurp("CURPLEON1234");
//        c.setSexo(Sexo.HOMBRE);
//        c.setFechaNacimiento(LocalDate.of(2005, Month.OCTOBER, 9));
//        c.setExperiencia("Experto en Doom.");
//        c.setNivelEstudio("Universidad.");
//        c.setHabilidadesClave("Inteligencia Artificial.");
//
//        try {
//            c = cDAO.registrarCandidato(c);
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(c.toString());
//
//        Set<Pregunta> preguntas = new HashSet();
//        preguntas.add(new Pregunta("Pregunta1?", "Respuesta1"));
//        preguntas.add(new Pregunta("Pregunta2?", "Respuesta2"));
//        preguntas.add(new Pregunta("Pregunta3?", "Respuesta3"));
//
//        Evaluacion e = new Evaluacion();
//        e.setFechaHoraEvaluacion(LocalDateTime.now());
//        e.setCandidato(c);
//        e.setPreguntas(preguntas);
//        e.setResultado(ResultadoEvaluacion.APROBADO);
//
//        try {
//            eDAO.registrarEvaluacion(e);
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(e.toString());
//
//        Empleado em = new Empleado();
//        List<HorarioLaboral> horarios = new ArrayList();
//        horarios.add(new HorarioLaboral(DiaSemana.LUNES, LocalTime.of(9, 0), LocalTime.of(17, 0)));
//        horarios.add(new HorarioLaboral(DiaSemana.MARTES, LocalTime.of(10, 0), LocalTime.of(18, 0)));
//        horarios.add(new HorarioLaboral(DiaSemana.MIERCOLES, LocalTime.of(9, 0), LocalTime.of(14, 0)));
//        horarios.add(new HorarioLaboral(DiaSemana.JUEVES, LocalTime.of(12, 0), LocalTime.of(20, 0)));
//        horarios.add(new HorarioLaboral(DiaSemana.VIERNES, LocalTime.of(9, 0), LocalTime.of(15, 0)));
//
//        em.setHorariosLaborales(horarios);
//        em.setNombre(c.getNombre());
//        em.setApellidoPaterno(c.getApellidoPaterno());
//        em.setApellidoMaterno(c.getApellidoMaterno());
//        em.setRfc(c.getRfc());
//        em.setEmail(c.getEmail());
//        em.setTelefono(faker.phoneNumber().cellPhone());
//        em.setCurp(c.getCurp());
//        em.setFechaNacimiento(c.getFechaNacimiento());
//        em.setDepartamento("Producción");
//        em.setDireccion(new Direccion(faker.address().streetName(), faker.address().streetAddressNumber(), faker.address().secondaryAddress()));
//        em.setEstado(EstadoEmpleado.ACTIVO);
//        em.setPuesto(faker.job().title());
//        em.setSalarioBase(200.00);
//        em.setFechaNacimiento(LocalDate.of(2005, 10, 9));
//
//        try {
//            emDAO.registrarEmpleado(em);
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(em.toString());
//        
//        try {
//            Empleado empleado = emDAO.obtenerEmpleado(em);
//            Contrato contrato = new Contrato();
//            contrato.setEmpleado(empleado);
//            contrato.setDepartamento(empleado.getDepartamento());
//            contrato.setFechaInicio(LocalDate.of(2025, Month.MAY, 10));
//            contrato.setFechaFin(LocalDate.of(2026, Month.MAY, 10));
//            contrato.setHorarios(null);
//            contrato.setLugarTrabajo("ITSON");
//            contrato.setSueldo(empleado.getSalarioBase());
//            contrato.setModoPago(ModoPago.TRANSFERENCIA);
//            contrato.setPeriodoPago(PeriodoPago.SEMANAL);
//            contrato.setPuesto(empleado.getPuesto());
//            contrato.setTipoContrato(TipoContrato.PERIODO);
//            coDAO.registrarContrato(contrato);
//            
//        } catch (AccesoDatosException ex) {
//            Logger.getLogger(Dao_PotrosRH.class.getName()).log(Level.SEVERE, null, ex);
//        }
        

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
