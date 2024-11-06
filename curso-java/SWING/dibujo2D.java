package SWING;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class dibujo2D {

    public static void main(String[] args) {
        
        marcos_dibujo frame1 = new marcos_dibujo();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }


}
class marcos_dibujo extends JFrame{

    public marcos_dibujo(){

        setTitle("MI APP");
        setSize(400,400);
        setVisible(true);
        dibujos mi_dibujo = new dibujos();
        add(mi_dibujo);
        mi_dibujo.setBackground(SystemColor.window);
        //setBackground(Color.YELLOW);
        
    }

}

class dibujos extends JPanel{

    public dibujos(){
    //no es necesario poner el constructor porque se usa el constructor por defecto
    }

    public void paintComponent(Graphics g){

        //la clase rectable2D no se puede instanciar lo tienes que haces con el rectangle2D.double()

        Graphics2D g2 = (Graphics2D) g;//con esto convertimos un tipo de objeto en otro
        //se denomina "casting"

        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        Ellipse2D elipse = new Ellipse2D.Double();
        Ellipse2D circulo = new Ellipse2D.Double();

        Font mifuente = new Font("Arial", Font.BOLD, 26);

        double centrox = rectangulo.getCenterX();
        double centroy = rectangulo.getCenterY();
        double radio = Math.sqrt((100*100) + (75*75));

        circulo.setFrameFromCenter(centrox, centroy, centrox+radio, centroy+radio);
        elipse.setFrame(rectangulo);
        
        //TEXTO
        g2.setColor(Color.GREEN);
        g2.setFont(mifuente);
        g2.drawString("Mario Ramos Salson", 50, 50);

        g2.setColor(Color.BLUE);
        g2.setFont(new Font("Consolas", Font.ITALIC, 10));
        g2.drawString("Me gusta aprender a programar en JAVA", 75, 75);
        
        g2.draw(circulo);

        g2.setPaint(Color.BLUE);
        g2.draw(rectangulo);
        g2.setPaint(Color.RED);
        g2.fill(rectangulo);
        
        g2.setPaint(new Color(100, 50, 80).brighter());
        g2.fill(elipse);

        
        //g2.fill(elipse);
        g2.draw(new Line2D.Double(100, 100, 300, 250));//con esto instancio una linea directamente en el metodo draw
        g2.draw(new Line2D.Double(300, 100, 100, 250));

    }
    
}
