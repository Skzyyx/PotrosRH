package PanelesReportes;

import Controles.ControlCampos;
import Controles.ControlFlujo;
import Controles.ControlReportes;
import Excepciones.PresentacionException;
import OptionPane.OptionPane;
import dto.ReporteRevisadoDTO;
import dto.ReporteRevisadoOmitidoDTO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * Panel para la recepción del motivo de la omisión de la mala
 * conducta del empleado reportado.
 * @author Leonardo Flores Leyva (252390)
 */
public class MotivoOmisionMalaConducta extends javax.swing.JPanel {
    /**
     * Reporte revisado a registrar como reporte omitido.
     */
    private ReporteRevisadoDTO reporteRevisado = new ReporteRevisadoDTO();
    /**
     * Constructor por defecto.
     */
    public MotivoOmisionMalaConducta() {
        initComponents();
        ControlCampos.limiteCaracteresAreaTexto(jTAMotiviOmision, 1000);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLDeterminacionCaso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAMotiviOmision = new javax.swing.JTextArea();
        btnConfirmar = new javax.swing.JButton();

        setBackground(new java.awt.Color(17, 119, 202));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 630, 137, 55));
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setOpaque(false);
        btnCancelar.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Pinta un fondo redondeado
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 50, 50);
                super.paint(g2, c);
                g2.dispose();
            }
        });

        btnAnterior.setBackground(new java.awt.Color(0, 0, 0));
        btnAnterior.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 630, 146, 55));
        btnAnterior.setBorderPainted(false);
        btnAnterior.setContentAreaFilled(false);
        btnAnterior.setOpaque(false);
        btnAnterior.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Pinta un fondo redondeado
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 50, 50);
                super.paint(g2, c);
                g2.dispose();
            }
        });

        jPanel2.setBackground(new java.awt.Color(17, 119, 202));
        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 28, 1280, -1));

        jLTitulo.setBackground(new java.awt.Color(0, 0, 0));
        jLTitulo.setFont(new java.awt.Font("Segoe UI", 1, 42)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setText("Revision de reporte");
        jLTitulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jLTitulo.setOpaque(true);
        add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 44, -1, 55));

        jLDeterminacionCaso.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLDeterminacionCaso.setForeground(new java.awt.Color(255, 255, 255));
        jLDeterminacionCaso.setText("Motivo omisión mala conducta:");
        add(jLDeterminacionCaso, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 430, 49));

        jTAMotiviOmision.setBackground(new java.awt.Color(255, 255, 255));
        jTAMotiviOmision.setColumns(20);
        jTAMotiviOmision.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTAMotiviOmision.setForeground(new java.awt.Color(0, 0, 0));
        jTAMotiviOmision.setLineWrap(true);
        jTAMotiviOmision.setRows(5);
        jTAMotiviOmision.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTAMotiviOmision);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 1170, 390));

        btnConfirmar.setBackground(new java.awt.Color(0, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 628, 146, 55));
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setOpaque(false);
        btnConfirmar.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Pinta un fondo redondeado
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 50, 50);
                super.paint(g2, c);
                g2.dispose();
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try {
            ControlFlujo.mostrarAnalisisIncialEInvestigacion(reporteRevisado.getReporteMalaConducta());
        } catch (PresentacionException e) {OptionPane.showErrorMessage(this, "ERROR: " + e.getMessage(), "ERROR");}
    }//GEN-LAST:event_btnAnteriorActionPerformed
    /**
     * Botón Cancelar. Regresa al Submenú de Reportes de Mala Conducta.
     * @param evt Click.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirmacion = OptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar la operación?", "Confirmación de cancelación");
        if(confirmacion == JOptionPane.YES_OPTION)
            ControlFlujo.mostrarSubmenuReportes();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Botón Confirmar. Registra el nuevo reporte revisado omitido,
     * con el motivo de la omisión ingresada.
     * @param evt Click.
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if(!jTAMotiviOmision.getText().trim().isEmpty()){
            try {
                ReporteRevisadoOmitidoDTO reporteOmitido = new ReporteRevisadoOmitidoDTO();
                reporteOmitido.setReporteMalaConducta(reporteRevisado.getReporteMalaConducta());
                reporteOmitido.setInfoCompleta(reporteRevisado.isInfoCompleta());
                reporteOmitido.setTieneAntecedentesPrevios(reporteRevisado.isTieneAntecedentesPrevios());
                reporteOmitido.setDescripcionAntecedentesPrevios(reporteRevisado.getDescripcionAntecedentesPrevios());
                reporteOmitido.setEntrevistasRealizadas(reporteRevisado.getEntrevistasRealizadas());
                reporteOmitido.setEvidenciasRevisadas(reporteRevisado.getEvidenciasRevisadas());
                reporteOmitido.setMotivoOmision(jTAMotiviOmision.getText().trim());
                if(ControlReportes.getInstance().registrarReporteOmitido(reporteOmitido) != null){
                    OptionPane.showInfoMessage(this, "¡Reporte revisado registrado con éxito!", "Reporte revisado exitosamente");
                    ControlFlujo.mostrarSubmenuReportes();
                }
                else
                    OptionPane.showInfoMessage(this, "Ha ocurrido un error al intentar registrar el reporte revisado.", "Fracaso en registro de reporte revisado");
            } catch (PresentacionException ex) {OptionPane.showErrorMessage(this, "ERROR: " + ex.getMessage(), "ERROR");}
        } else
            OptionPane.showErrorMessage(this, "ERROR: Ingrese el motivo de la omisión del reporte.", "Sin motivo de omisión");
    }//GEN-LAST:event_btnConfirmarActionPerformed

   /**
     * Añade el reporte revisado recibido, asegurándose que
     * no esté vacío.
     * @param reporte Reporte Revisado a añadir.
     * @throws PresentacionException Excepción de la capa de Presentación.
     */
    public void setReporte(ReporteRevisadoDTO reporte) throws PresentacionException{
        if(reporte != null)
            reporteRevisado = reporte;
         else
            throw new PresentacionException("El reporte no puede estar vacío.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLDeterminacionCaso;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAMotiviOmision;
    // End of variables declaration//GEN-END:variables
}