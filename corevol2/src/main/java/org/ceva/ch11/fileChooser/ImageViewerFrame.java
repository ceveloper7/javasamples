package org.ceva.ch11.fileChooser;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;

/**
 * A frame that has a menu for loading an image and a display area for the
 * loaded image.
 */
public class ImageViewerFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up menu bar
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event ->
        {
            // 2. set current working directory
            chooser.setCurrentDirectory(new File("."));

            // show file chooser dialog
            int result = chooser.showOpenDialog(ImageViewerFrame.this);

            // if image file accepted, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
                pack();
            }
        });

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));

        // use a label to display the images
        label = new JLabel();
        add(label);

        // 1. set up file chooser
        chooser = new JFileChooser();

        // accept all image files ending with .jpg, .jpeg, .gif
        var filter = new FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);

        chooser.setAccessory(new ImagePreviewer(chooser));

        chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
    }
}
