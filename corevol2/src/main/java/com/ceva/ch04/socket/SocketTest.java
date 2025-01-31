package com.ceva.ch04.socket;

import java.io.*;
import java.net.*;
import java.util.*;


public class SocketTest{
    public static void main(String[] args) throws IOException
    {
        // abrimos un socket
        try (var s = new Socket("time-a.nist.gov", 13);
             // leemos del socket y retornamos un ImputStream
             var in = new Scanner(s.getInputStream()))
        {
            s.setSoTimeout(10000); // timeout 10 seg
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        catch (SocketTimeoutException ex){
            System.out.println("Timeout reached");
            ex.printStackTrace();
        }
    }
}
