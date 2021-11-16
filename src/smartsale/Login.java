package smartsale;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class Login extends JFrame {
    //INSTANCIA CLASE PUNTO DE VENTA
    PuntodeVenta punto = new PuntodeVenta();
    //INSTANCIA CLASE CONFIGURACIÓN
    Configurar config = new Configurar();

    //OBJETOS
    private JLabel etiquetaNickName;
    private JLabel etiquetaPassword;
    private JTextField campoNickName;
    private JTextField campoPassword;
    private JButton Iniciar;
    private JButton Reiniciar;
    private JButton Configurar;
    private final String rutaNickName = System.getProperties().getProperty("user.dir");
    private final String rutaPassword = System.getProperties().getProperty("user.dir");
    private final String rutaNombre =System.getProperties().getProperty("user.dir");
    String usser = "", password = "";

   /* public void nombreNegocio() {
        File archNombreNegocio = null;
        FileReader FileNombreNegocio = null;
        BufferedReader BufferedNombreNegocio = null;

        try {
            archNombreNegocio = new File(rutaNombre + "//Almacen.txt");
            FileNombreNegocio = new FileReader(archNombreNegocio);
            BufferedNombreNegocio = new BufferedReader(FileNombreNegocio);
            String informacionNegocio = null;
            while ((informacionNegocio = BufferedNombreNegocio.readLine()) != null) {
                nombreNegocio=informacionNegocio;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (null != FileNombreNegocio) {
                    FileNombreNegocio.close();
                }
            } catch (IOException e2) {
            }
        }
    }*/
    
     //CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR
    public Login() {
        setTitle("");
        setSize(450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        Objetos();
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

        Configurar = new JButton("CONFIGURAR");
        Configurar.setFont(new Font("new times roman", Font.PLAIN, 13));
        Configurar.setBounds(220, 200, 130, 25);
        add(Configurar);

        //ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR//ACCIÓN DEL BOTÓN INCIAR
        Iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //LEE LO QUE HAY EN TXT USUARIO
                File archUsuario = null;
                FileReader FileUsuario = null;
                BufferedReader BufferedUsuario = null;

                try {
                    archUsuario = new File(rutaNickName + "//Usuario.txt");
                    FileUsuario = new FileReader(archUsuario);
                    BufferedUsuario = new BufferedReader(FileUsuario);
                    String informacionUsuario = null;
                    while ((informacionUsuario = BufferedUsuario.readLine()) != null) {
                        usser = informacionUsuario;
                    }
                } catch (Exception e) {
                } finally {
                    try {
                        if (null != FileUsuario) {
                            FileUsuario.close();
                        }
                    } catch (IOException e2) {

                    }
                }

                //LEE LO QUE HAY EN TXT PASSWORD
                File archPassword = null;
                FileReader FilePassword = null;
                BufferedReader BufferedPassword = null;

                try {
                    archPassword = new File(rutaPassword + "//Password.txt");
                    FilePassword = new FileReader(archPassword);
                    BufferedPassword = new BufferedReader(FilePassword);
                    String informacionPassword = null;

                    while ((informacionPassword = BufferedPassword.readLine()) != null) {
                        password = informacionPassword;
                    }
                } catch (Exception e) {
                } finally {
                    try {
                        if (null != FilePassword) {
                            FilePassword.close();
                        }
                    } catch (IOException e2) {

                    }
                }

                if (campoNickName.getText().equals(usser) &&campoPassword.getText().equals(password) ) {
                    punto.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"USUARIO O CONTRASEÑA SON INCORRECTOS \n POR FAVOR INTENTE DE NUEVO");
                    campoNickName.setText("");
                    campoPassword.setText("");
                }
            }
        }
        );

        //ACCIÓN REINCIAR
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

        //ACCIÓN CONFIGURAR
        Configurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                config.setVisible(true);
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
