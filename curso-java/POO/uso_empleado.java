package POO;    

import java.util.*;


public class uso_empleado{

    public static void main(String[] args) {

        /*empleado empleado1 = new empleado("Mario", 85000, 2004, 9, 26);

        empleado empleado2 = new empleado("Paco", 70000, 1998, 4, 2);
    
        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);*/

        jefatura jefeRRHH = new jefatura("Mario", 80000, 2004, 9, 26);

        jefeRRHH.establece_incentivo(2000);

        empleado[] misEmpleados = new empleado[6]; //array de la clase empeleado 
        //en la cual usamos el nombre del constructor para cuando pasemos datos esos sean los que reciba el constructor  

        misEmpleados[0] = new empleado("Mario Ramos", 85000, 1990, 12, 17); 
        misEmpleados[1] = new empleado("Ana Gomez", 70000, 1998, 05, 12);
        misEmpleados[2] = new empleado("Paco Sanz", 20000, 2000, 07, 26);
        misEmpleados[3] = new empleado("Mario Ramos");
        misEmpleados[4] = jefeRRHH; //polimorfismo y principio de sustitucion
        misEmpleados[5] = new jefatura("Ana", 70000, 1998, 5, 12);

        jefatura jefa_finanzas = (jefatura) misEmpleados[5];//con esto convertimos un tipo de objeto en otro

        System.out.println(jefa_finanzas.dameNombre() + "tiene un bonus de " + 
            jefa_finanzas.establece_bonus(4000) + " euros");
    
        System.out.println(jefeRRHH.tomar_decisiones("Despedir a todos"));

        /*empleado directo_comercial = new jefatura("Javier", 80000, 1980, 04, 12);

        Comparable ejemplo = new empleado("Mario", 90000, 2000, 01, 01);

        if(directo_comercial instanceof empleado){

            System.out.println("Es de tipo jefatura");  

        }

        if(ejemplo instanceof Comparable){

            System.out.println("Implementa la interfaz Comparable"); 

        }*/

        Arrays.sort(misEmpleados);

        for (int i = 0; i < misEmpleados.length; i++){

            System.out.println("Nombre: " + misEmpleados[i].dameNombre() + ". Salario: " + misEmpleados[i].dameSueldo() +
            " euros" + ". Ingreso en la empresa: " + misEmpleados[i].dameFecha());

        }
        //cuando este bucle analiza en jefeRRHH el metodo llama sueldo es el de su clase propia
        

    }

    
}

class empleado implements Comparable, trabajadores{

    private String nombre;
    private double sueldo;
    private Date altaContrato;

    public empleado(String nom, double sue, int agno, int mes, int dia){ 
        
        nombre = nom;
        sue = sueldo;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);// mes -1 porq enero es 0
        altaContrato = calendario.getTime();


    }

    public empleado(String nom){// se pueden crear varias constructores pero tienen que recibir diferentes parametros

        
        this(nom, 30000, 2001, 12, 03);//esto lo que hace esq cada vez que se llame a ese constructor le pase estos parametros al constructor que los pida

    }

    public String dameNombre(){

        return nombre;

    }

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

    public int compareTo(Object miObjeto){//esto se usa asi siempre es una estructura

        empleado otroEmpleado = (empleado) miObjeto;

        if(this.sueldo<otroEmpleado.sueldo){

            return -1;

        }

        if(this.sueldo>otroEmpleado.sueldo){

            return 1;

        }

        return 0;   

    }

    public double establece_bonus(double gratificacion){

        return trabajadores.bonus_base + gratificacion;
    }
}

class jefatura extends empleado implements jefes{

    //variables

    private double incentivo;

    public jefatura(String nom, double sue, int agno, int mes, int dia){

        super(nom, sue, agno, mes, dia);//con esto llamamos al constructor de la base que hereda
        //y como ese constructor recibe parametros hay que pasarle parametros
    }

    public String tomar_decisiones(String decision){

        return "Un miembro de la direccion ha tomado la decision de: " + decision;

    }

    public double establece_bonus(double gratificacion){

        double prima = 2000;
        
        return trabajadores.bonus_base + gratificacion + prima;

    }

    public void establece_incentivo(double b){

        incentivo = b;

    }

    public double dameSueldo(){

        double sueldoJefe = super.dameSueldo();//lo que haces el llamar a la clase pero la de la clase principal

        return sueldoJefe + incentivo;

    }



}



/*final class director extends jefatura{

    public director(String nom, double sue, int agno, int mes, int dia){

        super(nom, sue, agno, mes, dia);//dentor del constructor tiene que poner super para llamar a la otra clase


    }


}*/





