package smartsale;
import javax.swing.JFrame;

public class SmartSale extends JFrame {
    //INSTANCIAR CLASE LOGIN
    Login login = new Login();

    //CONSTRUCTOR
    public SmartSale() {
        Objetos();
        setResizable(false);
    }
    
    //MÉTODO OBJETOS
    private void Objetos() {
        login.setVisible(true);
    }

     public static void main(String[] args) {
        SmartSale smartsale = new SmartSale();
        smartsale.setVisible(true);
        smartsale.setResizable(false);
        smartsale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}