package com.epbs.console.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keypad {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getInput() throws IOException {
        return reader.readLine();
    }
}
