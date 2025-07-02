package sec2.operlogic;

public class LogicOperators {
    private static void andLogic(){
        int ten = 0b1010; // 10
        int twelve = 0b1100; // 12

        /**
         * Realizamos un & (AND) en cada bit de los numeros
         * 10 = 0b1010
         * 12 = 0b1100
         *     -------
         *      0b1000 -> representa 8
         */
        int r = ten & twelve;
        System.out.println("10 & 12 == " + r);
    }

    private static void orLogic(){
        int ten = 0b1010;
        int twelve = 0b1100;

        /**
         * Realizamos un | (OR) en cada bit del numero
         * 10 = 0b1010
         * 12 = 0b1100
         *      ------
         *      0b1110 -> representa 14
         */
        int r = ten | twelve;
        System.out.println("10 | 12 == " + r);
    }

    private static void notLogic(){
        int ten = 0b1010;

        /**
         * Realizamos un ~ (NOT) en cada bit del numero
         * 10 = 0b1010 => 0b0101
         *
         */
        System.out.println(0b0101);

    }

    public static void main(String[] args) {
        andLogic();
        orLogic();
        notLogic();
    }
}
