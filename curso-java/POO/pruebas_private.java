package POO;

public class pruebas_private {

    public static void main(String[] args) {
        
        empleados trabajador1 = new empleados ("Mario");

        empleados trabajador2 = new empleados ("Ana");

        trabajador1.cambiaSeccion("RRHH");

        System.out.println(trabajador1.dimeDatos());
        
        System.out.println(trabajador2.dimeDatos());

    }
     
}

class empleados{

    private final String nombre;
    private String seccion;
    private int id;//esta variable es compartida
    private static int idSiguiente = 1;

    public empleados(String nom){
        nombre = nom;

        seccion = "administracion";

        id = idSiguiente;

        idSiguiente++;//cada vez que creamos un objeto llamamos a la clase constructor y incrementa en 1 la id

    }
    public void cambiaSeccion(String seccion){ //setter

        this.seccion = seccion;// el ultimo es el argumento
    }
    
    

    public String dimeDatos(){//getter

        return "El nombre es: " + nombre + " y la seccion es: " + seccion;

    }
}
