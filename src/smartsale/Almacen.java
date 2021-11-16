package smartsale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Almacen extends JFrame {
    //INSNTANCIA CLASE BLOQUEO
    Bloqueador bloqueo = new Bloqueador();

    DefaultTableModel modelo;//JTABLE
    private JLabel etiProducto, etiPrecio, etiAlmacen;
    private JTextField campoNombreProducto, campoPrecioProducto;
    private JButton agregarAlmacen, limpiarCasillas;
    private JButton guardarCambios, quitarProducto;

    public Almacen() {
        setTitle("ALMACÉN");
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        Objetos();
        Bloqueo();
    }

    private void Bloqueo() {
        bloqueo.numdec(campoPrecioProducto);
    }

    private void Objetos() {
        //ETIQUETA 
        etiProducto = new JLabel("NOMBRE DEL PRODUCTO: ");
        etiProducto.setBounds(50, 30, 200, 25);
        etiProducto.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiProducto);

        etiPrecio = new JLabel("PRECIO DEL PRODUCTO:");
        etiPrecio.setBounds(50, 75, 200, 25);
        etiPrecio.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiPrecio);

        etiAlmacen = new JLabel("ALMACÉN");
        etiAlmacen.setBounds(50, 165, 100, 25);
        etiAlmacen.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiAlmacen);

        campoNombreProducto = new JTextField();
        campoNombreProducto.setBounds(250, 30, 300, 25);
        add(campoNombreProducto);

        campoPrecioProducto = new JTextField();
        campoPrecioProducto.setBounds(250, 75, 300, 25);
        add(campoPrecioProducto);

        agregarAlmacen = new JButton("AGREGAR AL ALMACEN");
        agregarAlmacen.setBounds(50, 120, 240, 25);
        agregarAlmacen.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(agregarAlmacen);

        limpiarCasillas = new JButton("LIMPIAR CASILLAS");
        limpiarCasillas.setBounds(310, 120, 240, 25);
        limpiarCasillas.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(limpiarCasillas);

        guardarCambios = new JButton("GUARDAR CAMBIOS");
        guardarCambios.setBounds(50, 460, 240, 25);
        guardarCambios.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(guardarCambios);

        quitarProducto = new JButton("QUITAR PRODUCTO");
        quitarProducto.setBounds(310, 460, 240, 25);
        quitarProducto.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(quitarProducto);
        //JTABLE
        modelo = new DefaultTableModel();
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO");
        final JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll);
        scroll.setBounds(50, 190, 500, 250);
        setLayout(null);

        //ORDENA TABLA
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modelo);
        tabla.setRowSorter(sorter);
        //BOTÓN AGREGAR
        agregarAlmacen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //bocina.sonido1();
                String[] info = new String[4];//TAMAÑO DEL JTABLE
                if (campoNombreProducto.getText().isEmpty() || campoPrecioProducto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE AGREGAR AL ALMACÉN");
                } else {
                    //NOMBRE
                    String nombre = campoNombreProducto.getText();
                    info[0] = nombre;
                    //PRECIO
                    String precio = campoPrecioProducto.getText();
                    info[1] = precio;
                    modelo.addRow(info);
                }
            }
        });

        //BOTÓN LIMPIAR CASILLAS
        limpiarCasillas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                if (campoNombreProducto.getText().isEmpty() || campoPrecioProducto.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE LIMPIAR");
                } else {
                    int resp = JOptionPane.showConfirmDialog(null, "¿DESEA LIMPIAR LAS CASILLAS?");
                    if (resp == JOptionPane.YES_OPTION) {
                        campoNombreProducto.setText("");
                        campoPrecioProducto.setText("");
                    }
                }
            }
        });

        //BOTÓN QUITAR
        quitarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //bocina.sonido1();
                int fila = tabla.getSelectedRow();//VERIFICA QUE VECTOR HA SIDO SELECCIONADO
                if (fila >= 0) {//SIGNIFICA QUE SI FUE SELECCIONADA UNA OPCIÓN
                    int respuestaquitar = JOptionPane.showConfirmDialog(null, "¿DESEA QUITAR ESTE PRODUCTO DEL CARRITO?");
                    if (respuestaquitar == JOptionPane.YES_OPTION) {
                        modelo.removeRow(fila);//REMUEVE FILA SELECCIONADA
                    }
                } else {//SIGNIFICA QUE NO FUE SELECCIONADA NINGUNA OPCIÓN
                    JOptionPane.showMessageDialog(null, "SELECCIONE ALGO A ELIMINAR");
                }
            }
        });

        //BOTÓN GUARDAR CAMBIOS
        guardarCambios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                try {
                    File fichero = new File("Almacen.txt");
                    fichero.createNewFile();
                    FileWriter fw = new FileWriter(fichero);
                    BufferedWriter bw = new BufferedWriter(fw);
                    for (int i = 0; i < tabla.getRowCount(); i++) //realiza un barrido por filas.
                    {
                        for (int j = 0; j < tabla.getColumnCount(); j++) //realiza un barrido por columnas.
                        {
                            bw.write((String) (tabla.getValueAt(i, j)));
                            if (j < tabla.getColumnCount() - 1) { //agrega separador "," si no es el ultimo elemento de la fila.
                                bw.write(" ");
                            }
                        }
                        
                        bw.newLine(); //inserta nueva linea.
                    }

                    bw.close(); //cierra archivo!
                    JOptionPane.showMessageDialog(null, "EL ALMACÉN SE HA SALVADO CORRECTAMENTE");
                } catch (IOException e) {
                }
            }
        });
    }

    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        almacen.setVisible(true);
        almacen.setResizable(false);
        almacen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
