package com.ceva.ch08.web;

import java.io.InputStream;
public class MockConnectionFactory implements ConnectionFactory{
    private InputStream inputStream;

    public void setData(InputStream inputStream){
        this.inputStream = inputStream;
    }

    /**
     * Get the input stream.
     *
     * @throws Exception
     */
    public InputStream getData() throws Exception
    {
        return inputStream;
    }
}
