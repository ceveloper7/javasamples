package com.ceva.ch04.urlConnection;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This program connects to an URL and displays the response header data and the first 10 lines of the requested data.
 * Supply the URL and an optional username and password (for HTTP basic authentication) on the command line.
 */
public class URLConnectionTest {
    public static void main(String[] args)
    {
        try
        {
            String urlName;
            if (args.length > 0) urlName = args[0];
            else urlName = "http://horstmann.com";

            // Construimos un objeto URL a partir de la clase URI
            var url = new URI(urlName).toURL();
            // URLCOnnection nos brinda mayor control que la clase base URL
            // 1. Obtenemos un objeto URLConnection
            URLConnection connection = url.openConnection();

            // set username, password if specified on command line

            if (args.length > 2)
            {
                String username = args[1];
                String password = args[2];
                String input = username + ":" + password;
                Base64.Encoder encoder = Base64.getEncoder();
                String encoding = encoder.encodeToString(input.getBytes());
                // 2. Establecemos request properties
                connection.setRequestProperty("Authorization", "Basic " + encoding);
            }

            // 3. Nos conectamos al socket del servidor (recurso remoto)
            connection.connect();

            // 4. Consultamos la informacion del encabezado
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet())
            {
                // print header fields
                String key = entry.getKey();
                for (String value : entry.getValue())
                    System.out.println(key + ": " + value);
            }

            // print convenience functions
            System.out.println("----------");
            System.out.println("getContentType: " + connection.getContentType());
            System.out.println("getContentLength: " + connection.getContentLength());
            System.out.println("getContentEncoding: " + connection.getContentEncoding());
            System.out.println("getDate: " + connection.getDate());
            System.out.println("getExpiration: " + connection.getExpiration());
            System.out.println("getLastModifed: " + connection.getLastModified());
            System.out.println("----------");

            // 5. Accdemos a los datos del recurso
            String encoding = connection.getContentEncoding();
            if (encoding == null) encoding = "UTF-8";
            // obtenemos un INputSTream para leer la informacion
            try (var in = new Scanner(connection.getInputStream(), encoding))
            {
                // print first ten lines of contents    
                for (int n = 1; in.hasNextLine() && n <= 10; n++)
                    System.out.println(in.nextLine());
                if (in.hasNextLine()) System.out.println(". . .");
            }
        }
        catch (IOException | URISyntaxException e)
        {
            e.printStackTrace();
        }
    }
}
