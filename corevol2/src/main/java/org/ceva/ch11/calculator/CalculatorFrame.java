package org.ceva.ch11.calculator;

import javax.swing.*;

public class CalculatorFrame  extends JFrame
{
    public CalculatorFrame()
    {
        add(new CalculatorPanel());
        pack();
    }
}
