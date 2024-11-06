package POO;



public class coche {
    
    private int ruedas; //encapsulacion

    private int largo;

    private int ancho;

    private int motor;

    private int peso_plataforma;

    private String color;
    
    private int peso_final;

    private boolean asientosCuero,climatizador;


    public coche(){//constructor
        
        ruedas = 4;
        largo = 2000;//cm
        ancho = 300;//cm
        motor = 1600;//cc
        peso_plataforma = 500;//kg
    }

    public String dime_datos_generales(){//EL STRING DETERMINA QUE VA A DEVOLVER EL RETURN 
        //esto es un metodo getter (metodo)

        return "la plataforma del vehículo: " + ruedas +" ruedas" +
        ". Mide" + largo/1000 + " metros con un ancho de " + ancho + 
        " cm" + ". Y un peso de plataforma" + peso_plataforma + " kilos";



    }



    public void establece_color(String color_coche){//esto es un setter (metodo)
        //el void significa que esto no devuelve nada(no tiene return           )
        //color = "azul";
        color = color_coche;

    }

    public String get_color(){

        return "El color del coche es: " + color;

    }

    

    public void configura_asientos(String asientosCuero){

        //this.asientosCuero = asientosCuero;//el segundo es el parametro

        if (asientosCuero == "si"){

            this.asientosCuero = true;// el this es para cuando el parametor coincide con la variable

        }else{

            this.asientosCuero = false;



        }

    }

    public String dime_asientos(){

        if (asientosCuero == true){

            return "El coche tiene asientos de cuero";

        }else{

            return "El coche tiene asientos de serie";

        }

    }

    public void configura_climatizador(String climatizador){

        if(climatizador == "si"){

            this.climatizador = true;
 
        }else{

            this.climatizador = false;

        }


    }

    public String dime_climatizador(){

        if (climatizador == true){

            return "Tu coche tiene climatizador";

        }else{

            return "Tu coche no tiene climatizador";
        }

    }

    public String dime_peso_coche(){ // setter and getter
        
        int peso_carroceria = 500; 

        peso_final = peso_plataforma + peso_carroceria;

        if(asientosCuero == true){

            peso_final=+50; 

        }
        if(climatizador == true){

            peso_final=+20;

        }

        return "El peso del coche es: " + peso_final;
    }

    public int precio_coche(){

        int precio_final = 10000;

        if (asientosCuero == true){

            precio_final=+2000;

        }
        if (climatizador == true){

            precio_final=+1500;

        }            

        return precio_final;

    }

    
    
}
