package com.ceva.ch12.tableModel;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

/*
 * This program shows how to build a table from a table model.
 */
public class InvestmentTable
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            var frame = new InvestmentTableFrame();
            frame.setTitle("InvestmentTable");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
