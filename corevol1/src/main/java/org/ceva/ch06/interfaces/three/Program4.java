package org.ceva.ch06.interfaces.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * 6.3.6 Inner class anonimas
 */
public class Program4 {
    public void start(int interval, boolean beep){
        // Anonymous inner class
        var listener = new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                if(beep)
                    Toolkit.getDefaultToolkit().beep();
            }
        };
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public static void main(String[] args) {
        Program4 program4 = new Program4();
        program4.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
