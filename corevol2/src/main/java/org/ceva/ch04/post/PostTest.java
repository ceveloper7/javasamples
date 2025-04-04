package org.ceva.ch04.post;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

/**
 * This program demonstrates how to use the URLConnection class for a POST request.
 */
public class PostTest {
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        String propsFilename = args.length > 0 ? args[0] : "post.properties";
        var props = new Properties();
        try (Reader in = Files.newBufferedReader(
                Path.of(propsFilename)))
        {
            props.load(in);
        }
        // removemos las entradas url y User-Agent
        String urlString = props.remove("url").toString();
        Object userAgent = props.remove("User-Agent");
        Object redirects = props.remove("redirects");
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        String result = doPost(new URI(urlString).toURL(), props,
                userAgent == null ? null : userAgent.toString(),
                redirects == null ? -1 : Integer.parseInt(redirects.toString()));
        System.out.println(result);
    }

    /**
     * Do an HTTP POST.
     * @param url the URL to post to
     * @param nameValuePairs the query parameters
     * @param userAgent the user agent to use, or null for the default user agent
     * @param redirects the number of redirects to follow manually, or -1 for automatic
     * redirects
     * @return the data returned from the server
     * @throws URISyntaxException
     */
    public static String doPost(URL url, Map<Object, Object> nameValuePairs, String userAgent,
                                int redirects) throws IOException, URISyntaxException
    {
        // Open the connection
        var connection = (HttpURLConnection) url.openConnection();
        if (userAgent != null)
            // set the User-Agent
            connection.setRequestProperty("User-Agent", userAgent);

        if (redirects >= 0)
            connection.setInstanceFollowRedirects(false);

        // configuramos la conexion para Output
        connection.setDoOutput(true);

        // open OutputStream
        try (var out = new PrintWriter(connection.getOutputStream()))
        {
            boolean first = true;
            // enumeramos todas las llaves y valores
            for (Map.Entry<Object, Object> pair : nameValuePairs.entrySet())
            {
                if (first)
                    first = false;
                else
                    out.print("&"); // enviamos al servidor el caracter &
                String name = pair.getKey().toString();
                String value = pair.getValue().toString();
                // enviamos al server the key, el caracter =
                out.print(name);
                out.print("=");
                out.print(URLEncoder.encode(value, StandardCharsets.UTF_8));
            }
        }
        //
        String encoding = connection.getContentEncoding();
        if (encoding == null) encoding = "UTF-8";

        if (redirects > 0)
        {
            // get ResponseCode
            int responseCode = connection.getResponseCode();
            // verify ResponseCode type
            if (responseCode == HttpURLConnection.HTTP_MOVED_PERM
                    || responseCode == HttpURLConnection.HTTP_MOVED_TEMP
                    || responseCode == HttpURLConnection.HTTP_SEE_OTHER)
            {
                // get Location response header para obtener el URL para el redirect
                String location = connection.getHeaderField("Location");
                if (location != null)
                {
                    URL base = connection.getURL();
                    connection.disconnect();
                    return doPost(base.toURI().resolve(location).toURL(), nameValuePairs,
                            userAgent, redirects - 1);
                }
            }
        }
        else if (redirects == 0)
        {
            throw new IOException("Too many redirects");
        }

        var response = new StringBuilder();
        try (var in = new Scanner(connection.getInputStream(), encoding))
        {
            while (in.hasNextLine())
            {
                response.append(in.nextLine());
                response.append("\n");
            }
        }
        catch (IOException e)
        {
            // obtenemos la pagina de error enviada por el servidor
            InputStream err = connection.getErrorStream();
            if (err == null) throw e;
            try (var in = new Scanner(err))
            {
                response.append(in.nextLine());
                response.append("\n");
            }
        }

        return response.toString();
    }
}
