package Conceptos_básicos;
import java.util.*;

public class proyecto1 {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero_respuesta = 0;
        int numero = 0;
        
        String[] paises = new String[8];
        
        for (int i = 0; i<paises.length; i++){

            numero++;    

            System.out.println("Introduce el país Nº " + numero);
            String paises_respuesta = entrada.nextLine();
            paises[i] = paises_respuesta;

        }            
        
        boolean duplicado = false;

        while (duplicado == false){

            for (int v = 0; v<paises.length; v++){
                
                for (int j = v + 1; j <paises.length; j ++){                

                    if (paises[v].equals(paises[j])){

                        //String posicion_repetida = paises[j];
                        
                        System.out.println("El país " + "'" + paises[j] + "'" +  " ya esta en la lista");
                        System.out.println("Por favor introduzca otro");

                        String pais_repetido = entrada.nextLine();

                    
                
                        while (pais_repetido.equalsIgnoreCase(paises[j])){

                            System.out.println("No vuelva a introducir el mismo pais");
                            System.out.println("Por favor introduzca otro");
                            pais_repetido = entrada.nextLine();
                        

                        
                        }
                    
                    paises[j] = pais_repetido;
                    duplicado = true;
                    }
                    
                }

            }
            
            
        }//while
        

        System.out.println("Hemos salido del bucle");
        System.out.println("Su lista es la siguiente");
        for (int x = 0; x<8; x++){

            numero_respuesta++;
            
            System.out.println("El pais numero " + numero_respuesta + " es " + paises[x]);
                
        }
    }
}