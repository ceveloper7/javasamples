package org.mikado.ch02;

import org.mikado.ch02.ui.App;
import org.mikado.ch02.ui.ApplicationException;

public class Launcher {
    public static void main(String[] argv) {
        try {
            App.setStorageFile("opt/local/app/db.txt");
            App app = new App();
            app.launch();
        } catch (ApplicationException e) {
            System.err.println("Could not start application");
            e.printStackTrace();
        }
    }
}
