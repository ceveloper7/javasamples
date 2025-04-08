package org.mikado.ch02.ui;

public class ApplicationException extends Exception{
    private static final long serialVersionUID = 1L;

    public ApplicationException(Exception e) {
        super(e);
    }
}
