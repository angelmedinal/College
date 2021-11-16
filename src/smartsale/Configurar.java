package smartsale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Configurar extends JFrame {

    //OBJETOS
    private JLabel etiquetaNickName;
    private JLabel etiquetaPassword;
    private JLabel etiquetaMensajeBienvenida;
    private JLabel etiquetaMensajeAgradecimiento;
    private JTextField campoNickName;
    private JTextField campoPassword;
    private JButton guardarUsuario;
    private JButton guardarPassword;
    private JButton guardarBienvenida;
    private JButton guardarAgradecimiento;

    private JTextArea AreaBienvenida;
    private JScrollPane jsparea;

    private JTextArea AreaAgradecimiento;
    private JScrollPane jspareaagra;

    //CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR
    public Configurar() {
        setSize(700, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        Objetos();
        Bloqueo();
    }

    private void Bloqueo() {

    }

    //CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS
    private void Objetos() {
        //SECCIÓN USUARIO//SECCIÓN USUARIO//SECCIÓN USUARIO//SECCIÓN USUARIO//SECCIÓN USUARIO//SECCIÓN USUARIO
        //ETIQUETA NICKNAME
        etiquetaNickName = new JLabel("USUARIO:");
        etiquetaNickName.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        etiquetaNickName.setBounds(50, 50, 100, 25);
        add(etiquetaNickName);

        //CAMPO NICKNAME
        campoNickName = new JTextField();
        campoNickName.setBounds(180, 50, 200, 25);
        add(campoNickName);

        //BOTÓN GUARDAR PASSWORD
        guardarUsuario = new JButton("GUARDAR USUARIO");
        guardarUsuario.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        guardarUsuario.setBounds(400, 50, 200, 25);
        add(guardarUsuario);

        //SECCIÓN PASSWORD//SECCIÓN PASSWORD//SECCIÓN PASSWORD//SECCIÓN PASSWORD//SECCIÓN PASSWORD//SECCIÓN PASSWORD
        //ETIQUETA PASSWORD
        etiquetaPassword = new JLabel("PASSWORD:");
        etiquetaPassword.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        etiquetaPassword.setBounds(50, 100, 100, 25);
        add(etiquetaPassword);

        //CAMPO PASSWORD
        campoPassword = new JTextField();
        campoPassword.setBounds(180, 100, 200, 25);
        add(campoPassword);

        //BOTÓN GUARDAR PASSWORD
        guardarPassword = new JButton("GUARDAR PASSWORD");
        guardarPassword.setFont(new Font("new times roman", Font.PLAIN, 13));
        guardarPassword.setBounds(400, 100, 200, 25);
        add(guardarPassword);
        
        //SECCIÓN MENSAJE DE BIENVENIDA//SECCIÓN MENSAJE DE BIENVENIDA//SECCIÓN MENSAJE DE BIENVENIDA//SECCIÓN MENSAJE DE BIENVENIDA
        //ETIQUETA BIENVENIDA
        etiquetaMensajeBienvenida = new JLabel("ESCRIBA UN MENSAJE DE BIENVENIDA:");
        etiquetaMensajeBienvenida.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        etiquetaMensajeBienvenida.setBounds(50, 150, 300, 25);
        add(etiquetaMensajeBienvenida);
        
        //AREA MENSAJE DE BIENVENIDA
        AreaBienvenida = new JTextArea();
        AreaBienvenida.setLineWrap(true);
        jsparea = new JScrollPane(AreaBienvenida);
        jsparea.setBounds(50, 190, 330, 200);
        add(jsparea);
        
        //BOTÓN GUARDAR MENSAJE DE BIENVENIDA
        guardarBienvenida= new JButton("GUARDAR BIENVENIDA");
        guardarBienvenida.setFont(new Font("new times roman", Font.PLAIN, 13));
        guardarBienvenida.setBounds(400, 190, 200, 25);
        add(guardarBienvenida);
        
        //SECCIÓN MENSAJE DE AGRADECIMIENTO
        etiquetaMensajeAgradecimiento = new JLabel("ESCRIBA UN MENSAJE DE AGRADECIMIENTO:");
        etiquetaMensajeAgradecimiento .setFont(new Font("new Times Roman", Font.PLAIN, 13));
        etiquetaMensajeAgradecimiento .setBounds(50, 410, 300, 25);
        add(etiquetaMensajeAgradecimiento );
        
        //AREA MENSAJE DE BIENVENIDA
        AreaAgradecimiento = new JTextArea();
        AreaAgradecimiento.setLineWrap(true);
        jspareaagra = new JScrollPane(AreaAgradecimiento);
        jspareaagra.setBounds(50, 450, 330, 200);
        add(jspareaagra);
        
        //BOTÓN GUARDAR MENSAJE DE BIENVENIDA
        guardarAgradecimiento= new JButton("GUARDAR AGRADECIMIENTO");
        guardarAgradecimiento.setFont(new Font("new times roman", Font.PLAIN, 13));
        guardarAgradecimiento.setBounds(400, 450, 200, 25);
        add(guardarAgradecimiento);
        
        setLayout(null);

        //ACCIÓN DEL BOTÓN GUARDAR USUARIO
        guardarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //GUARDA NICKNAME
                if (campoNickName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE GUARDAR");
                } else {
                    try {
                        File ficheroU = new File("Usuario.txt");
                        ficheroU.createNewFile();
                        FileWriter fw = new FileWriter(ficheroU);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(campoNickName.getText());
                        bw.close();
                    } catch (IOException a) {
                    }
                    JOptionPane.showMessageDialog(null, "CAMBIOS GUARDADOS");
                }
            }
        }
        );

        guardarPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //GUARDA PASSWORD
                if (campoNickName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE GUARDAR");
                } else {
                    try {
                        File ficheroU = new File("Password.txt");
                        ficheroU.createNewFile();
                        FileWriter fw = new FileWriter(ficheroU);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(campoPassword.getText());
                        bw.close();
                    } catch (IOException a) {
                    }
                    JOptionPane.showMessageDialog(null, "CAMBIOS GUARDADOS");
                }
            }
        }
        );
        
        guardarBienvenida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //GUARDA PASSWORD
                if (AreaBienvenida.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE GUARDAR");
                } else {
                    try {
                        File ficheroU = new File("Bienvenida.txt");
                        ficheroU.createNewFile();
                        FileWriter fw = new FileWriter(ficheroU);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(AreaBienvenida.getText());
                        bw.close();
                    } catch (IOException a) {
                    }
                    JOptionPane.showMessageDialog(null, "CAMBIOS GUARDADOS");
                }
            }
        }
        );
        
         guardarAgradecimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //GUARDA PASSWORD
                if (AreaAgradecimiento.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE GUARDAR");
                } else {
                    try {
                        File ficheroU = new File("Agradecimiento.txt");
                        ficheroU.createNewFile();
                        FileWriter fw = new FileWriter(ficheroU);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(AreaAgradecimiento.getText());
                        bw.close();
                    } catch (IOException a) {
                    }
                    JOptionPane.showMessageDialog(null, "CAMBIOS GUARDADOS");
                }
            }
        }
        );

    }

    public static void main(String[] args) {
        Configurar configurar = new Configurar();
        configurar.setVisible(true);
        configurar.setResizable(false);
        configurar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
