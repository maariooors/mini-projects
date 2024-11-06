package Conceptos_básicos;
import java.util.Scanner;

public class bucles1 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String clave = "Mario";

        String pass = "";

        while (clave.equals(pass)==false) {

            System.out.println("Introduce la contraseña por favor");
            pass = entrada.nextLine();

            if(clave.equals(pass)==false){

                System.out.println("Contraseña incorrecta");

            }
            
        }
        
    }
    
}
