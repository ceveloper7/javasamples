package org.ceva.ch11.text;

import java.awt.*;
import javax.swing.*;

public class TextComponentTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            var frame = new TextComponentFrame();
            frame.setTitle("TextComponentTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
