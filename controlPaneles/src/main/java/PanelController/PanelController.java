/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PanelController;

import javax.swing.JPanel;

/**
 *
 * @author skyro
 */
public class PanelController {

    // Método para cambiar la visibilidad de los paneles
    public static void showPanel(JPanel currentPanel, JPanel targetPanel) {
        if (currentPanel != null) {
            currentPanel.setVisible(false); // Ocultar el panel actual
        }
        currentPanel = targetPanel;
        currentPanel.setVisible(true); // Mostrar el panel objetivo
    }
}
