package SWING;
import java.awt.*;
import javax.swing.*;

public class creando_frame_centrado {
    
    public static void main(String[] args) {
        
        mi_frame frame1 = new mi_frame();
        frame1.setTitle("MI APP");
    }

}

class mi_frame extends JFrame{

    public mi_frame(){

        Toolkit mi_pantalla = Toolkit.getDefaultToolkit();//con esto puedo interactuar con el sistema
        Dimension dimension_pantalla = mi_pantalla.getScreenSize();
        int ancho = dimension_pantalla.width;
        int largo = dimension_pantalla.height;
        Image mi_imagen = mi_pantalla.getImage("src/SWING/icono.jpg");//mirar porq no funciona
        //asi se coge las dimensiones de la pantalla

        setSize(ancho/2,largo/2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(ancho/4, largo/4);
        setIconImage(mi_imagen);
        
    }

}
