package com.ceva.ch04.threaded;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * This program implements a multithreaded server that listens to port 8189 and echoes back all client input.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException
    {
        try (var s = new ServerSocket(8189))
        {
            int i = 1;
            ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

            /**
             * Cada vez que se llame a accept() se retorna un socket y se lanza un nuevo Thread para
             * ocuparse de la conexion entre el server y el cliente
             */
            while (true)
            {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                service.submit(() -> serve(incoming));
                i++;
            }
        }
    }

    // communication loop with client
    public static void serve(Socket incoming)
    {
        try (var in = new Scanner(incoming.getInputStream());
             var out = new PrintWriter(incoming.getOutputStream(),
                     true /* autoFlush */))
        {
            out.println( "Hello! Enter BYE to exit." );

            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine())
            {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.strip().equals("BYE"))
                    done = true;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
