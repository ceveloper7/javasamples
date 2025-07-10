package sec4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AA01SystemInTest {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese su nombre: ");
        String name = in.readLine();
        System.out.println("Saludos " + name + "!.");
    }
}
