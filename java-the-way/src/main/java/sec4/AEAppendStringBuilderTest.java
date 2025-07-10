package sec4;

public class AEAppendStringBuilderTest {
    private static void appendTest(){
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hola mundo");
        for(int i = 0; i < 100000; i++){
            sb.append(i);
        }
        String s = sb.toString();
        long end = System.currentTimeMillis();

        System.out.println("Tiempo transcurrido: " + (end - start) + " ms.");
    }

    public static void main(String[] args) {
        appendTest();
    }

}
