package com.ceva.ch01;

/**
 * Andreas Zeller - Why programs fails
 * Page 12
 */
public class Sample {
    private static void shellShort(int a[], int size){
        int i, j;
        int h = 1;

        System.err.println("At shell_sort");
        for (int ii = 0; ii < size; ii++) {
            System.err.println("a[" + ii + "] = " + a[ii]);
        }
        System.err.println("size = " + size);


        do {
            h = h * 3 + 1;
        }
        while (h <= size);

        do {
            h /= 3;
            for (i = h; i < size; i++)
            {
                int v = a[i];
                for (j = i; j >= h && a[j - h] > v; j -= h)
                    a[j] = a[j - h];
                if (i != j)
                    a[j] = v;
            }
        }
        while (h != 1);
    }

    public static void main(String[] argv) {
        int[] a = new int[argv.length];
        // Copiamos los argumentos pasados al array a
        for (int i = 0; i < argv.length; i++) {
            a[i] = Integer.parseInt(argv[i]);
        }

        // ordenamos el array a
        shellShort(a, argv.length);

        System.out.print("Output: ");
        for (int i = 0; i < argv.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
