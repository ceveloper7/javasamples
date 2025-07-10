package sec4;

/**
 * Building and comparing a String using class String and StringBuilder
 */
public class ADAppendStringTest {
    private static void appendTest1(){
        long start = System.currentTimeMillis();

        String s = "Hola mundo";
        for(int i = 0; i < 100000; i++){
            s = s + i;
        }
        long end = System.currentTimeMillis();

        System.out.println("Tiempo transcurrido: " + (end - start) + " ms.");
    }

    public static void main(String[] args) {
        appendTest1();
    }
}
