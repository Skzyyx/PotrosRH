package Controles;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Clase para limitar algunos campos, y así filtrar
 * mejor la información recibida por el usuario.
 * @author Leonardo Flores Leyva (252390)
 * @author José Alfredo Guzmán Moreno (252524)
 * @author Jesús Ernesto López Ibarra (252663)
 * @author José Luis Islas Molina (252574)
 * @author Benjamin Soto Coronado (253183)
 */
public class ControlCampos {
    /**
     * Asegura que un campo de texto solo reciba letras.
     * Ideal para nombres.
     * @param campo JTextField a configurar.
     */
    public static void configurarCamposTexto(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isLetter(input) && input != KeyEvent.VK_BACK_SPACE &&  input != KeyEvent.VK_DELETE && input != KeyEvent.VK_SPACE)
                    e.consume();
                
            }
        });
    }
    /**
     * Asegura que un campo de texto solo reciba letras y números.
     * Ideal para nombres.
     * @param campo JTextField a configurar.
     */
    public static void configurarCamposRFC(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isLetterOrDigit(input) && input != KeyEvent.VK_BACK_SPACE &&  input != KeyEvent.VK_DELETE && input != KeyEvent.VK_SPACE)
                    e.consume();
            }
        });
    }
    /**
     * Asegura que un campo de texto solo reciba números decimales positivos.
     * Ideal para bonos o salarios.
     * @param campo Campo a configurar.
     */
    public static void configurarCamposMonto(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isDigit(input) && input != '.' && input != KeyEvent.VK_BACK_SPACE && input != KeyEvent.VK_DELETE)
                    e.consume();
                
                if (input == '.' && campo.getText().contains(".")) 
                    e.consume();
                
            }
        });
    }
    /**
     * Asegura que un campo de texto solo reciba números enteros positivos.
     * Ideal cuando se quieren recibir únicamente cantidades.
     * @param campo Campo a configurar.
     */
    public static void configurarCamposCantidades(JTextField campo){
        for(KeyListener keyListener : Arrays.asList(campo.getKeyListeners()))
            campo.removeKeyListener(keyListener);
        
        campo.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char input = e.getKeyChar();
                if(!Character.isDigit(input) && input != KeyEvent.VK_BACK_SPACE &&  input != KeyEvent.VK_DELETE)
                    e.consume();
            }
        });
    }
    /**
     * Aplica un límite de caracteres a un campo de texto.
     * Ideal para no superar el espacio deseado en la base
     * de datos.
     * @param campo Campo a configurar.
     * @param limite Límite de caracteres a asignar.
     */
    public static void limiteCaracteresCampoTexto(JTextField campo, int limite){
        if(limite >= 0)
            campo.setDocument(new JTextLimit(limite));
    }
    /**
     * Aplica un límite de caracteres a un área de texto.
     * Ideal para no superar el espacio deseado en la base
     * de datos.
     * @param campo Campo a configurar.
     * @param limite Límite de caracteres a asignar.
     */
    public static void limiteCaracteresAreaTexto(JTextArea campo, int limite){
        if(limite >= 0)
            campo.setDocument(new JTextLimit(limite));
    }
    /**
     * Valida que un campo de texto no esté vacío.
     * @param campo Campo a validar
     * @return VERDADERO si el campo no está vacío, FALSO en caso contrario.
     */
    public static boolean validarCampoInvalidoTexto(JTextField campo){return !campo.getText().trim().isEmpty();}
    /**
     * Asegura que un campo de texto no esté vacío y el monto
     * ingresado no sea menor a cero.
     * @param campo Campo a validar
     * @return VERDADERO si el campo no está vacío y el monto ingresado es mayor a cero, FALSO en caso contrario.
     */
    public static boolean validarCampoInvalidoMontos(JTextField campo){return !campo.getText().trim().isEmpty() && Double.parseDouble(campo.getText()) > 0.0;}
    /**
     * Asegura que un campo de texto no esté vacío y la cantidad
     * ingresada ingresado no sea menor a cero.
     * @param campo Campo a validar
     * @return VERDADERO si el campo no está vacío y la cantidad ingresada es mayor a cero, FALSO en caso contrario.
     */
    public static boolean validarCampoInvalidoCantidades(JTextField campo){return !campo.getText().trim().isEmpty() && Integer.parseInt(campo.getText()) > 0;}
}