package SWING;
import java.awt.*;
import javax.swing.*;

public class prueba_dibujo {
    
    public static void main(String[] args) {
        
        marco_dibujo frame1 = new marco_dibujo();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class marco_dibujo extends JFrame{

    public marco_dibujo(){

        setTitle("MI APP");
        setSize(400,400);
        setVisible(true);
        dibujo dibujos = new dibujo();
        add(dibujos);
    }

}

class dibujo extends JPanel{

    public dibujo(){

    }

    public void paintComponent(Graphics g){

        //super.paintComponent(g);

        //cuadrados
        g.drawRect(50, 50, 50, 50);
        g.drawRect(150, 100, 50, 50);

        //linea de x 100
        g.drawLine(100, 100, 200, 150);
        g.drawLine(100, 50, 200, 100);

        //linea de x 50
        g.drawLine(50, 100, 150, 150);
        g.drawLine(50, 50, 150, 100);

        //circulo
        g.drawArc(200, 150, 50, 50, 0, 360);
        
    }


}
