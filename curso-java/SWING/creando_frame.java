package SWING;
import javax.swing.*;   

public class creando_frame {
    
    public static void main(String[] args) {
        
        mi_marco marco1 = new mi_marco();

        //marco1.setVisible(true);

        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//eso es para que se pare cuando se cierre
        
    }

}

class mi_marco extends JFrame{

    public mi_marco(){

        setSize(500,300);
        setVisible(true);        
        setLocation(500,300);
        setTitle("Mi APP");
        setResizable(false);//no se puede redimensionar el frame
        //setExtendedState(Frame.MAXIMIZED_BOTH);//te pone el frame a pantalla completa
        //setIconImage();

    }

}
