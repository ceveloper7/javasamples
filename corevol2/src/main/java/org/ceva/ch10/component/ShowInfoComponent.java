package org.ceva.ch10.component;

import javax.swing.*;
import java.awt.*;

public class ShowInfoComponent {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            var frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * A frame that contains a message panel.
 */
class NotHelloWorldFrame extends JFrame
{
    public NotHelloWorldFrame()
    {
        add(new NotHelloWorldComponent());
        pack();
    }
}