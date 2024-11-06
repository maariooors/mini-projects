package Conceptos_básicos;
/*
public class declaraciones_operadores {
    
    public static void main(String[] args) {
        
        byte a = 5;


        byte b;

        b = 7;

        int c = b + a;

        c++; //Incremento en 1
        
        c=+8; //Incremento en 8

        

        double d = b/a; // cuando divides tienes que poner "double en a y b"

        System.out.println(c);
        System.out.println(d);

    }
}
*/

public class declaraciones_operadores{

    public static void main(String[] args) {
        
        //byte c = 5;
        //c = 7; 

        final double una_pulgada = 2.54; //(cm)

        double cm = 6;

        double resultado_final = (cm * 1)/ una_pulgada;

        System.out.println("En " + cm + " cm hay " + resultado_final + " pulgadas");
    }
}
