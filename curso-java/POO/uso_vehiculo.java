package POO;


public class uso_vehiculo{
    
    public static void main(String[] args) {

        coche coche1 = new coche();

        furgoneta furgoneta1 = new furgoneta(7, 580);

        coche1.establece_color("rojo");

        furgoneta1.establece_color("blanca");
        furgoneta1.configura_asientos("Si");
        furgoneta1.configura_climatizador("Si");
        
        //coche Renault = new coche();//Instanciar una clase
        //el primer coche es el nombre de la clase
        //el segundo es el nombre del constructor   

        //System.out.println("Este coche tiene: " + Renault.ruedas + " ruedas");

        //System.out.println(Renault.get_largo());

        /*coche mi_coche = new coche();
        
        mi_coche.establece_color("rojo");

        mi_coche.configura_asientos("si");

        mi_coche.configura_climatizador("si");

        System.out.println(mi_coche.dime_datos_generales());

        System.out.println(mi_coche.get_color());;

        System.out.println(mi_coche.dime_asientos());

        System.out.println(mi_coche.dime_climatizador());

        System.out.println(mi_coche.dime_peso_coche());

        System.out.println("El precio final del coche es: " + mi_coche.precio_coche() + " euros");*/

    }
}
//metodos es como se comunican las clases entre si