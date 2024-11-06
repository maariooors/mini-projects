package Conceptos_básicos;
import java.util.Scanner;


public class bucles3 {

    public static void main(String[] args) {

        
        Scanner entrada = new Scanner(System.in);
        String genero;
        do{
            
            System.out.println("Especifica si eres hombre o mujer. (H/M)");                         
            genero = entrada.nextLine();//aunq esta iniciada dentro del bucle se tiene que crear fuera

        }while(genero.equalsIgnoreCase("H")== false && genero.equalsIgnoreCase("M") == false);{

            System.out.println("Introduce tu altura");
            int altura = entrada.nextInt();

            int peso_ideal = 0;

            if (genero.equalsIgnoreCase("H")){

                peso_ideal = altura - 110;
                System.out.println("Tu peso ideal es: " + peso_ideal + " kg");

            }else if(genero.equalsIgnoreCase("M")){

                peso_ideal = altura - 120;
                System.out.println("Tu peso ideal es: " + peso_ideal + " kg");

            }

        }
    
    }
  
}
    