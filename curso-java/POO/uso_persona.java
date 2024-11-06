package POO;

import java.util.Date;
import java.util.GregorianCalendar;



public class uso_persona {

    public static void main(String[] args) {

        persona[] las_personas = new persona[2];

        las_personas[0] = new empleado2("Mario", 50000, 20000, 12, 26);
        las_personas[1] = new alumno("Paco", "Informatica");
        
        for (persona i:las_personas){

            System.out.println(i.dameNombre() + ", " + i.dameDescripcion());

        }


    }

}

abstract class persona{

    private String nombre;

    public persona(String nom){

        nom = nombre;
    }

    public String dameNombre(){

        return nombre;
    }

    public abstract String dameDescripcion();//asi se declara un metodo abstracto

        

} 

class empleado2 extends persona{

    
    private double sueldo;
    private Date altaContrato;

    public empleado2 (String nom, double sue, int agno, int mes, int dia){ 
        
        super(nom); 
        
        sue = sueldo;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);// mes -1 porq enero es 0
        altaContrato = calendario.getTime();

        


    }

    public String dameDescripcion(){

        return "Este empleado tiene un sueldo de: " + sueldo + " euros";

    }

    /*public empleado(String nom){// se pueden crear varias constructores pero tienen que recibir diferentes parametros

        
        this(nom, 30000, 2001, 12, 03);//esto lo que hace esq cada vez que se llame a ese constructor le pase estos parametros al constructor que los pida

    }*/

    

    public /*final*/ double dameSueldo(){ //con el final haces que no se pueda crear un metodo con el mismo nombre

        return sueldo;

    }
    public Date dameFecha(){

        return altaContrato;

    }
    public void subeSueldo(double porcentaje){

        double aumento = (sueldo*porcentaje)/100;
        sueldo+=aumento;

    }
}


class alumno extends persona{

    private String carrera;
    
    public alumno(String nom, String car){
    
        super(nom);
    
        carrera = car;
    
    }
    
    public String dameDescripcion(){
    
        return "Este alumno esta estudiando la carrera de: " + carrera;
    
    }

}