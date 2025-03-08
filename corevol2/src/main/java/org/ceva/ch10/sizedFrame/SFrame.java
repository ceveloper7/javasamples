package org.ceva.ch10.sizedFrame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SFrame extends JFrame {
    public SFrame(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame width, height and let platform pick screen location

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        // set frame icon
        Class<?> cl = SFrame.class;
        URL imgURL = cl.getResource("/duke.gif");

        Image img = null;
        if (imgURL != null) {
            img = new ImageIcon(imgURL).getImage();
            setIconImage(img);
        } else {
            System.err.println("Couldn't find file: " + imgURL);
        }

    }
}
