package PanelesCasoBase;

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

/**
 * Clase para previsualizar los datos de la nómina generada.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class PrevisualizarNomina extends javax.swing.JPanel {
    // Nómina a mostrar.
    private NominaDTO nomina;
    private EmpleadoDTO empleado;
    private double bono = 0.0;

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

        btnRegistrar = new javax.swing.JButton();
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

        btnRegistrar.setBackground(new java.awt.Color(44, 44, 44));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(44, 44, 44));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setMaximumSize(new java.awt.Dimension(1820, 23));
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
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(bonoSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnRegistrar});

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
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnRegistrar});

        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setOpaque(false);
        btnRegistrar.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
    /**
     * Botón Cancelar. Cancela toda la operación.
     * @param evt Click.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        ControlFlujo.mostrarBusquedaEmpleado();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Botón Registrar. Registra la nómina y muestra un
     * mensaje de confirmación.
     * @param evt Click.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if(bono > 0.0)
                nomina.setBono(bono);

            if (ControlNomina.getInstance().guardarNomina(nomina) != null) 
                OptionPane.showInfoMessage(this, "Nomina guardada con éxito", "Éxito");

            ControlFlujo.mostrarBusquedaEmpleado();
            
        } catch (PresentacionException ex) {
            Logger.getLogger(PrevisualizarNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    /**
     * CheckBox para seleccionar el bono de la nómina.
     * @param evt Cambio de selección.
     */
    private void bonoSelectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bonoSelectorItemStateChanged
        if(empleado != null)
            actualizarBono();
    }//GEN-LAST:event_bonoSelectorItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bonoSelector;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
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

    /**
    * Actualiza el bono del empleado y recalcula su salario bruto y neto.
    * 
    * Este método obtiene el RFC del empleado, el bono seleccionado y actualiza la información 
    * del bono, salario bruto y salario neto en la interfaz de usuario. Si el RFC o el bono son 
    * inválidos, el método simplemente retorna sin realizar cambios.
    * 
    * @throws PresentacionException Si ocurre un error al obtener los datos del empleado o 
    * al realizar alguna operación relacionada con el bono.
    */
    private void actualizarBono() {
        try {
            
            String item = (String) bonoSelector.getSelectedItem();
            
            EmpleadoDTO empleadoEncontrado = ControlNomina.getInstance().obtenerEmpleado(empleado);
            if (empleadoEncontrado == null) 
                return;
            
            if (Bonos.valueOf(item) == null) 
                return;
            
            Bonos bonoEnum = Bonos.valueOf(item);
            bono = bonoEnum.getCantidad();
            lblBono.setText(String.format("$%.2f", bono));

            double salarioBruto = nomina.getSalarioBruto() + bono;
            lblSalarioBrutoEmpleado.setText(String.format("$%.2f", salarioBruto));
            
            double salarioNeto = salarioBruto - nomina.getIsr();
            nomina.setSalarioNeto(salarioBruto - nomina.getIsr());
            lblSalarioNetoEmpleado.setText(String.format("$%.2f", salarioNeto));
        } catch (PresentacionException ex) {
            Logger.getLogger(PrevisualizarNomina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
    * Actualiza los componentes de la interfaz con los datos de la nómina y el empleado.
    * 
    * Recibe un objeto NominaDTO y actualiza las etiquetas correspondientes con la 
    * información del empleado (nombre, RFC, puesto, estado) y los detalles de la nómina 
    * (horas trabajadas, horas extras, salario bruto, ISR y salario neto).
    * @param empleado Empleado asociado a la nómina.
    * @param nomina Objeto NominaDTOcon los datos de la nómina.
    * @throws PresentacionException Excepción de la capa de Presentación.
    */
    public void setDatosNomina(NominaDTO nomina,EmpleadoDTO empleado) throws PresentacionException {
        if(empleado != null && nomina != null){
            this.nomina = nomina;
            this.empleado=empleado;
            System.out.println(nomina.toString());
            lblNombreEmpleado.setText(empleado.getNombre());
            lblApellidoPaternoEmpleado.setText(empleado.getApellidoPaterno());
            lblApellidoMaternoEmpleado.setText(empleado.getApellidoMaterno());
            lblRfcEmpleado.setText(empleado.getRfc());
            lblPuestoEmpleado.setText(empleado.getPuesto());
            lblEstadoEmpleado.setText(String.valueOf(empleado.getEstado()));
            lblHorasTrabajadasEmpleado.setText(String.format("%.1f", nomina.getHorasTrabajadas()));
            lblHorasExtraEmpleado.setText(String.format("%.1f", nomina.getHorasExtra()));
            lblSalarioBrutoEmpleado.setText(String.format("$%.2f", nomina.getSalarioBruto()));
            lblIsrEmpleado.setText(String.format("$%.2f", nomina.getIsr()));
            lblSalarioNetoEmpleado.setText(String.format("$%.2f", nomina.getSalarioNeto()));
        } else
            throw new PresentacionException("La nómina o el empleado están vacíos.");
        
    }
}