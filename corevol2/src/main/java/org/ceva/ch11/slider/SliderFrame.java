package org.ceva.ch11.slider;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * A frame with many sliders and a text field to show slider values.
 */
public class SliderFrame extends JFrame
{
    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame()
    {
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        // common listener for all sliders
        listener = event ->
        {
            // update text field when the slider value changes
            JSlider source = (JSlider) event.getSource();
            textField.setText("" + source.getValue());
        };

        // add a plain slider

        var slider = new JSlider();
        addSlider(slider, "Plain");

        // add a slider with major and minor ticks

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Ticks");

        // add a slider that snaps to ticks

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Snap to ticks");

        // add a slider with no track

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider, "No track");

        // add an inverted slider

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Inverted");

        // add a slider with numeric labels

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Labels");

        // add a slider with alphabetic labels

        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        var labelTable = new Hashtable<Integer, Component>();
        labelTable.put(0, new JLabel("A"));
        labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Custom labels");

        // add a slider with icon labels

        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        labelTable = new Hashtable<>();

        // add card images

        labelTable.put(0, new JLabel(new ImageIcon(this.getClass().getResource( "/nine.gif"))));
        labelTable.put(20, new JLabel(new ImageIcon(this.getClass().getResource("/ten.gif"))));
        labelTable.put(40, new JLabel(new ImageIcon(this.getClass().getResource("/jack.gif"))));
        labelTable.put(60, new JLabel(new ImageIcon(this.getClass().getResource("/queen.gif"))));
        labelTable.put(80, new JLabel(new ImageIcon(this.getClass().getResource("/king.gif"))));
        labelTable.put(100, new JLabel(new ImageIcon(this.getClass().getResource("/ace.gif"))));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Icon labels");

        // add the text field that displays the slider value

        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a slider to the slider panel and hooks up the listener.
     * @param slider the slider
     * @param description the slider description
     */
    public void addSlider(JSlider slider, String description)
    {
        slider.addChangeListener(listener);
        var panel = new JPanel();
        panel.add(slider);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        var gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel, gbc);
    }
}
