package Conceptos_básicos;
public class prueba1 {

    public static void main(String[] args) {

        String[] names = {"Mario", "Sandra", "Marta", "Mario", "Andres"};
        
        for (int i = 0; i < names.length; i++) {

            for (int j = i + 1 ; j < names.length; j++) {

                if (names[i].equals(names[j])) {

                }
            }
        }
        
    }

}