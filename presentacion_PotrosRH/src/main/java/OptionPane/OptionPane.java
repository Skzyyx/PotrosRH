/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OptionPane;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class OptionPane {
    
    // Cargar iconos personalizados
    private static final Icon INFO_ICON = new ImageIcon(OptionPane.class.getResource("/Images/OptionPane/InfoIcon.png"));
    private static final Icon WARNING_ICON = new ImageIcon(OptionPane.class.getResource("/Images/OptionPane/WarningIcon.png"));
    private static final Icon ERROR_ICON = new ImageIcon(OptionPane.class.getResource("/Images/OptionPane/ErrorIcon.png"));
    private static final Icon QUESTION_ICON = new ImageIcon(OptionPane.class.getResource("/Images/OptionPane/QuestionIcon.png"));

    // Método para mostrar un mensaje de información
    public static void showInfoMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE, INFO_ICON);
    }

    // Método para mostrar un mensaje de advertencia
    public static void showWarningMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.WARNING_MESSAGE, WARNING_ICON);
    }

    // Método para mostrar un mensaje de error
    public static void showErrorMessage(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE, ERROR_ICON);
    }

    // Método para mostrar una pregunta
    public static int showConfirmDialog(Component parent, String message, String title) {
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, QUESTION_ICON);
    }
}
