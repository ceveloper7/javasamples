package com.ceva.ch07;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A sample test case that demonstrates how to stub an HTTP server using Jetty as an embedded server.
 *
 */
public class TestWebClient {
    // 1. Instanciamos la clase a evaluar
    private WebClient client = new WebClient();

    @BeforeAll
    public static void setUp() throws Exception {
        // Construimos el objeto server Jetty
        Server server = new Server(8081);

        Context contentOkContext = new Context(server, "/testGetContentOk");
        // Indicamos a Jetty usar un handler
        contentOkContext.setHandler(new TestGetContentOkHandler());

        Context contentErrorContext = new Context(server, "/testGetContentError");
        contentErrorContext.setHandler(new TestGetContentServerErrorHandler());

        Context contentNotFoundContext = new Context(server, "/testGetContentNotFound");
        contentNotFoundContext.setHandler(new TestGetContentNotFoundHandler());

        server.setStopAtShutdown(true);
        server.start();
    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        // 3. Realizamos una accion
        String workingContent = client.getContent(new URL("http://localhost:8081/testGetContentOk"));
        // 4. afirmamos el estado final de la clase
        assertEquals("It works", workingContent);
    }

    /**
     * Handler to handle the good requests to the server.
     */
    private static class TestGetContentOkHandler extends AbstractHandler {
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {

            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    /**
     * Handler to handle bad requests to the server
     */
    private static class TestGetContentServerErrorHandler extends AbstractHandler {

        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        }
    }

    /**
     * Handler to handle requests that request unavailable content.
     */
    private static class TestGetContentNotFoundHandler extends AbstractHandler {

        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @AfterAll
    public static void tearDown() {
        // Empty
    }
}
