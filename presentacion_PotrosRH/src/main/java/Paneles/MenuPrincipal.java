package Paneles;

import Controles.ControlFlujo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class MenuPrincipal extends javax.swing.JPanel {

    private static MenuPrincipal instance;
    
    /**
     * Creates new form MenuPrincipal
     */
    private MenuPrincipal() {initComponents();}
    
    public static MenuPrincipal getInstance() {
        if (instance == null) {
            instance = new MenuPrincipal();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContrataciones = new javax.swing.JButton();
        btnDespedirEmpleado = new javax.swing.JButton();
        btnNominas = new javax.swing.JButton();
        btnAsistencias = new javax.swing.JButton();
        btnExpedientes = new javax.swing.JButton();
        btnReportarEmpleado = new javax.swing.JButton();

        setBackground(new java.awt.Color(17, 119, 202));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));

        btnContrataciones.setBackground(new java.awt.Color(44, 44, 44));
        btnContrataciones.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnContrataciones.setForeground(new java.awt.Color(255, 255, 255));
        btnContrataciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Contrataciones.png"))); // NOI18N
        btnContrataciones.setText("Contrataciones");
        btnContrataciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContratacionesActionPerformed(evt);
            }
        });

        btnDespedirEmpleado.setBackground(new java.awt.Color(44, 44, 44));
        btnDespedirEmpleado.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnDespedirEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnDespedirEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DespedirEmpleado.png"))); // NOI18N
        btnDespedirEmpleado.setText("<html>Despedir<br>Empleado</html>");
        btnDespedirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespedirEmpleadoActionPerformed(evt);
            }
        });

        btnNominas.setBackground(new java.awt.Color(44, 44, 44));
        btnNominas.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnNominas.setForeground(new java.awt.Color(255, 255, 255));
        btnNominas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Nominas.png"))); // NOI18N
        btnNominas.setText("Nóminas");
        btnNominas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNominasActionPerformed(evt);
            }
        });

        btnAsistencias.setBackground(new java.awt.Color(44, 44, 44));
        btnAsistencias.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnAsistencias.setForeground(new java.awt.Color(255, 255, 255));
        btnAsistencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Asistencias.png"))); // NOI18N
        btnAsistencias.setText("Asistencias");
        btnAsistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciasActionPerformed(evt);
            }
        });

        btnExpedientes.setBackground(new java.awt.Color(44, 44, 44));
        btnExpedientes.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnExpedientes.setForeground(new java.awt.Color(255, 255, 255));
        btnExpedientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Expedientes.png"))); // NOI18N
        btnExpedientes.setText("Expedientes");
        btnExpedientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpedientesActionPerformed(evt);
            }
        });

        btnReportarEmpleado.setBackground(new java.awt.Color(44, 44, 44));
        btnReportarEmpleado.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnReportarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnReportarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ReportarEmpleado.png"))); // NOI18N
        btnReportarEmpleado.setText("<html>Reportar<br>Empleado</html>");
        btnReportarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnContrataciones, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDespedirEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReportarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnContrataciones, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNominas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDespedirEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReportarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        btnContrataciones.setBorderPainted(false);
        btnContrataciones.setContentAreaFilled(false);
        btnContrataciones.setOpaque(false);
        btnContrataciones.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnDespedirEmpleado.setBorderPainted(false);
        btnDespedirEmpleado.setContentAreaFilled(false);
        btnDespedirEmpleado.setOpaque(false);
        btnDespedirEmpleado.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnNominas.setBorderPainted(false);
        btnNominas.setContentAreaFilled(false);
        btnNominas.setOpaque(false);
        btnNominas.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnAsistencias.setBorderPainted(false);
        btnAsistencias.setContentAreaFilled(false);
        btnAsistencias.setOpaque(false);
        btnAsistencias.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnExpedientes.setBorderPainted(false);
        btnExpedientes.setContentAreaFilled(false);
        btnExpedientes.setOpaque(false);
        btnExpedientes.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnReportarEmpleado.setBorderPainted(false);
        btnReportarEmpleado.setContentAreaFilled(false);
        btnReportarEmpleado.setOpaque(false);
        btnReportarEmpleado.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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

    private void btnContratacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContratacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContratacionesActionPerformed

    private void btnDespedirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespedirEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDespedirEmpleadoActionPerformed

    private void btnNominasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNominasActionPerformed
        ControlFlujo.mostrarBusquedaEmpleado();

    }//GEN-LAST:event_btnNominasActionPerformed

    private void btnAsistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsistenciasActionPerformed

    private void btnExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpedientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExpedientesActionPerformed

    private void btnReportarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportarEmpleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencias;
    private javax.swing.JButton btnContrataciones;
    private javax.swing.JButton btnDespedirEmpleado;
    private javax.swing.JButton btnExpedientes;
    private javax.swing.JButton btnNominas;
    private javax.swing.JButton btnReportarEmpleado;
    // End of variables declaration//GEN-END:variables
}