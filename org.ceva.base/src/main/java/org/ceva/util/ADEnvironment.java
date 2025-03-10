package org.ceva.util;

import java.util.Properties;

public final class ADEnvironment {

    public static final String AD_ROLE_ID = "#AD_Role_ID";
    public static final String AD_USER_ID = "#AD_User_ID";
    public static final String AD_ORG_ID = "#AD_Org_ID";
    public static final String AD_CLIENT_ID = "#AD_Client_ID";
    public static final String AD_ORG_NAME = "#AD_Org_Name";
    public static final String M_WAREHOUSE_ID = "#M_Warehouse_ID";

    private static ContextProvider contextProvider = new DefaultContextProvider();

    public static Properties getCtx(){
        return contextProvider.getContext();
    }

}
