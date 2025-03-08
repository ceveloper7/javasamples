package org.ceva.ch12.tableCellRender;

import java.awt.*;
import javax.swing.*;

public class TableCellRenderTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {

            var frame = new TableCellRenderFrame();
            frame.setTitle("TableCellRenderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
