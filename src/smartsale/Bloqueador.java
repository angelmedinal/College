package smartsale;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//ESTO SIRVE PARA BLOQUEAR LOS DIGITOS O CARÁCTERES EN LAS TEXTFIELDS
public class Bloqueador {

    //METODO PUBLICO QUE BLOQUEA CÁRACTERES Y SOLO ACEPTA NÚMEROS
    public void num(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

       //METODO PUBLICO QUE BLOQUEA CÁRACTERES Y SOLO ACEPTA NÚMEROS Y DECIMALES
    public void numdec(final JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) &&  c != '.') {
                    e.consume();
                }
                if (c == '.' && a.getText().contains(".")) {
                    e.consume();
                }
            }
        });
    }
    
    //MÉTODO PUBLIC QUE BLOQUEA NÚMEROS Y SOLO ACEPTA LETRAS Y ESPACIOS
    public void let(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                    e.consume();
                }
            }
        });
    }

    //BLOQUEA AREAS TANTO PARA NUMEROS COMO PARA LETRAS
    public void arenum(JTextArea c) {
        c.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //if(!Character.isLetter(c) && !Character.isSpaceChar(c) || !Character.isDigit(c) &&!Character.isSpaceChar(c) ){
                if (!Character.isLetter(c) || !Character.isSpaceChar(c) || !Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
}
