package com.ceva.ch11.border;

import java.awt.*;
import javax.swing.*;

public class BorderTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            var frame = new BorderFrame();
            frame.setTitle("BorderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
