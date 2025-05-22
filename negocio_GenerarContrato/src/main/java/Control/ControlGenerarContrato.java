/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Excepciones.CorreoException;
import Exceptions.GenerarContratoException;
import Exceptions.ObjetosNegocioException;
import Interface.ISistemaCorreo;
import Interfaces.IContratoBO;
import SistemaCorreo.SistemaCorreo;
import bo.ContratoBO;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import dto.ContratoDTO;
import dto.CorreoDTO;
import dto.HorarioLaboralDTO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de control que implementa la lógica para la generación y registro de
 * contratos. Se encarga de validar los datos del contrato, registrarlo en la
 * base de datos, generar el documento PDF del contrato y enviarlo por correo
 * electrónico.
 *
 * @author Jose Luis Islas Molina 252574
 */
public class ControlGenerarContrato {

    /**
     * Color principal utilizado en el diseño del documento PDF del contrato.
     */
    private static final DeviceRgb COLOR_PRINCIPAL = new DeviceRgb(41, 128, 185);

    /**
     * Color secundario utilizado en el diseño del documento PDF del contrato.
     */
    private static final DeviceRgb COLOR_SECUNDARIO = new DeviceRgb(52, 73, 94);

    /**
     * Objeto de negocio para operaciones con contratos.
     */
    private static IContratoBO contratoBO = ContratoBO.getInstance();

