package com.ceva.ch12.tableModel;

import javax.swing.*;

/**
 * This frame contains the investment table.
 */
public class InvestmentTableFrame extends JFrame
{
    public InvestmentTableFrame()
    {
        var model = new InvestmentTableModel(30, 5, 10);
        var table = new JTable(model);
        add(new JScrollPane(table));
        pack();
    }
}
