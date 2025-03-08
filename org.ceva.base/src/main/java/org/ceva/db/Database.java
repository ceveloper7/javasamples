package org.ceva.db;

public class Database {

    /** Connection Timeout in seconds   */
    public static int CONNECTION_TIMEOUT = 10;

    /** PostgreSQL ID   */
    public static String DB_POSTGRESQL = "PostgreSQL";

    // Supported Databases
    public static String[] DB_NAMES = new String[]{
            DB_POSTGRESQL
    };

    // Database Classes
    protected static Class<?>[] DB_CLASSES = new Class[]{
            DB_PostgreSQL.class
    };

    /**
     * Get Database by Id
     */
    public static GeneralDataBase getDatabase(String type) throws Exception{
        GeneralDataBase db = null;
        for(int i = 0; i < Database.DB_NAMES.length; i++){
            if(Database.DB_NAMES[i].equals(type)){
                db = (GeneralDataBase) Database.DB_CLASSES[i].newInstance();
                break;
            }
        }
        return db;
    }

    /**
     *  Get Database Driver by url string.
     *  Access to database specific functionality.
     *  @param
     *  @return Adempiere Database Driver
     */
    public static GeneralDataBase getDatabaseFromURL(String url){
        if(url == null || url.isEmpty())
            return null;
        if(url.contains("postgresql")){
            return new DB_PostgreSQL();
        }
        return null;
    }

}
