package org.ceva.ch06.interfaces.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * Local inner class - Accessing varaibles from outer methods
 */
public class Program3 {

    public void start(int interval, boolean beep){
        class TimePrinter implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                // accedemos a la variable beep del metodo de mas afuera
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        }

        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public static void main(String[] args) {
        Program3 program3 = new Program3();
        program3.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
