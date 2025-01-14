package com.ceva.ch07;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.IOException;

/**
 * A sample web-client class that opens an HTTP connection to a web-server and reads the response from it.
 *
 */
public class WebClient {
    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            // 1. abrimos la conexion
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int count;
            // 2. procesamos el stream hasta terminar el contenido
            while (-1 != (count = is.read(buffer))) {
                content.append(new String(buffer, 0, count));
            }
        }
        // 3. manejamos el error
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }
}
