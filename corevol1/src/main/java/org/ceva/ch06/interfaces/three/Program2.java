package org.ceva.ch06.interfaces.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * Local Inner class
 */
public class Program2 {
    private int interval;
    private boolean beep;

    public Program2(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        // definimos una local inner class TimePrinter
        class TimePrinter implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        }

        var listener = new TimePrinter();
        var timer = new Timer(1000, listener);
        timer.start();
    }

    public static void main(String[] args) {
        var clock = new Program2(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
