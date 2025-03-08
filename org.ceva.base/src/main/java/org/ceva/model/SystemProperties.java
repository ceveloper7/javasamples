package org.ceva.model;

import org.ceva.util.Ini;

public class SystemProperties {
    private static final String APP_HOME = Ini.APP_HOME;

    public static String getAppHome(){
        return System.getProperty(APP_HOME);
    }
}
