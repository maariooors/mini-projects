package Conceptos_básicos;

public class clase_string {
    
    public static void main(String[] args) {

         String nombre = "Mario";

         int ultima_letra = nombre.length();

         System.out.println("Mi nombre es " + nombre);
        
         System.out.println("Mi nombre tiene " + nombre.length() + " letras");

         System.out.println("La primera letra de mi nombre es la " + nombre.charAt(0));

         System.out.println("La ultima letra de " + nombre + " es la " + nombre.charAt(ultima_letra-1));


    }
}