    /**
     * Registra un nuevo contrato en el sistema después de validar sus campos.
     *
     * @param contrato El objeto ContratoDTO con la información del contrato a
     * registrar
     * @return El objeto ContratoDTO registrado, con identificadores generados
     * @throws GenerarContratoException Si ocurre un error durante la validación
     * o registro
     */
    public ContratoDTO registrarContrato(ContratoDTO contrato) throws GenerarContratoException {
        if (contrato == null) {
            throw new GenerarContratoException("El contrato no puede ser nulo.");
        }

        for (Field field : contrato.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            // Filtrar atributos que no quieres validar
            if (field.getName().equals("id")) {
                continue;
            }

            try {
                if (field.get(contrato) == null) {
                    throw new GenerarContratoException("El campo '" + field.getName() + "' no puede ser nulo.");
                }
            } catch (IllegalAccessException e) {
                throw new GenerarContratoException("Error al acceder al campo: " + field.getName());
            }
        }

        try {
            return contratoBO.registrarContrato(contrato);
        } catch (ObjetosNegocioException ex) {
            Logger.getLogger(ControlGenerarContrato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            throw new GenerarContratoException(ex.getMessage());
        }
    }

    /**
     * Envía el contrato por correo electrónico al empleado.
     *
     * @param correo Objeto CorreoDTO con la información del correo a enviar
     * @param contrato Objeto ContratoDTO con la información del contrato
     */
    public void enviarContrato(CorreoDTO correo, ContratoDTO contrato) {

        try {
            ISistemaCorreo sistemaCorreo = new SistemaCorreo();

            sistemaCorreo.sendEmail(correo, generarPDFContrato(contrato));
        } catch (IOException ex) {
            Logger.getLogger(ControlGenerarContrato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } catch (CorreoException ex) {
            Logger.getLogger(ControlGenerarContrato.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }

    /**
     * Genera un documento PDF con la información del contrato.
     *
     * @param contrato Objeto ContratoDTO con la información del contrato
     * @return Array de bytes que representa el documento PDF generado
     * @throws IOException Si ocurre un error durante la generación del PDF
     */
    private byte[] generarPDFContrato(ContratoDTO contrato) throws IOException {
        // Crear un stream para almacenar el PDF
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Inicializar el escritor PDF
        PdfWriter writer = new PdfWriter(baos);

        // Inicializar el documento PDF
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.setDefaultPageSize(PageSize.A4);

        // Crear el documento
        Document document = new Document(pdfDoc);

        // Configurar fuentes
        PdfFont fontBold = PdfFontFactory.createFont("Helvetica-Bold");
        PdfFont fontRegular = PdfFontFactory.createFont("Helvetica");

        // Título del documento
        Paragraph titulo = new Paragraph("CONTRATO DE TRABAJO")
                .setFont(fontBold)
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER)
                .setBold();
        document.add(titulo);

        // Agregar espacio
        document.add(new Paragraph("\n"));

        // Agregar número de contrato
        Paragraph numeroContrato = new Paragraph("Contrato N°: " + new Random().nextInt(0, 100))
                .setFont(fontBold)
                .setFontSize(12)
                .setTextAlignment(TextAlignment.RIGHT);
        document.add(numeroContrato);

        // Agregar espacio
        document.add(new Paragraph("\n"));

        // Crear tabla para los datos del contrato
        Table table = new Table(UnitValue.createPercentArray(new float[]{30, 70}));
        table.setWidth(UnitValue.createPercentValue(100));

        // Agregar filas a la tabla con los datos del contrato
        agregarFilaTabla(table, "Departamento:", contrato.getDepartamento(), fontBold, fontRegular);
        agregarFilaTabla(table, "Lugar de Trabajo:", contrato.getLugarTrabajo(), fontBold, fontRegular);
        agregarFilaTabla(table, "Fecha de Inicio:", formatearFecha(contrato.getFechaInicio().toString()), fontBold, fontRegular);
        agregarFilaTabla(table, "Fecha de Finalización:", formatearFecha(contrato.getFechaFin().toString()), fontBold, fontRegular);
        agregarFilaTabla(table, "Puesto:", contrato.getPuesto(), fontBold, fontRegular);
        agregarFilaTabla(table, "Sueldo:", formatearSueldo(contrato.getSueldo()), fontBold, fontRegular);
        agregarFilaTabla(table, "Periodo de Pago:", contrato.getPeriodoPago(), fontBold, fontRegular);
        agregarFilaTabla(table, "Modo de Pago:", contrato.getModoPago(), fontBold, fontRegular);

        document.add(table);

        // Agregar espacio
        document.add(new Paragraph("\n"));

        // Agregar sección de horarios
        Paragraph tituloHorarios = new Paragraph("HORARIOS DE TRABAJO")
                .setFont(fontBold)
                .setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER);
        document.add(tituloHorarios);

        // Agregar espacio
        document.add(new Paragraph("\n"));

        // Crear tabla para los horarios
        Table tablaHorarios = new Table(UnitValue.createPercentArray(new float[]{33, 33, 33}));
        tablaHorarios.setWidth(UnitValue.createPercentValue(100));

        // Encabezados de la tabla de horarios
        Cell cellDia = new Cell().add(new Paragraph("Día").setFont(fontBold))
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        Cell cellEntrada = new Cell().add(new Paragraph("Hora Entrada").setFont(fontBold))
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        Cell cellSalida = new Cell().add(new Paragraph("Hora Salida").setFont(fontBold))
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);

        tablaHorarios.addHeaderCell(cellDia);
        tablaHorarios.addHeaderCell(cellEntrada);
        tablaHorarios.addHeaderCell(cellSalida);

        // Agregar filas con los horarios
        if (contrato.getHorarios() != null && !contrato.getHorarios().isEmpty()) {
            for (HorarioLaboralDTO horario : contrato.getHorarios()) {
                tablaHorarios.addCell(new Cell().add(new Paragraph(horario.getDiaSemana()).setFont(fontRegular))
                        .setTextAlignment(TextAlignment.CENTER));
                tablaHorarios.addCell(new Cell().add(new Paragraph(horario.getHoraInicioTurno().toString()).setFont(fontRegular))
                        .setTextAlignment(TextAlignment.CENTER));
                tablaHorarios.addCell(new Cell().add(new Paragraph(horario.getHoraFinTurno().toString()).setFont(fontRegular))
                        .setTextAlignment(TextAlignment.CENTER));
            }
        } else {
            Cell cellNoHorarios = new Cell(1, 4).add(new Paragraph("No hay horarios definidos").setFont(fontRegular))
                    .setTextAlignment(TextAlignment.CENTER);
            tablaHorarios.addCell(cellNoHorarios);
        }

        document.add(tablaHorarios);

        // Agregar espacio
        document.add(new Paragraph("\n\n"));

        // Agregar sección para firmas
        Table tablaFirmas = new Table(UnitValue.createPercentArray(new float[]{50, 50}));
        tablaFirmas.setWidth(UnitValue.createPercentValue(100));

        Cell cellFirmaEmpleado = new Cell().add(new Paragraph("_________________________\nFirma del Empleado").setFont(fontRegular))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(null);

        Cell cellFirmaEmpleador = new Cell().add(new Paragraph("_________________________\nFirma del Empleador").setFont(fontRegular))
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(null);

        tablaFirmas.addCell(cellFirmaEmpleado);
        tablaFirmas.addCell(cellFirmaEmpleador);

        document.add(tablaFirmas);

        // Agregar pie de página con fecha de generación
        Paragraph piePagina = new Paragraph("Documento generado el " + java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .setFont(fontRegular)
                .setFontSize(8)
                .setTextAlignment(TextAlignment.CENTER);

        document.add(new Paragraph("\n\n"));
        document.add(piePagina);

        // Cerrar el documento
        document.close();

        // Devolver el array de bytes
        return baos.toByteArray();
    }

    /**
     * Método auxiliar para agregar filas a la tabla del contrato.
     *
     * @param table Tabla a la que se agregará la fila
     * @param etiqueta Etiqueta o nombre del campo
     * @param valor Valor del campo
     * @param fontBold Fuente en negrita para la etiqueta
     * @param fontRegular Fuente regular para el valor
     */
    private void agregarFilaTabla(Table table, String etiqueta, String valor, PdfFont fontBold, PdfFont fontRegular) {
        Cell cellEtiqueta = new Cell().add(new Paragraph(etiqueta).setFont(fontBold))
                .setTextAlignment(TextAlignment.RIGHT)
                .setBorder(new SolidBorder(ColorConstants.WHITE, 1));

        Cell cellValor = new Cell().add(new Paragraph(valor != null ? valor : "").setFont(fontRegular))
                .setBorder(new SolidBorder(ColorConstants.WHITE, 1));

        table.addCell(cellEtiqueta);
        table.addCell(cellValor);
    }

    /**
     * Método para formatear fechas en el documento.
     *
     * @param fecha Fecha en formato String
     * @return Fecha formateada o mensaje si no está especificada
     */
    private String formatearFecha(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            return "No especificada";
        }
        return fecha;
    }

    /**
     * Método para formatear el sueldo en el documento.
     *
     * @param sueldo Valor del sueldo
     * @return Sueldo formateado con símbolo de moneda o mensaje si no está
     * especificado
     */
    private String formatearSueldo(Double sueldo) {
        if (sueldo == null) {
            return "No especificado";
        }
        return String.format("$%.2f", sueldo);
    }
}
