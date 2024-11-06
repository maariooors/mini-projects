package POO;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;
import java.util.Scanner; 

public class prueba_temporizador2 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Quieres introducir sonido?: ");
        String pregunta = entrada.nextLine();
        
        boolean respuesta;
        if(pregunta.equalsIgnoreCase("si")){

            respuesta = true;

        }else{

            respuesta = false;

        }

        reloj mi_reloj = new reloj(3000, respuesta);

        mi_reloj.en_marcha();

        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");

        System.exit(0);

    }

}

class reloj{

    private int intervalo;
    private boolean sonido;

    public reloj(int intervalo, boolean sonido){

        this.intervalo = intervalo;
        this.sonido = sonido;

    }

    public void en_marcha(){

        ActionListener oyente = new dame_hora2();
        //oyente necesita se de tipo actionListener y que pertenezca a la clase que importa actionListener
        /* el objeto oyente al ser de tipo actionlistener va a ejecutar lo que este dentro de la clase
        que implemente a actionlistener.*/
        Timer mi_temporizador = new Timer(intervalo, oyente);

        mi_temporizador.start();

    }

    private class dame_hora2 implements ActionListener{//todas las clases internas son private

        /*al crear una clase interna puedes acceder a las variables de la clase superior
        sin tener que hacer getters y setters*/
        public void actionPerformed(ActionEvent evento){

            Date ahora = new Date();
            System.out.println("Te pongo la hora cada 3 segundos " + ahora);

            if(sonido == true){

                Toolkit.getDefaultToolkit().beep();

            }

        }

    }
    
}
