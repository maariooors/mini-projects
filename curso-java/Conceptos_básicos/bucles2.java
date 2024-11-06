package Conceptos_básicos;
import java.util.*;
public class bucles2 {

    public static void main(String[] args) {

        int aleatorio = (int)(Math.random()*100);
        
        Scanner entrada = new Scanner(System.in);

        int numero = 0;

        int intento = 0;

        while(numero!=aleatorio){

            System.out.println("Introduce un numero para ver si adivinas");

            numero = entrada.nextInt();

            intento++;

            if (aleatorio < numero){

                System.out.println("Mas bajo");
                

            }else if (aleatorio>numero){

                System.out.println("Mas alto");

            }
            
        }
        System.out.println("Correcto");
        System.out.println("El número de intentos a sido: " + intento);
        

    }
}
