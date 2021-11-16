package smartsale;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PuntodeVenta extends JFrame {

    //INSTANCIAR CLASE BLOQUEADOR
    Bloqueador bloqueo = new Bloqueador();
    //INSTANCIAR CLASE ALMACEN
    Almacen almacen = new Almacen();
    //INSTANCIAR CLASE MENSAJE
    Mensajes mensaje = new Mensajes();

    private JLabel etiquetaProducto, etiquetaProductoElegido, etiquetaPrecio, etiquetaUnidades;
    private JLabel etiquetaCarrito, etiquetaCompra, etiquetaImporte, etiquetaPago;
    private JLabel etiPrecio, etiNombre;
    private JButton botonDetalles, botonLimpiar, botonAgregaralCarrito;
    private JButton botonQuitarProducto, botonVaciarCarrito, botonTotalapagar, botonDescuento, botonGenerarTicket;
    private Double costo, unidades, total;
    private String precio, importe;
    private JButton Imprimirticket, Borrarticket;
    private JTextField campoUnidades;
    private JTextArea Area;
    private JScrollPane jsparea;
    private JComboBox listaDespegableProductos;
    DefaultTableModel modelo;//JTABLE
    private String a1, a2;
    //MENÚ 
    double suma = 0;
    private JMenuBar Menu;
    private JMenu Archivo;
    private JMenuItem itemNuevo;
    private JMenuItem itemAbre;
    private JMenuItem itemGuarda;
    private JMenuItem itemAlmacenar;

    //CADENAS
    String cadena = "";
    String n = "";
    char[] cadena_div;

    //CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR//CONSTRUCTOR
    public PuntodeVenta() {
        setTitle("PUNTO DE VENTA");
        setSize(1370, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        Objetos();
        Bloqueo();
        listaDesplegable();
    }

    private void Bloqueo() {
        bloqueo.num(campoUnidades);
        bloqueo.arenum(Area);
    }

    //AGREGA DATOS DEL TXT ALMACEN AL JCOMBOBOX
    private final String rutaProductos = System.getProperties().getProperty("user.dir");

    public void listaDesplegable() {
        //JCOMBOX
        listaDespegableProductos = new JComboBox();
        listaDespegableProductos.setBounds(118, 50, 192, 25);
        add(listaDespegableProductos);

        File arch = null;
        FileReader FileR = null;
        BufferedReader BufferedR = null;

        try {
            arch = new File(rutaProductos + "//Almacen.txt");
            FileR = new FileReader(arch);
            BufferedR = new BufferedReader(FileR);
            String informacion = null;
            DefaultComboBoxModel listaProductos = new DefaultComboBoxModel();
            listaProductos.addElement("");
            while ((informacion = BufferedR.readLine()) != null) {
                listaProductos.addElement(informacion);
            }

            listaDespegableProductos.setModel(listaProductos);
        } catch (Exception e) {
        } finally {
            try {
                if (null != FileR) {
                    FileR.close();
                }
            } catch (IOException e2) {
            }
        }
    }

    //CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS//CONTENEDOR DE OBJETOS
    private void Objetos() {
        //ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS
        //JMENÚBAR
        Menu = new JMenuBar();
        //JITEM ARCHIVO
        Archivo = new JMenu("Archivo");
        Archivo.setFont(new Font("new times roman", Font.PLAIN, 13));
        //JITEM NUEVO
        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setFont(new Font("new times roman", Font.PLAIN, 13));
        //JITEM ABRE
        itemAbre = new JMenuItem("Abrir");
        itemAbre.setFont(new Font("new times roman", Font.PLAIN, 13));
        //JITEM GUARDA
        itemGuarda = new JMenuItem("Guardar");
        itemGuarda.setFont(new Font("new times roman", Font.PLAIN, 13));
        //JMENU ALAMACENAR
        itemAlmacenar = new JMenuItem("Almacenar");
        itemAlmacenar.setFont(new Font("new times roman", Font.PLAIN, 13));
        //AGREGA ITEMS AL BOTÓN ARCHIVO
        Archivo.add(itemNuevo);
        Archivo.add(itemAbre);
        Archivo.add(itemGuarda);
        Archivo.add(itemAlmacenar);
        //DA TAMAÑO A JMENUBAR
        Menu.add(Archivo);
        Menu.setBounds(0, 0, 1370, 25);
        add(Menu);
        setLayout(null);

        //PRIMERA SECCIÓN//PRIMERA SECCIÓN//PRIMERA SECCIÓN//PRIMERA SECCIÓN//PRIMERA SECCIÓN
        //ETIQUETA PRODUCTO
        etiquetaProducto = new JLabel("PRODUCTO:");
        etiquetaProducto.setBounds(30, 50, 80, 25);
        etiquetaProducto.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiquetaProducto);

        //ETIQUETA QUE MUESTRA EL NOMBRE DEL PRODUCTO SELECCIONADO
        etiquetaProductoElegido = new JLabel("PRODUCTO ELEGIDO:");
        etiquetaProductoElegido.setBounds(370, 50, 190, 25);
        etiquetaProductoElegido.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiquetaProductoElegido);

        //ETIQUETA NOMBRE
        etiNombre = new JLabel("");//////////////////////////////////////////////////
        etiNombre.setBounds(520, 50, 130, 25);/////////////////////////////////////////
        etiNombre.setFont(new Font("new times roman", Font.PLAIN, 13));////////////////////
        add(etiNombre);///////////////////////////////////////////////////////////////////////

        //ETIQUETA QUE MUESTRA EL PRECIO DEL PRODUCTO SELECCIONADO
        etiquetaPrecio = new JLabel("PRECIO:");
        etiquetaPrecio.setBounds(370, 100, 190, 25);
        etiquetaPrecio.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiquetaPrecio);

        //ETIQUETA PRECIO
        etiPrecio = new JLabel("");///////////////////////////////////////////////////
        etiPrecio.setBounds(520, 100, 130, 25);/////////////////////////////////////////
        etiPrecio.setFont(new Font("new times roman", Font.PLAIN, 13));///////////////////////
        add(etiPrecio);////////////////////////////////////////////////////////////////////

        //ETIQUETA QUE MUESTRA LA CANTIDAD DE PRODUCTOS A SELECCIONAR
        etiquetaUnidades = new JLabel("UNIDADES:");
        etiquetaUnidades.setBounds(370, 150, 190, 25);
        etiquetaUnidades.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiquetaUnidades);

        //CAMPO QUE MUESTRA LA CANTIDAD DE PRODUCTO A COMPRAR
        campoUnidades = new JTextField();
        campoUnidades.setBounds(520, 150, 130, 25);
        add(campoUnidades);

        //BOTÓN VER DETALLES
        botonDetalles = new JButton("VER DETALLES");
        botonDetalles.setBounds(30, 100, 280, 25);
        botonDetalles.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(botonDetalles);

        //LIMPIAR
        botonLimpiar = new JButton("LIMPIAR");
        botonLimpiar.setBounds(30, 150, 280, 25);
        botonLimpiar.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(botonLimpiar);

        //BOTÓN AGREGAR
        botonAgregaralCarrito = new JButton("AGREGAR AL CARRITO");
        botonAgregaralCarrito.setBounds(370, 200, 280, 25);
        botonAgregaralCarrito.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(botonAgregaralCarrito);

        //SEGUNDA SECCIÓN//SEGUNDA SECCIÓN//SEGUNDA SECCIÓN//SEGUNDA SECCIÓN//SEGUNDA SECCIÓN//SEGUNDA SECCIÓN
        //ETIQUETA CARRITO
        etiquetaCarrito = new JLabel("CARRITO:");
        etiquetaCarrito.setBounds(30, 250, 100, 25);
        etiquetaCarrito.setFont(new Font("new times roman", Font.PLAIN, 13));
        add(etiquetaCarrito);

        //JTABLE
        modelo = new DefaultTableModel();
        modelo.addColumn("DESCRIPCIÓN");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        final JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll);
        scroll.setBounds(30, 300, 620, 300);

        //BOTÓN QUITAR
        botonQuitarProducto = new JButton("QUITAR PRODUCTO");
        botonQuitarProducto.setBounds(30, 625, 280, 25);
        botonQuitarProducto.setFont(new Font("new Tomes Roman", Font.PLAIN, 13));
        add(botonQuitarProducto);

        //BOTÓN VACÍAR
        botonVaciarCarrito = new JButton("VACÍAR CARRITO");
        botonVaciarCarrito.setBounds(30, 675, 280, 25);
        botonVaciarCarrito.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(botonVaciarCarrito);

        //BOTÓN CÁLCULAR TOTAL A PAGAR
        botonTotalapagar = new JButton("CÁLCULAR PAGO");
        botonTotalapagar.setBounds(30, 725, 280, 25);
        botonTotalapagar.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(botonTotalapagar);

        //BOTÓN DESCUENTO
        botonDescuento = new JButton("APLICAR DESCUENTO");
        botonDescuento.setBounds(30, 775, 280, 25);
        botonDescuento.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(botonDescuento);

        //BOTÓN VER COMPRA
        botonGenerarTicket = new JButton("GENERAR TICKET");
        botonGenerarTicket.setBounds(370, 725, 280, 25);
        botonGenerarTicket.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(botonGenerarTicket);

        //ETIQUETA DE IMPORTE
        etiquetaImporte = new JLabel("IMPORTE:");
        etiquetaImporte.setBounds(370, 625, 100, 50);
        etiquetaImporte.setFont(new Font("new Times Roma", Font.PLAIN, 20));
        add(etiquetaImporte);

        //ETIQUETA PAGO
        etiquetaPago = new JLabel("");
        etiquetaPago.setBounds(500, 625, 100, 50);
        etiquetaPago.setFont(new Font("new Times Roman", Font.PLAIN, 20));
        add(etiquetaPago);

        //TERCERA SECCIÓN//TERCERA SECCIÓN//TERCERA SECCIÓN//TERCERA SECCIÓN//TERCERA SECCIÓN//TERCERA SECCIÓN
        //ETIQUETA COMPRA:
        etiquetaCompra = new JLabel("COMPRA:");
        etiquetaCompra.setBounds(710, 50, 100, 25);
        etiquetaCompra.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(etiquetaCompra);

        //ÁREA
        Area = new JTextArea();
        Area.setLineWrap(true);
        jsparea = new JScrollPane(Area);
        jsparea.setBounds(710, 100, 620, 500);
        add(jsparea);

        //BOTÓN IMPRIMIR TICKET
        Imprimirticket = new JButton("IMPRIMIR TICKET");
        Imprimirticket.setBounds(710, 625, 280, 25);
        Imprimirticket.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(Imprimirticket);

        //BOTÓN BORRAR TICKET
        Borrarticket = new JButton("BORRAR TICKET");
        Borrarticket.setBounds(1050, 625, 280, 25);
        Borrarticket.setFont(new Font("new Times Roman", Font.PLAIN, 13));
        add(Borrarticket);

        //ACCIÓN DE LOS BOTONES
        //BOTÓN DETALLES
        botonDetalles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //AGARRA EL NOMBRE DEL PRODUCTO
                //String cadena=listaDespegableProductos.getSelectedItem(
                etiNombre.setText("" + listaDespegableProductos.getSelectedItem());
                //AGARRA PRECIO DEL PRODUCTO
                cadena = etiNombre.getText();
                cadena_div = cadena.toCharArray();
                //String n="";
                //for (int j = 0; j < 1; j++) {
                for (int i = 0; i < cadena_div.length; i++) {
                    if (Character.isDigit(cadena_div[i])) {
                        n = n + cadena_div[i];
                    }
                    if (cadena_div[i] == '.' && etiNombre.getText().contains(".")) {
                        n = n + cadena_div[i];
                    }
                }
                etiPrecio.setText("" + n);
                cadena = "";
                n = "";
            }
        });

        //BOTÓN LIMPIAR
        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                etiNombre.setText("");
                etiPrecio.setText("");
                campoUnidades.setText("");
                n = "";
                cadena = "";
                int respuesta = JOptionPane.showConfirmDialog(null, "¿TAMBIÉN DESEA LIMPIAR EL CARRITO?");
                if (respuesta == JOptionPane.YES_OPTION) {
                    int filaa = tabla.getRowCount();//VERIFICA SI HAY VECTORES EN JTABLE
                    if (filaa == 0) {
                        JOptionPane.showMessageDialog(null, "NO HAY NADA QUE ELIMINAR");
                    } else {
                        int elecvaciar = JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA VACÍAR EL CARRITO?");
                        if (elecvaciar == JOptionPane.YES_OPTION) {
                            int fila = tabla.getRowCount();
                            for (int i = fila - 1; i >= 0; i--) {
                                modelo.removeRow(i);
                            }
                            etiNombre.setText("");
                            etiPrecio.setText("");
                            campoUnidades.setText("");
                        }
                    }
                } else {
                    etiNombre.setText("");
                    etiPrecio.setText("");
                    campoUnidades.setText("");
                }
            }
        });

        //BOTÓN AGREGAR
        botonAgregaralCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                //bocina.sonido1();
                String[] info = new String[4];//TAMAÑO DEL JTABLE
                if (campoUnidades.getText().isEmpty()) {
                    campoUnidades.setText("" + 1);
                }
                if (etiNombre.getText().isEmpty() || etiPrecio.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE VENDER");
                } else {
                    //NOMBRE
                    String nombre = etiNombre.getText();
                    info[0] = nombre;
                    //SECCIÓN PRECIO
                    String precio = etiPrecio.getText();
                    info[1] = precio;
                    //SECCIÓN CANTIDAD
                    String cantidad = campoUnidades.getText();
                    info[2] = cantidad;
                    Operador();//LLAMA EL MÉTODO OPERADOR
                    //SECCIÓN TOTAL
                    importe = "" + total;
                    info[3] = importe;
                    modelo.addRow(info);
                }
                campoUnidades.setText("");
                etiPrecio.setText("");
                etiNombre.setText("");
                cadena = "";
                n = "";
            }
        });

        //BOTÓN QUITAR
        botonQuitarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
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

        //BOTÓN TOTAL A PAGAR
        botonTotalapagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                suma = 0;
                int contar = modelo.getRowCount();//CUENTA CUANTOS VECTORES HAY
                // double suma = 0;
                for (int i = 0; i < contar; i++) {
                    suma = suma + Double.parseDouble(modelo.getValueAt(i, 3).toString());
                }
                etiquetaPago.setText("$ " + suma);
            }
        });

        //BOTÓN VACIAR
        botonVaciarCarrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                int filaa = tabla.getRowCount();//VE SI HAY FILAS EN LA JTABLE
                if (filaa == 0) {
                    JOptionPane.showMessageDialog(null, "NO HAY NADA QUE ELIMINAR");
                } else {
                    int respuestavaciar = JOptionPane.showConfirmDialog(null, "¿SEGURO QUE DESEA VACÍAR EL CARRITO?");
                    if (respuestavaciar == JOptionPane.YES_OPTION) {
                        int fila = tabla.getRowCount();
                        for (int i = fila - 1; i >= 0; i--) {
                            modelo.removeRow(i);
                        }
                    }
                }
                etiquetaPago.setText("");
                campoUnidades.setText("");
                etiPrecio.setText("");
                etiNombre.setText("");
                cadena = "";
                n = "";
            }
        });

        //BOTÓN VER COMPRA
        botonGenerarTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaa = tabla.getRowCount();//VE SI HAY FILAS EN LA JTABLE
                //VERIFICA SI LA ETIQUETA DE PAGO ESTA VACÍA
                if (etiquetaPago.getText().isEmpty()) {
                    //CÁLCULA TOTAL A PAGAR
                    int contar = modelo.getRowCount();//CUENTA CUANTOS VECTORES HAY
                    for (int i = 0; i < contar; i++) {
                        suma = suma + Double.parseDouble(modelo.getValueAt(i, 3).toString());
                    }
                }
                //SI EL AREA ESTA VACÍA HACE ESTO
                if (Area.getText().isEmpty()) {
                    if (filaa == 0) {
                        JOptionPane.showMessageDialog(null, "EL CARRITO ESTA VACÍO");
                    } else {
                        //GENERA EL TICKET DE PAGO
                        etiquetaPago.setText("$ " + suma);
                        Area.setText(Area.getText() + mensaje.Bienvenida(a2) + "\n\n");
                        Area.setText(Area.getText() + "Producto\t\tPrecio\tCantidad\tTotal\n\n");
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            String Producto = modelo.getValueAt(i, 0).toString();
                            String Precio = modelo.getValueAt(i, 1).toString();
                            String Cantidad = modelo.getValueAt(i, 2).toString();
                            String Total = modelo.getValueAt(i, 3).toString();
                            Area.setText(Area.getText() + Producto + "\t\t$" + Precio + "\t" + Cantidad + "\t$" + Total + "\n\n");
                        }
                        Area.setText(Area.getText() + "\nSu Total a Pagar es de :\t$" + suma + "\n\n" + mensaje.Agradecimiento(a1));
                    }
                } else {//SI EL AREA NO ESTA VACÍA HACE ESTO
                    //CÁLCULA TOTAL A PAGAR
                    int contar = modelo.getRowCount();//CUENTA CUANTOS VECTORES HAY
                    for (int i = 0; i < contar; i++) {
                        suma = suma + Double.parseDouble(modelo.getValueAt(i, 3).toString());
                    }
                    Area.setText("");
                    if (filaa == 0) {
                        JOptionPane.showMessageDialog(null, "EL CARRITO ESTA VACÍO");
                    } else {
                        //GENERA EL TICKET DE PAGO
                        etiquetaPago.setText("$ " + suma);
                        Area.setText(Area.getText() + mensaje.Bienvenida(a2) + "\n\n");
                        Area.setText(Area.getText() + "Producto\t\tPrecio\tCantidad\tTotal\n\n");
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            String Producto = modelo.getValueAt(i, 0).toString();
                            String Precio = modelo.getValueAt(i, 1).toString();
                            String Cantidad = modelo.getValueAt(i, 2).toString();
                            String Total = modelo.getValueAt(i, 3).toString();
                            Area.setText(Area.getText() + Producto + "\t\t$" + Precio + "\t" + Cantidad + "\t$" + Total + "\n\n");
                        }
                        Area.setText(Area.getText() + "\nSu Total a Pagar es de :\t$" + suma + "\n\n" + mensaje.Agradecimiento(a1));
                    }
                }
            }
        });

        //BOTÓN IMPRIMIR TICKET
        Imprimirticket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Area.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "¡NO SE HA GENERADO UN TICKET DE VENTA!");
                } else {
                    try {
                        File fichero = new File("TICKET.txt");
                        fichero.createNewFile();
                        FileWriter fw = new FileWriter(fichero);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(Area.getText() + "\n\n");
                        bw.close();
                    } catch (Exception ex) {
                    }
                    JOptionPane.showMessageDialog(null, "¡GRACIAS POR COMPRAR!");
                }
            }
        });

        //BOTÓN LIMPIAR
        Borrarticket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Area.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "NO HA FACTURADO NADA.\nIMPOSIBLE BORRAR TICKET");
                }
                Area.setText("");
            }
        });

        //ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS//ITEMS
        //ITEM NUEVO
        itemNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                int filaa = tabla.getRowCount();//VE SI HAY FILAS EN LA JTABLE
                int fila = tabla.getRowCount();
                for (int i = fila - 1; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                etiquetaPago.setText("");
                campoUnidades.setText("");
                etiPrecio.setText("");
                etiNombre.setText("");
                cadena = "";
                n = "";
                Area.setText("");
                etiquetaPago.setText("");
                campoUnidades.setText("");
                etiPrecio.setText("");
                etiNombre.setText("");
                cadena = "";
                n = "";
            }
        });

        //ITEM ABRE
        itemAbre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                JOptionPane.showMessageDialog(null, "Por favor!!! Abra un archivo .txt ESTRICTAMENTE");
                try {
                    if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
                        archivo = seleccionar.getSelectedFile();
                        if (archivo.getName().endsWith("txt")) {
                            String documento = AbrirArchivo(archivo);
                            Area.setText(documento);
                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo no compatible");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lectura abrir Archivo");
                }
            }
        });

        //ITEM GUARDAR TEXTO
        itemGuarda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                try {
                    File fichero = new File("TEXTO.txt");
                    if (!fichero.exists()) {
                        fichero.createNewFile();
                    }
                    FileWriter fw = new FileWriter(fichero);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("TEXTO:\n" + Area.getText() + "\n");
                    bw.close();
                } catch (Exception ex) {
                }
                JOptionPane.showMessageDialog(null, "Su archivo se guardo correctamente!!!\n"
                        + "Vaya a la carpeta del programa y encntrara un archivo llamado TEXTO.TXT\n"
                        + "Ahi encontrara su programa.");
            }
        });

        itemAlmacenar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                almacen.setVisible(true);
            }
        });
    }

    //JFLECHOSSER
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;

    //METODO ABRIR ARCHIVO 
    public String AbrirArchivo(File archivo) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                documento += caracter;
            }
        } catch (Exception e) {
        }
        return documento;
    }

    //MÉTODO OPERADOR
    private void Operador() {
        costo = Double.parseDouble(etiPrecio.getText());
        unidades = Double.parseDouble(campoUnidades.getText());
        total = costo * unidades;
    }

    public static void main(String[] args) {
        PuntodeVenta punto = new PuntodeVenta();
        punto.setVisible(true);
        punto.setResizable(false);
        punto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
