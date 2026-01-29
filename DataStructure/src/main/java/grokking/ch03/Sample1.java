package grokking.ch03;

/**
 * Basic Recursion function
 */
public class Sample1 {
    private void printNumber(int n){
        System.out.println(n);
        // Caso base
        if(n <= 1)
            return;
        else
            // Caso Recursivo
            printNumber(n -1);
    }

    public static void main(String[] args) {
        Sample1 sample1 = new Sample1();
        sample1.printNumber(5);
    }
}
