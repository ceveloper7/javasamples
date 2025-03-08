package org.ceva.ch07;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * A class that demonstrates how to create a sample Jetty embedded server.
 *
 */
public class JettySample {
    public static void main(String[] args) throws Exception {
        // 1. Creamos el objeto jetty server
        Server server = new Server(8081);

        // 2. Creamos el objeto root de tipo Context
        Context root = new Context(server, "/");
        root.setResourceBase("./pom.xml");
        root.setHandler(new ResourceHandler());

        server.setStopAtShutdown(true);
        // 3. Iniciamos el servidor, vemos el contenido de pom.xml en: http://localhost:8081
        server.start();
    }
}
