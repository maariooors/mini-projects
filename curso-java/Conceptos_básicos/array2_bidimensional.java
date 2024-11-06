package Conceptos_básicos;
public class array2_bidimensional {
   
    public static void main(String[] args) {

        int [][] mi_array = {
        {2, 5, 5, 8, 9}, // [0]
        {43, 54, 83, 90, 76},// [1]
        {34, 83, 93, 1, 89},// [2]
        {54, 67, 81, 874, 84}// [3]
        };

        for (int i = 0; i<4; i++){
            System.out.println();
            for (int j = 0; j<5; j++){

                System.out.print(mi_array[i][j] + " ");

            }
        }
    }   

    

}
