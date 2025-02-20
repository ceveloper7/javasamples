package com.ceva.ch10.action;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;

public class ActionFrame extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        // define three actions de tipo ColorActions
        var yellowAction = new ColorAction("Yellow", new ImageIcon(this.getClass().getResource("/yellow-ball.gif")), Color.YELLOW);
        var blueAction = new ColorAction("Blue", new ImageIcon(this.getClass().getResource("/blue-ball.gif")), Color.BLUE);
        var redAction = new ColorAction("Red", new ImageIcon(this.getClass().getResource("/red-ball.gif")), Color.RED);

        /*
         * Asociamos los actions con los buttons
         * JButton constructor lee el nombre e icon del action y establece el short description como tooltip
         */
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        // add panel to frame
        add(buttonPanel);

        // associate the Y, B, and R keys with names (KeyStroke)
        InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        inputMap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        // associate the names with actions
        ActionMap actionMap = buttonPanel.getActionMap();
        actionMap.put("panel.yellow", yellowAction);
        actionMap.put("panel.blue", blueAction);
        actionMap.put("panel.red", redAction);
    }

    /*
     * Action object que permite el cambio de color
     */
    public class ColorAction extends AbstractAction
    {
        /**
         * Constructs a color action.
         * @param name the name to show on the button
         * @param icon the icon to display on the button
         * @param c the background color
         */
        public ColorAction(String name, Icon icon, Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            //putValue(Action.LONG_DESCRIPTION, "A long description of the icon for potential use in online help. No Swing component uses this value. " + name.toLowerCase());
            putValue("color", c);
        }

        public void actionPerformed(ActionEvent event)
        {
            var color = (Color) getValue("color");
            buttonPanel.setBackground(color);
        }
    }
}
