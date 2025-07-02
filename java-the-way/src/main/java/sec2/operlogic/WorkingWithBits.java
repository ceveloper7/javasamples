package sec2.operlogic;

public class WorkingWithBits {
    private static void activatingBit(){
        int n = 0b1101;
        System.out.println("Before activating second bit from right to left in 0b1101 == " +  n);

        // activando el segundo bit de derecha a izquierda sin afectar a los demas con OR (|)
        n = n | 0b10;
        System.out.println(" After activating second bit from right to left in 0b1111 == " + n);
    }

    private static void deActivatingBit(){
        // con el operador AND (&) podemos pasar un numero con los bits activos excepto el que queremos limpiar
        int n = 0b1111; // 15
        System.out.println("Before deactivating a bit from 0b1111 == " + n);

        n = n & 0b1101;
        System.out.println("after  deactivating a bit to 0b1101 == " + n);
    }

    /**
     * Complemento a 2
     * Al calcular el complemento a 2 de cualqier numero binario obtenemos su correspondiente numero negativo.
     */
    private static void complementTo2(){
        // representacion de 1 en binario
        int n = 0b0001;

        // paso 1. negacion de n
        n = 0b1110;

        // paso 2. le sumamos 1
        n = 0b1111;

        System.out.println(n); // si se representa como binario sin signo es 255, pero si se interpreta com completo a 2, es -1

        // sumando 2 al -1 (0b1111) para obtener un numero positivo
        n = 0b1111 + 0b0010;
        System.out.println("Suma -1(0b1111) + 2(0b0010) == " + 0b0001);
    }

    private static void movimientoBits(){
        // << mueve los bits a la izquierda
        // >> mueve los bits a la derecha
        // >>>

        // movemos a la izquierda 4 bits ()
        int n = 0b1111 << 4; // 0b11110000
        System.out.println("0b1111 << 4 == " + n);

        /**
         * Movimiento de bits a la derecha
         * Considerando el signo (usamos >>) Si lo aplicamos para un numero negativo, como el bit del signo esta activo, entonces los bits
         * se recorreran y se insertaran unos a la izquierda
         * No considerando el signo (usamos >>>)
         */

    }

    public static void main(String[] args) {
        activatingBit();
        deActivatingBit();
        complementTo2();
        movimientoBits();
    }
}
