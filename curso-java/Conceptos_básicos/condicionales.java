package Conceptos_básicos;
import java.util.Scanner;

public class condicionales {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu edad por favor");

        int edad = entrada.nextInt();

        if(edad < 18){

            System.out.println("Eres un adolescente");

        }else if (edad < 40){
            
            System.out.println("Eres un joven");

        }else if (edad < 65){

            System.out.println("Eres mayor");

        }else{

            System.out.println("Cuidate perro");

        }
    }

        
    
}



