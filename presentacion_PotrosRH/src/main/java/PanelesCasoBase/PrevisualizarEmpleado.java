package PanelesCasoBase;

import Controles.ControlFlujo;
import Controles.ControlNomina;
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
import javax.swing.JOptionPane;

/**
 * Clase para previsualizar los datos del empleado obtenido, antes
 * de generar la nómina.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class PrevisualizarEmpleado extends javax.swing.JPanel {
    /**
     * EmpleadoDTO, con la información completa del empleado asociado a la nómina.
     */
    private EmpleadoDTO empleadoDTO = new EmpleadoDTO();;
    /**
     * Creates new form PrevisualisarEmpleado
     */
    public PrevisualizarEmpleado() {initComponents();}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnGenerar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
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
        };
        ;
        jLabel6 = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JLabel();
        apellidoPaternoEmpleado = new javax.swing.JLabel();
        apellidoMaternoEmpleado = new javax.swing.JLabel();
        RFCEmpleado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        puestoEmpleado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        estadoEmpleado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(17, 119, 202));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));

        btnCancelar.setBackground(new java.awt.Color(44, 44, 44));
        btnCancelar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGenerar.setBackground(new java.awt.Color(44, 44, 44));
        btnGenerar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnGenerar.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerar.setText("Generar");
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(17, 119, 202));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1190, 508));
        jPanel1.setMinimumSize(new java.awt.Dimension(1190, 508));
        jPanel1.setOpaque(false); // Hacer el panel transparente para que se vea el fondo redondeado
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel6.setText("Puesto:");

        nombreEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        nombreEmpleado.setText(".");

        apellidoPaternoEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        apellidoPaternoEmpleado.setText(".");

        apellidoMaternoEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        apellidoMaternoEmpleado.setText(".");

        RFCEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        RFCEmpleado.setText(".");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Nombre:");

        puestoEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        puestoEmpleado.setText(".");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("Apellido paterno:");

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel4.setText("Apellido materno:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setText("RFC:");

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel7.setText("Estado:");

        estadoEmpleado.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        estadoEmpleado.setText(".");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel8.setText("Información del Empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(181, 181, 181)
                                .addComponent(estadoEmpleado))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(75, 75, 75)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidoMaternoEmpleado)
                                    .addComponent(RFCEmpleado)
                                    .addComponent(puestoEmpleado)
                                    .addComponent(nombreEmpleado)
                                    .addComponent(apellidoPaternoEmpleado))))))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoPaternoEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoMaternoEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RFCEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puestoEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(estadoEmpleado))))
                .addContainerGap(188, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Botón Generar. Genera la nómina y la transfiere al
     * panel de PrevisualizarNomina.
     * @param evt Click.
     */
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        int resultado = OptionPane.showConfirmDialog(this, "¿Deseas previsualizar la nómina?", "Mensaje de confirmación");
        if (resultado == JOptionPane.YES_OPTION) {
            try {
                NominaDTO nominaGenerada = ControlNomina.getInstance().generarNomina(empleadoDTO);
                ControlFlujo.mostrarPrevisualizarNomina(nominaGenerada, empleadoDTO);
            } catch (PresentacionException ex) {
                Logger.getLogger(PrevisualizarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                OptionPane.showErrorMessage(this, ex.getMessage(), "Error");
            }
        }
    }//GEN-LAST:event_btnGenerarActionPerformed
    /**
     * Regresa a la búsqueda de empleados al hacer click
     * en el botón cancelar.
     * @param evt Click..
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpia los campos.
        nombreEmpleado.setText("");
        apellidoPaternoEmpleado.setText("");
        apellidoMaternoEmpleado.setText("");
        RFCEmpleado.setText("");
        puestoEmpleado.setText("");
        estadoEmpleado.setText(String.valueOf(""));
        // Regresa a la búsqueda de empleados.
        ControlFlujo.mostrarBusquedaEmpleado();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RFCEmpleado;
    private javax.swing.JLabel apellidoMaternoEmpleado;
    private javax.swing.JLabel apellidoPaternoEmpleado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel estadoEmpleado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombreEmpleado;
    private javax.swing.JLabel puestoEmpleado;
    // End of variables declaration//GEN-END:variables

    /**
    * Actualiza los componentes de la interfaz con los datos del empleado.
    * Recibe un objeto EmpleadoDTO y actualiza las etiquetas correspondientes 
    * con la información del empleado (nombre, apellido paterno, apellido materno, RFC, 
    * puesto y estado).
    * @param empleado Objeto EmpleadoDTO con los datos del empleado.
    * @throws PresentacionException Excepción de la capa de Presentación.
    */
    public void setDatosEmpleado(EmpleadoDTO empleado) throws PresentacionException {
        if(empleado != null){
            empleadoDTO = empleado;
            System.out.println(empleadoDTO.toString());
            nombreEmpleado.setText(empleadoDTO.getNombre());
            apellidoPaternoEmpleado.setText(empleadoDTO.getApellidoPaterno());
            apellidoMaternoEmpleado.setText(empleadoDTO.getApellidoMaterno());
            RFCEmpleado.setText(empleadoDTO.getRfc());
            puestoEmpleado.setText(empleadoDTO.getPuesto());
            estadoEmpleado.setText(String.valueOf(empleadoDTO.getEstado()));
        } else
            throw new PresentacionException("El empleado está vacío.");
    }
}