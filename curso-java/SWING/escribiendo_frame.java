package SWING;

import javax.swing.*;
import java.awt.*;

public class escribiendo_frame {

    public static void main(String[] args) {
        
        marco frame1 = new marco();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       

    }

}
class marco extends JFrame{

    public marco(){

        setVisible(true);
        setSize(600,450); 
        setTitle("APP");
        setLocation(400,200);
        
        escritura mi_texto = new escritura();
        add(mi_texto);
        
    }

}

class escritura extends JPanel{

    public escritura(){
        //este es el constructor por defecto no se necesitaria llamar
    }

    public void paintComponent(Graphics g){

        //super.paintComponent(g);//llamas a la clase padre

        g.drawString("Mi texto", 200, 100);
        
    }


}
