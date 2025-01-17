package com.ceva.ch08.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test-case for the WebClient class. We use our MockHttpURLConnection
 * and we also extend the WebClient class to
 * overwrite one of its methods.
 */
public class TestWebClient {
    @Test
    public void testGetContentOk()
            throws Exception {
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
        MockInputStream mockStream = new MockInputStream();
        mockStream.setBuffer("It works");

        mockConnectionFactory.setData(mockStream);

        WebClient2 client = new WebClient2();

        String workingContent = client.getContent(mockConnectionFactory);

        assertEquals("It works", workingContent);
        mockStream.verify();
    }
}
