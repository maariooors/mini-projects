package POO;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date; 

public class prueba_temporizador {

    public static void main(String[] args) {
        
        ActionListener oyente = new dame_hora();//cada objeto de dame_hora hace lo del public void...

        Timer mi_temporizador = new Timer(5000, oyente);

        mi_temporizador.start();

        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");  

        System.out.println("Se acaba el programa");

        System.exit(0);

    }

}

class dame_hora implements ActionListener{//esto seria como hacer un temporizador

    public void actionPerformed(ActionEvent e){//dentro de esto esta la funcionalidad

        Date ahora = new Date();

        System.out.println("Te pongo la hora cada 5 sg: " + ahora);

        Toolkit.getDefaultToolkit().beep();//eso hace que suene el tipico sonido de windows

    }

}
