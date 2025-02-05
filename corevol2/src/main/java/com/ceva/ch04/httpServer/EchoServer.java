package com.ceva.ch04.httpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;

/**
 * This program implements an HTTP server that listens to port 8189
 */
public class EchoServer {
    public static void main(String[] args) throws IOException
    {
        int port = args.length >= 1 ? Integer.parseInt(args[0]) : 8189;
        // Iniciamos un server y lo configuramos para que no funcione como un servidor de archivos (lo configuramos para q no haga nada)
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        // concurrente
        server.setExecutor(Executors.newVirtualThreadPerTaskExecutor());

        // Creamos dos contextos: / y /echo
        server.createContext("/", HttpHandlers.of(301,
                Headers.of("Location", "https://horstmann.com/corejava"), ""));
        server.createContext("/echo", (HttpExchange exchange) ->
                {
                    var headers = new StringBuilder();
                    // read headers
                    exchange.getRequestHeaders().forEach((k, vs) ->
                            vs.forEach(v ->
                                    headers.append("%s: %s\n".formatted(k, v))));

                    // read request body
                    String requestBody = new String(exchange.getRequestBody().readAllBytes());
                    String response = "%s %s\n%s\n%s\n".formatted(
                            exchange.getRequestMethod(), exchange.getRequestURI(),
                            headers,
                            requestBody);
                    byte[] responseBytes = response.getBytes();

                    // establecemos el status code  y longitud del response body
                    exchange.sendResponseHeaders(200, responseBytes.length);
                    // write response body
                    OutputStream responseBody = exchange.getResponseBody();
                    responseBody.write(responseBytes);
                    //responseBody.write(2222);
                    responseBody.close();
                }
        );
        server.start();
    }
}
