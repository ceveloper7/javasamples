package org.ceva.ch08.web;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWebClientMock {

    @Test
    public void testGetContentOk() throws Exception {
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));

        TestableWebClient client = new TestableWebClient();
        client.setHttpURLConnection(mockConnection);

        String result = client.getContent(new URL("http://localhost"));

        assertEquals("It works", result);
    }


    /**
     * An inner, private class that extends WebClient and allows us
     * to override the createHttpURLConnection method.
     */
    private class TestableWebClient extends WebClient1 {
        /**
         * The connection.
         */
        private HttpURLConnection connection;

        /**
         * Setter method for the HttpURLConnection.
         *
         * @param connection
         */
        public void setHttpURLConnection(HttpURLConnection connection) {
            this.connection = connection;
        }

        /**
         * A method that we overwrite to create the URL connection.
         */
        public HttpURLConnection createHttpURLConnection(URL url) throws IOException {
            return this.connection;
        }
    }
}
