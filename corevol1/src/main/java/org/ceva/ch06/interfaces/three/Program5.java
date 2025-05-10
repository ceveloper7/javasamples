package org.ceva.ch06.interfaces.three;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;

/**
 * Anonymous inner class with lambda expressions
 */
public class Program5 {
    public void start(int interval, boolean beep){
        var timer = new Timer(interval, (event)->{
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        });

        timer.start();
    }

    public static void main(String[] args) {
        Program5 program5 = new Program5();
        program5.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
