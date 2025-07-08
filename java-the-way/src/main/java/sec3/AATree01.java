package sec3;

public class AATree01 {
    private static final int TREE_SIZE = 17;
    private static int ASTERISK_NRO = 1;

    public static void main(String[] args) {
        while (ASTERISK_NRO < TREE_SIZE){
            // print spaces
            for(int i = 0; i < (TREE_SIZE / 2) - (ASTERISK_NRO / 2); i++ ){
                System.out.print(" ");
            }

            // print asterisk
            for(int i = 0; i < ASTERISK_NRO; i++){
                System.out.print("*");
            }
            System.out.println();
            ASTERISK_NRO += 2;
        }

        // print tronco
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < (TREE_SIZE/2)-1; j++){
                System.out.print(" ");
            }
            System.out.println("| |");
        }
    }
}
