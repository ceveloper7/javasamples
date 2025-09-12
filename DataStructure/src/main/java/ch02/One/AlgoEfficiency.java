package ch02.One;

public class AlgoEfficiency {

    /**
     * Tiempo de ejecucion: x.length
     * Big O: O(n)
     * Search and array for a value
     * @param x
     * @param target
     * @return
     */
    public static int search(int[] x, int target){
        for(int i = 0; i < x.length; i++){
            if(x[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * execution time: x.length time and y.length
     * Big O: O(n * m) - where n is x and m is y
     * Determinar si dos array no tienen elementos comunes
     * @param x
     * @param y
     * @return true si no hay elementos comunes
     */
    public static boolean areDifferent(int[] x, int[] y){
        for(int i = 0; i < x.length; i++){
            if(search(y, x[i]) != -1){
                return false;
            }
        }
        return true;
    }

    /**
     * execution time: (x.length)^2
     * Big O: O(n^2)
     * Determinamos si los elementos del array son unicos (ineficiente)
     * @return
     */
    public static boolean areUnique(int[] x){
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x.length; j++){
                if(i != j && x[i] == x[j])
                    return false;
            }
        }
        return true;
    }

    // mas eficiente en lugar de areUnique
    // execution time: (x.length)^2
    // Big O: O(n^2)
    public static boolean areUniqueV2(int[] x){
        for(int i = 0; i < x.length; i++){
            for(int j = i+1; j < x.length; j++){
                if(x[i] == x[j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] x = {6,4,8,2,4,6,9,0};
        int[] y = {1,1,1,1,1,1,1,1};
        int[] z = {1,2,3,1};

        System.out.println(search(x, 1));

        System.out.println(areDifferent(x, y));

        System.out.println(areUniqueV2(z));
    }
}
