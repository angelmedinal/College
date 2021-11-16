package smartsale;
//package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Login extends JFrame {

    //INSTANCIA CLASE PUNTO DE VENTA

    PuntodeVenta punto = new PuntodeVenta();

    //OBJETOS
    private JLabel etiquetaNickName;
    private JLabel etiquetaPassword;
    private JTextField campoNickName;
    private JTextField campoPassword;
    private JButton Iniciar;
    private JButton Reiniciar;

    //CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR
    public Login() {
        setSize(450, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        Objetos();
        Bloqueo();
    }

    private void Bloqueo() {

    }

    //CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS
    private void Objetos() {
        //ETIQUETA NICKNAME
        etiquetaNickName = new JLabel("USUARIO:");
        etiquetaNickName.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        etiquetaNickName.setBounds(50, 50, 100, 25);
        add(etiquetaNickName);

        //ETIQUETA PASSWORD
        etiquetaPassword = new JLabel("PASSWORD:");
        etiquetaPassword.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        etiquetaPassword.setBounds(50, 100, 100, 25);
        add(etiquetaPassword);
        setLayout(null);

        //CAMPO NICKNAME
        campoNickName = new JTextField();
        campoNickName.setBounds(150, 50, 200, 25);
        add(campoNickName);

        //CAMPOPASSWORD
        campoPassword = new JTextField();
        campoPassword.setBounds(150, 100, 200, 25);
        add(campoPassword);

        //BOTÓN REINCIAR
        Reiniciar = new JButton("REINICIAR");
        Reiniciar.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        Reiniciar.setBounds(50, 150, 130, 25);
        add(Reiniciar);

        //BOTÓN INCIAR
        Iniciar = new JButton("INICIAR");
        Iniciar.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        Iniciar.setBounds(220, 150, 130, 25);
        add(Iniciar);

        //ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR
        Iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                punto.setVisible(true);
               /* int opc = 0;
                if (campoNickName.getText().equals("Axel") && campoPassword.getText().equals("123")) {//"12c13e20ccecaxutp"
                    punto.setVisible(true);
                } else {
                    if (campoNickName.getText() != "Axel") {
                        JOptionPane.showMessageDialog(null, "NickName Erroneo");
                        opc = 2;
                    } else {
                        if (campoPassword.getText() != "123") {
                            JOptionPane.showMessageDialog(null, "Password Erroneo");
                            opc = 3;
                        } else {
                            if (campoNickName.getText() != "Axel" && campoPassword.getText() != "123") {
                                JOptionPane.showMessageDialog(null, "T Erroneo");
                                opc = 4;
                            }
                        }
                    }
                }*/
            }
        });

        //ACCIÓ REINCIAR
        Reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                if (campoNickName.getText().isEmpty() && campoPassword.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay Datos para borrar");
                } else {
                    campoNickName.setText("");
                    campoPassword.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
