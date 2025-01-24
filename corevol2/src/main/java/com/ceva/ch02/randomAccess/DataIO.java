package com.ceva.ch02.randomAccess;

import java.io.*;

public class DataIO {
    /**
     * leemos characters de un input stream hasta que se haya consumido size code units o
     * hasta que se encuentra un valor zero
     * @param size
     * @param in
     * @return
     * @throws IOException
     */
    public static String readFixedString(int size, DataInput in) throws IOException
    {
        var b = new StringBuilder(size);
        int i = 0;
        boolean done = false;
        while (!done && i < size)
        {
            char ch = in.readChar();
            i++;
            if (ch == 0)
                done = true;
            else
                b.append(ch);
        }
        in.skipBytes(2 * (size - i));
        return b.toString();
    }

    /**
     * Escribimos un numero especifico de Code Units empezando desde el inicio del string
     * @param s content
     * @param size
     * @param out
     * @throws IOException
     */
    public static void writeFixedString(String s, int size, DataOutput out) throws IOException
    {
        for (int i = 0; i < size; i++)
        {
            char ch = 0;
            // si hay pocos code units llenamos el string con 0
            if (i < s.length())
                ch = s.charAt(i);
            out.writeChar(ch);
        }
    }
}
