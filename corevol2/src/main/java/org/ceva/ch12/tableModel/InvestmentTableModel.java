package org.ceva.ch12.tableModel;

import javax.swing.table.AbstractTableModel;

/**
 * This table model computes the cell entries each time they are requested. The table contents
 * shows the growth of an investment for a number of years under different interest rates.
 */
public class InvestmentTableModel extends AbstractTableModel
{
    private static double INITIAL_BALANCE = 100000.0;

    private int years;
    private int minRate;
    private int maxRate;

    /**
     * Constructs an investment table model.
     * @param y the number of years
     * @param r1 the lowest interest rate to tabulate
     * @param r2 the highest interest rate to tabulate
     */
    public InvestmentTableModel(int y, int r1, int r2)
    {
        years = y; // 30
        minRate = r1; // 5
        maxRate = r2; // 10
    }

    public int getRowCount()
    {
        return years;
    }

    public int getColumnCount()
    {
        return maxRate - minRate + 1;
    }

    public Object getValueAt(int r, int c)
    {
        double rate = (c + minRate) / 100.0;
        int nperiods = r;
        double futureBalance = INITIAL_BALANCE * Math.pow(1 + rate, nperiods);
        return "%.2f".formatted(futureBalance);
    }

    public String getColumnName(int c)
    {
        return (c + minRate) + "%";
    }
}
