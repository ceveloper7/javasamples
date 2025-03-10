package org.ceva.util;

import java.util.Properties;

public class DefaultContextProvider implements ContextProvider{

    private static Properties s_ctx = new Properties();

    private static String	UNIX_BROWSER = "netscape";

    private static String   MAC_BROWSER = "open";

    public static String GOOGLE_MAPS_URL_PREFIX = "http://local.google.com/maps?q=";

    @Override
    public Properties getContext() {
        return s_ctx;
    }

    @Override
    public void showURL(String url, String title) {
        try{
            java.net.URI uri = new java.net.URI(url);
            java.awt.Desktop.getDesktop().browse(uri);
        }
        catch (Exception e){}
    }
}
