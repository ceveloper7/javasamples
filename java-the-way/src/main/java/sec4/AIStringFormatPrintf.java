package sec4;

public class AIStringFormatPrintf {

    public static void main(String[] args) {
        int line = 100;
        String source = "Test.java";
        String message = "Este es un mensaje";

        System.out.println("[" + source + " " + line + "]" + message);

        // USING PRINTF
        System.out.printf("[%s %d] %s\n", source, line, message);

        String m = String.format("[%s %d] %s\n", source, line, message);
        System.out.print(m);
    }
}
