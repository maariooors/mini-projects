package POO;

public class furgoneta extends coche{//"extends" significa que hereda no se puede heredar de varias clases
    
    private int capacidad_carga;
    private int plazas_extra;
        
    public furgoneta(int plazas_extra, int capacidad_carga){

        super();//con esto llamamos al constructor de la clase que hereda

        this.plazas_extra = plazas_extra;
        this.capacidad_carga = capacidad_carga;
        
    }

    public String dimeDatosFurgoneta(){

        return "La capacidad de carga es: " + capacidad_carga + ". Y las plazas son: " + 
        plazas_extra;

    }

}
