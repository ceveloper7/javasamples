package sec4;

public class AC03ConvertStringToInt {
    private static void convertToInt(char c){
        System.out.println("int value of char " + c + " is = " + (c - '0'));
    }

    private static boolean isDigit(char c){
        return (c <= '0') && (c >= '9');
    }

    /**
     * convert string positive or negative to integer
     * validamos que al inicio el numero tenga el signo negativo y el resto sean digitos
     * @param text -> text to convert
     * @return res -> integer value
     */
    private static int convertStringToInteger(String text){
        int res = 0;
        boolean isNegative = false;
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            // validamos si el primero caracter es signo negativo
            if((i == 0) && (ch == '-')){
                isNegative = true;
                continue;
            }
            // validamos si el caracter no es un digito,
            if(!isDigit(ch))
                return 0;
            int digit = text.charAt(i) - '0';
            res = res * 10 + digit;
        }

        if(isNegative)
            return -res;

        return res;
    }

    public static void main(String[] args) {
       int res = convertStringToInteger("8p5");
        System.out.println(res);
    }
}
