package org.ceva.ch11.dialog;

import java.awt.*;
import javax.swing.*;

public class DialogTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            var frame = new DialogFrame();
            frame.setTitle("DialogTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
