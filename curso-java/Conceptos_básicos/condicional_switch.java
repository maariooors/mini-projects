package Conceptos_básicos;
import java.util.Random;
import java.util.Scanner;

public class condicional_switch {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce que área quieres calcular: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo");
        
        int respuesta = entrada.nextInt();

        switch (respuesta){

            case 1:

                System.out.println("Introduce el lado de tu cuadrado");
                int lado = entrada.nextInt();
                System.out.println("El área del cuadrado es: " + Math.pow(lado,2) + " cm²");
                break;

            case 2:

                System.out.println("Introduce el lado mayor de tu rectángulo");
                int lado_mayor = entrada.nextInt();
                System.out.println("Introduce el lado manor de tu rectángulo");
                int lado_menor = entrada.nextInt();
                System.out.println("El área de tu rectángulo es: " + (lado_mayor * lado_menor) + " cm²");
                break;

            case 3:

                System.out.println("Introduce la altura de tu triángulo");
                int altura = entrada.nextInt();
                System.out.println("Introduce la base de tu triángulo");
                int base = entrada.nextInt();
                System.out.println("El área de tu triángulo es: " + (base*altura)/2 + (" cm²"));
                break;

            case 4:
            
                System.out.println("Introduce el radio de tu círculo");
                int radio = entrada.nextInt();
                System.out.println("El área de tu círculo es: " + (Math.pow(radio, 2)* Math.PI) + " cm²");
                break;
        }


    }
}

    