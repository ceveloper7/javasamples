package com.ceva.ch04.httpClient;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;
import java.net.http.*;
import java.net.http.HttpRequest.*;

/**
 * This program demonstrates the HTTP client
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException    {
        System.setProperty("jdk.httpclient.HttpClient.log", "headers,requests,content");
        String propsFilename = args.length > 0 ? args[0] : "post.properties";
        Path propsPath = Path.of(propsFilename);
        var props = new Properties();
        try (Reader in = Files.newBufferedReader(propsPath))
        {
            props.load(in);
        }
        String urlString = "" + props.remove("url");
        String contentType = "" + props.remove("Content-Type");
        BodyPublisher publisher = null;
        if (contentType.equals("application/x-www-form-urlencoded"))
            publisher = MoreBodyPublishers.ofFormData(props);
        else if (contentType.equals("multipart/form-data"))
        {
            // Split each value along commas, replace strings starting with
            // file:// with Path objects
            var data = new HashMap<String, List<?>>();
            for (Map.Entry<Object, Object> entry : props.entrySet())
            {
                data.put(entry.getKey().toString(),
                        Stream.of(entry.getValue().toString().split("\\s*,\\s*"))
                                .map(s -> s.startsWith("file://")
                                        ? propsPath.getParent().resolve(Path.of(s.substring(7)))
                                        : s)
                                .toList());
            }
            String boundary = UUID.randomUUID().toString().replace("-", "");
            contentType += "; boundary=" + boundary;
            publisher = MoreBodyPublishers.ofMimeMultipartData(data, boundary);
        }
        else
        {
            contentType = "application/json";
            publisher = MoreBodyPublishers.ofSimpleJSON(props);
        }

        String result = doPost(urlString, contentType, publisher);
        System.out.println(result);
    }

    public static String doPost(String url, String contentType, BodyPublisher publisher)
            throws IOException, URISyntaxException, InterruptedException
    {
        try (HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS).build())
        {
            // formulamos una Solictud POST (tambien aplicable para una Solicitud GET)
            HttpRequest request  = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Content-Type", contentType)
                    // Solicitud POST requiere un body publisher
                    .POST(publisher) // GET
                    .build();

            HttpResponse<String> response
                    = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
    }
}
