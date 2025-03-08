package org.ceva.util;

import org.ceva.model.SystemProperties;

import java.io.File;
import java.io.Serializable;

public final class Ini implements Serializable {

    /** IsClient Internal marker            */
    private static boolean      s_client = false;
    /** System Property Value of APP_HOME                          */
    public static final String  APP_HOME = "APP_HOME";

    public static boolean isClient(){
        return s_client;
    }

    public static void setClient(boolean client){
        s_client = client;
    }

    public static String getAppHome(){
        String env = SystemProperties.getAppHome();

        if(env == null || env.isEmpty()){
            String current = isClient() ? System.getProperty("user.home") : System.getProperty("user.dir");
            if(current != null || !current.isEmpty()){
                File file = new File(current);
                if(file.exists() && file.canWrite()){
                    env = current;
                }
            }
        }
        if(env == null || env.isEmpty()){
            env = File.separator + "app";
        }
        return env;
    }

    public static void main(String[] args) {
        Ini.setClient(true);
        System.out.println(getAppHome());
    }
}
