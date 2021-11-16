package smartsale;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Mensajes {

    private String Bienvenida = "";
    private String Agradecimiento="";
    private final String rutaBienvenida = System.getProperties().getProperty("user.dir");
    private final String rutaAgradecimiento= System.getProperties().getProperty("user.dir");

    public Mensajes() {

    }

    public String Bienvenida(String Bienvenida) {
        File arch = null;
        FileReader FileR = null;
        BufferedReader BufferedR = null;

        try {
            arch = new File(rutaBienvenida + "//Bienvenida.txt");
            FileR = new FileReader(arch);
            BufferedR = new BufferedReader(FileR);
            String informacionBienvenida = null;
            while ((informacionBienvenida = BufferedR.readLine()) != null) {
                Bienvenida = informacionBienvenida;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != FileR) {
                    FileR.close();
                }
            } catch (IOException a) {
            }
        }
        return Bienvenida;
    }

    public String Agradecimiento(String Agradecimiento) {
        File arch = null;
        FileReader FileR = null;
        BufferedReader BufferedR = null;

        try {
            arch = new File(rutaAgradecimiento + "//Agradecimiento.txt");
            FileR = new FileReader(arch);
            BufferedR = new BufferedReader(FileR);
            String informacionAgradecimiento = null;
            while ((informacionAgradecimiento = BufferedR.readLine()) != null) {
                Agradecimiento = informacionAgradecimiento;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (null != FileR) {
                    FileR.close();
                }
            } catch (IOException b) {
            }
        }
        return Agradecimiento;
    }
}
