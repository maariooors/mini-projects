package Conceptos_básicos;
import java.util.Scanner;

public class condicionales2 {
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Elige una opcion: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo");

        String respuesta = entrada.nextLine();

        

        if(respuesta.equalsIgnoreCase("Cuadrado")){

            System.out.println("Introduce el lado de tu cuadrado");
            int lado = entrada.nextInt();
            System.out.println("El área del cuadrado es: " + Math.pow(lado,2) + " cm²");

        }else if (respuesta.equalsIgnoreCase("Triangulo")){

            System.out.println("Introduce la altura de tu triángulo");
            int altura = entrada.nextInt();
            System.out.println("Introduce la base de tu triángulo");
            int base = entrada.nextInt();
            System.out.println("El área de tu triángulo es: " + (base*altura)/2 + (" cm²"));

        }else if (respuesta.equalsIgnoreCase("Rectangulo")){

            System.out.println("Introduce el lado mayor de tu rectángulo");
            int lado_mayor = entrada.nextInt();
            System.out.println("Introduce el lado manor de tu rectángulo");
            int lado_menor = entrada.nextInt();
            System.out.println("El área de tu rectángulo es: " + (lado_mayor * lado_menor) + " cm²");

        }else if (respuesta.equalsIgnoreCase("Circulo")){

            System.out.println("Introduce el radio de tu círculo");
            int radio = entrada.nextInt();
            System.out.println("El área de tu círculo es: " + (Math.pow(radio, 2)* Math.PI) + " cm²");
        }

    }

}
