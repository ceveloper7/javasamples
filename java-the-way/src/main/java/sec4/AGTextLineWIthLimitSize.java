package sec4;

import java.util.StringTokenizer;

/**
 * Programa para formatear texto
 * Tomamos una linea de texto grande y la convertimos en varias lineas de texto que no excedan un longitud determinada.
 *
 */
public class AGTextLineWIthLimitSize {
    private static final int LINE_WIDTH = 40;

    private static void makeRuler(){
        System.out.println();
        for(int i = 0; i < LINE_WIDTH; i++){
            // validamos que sea multiplo de 10
            if(((i+1) % 10) == 0){
                System.out.print(((i/10) + 1) % 10);
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int i = 0; i < LINE_WIDTH; i++){
            System.out.print((i + 1) % 10) ;
        }
        System.out.println();

        for(int i = 0; i < LINE_WIDTH; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printTextFormatted(String text){
        boolean space = false;
        StringTokenizer str = new StringTokenizer(text);

        int curPos = 0;
        while(str.hasMoreTokens()){
            String s = str.nextToken();
            if ((curPos + s.length()) > LINE_WIDTH){
                System.out.println();
                curPos = 0;
                space = false;
            }
            if (space)
                System.out.print(" ");
            System.out.print(s);
            // actualizamos la posicion: posicion actual + longitud de palabra + espacio
            curPos += s.length() + 1;
            space = true;
        }
    }

    public static void main(String[] args) {
        makeRuler();
        String str = "Sed aliquam, nulla et malesuada bibendum, nunc velit vehicula ligula, nec dictum sapien nisi eu est. In hac habitasse platea dictumst. Etiam maximus turpis vel consectetur egestas. Donec tincidunt massa quis imperdiet fringilla. Integer sed consequat velit. Nulla nec lorem non velit mattis consequat. Nam vitae elementum nisi. Phasellus ut dolor mauris. Fusce eleifend metus sed urna vulputate euismod. Quisque ut mauris suscipit risus auctor scelerisque. Fusce vestibulum mi felis, eu gravida velit maximus quis. Pellentesque mattis lacus non tristique lacinia. Mauris sed magna urna. Vivamus vestibulum neque ut libero facilisis, placerat condimentum eros laoreet. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        printTextFormatted(str);
    }
}
