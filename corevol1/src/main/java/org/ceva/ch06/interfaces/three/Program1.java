package org.ceva.ch06.interfaces.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * 6.3 Inner class
 * Program1 = TalkingClock
 * Internal name of a inner class: Program1$TimePrinter
 */
public class Program1 {
    private int interval;
    private boolean beep;

    public Program1(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        // create inner class object
        var listener = this.new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
            // access to outer class instance field
            if(Program1.this.beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }

    public static void main(String[] args) {
        var clock = new Program1(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program");
        System.exit(0);
    }
}
