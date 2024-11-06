package Conceptos_básicos;

import java.util.Scanner;

public class entrada_salida_datos {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);// esto solo dice que vamos a utilizar un scanner

        System.out.println("Introduce tu nombre por favor");

        String nombre_usuario = entrada.nextLine();//esto alamcena el input en una variable solo de string
        //esto es lo que guarda info

        System.out.println("Introduce tu edad por favor");

        int edad = entrada.nextInt();

        System.out.println("Hola " + nombre_usuario + ". El año que viene tendras " + (edad+1) + " años");

        System.out.println(entrada);//esto es para que no me marque que no he usado algo

    }
}
