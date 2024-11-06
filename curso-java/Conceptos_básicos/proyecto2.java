package Conceptos_básicos;
public class proyecto2 {
    
    public static void main(String[] args) {
        
        double [][] matix = new double [6][5];

        double acumulado;
        double comision = 0.1;

        for (int i = 0; i<6; i++){

            matix [i][0] = 10000;
            acumulado = 10000;

            for (int j = 1; j<5; j++){

                acumulado = acumulado+ (acumulado*comision);

                matix[i][j] = acumulado; 

            }
            comision = comision + 0.01;
        }
        int numero = 0;

        for (int h = 0; h<6; h++){
            System.out.println();

            numero++;
            System.out.println("Este es el bloque numero: " + numero);
            
            
            for (int v = 0; v<5; v++){                
                
                System.out.printf("%1.2f" , matix[h][v]);
                System.out.println(" ");
            }
            
        }



        



    }

}
