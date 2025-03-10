package org.ceva.util;

import java.util.Properties;

public interface ContextProvider {
    public Properties getContext();
    public void showURL(String url, String title);
}
