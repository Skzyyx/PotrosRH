package Paneles;

import Controles.ControlFlujo;
import Controles.ControlNomina;
import Enums.Bonos;
import Excepciones.PresentacionException;
import OptionPane.OptionPane;
import dto.EmpleadoDTO;
import dto.NominaDTO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class PrevisualizarNomina extends javax.swing.JPanel {

    private NominaDTO nomina;
    /**
     * Creates new form PrevisualizarNomina
     */
    public PrevisualizarNomina() {initComponents();}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGenerar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int arc = 50; // Radio de redondeo

                // Dibujar fondo redondeado
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arc, arc));

                g2.dispose();

                // Llamar a la implementación original para pintar los componentes hijos
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                // No pintar el borde predeterminado
            }
        }
        ;
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblBono = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        lblApellidoPaternoEmpleado = new javax.swing.JLabel();
        lblApellidoMaternoEmpleado = new javax.swing.JLabel();
        lblRfcEmpleado = new javax.swing.JLabel();
        lblPuestoEmpleado = new javax.swing.JLabel();
        lblEstadoEmpleado = new javax.swing.JLabel();
        lblHorasTrabajadasEmpleado = new javax.swing.JLabel();
        lblHorasExtraEmpleado = new javax.swing.JLabel();
        lblSalarioBrutoEmpleado = new javax.swing.JLabel();
        lblIsrEmpleado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSalarioNetoEmpleado = new javax.swing.JLabel();
        bonoSelector = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(17, 119, 202));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        btnGenerar.setBackground(new java.awt.Color(44, 44, 44));
        btnGenerar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(44, 44, 44));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(1820, 23));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(17, 119, 202));
        jPanel3.setMinimumSize(new java.awt.Dimension(1280, 1280));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 520));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1190, 508));
        jPanel1.setMinimumSize(new java.awt.Dimension(1190, 508));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 508));
        jPanel1.setOpaque(false); // Hacer el panel transparente para que se vea el fondo redondeado
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel3.setText("Apellido paterno:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel4.setText("Apellido materno:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        jLabel5.setText("RFC:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel6.setText("Puesto:");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel7.setText("Estado:");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel8.setText("Horas trabajadas:");

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel9.setText("Horas extra:");

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel11.setText("Salario bruto:");

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        jLabel13.setText("ISR:");

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel10.setText("Bono:");

        lblBono.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblBono.setText("0.0");

        lblNombreEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblNombreEmpleado.setText(".");

        lblApellidoPaternoEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblApellidoPaternoEmpleado.setText(".");

        lblApellidoMaternoEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblApellidoMaternoEmpleado.setText(".");

        lblRfcEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblRfcEmpleado.setText(".");

        lblPuestoEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblPuestoEmpleado.setText(".");

        lblEstadoEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblEstadoEmpleado.setText(".");

        lblHorasTrabajadasEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblHorasTrabajadasEmpleado.setText(".");

        lblHorasExtraEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblHorasExtraEmpleado.setText(".");

        lblSalarioBrutoEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblSalarioBrutoEmpleado.setText(".");

        lblIsrEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblIsrEmpleado.setText(".");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel12.setText("Nómina de Empleado");
        jPanel2.add(jLabel12);

        jLabel15.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel15.setText("Salario neto:");

        lblSalarioNetoEmpleado.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        lblSalarioNetoEmpleado.setText(".");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstadoEmpleado)
                    .addComponent(lblNombreEmpleado)
                    .addComponent(lblRfcEmpleado)
                    .addComponent(lblApellidoMaternoEmpleado)
                    .addComponent(lblApellidoPaternoEmpleado)
                    .addComponent(lblPuestoEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblIsrEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSalarioBrutoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSalarioNetoEmpleado))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblBono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHorasExtraEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHorasTrabajadasEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(225, 225, 225))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreEmpleado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblApellidoPaternoEmpleado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblApellidoMaternoEmpleado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblRfcEmpleado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPuestoEmpleado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblEstadoEmpleado)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblHorasTrabajadasEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHorasExtraEmpleado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(lblBono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSalarioBrutoEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIsrEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSalarioNetoEmpleado)))
                        .addGap(6, 6, 6)))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1);

        bonoSelector.setModel(new javax.swing.DefaultComboBoxModel<>());
        bonoSelector.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bonoSelectorItemStateChanged(evt);
            }
        });
        bonoSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonoSelectorActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 19)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Agregar bono:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(bonoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnGenerar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bonoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGenerar});

        btnGenerar.setBorderPainted(false);
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setOpaque(false);
        btnGenerar.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        Bonos[] bonos = Bonos.values();
        for (Bonos bono : bonos) {
            bonoSelector.addItem(bono.toString());
        }
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ControlFlujo.mostrarBusquedaEmpleado();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked

    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            nomina.setBono(Double.parseDouble(lblBono.getText()));
            nomina.setSalarioNeto(Double.parseDouble(lblSalarioNetoEmpleado.getText()));

            if(ControlNomina.getInstance().guardarNomina(nomina))
                OptionPane.showInfoMessage(this, "Nomina guardada con exito", "Exito");
            
            ControlFlujo.mostrarBusquedaEmpleado();
        } catch (PresentacionException ex) {
            Logger.getLogger(PrevisualizarNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void bonoSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bonoSelectorItemStateChanged

    }//GEN-LAST:event_bonoSelectorItemStateChanged

    private void bonoSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonoSelectorActionPerformed
        actualizarBono();
    }//GEN-LAST:event_bonoSelectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bonoSelector;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblApellidoMaternoEmpleado;
    private javax.swing.JLabel lblApellidoPaternoEmpleado;
    private javax.swing.JLabel lblBono;
    private javax.swing.JLabel lblEstadoEmpleado;
    private javax.swing.JLabel lblHorasExtraEmpleado;
    private javax.swing.JLabel lblHorasTrabajadasEmpleado;
    private javax.swing.JLabel lblIsrEmpleado;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblPuestoEmpleado;
    private javax.swing.JLabel lblRfcEmpleado;
    private javax.swing.JLabel lblSalarioBrutoEmpleado;
    private javax.swing.JLabel lblSalarioNetoEmpleado;
    // End of variables declaration//GEN-END:variables
    
    public JLabel getLblApellidoMaternoEmpleado() {return lblApellidoMaternoEmpleado;}

    public void setLblApellidoMaternoEmpleado(JLabel lblApellidoMaternoEmpleado) {this.lblApellidoMaternoEmpleado = lblApellidoMaternoEmpleado;}

    public JLabel getLblApellidoPaternoEmpleado() {return lblApellidoPaternoEmpleado;}

    public void setLblApellidoPaternoEmpleado(JLabel lblApellidoPaternoEmpleado) {this.lblApellidoPaternoEmpleado = lblApellidoPaternoEmpleado;}

    public JLabel getLblEstadoEmpleado() {return lblEstadoEmpleado;}

    public void setLblEstadoEmpleado(JLabel lblEstadoEmpleado) {this.lblEstadoEmpleado = lblEstadoEmpleado;}

    public JLabel getLblHorasExtraEmpleado() {return lblHorasExtraEmpleado;}

    public void setLblHorasExtraEmpleado(JLabel lblHorasExtraEmpleado) {this.lblHorasExtraEmpleado = lblHorasExtraEmpleado;}

    public JLabel getLblHorasTrabajadasEmpleado() {return lblHorasTrabajadasEmpleado;}

    public void setLblHorasTrabajadasEmpleado(JLabel lblHorasTrabajadasEmpleado) {this.lblHorasTrabajadasEmpleado = lblHorasTrabajadasEmpleado;}

    public JLabel getLblIsrEmpleado() {return lblIsrEmpleado;}

    public void setLblIsrEmpleado(JLabel lblIsrEmpleado) {this.lblIsrEmpleado = lblIsrEmpleado;}

    public JLabel getLblNombreEmpleado() {return lblNombreEmpleado;}

    public void setLblNombreEmpleado(JLabel lblNombreEmpleado) {this.lblNombreEmpleado = lblNombreEmpleado;}

    public JLabel getLblPuestoEmpleado() {return lblPuestoEmpleado;}

    public void setLblPuestoEmpleado(JLabel lblPuestoEmpleado) {this.lblPuestoEmpleado = lblPuestoEmpleado;}

    public JLabel getLblRfcEmpleado() {return lblRfcEmpleado;}

    public void setLblRfcEmpleado(JLabel lblRfcEmpleado) {this.lblRfcEmpleado = lblRfcEmpleado;}

    public JLabel getLblSalarioBrutoEmpleado() {return lblSalarioBrutoEmpleado;}

    public void setLblSalarioBrutoEmpleado(JLabel lblSalarioBrutoEmpleado) {this.lblSalarioBrutoEmpleado = lblSalarioBrutoEmpleado;}

    public JLabel getLblBono() {return lblBono;}

    public void setLblBono(JLabel lblBono) {this.lblBono = lblBono;}

    public JLabel getLblSalarioNetoEmpleado() {return lblSalarioNetoEmpleado;}

    public void setLblSalarioNetoEmpleado(JLabel lblSalarioNetoEmpleado) {this.lblSalarioNetoEmpleado = lblSalarioNetoEmpleado;}

    private void actualizarBono() {
        try {
            String rfc = lblRfcEmpleado.getText();
            String item = (String) bonoSelector.getSelectedItem();
            
            if (item.equals("NINGUNO") && ControlNomina.getInstance().obtenerEmpleado(rfc) == null) {
                return;
            }
            double bono = Bonos.valueOf(item).getCantidad();
            lblBono.setText(String.valueOf(bono));
            
            double salarioBruto = ControlNomina.getInstance().obtenerEmpleado(rfc).getSalarioBase() + bono;
            lblSalarioBrutoEmpleado.setText(String.valueOf(salarioBruto));
            
            double isr = nomina.getIsr();
            double salarioNeto = salarioBruto - isr;
            lblSalarioNetoEmpleado.setText(String.format("%.1f", salarioNeto));
        } catch (PresentacionException ex) {
            Logger.getLogger(PrevisualizarNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDatosNomina(NominaDTO nomina) {
        this.nomina = nomina;
        
        EmpleadoDTO empleado = nomina.getEmpleado();
        lblNombreEmpleado.setText(empleado.getNombre());
        lblApellidoPaternoEmpleado.setText(empleado.getApellidoPaterno());
        lblApellidoMaternoEmpleado.setText(empleado.getApellidoMaterno());
        lblRfcEmpleado.setText(empleado.getRfc());
        lblPuestoEmpleado.setText(empleado.getPuesto());
        lblEstadoEmpleado.setText(String.valueOf(empleado.getEstado()));
        lblHorasTrabajadasEmpleado.setText(String.valueOf(nomina.getHorasTrabajadas()));
        lblHorasExtraEmpleado.setText(String.valueOf(nomina.getHoraExtra()));
        lblSalarioBrutoEmpleado.setText(String.valueOf(nomina.getSalarioBruto()));
        lblIsrEmpleado.setText(String.format("%.1f", nomina.getIsr()));
        lblSalarioNetoEmpleado.setText(String.format("%.1f", nomina.getSalarioNeto()));
    }
}