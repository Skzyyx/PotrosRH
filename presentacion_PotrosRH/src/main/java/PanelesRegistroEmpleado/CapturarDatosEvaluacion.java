/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelesRegistroEmpleado;

import Controles.ControlFlujo;
import Controles.ControlRegistro;
import Excepciones.PresentacionException;
import OptionPane.OptionPane;
import dto.CandidatoDTO;
import dto.EvaluacionDTO;
import dto.PreguntaDTO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author skyro
 */
public class CapturarDatosEvaluacion extends javax.swing.JPanel {

    private CandidatoDTO candidato;

    /**
     * Creates new form CapturarDatosEvaluacion
     */
    public CapturarDatosEvaluacion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taPuntuacionesClave = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taNotas = new javax.swing.JTextArea();
        btnVolver = new javax.swing.JButton();
        btnTerminar = new javax.swing.JButton();
        btnAgregarPregunta = new javax.swing.JButton();
        btnEliminarPregunta = new javax.swing.JButton();

        setBackground(new java.awt.Color(17, 119, 202));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(17, 119, 202));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Evaluación");
        jPanel1.add(jLabel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Pregunta", "Pregunta", "Respuesta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Preguntas:");

        taPuntuacionesClave.setColumns(20);
        taPuntuacionesClave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taPuntuacionesClave.setRows(5);
        taPuntuacionesClave.setLineWrap(true);          // Habilita el salto de línea
        taPuntuacionesClave.setWrapStyleWord(true);    // Asegura que corte por palabra y no a la mitad
        jScrollPane2.setViewportView(taPuntuacionesClave);
        taPuntuacionesClave.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150), 1, true),
            javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Puntuaciones Clave:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Notas:");

        taNotas.setColumns(20);
        taNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        taNotas.setRows(5);
        taNotas.setLineWrap(true);          // Habilita el salto de línea
        taNotas.setWrapStyleWord(true);    // Asegura que corte por palabra y no a la mitad
        jScrollPane3.setViewportView(taNotas);
        taNotas.setBorder(javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150), 1, true),
            javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        btnVolver.setBackground(new java.awt.Color(44, 44, 44));
        btnVolver.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setMaximumSize(new java.awt.Dimension(1820, 23));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnTerminar.setBackground(new java.awt.Color(44, 44, 44));
        btnTerminar.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        btnTerminar.setForeground(new java.awt.Color(255, 255, 255));
        btnTerminar.setText("Terminar");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        btnAgregarPregunta.setBackground(new java.awt.Color(44, 44, 44));
        btnAgregarPregunta.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAgregarPregunta.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPregunta.setText("Agregar Pregunta");
        btnAgregarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPreguntaActionPerformed(evt);
            }
        });

        btnEliminarPregunta.setBackground(new java.awt.Color(44, 44, 44));
        btnEliminarPregunta.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEliminarPregunta.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPregunta.setText("Eliminar Pregunta");
        btnEliminarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPreguntaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(172, 172, 172)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(409, 409, 409))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setOpaque(false);
        btnVolver.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnTerminar.setBorderPainted(false);
        btnTerminar.setContentAreaFilled(false);
        btnTerminar.setOpaque(false);
        btnTerminar.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
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
        btnAgregarPregunta.setBorderPainted(false);
        btnAgregarPregunta.setContentAreaFilled(false);
        btnAgregarPregunta.setOpaque(false);
        btnAgregarPregunta.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Pinta un fondo redondeado
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);
                super.paint(g2, c);
                g2.dispose();
            }
        });
        btnEliminarPregunta.setBorderPainted(false);
        btnEliminarPregunta.setContentAreaFilled(false);
        btnEliminarPregunta.setOpaque(false);
        btnEliminarPregunta.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Pinta un fondo redondeado
                g2.setColor(c.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);
                super.paint(g2, c);
                g2.dispose();
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        btnVolver();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
        btnTerminar();
    }//GEN-LAST:event_btnTerminarActionPerformed

    private void btnAgregarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPreguntaActionPerformed
        agregarPregunta();
    }//GEN-LAST:event_btnAgregarPreguntaActionPerformed

    private void btnEliminarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPreguntaActionPerformed
        eliminarPregunta();
    }//GEN-LAST:event_btnEliminarPreguntaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPregunta;
    private javax.swing.JButton btnEliminarPregunta;
    private javax.swing.JButton btnTerminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea taNotas;
    private javax.swing.JTextArea taPuntuacionesClave;
    // End of variables declaration//GEN-END:variables

    private void btnVolver() {

        int result = OptionPane.showConfirmDialog(this, "¿Estás seguro que deseas volver?", "Mensaje de Confirmación");

        if (result == JOptionPane.OK_OPTION) {
            candidato = null;
            ControlFlujo.mostrarSeleccionarCandidatoEvaluacion();
        }
    }

    private void btnTerminar() {
        try {
            int result = OptionPane.showConfirmDialog(this, "¿Deseas aceptar esta evaluación?", "Confirmación");
            EvaluacionDTO evaluacion = new EvaluacionDTO();
            if (result == JOptionPane.YES_OPTION) {
                evaluacion.setResultado("APROBADO");
            } else {
                evaluacion.setResultado("NO_APROBADO");
            }

            evaluacion.setCandidato(candidato);
            evaluacion.setFechaHoraEvaluacion(LocalDateTime.now());
            evaluacion.setNotas(taNotas.getText());
            evaluacion.setPuntuacionesClave(taPuntuacionesClave.getText());
            evaluacion.setPreguntas(obtenerPreguntas());
            ControlRegistro.getInstance().registrarEvaluacion(evaluacion);
            OptionPane.showInfoMessage(this, "Evaluación registrada exitosamente", "Éxito");
            ControlFlujo.mostrarSeleccionarCandidatoEvaluacion();
        } catch (PresentacionException ex) {
            Logger.getLogger(CapturarDatosEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarPregunta() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{null, "Nueva pregunta", "Respuesta"});

        // Actualiza la numeración
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
    }

    private void eliminarPregunta() {
        int fila = jTable1.getSelectedRow();

        if (fila == -1) {
            OptionPane.showWarningMessage(this, "Debes seleccionar una pregunta primero", "Alerta");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(fila);

        // Actualiza la numeración
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
    }

    public void setCandidato(CandidatoDTO nuevoCandidato) {
        candidato = nuevoCandidato;
    }

    private Set<PreguntaDTO> obtenerPreguntas() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        Set<PreguntaDTO> listaCandidatos = new LinkedHashSet<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String pregunta = modelo.getValueAt(i, 1).toString();
            String respuesta = modelo.getValueAt(i, 2).toString();

            PreguntaDTO preguntaDTO = new PreguntaDTO(pregunta, respuesta);
            listaCandidatos.add(preguntaDTO);
        }
        return listaCandidatos;
    }
    
    private void limpiarCampos() {
        
    }
}
