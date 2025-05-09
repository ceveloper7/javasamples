package org.ceva.ch06.interfaces.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * 6.3 Inner class
 * Program1 = TalkingClock
 */
public class Program1 {
    private int interval;
    private boolean beep;

    public Program1(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
            if(beep)
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
