package Conceptos_básicos;
public class array1_bidimensional {
    
    public static void main(String[] args) {
        
        int[][] mi_array = new int [4][5];

        mi_array [0][0] = 19;
        mi_array [0][1] = 53;
        mi_array [0][2] = 64;
        mi_array [0][3] = 63;
        mi_array [0][4] = 73;

        mi_array [1][0] = 1;
        mi_array [1][1] = 90;
        mi_array [1][2] = 61;
        mi_array [1][3] = 32;
        mi_array [1][4] = 67;

        mi_array [2][0] = 96;
        mi_array [2][1] = 16;
        mi_array [2][2] = 95;
        mi_array [2][3] = 62;
        mi_array [2][4] = 61;

        mi_array [3][0] = 78;
        mi_array [3][1] = 87;
        mi_array [3][2] = 99;
        mi_array [3][3] = 25;
        mi_array [3][4] = 39
        ;

        for (int i = 0; i<4; i++){
            System.out.println();
            for (int j = 0; j<5; j++){

                System.out.print(mi_array[i][j] + " ");

            }
        }
    }

}
