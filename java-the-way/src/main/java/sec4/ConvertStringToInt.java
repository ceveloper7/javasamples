package sec4;

public class ConvertStringToInt {
    private static void convertToInt(char c){
        System.out.println("int value of char " + c + " is = " + (c - '0'));
    }

    /**
     * convert string positive or negative to integer
     * @param text -> text to convert
     * @return res -> integer value
     */
    private static int convertStringToInteger(String text){
        int res = 0;
        boolean isNegative = false;
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if((i == 0) && (ch == '-')){
                isNegative = true;
                continue;
            }
            int digit = text.charAt(i) - '0';
            res = res * 10 + digit;
        }

        if(isNegative)
            return -res;

        return res;
    }

    public static void main(String[] args) {
       int res = convertStringToInteger("85");
        System.out.println(res);
    }
}
