package org.ceva.ch04.server;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException
    {
        int port = args.length >= 1 ? Integer.parseInt(args[0]) : 8189;

        try (var s = new ServerSocket(port); // establish server socket que monitorea el puerto 8189
             // cuando el client se conecta al puerto, se retorna un objeto Socket
             Socket incoming = s.accept()) // wait for client connection
        {
            serve(incoming);
        }
    }

    public static void serve(Socket incoming) throws IOException
    {
        // obtenemos del objeto Socket los stream input y output. Convertimos en Scanner y Writers
        try (var in = new Scanner(incoming.getInputStream());
             var out = new PrintWriter(incoming.getOutputStream(), true /* autoFlush */))
        {
            // enviamos al cliente un saludo
            out.println( "Hello! Enter BYE to exit." );

            // echo client input
            boolean done = false;
            while (!done && in.hasNextLine())
            {
                // leemos el input del client
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.strip().equals("BYE"))
                    done = true;
            }
        }
    }
}

