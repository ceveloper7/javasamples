package com.ceva.ch12.treeModel;

import java.awt.*;
import javax.swing.*;

public class ObjectInspectorTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            var frame = new ObjectInspectorFrame();
            frame.setTitle("ObjectInspectorTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
