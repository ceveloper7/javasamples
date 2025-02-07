package com.ceva.ch05.exec;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.sql.*;

/**
 * Executes all SQL statements in a file. Call this program as
 * java -classpath driverPath:. ExecSQL Books.sql
 * java -classpath driverPath:. ExecSQL Authors.sql
 * java -classpath driverPath:. ExecSQL Publishers.sql
 *
 */
public class ExecSQL {
    public static void main(String[] args) throws IOException
    {
        /**
         * Evaluacion:
         *      Si no se le proporciona un argumento por consola al programa, el programa espera que el usuario escriba una sentencia SQL
         *      de lo contrario, toma el argumento como un archivo a leer.
         */
        try (Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Path.of(args[0]));
             // obtenemos una conexion a la BD
             Connection conn = getConnection();

             // creamos el objeto de tipo Statement para trabajar con sentencias SQL
             Statement stat = conn.createStatement())
        {
            while (true)
            {
                // si no se proporciona archivo sql a ejecutar, se espera que el usuario escriba la sentencia sql
                if (args.length == 0) System.out.println("Enter command or EXIT to exit:");
                // si no escribe comando, se termina el programa
                if (!in.hasNextLine()) return;

                // procesamos el input del usuario
                String line = in.nextLine().strip();
                if (line.equalsIgnoreCase("EXIT")) return;
                if (line.endsWith(";")) // remove trailing semicolon
                    line = line.substring(0, line.length() - 1);

                // ejecucion de cada sentencia con el metodo generico execute()
                try
                {
                    boolean isResult = stat.execute(line);
                    // si isResult es true, hay un resultset
                    if (isResult)
                    {
                        try (ResultSet rs = stat.getResultSet())
                        {
                            showResultSet(rs);
                        }
                    }
                    else
                    {
                        int updateCount = stat.getUpdateCount();
                        System.out.println(updateCount + " rows updated");
                    }
                }
                catch (SQLException e)
                {
                    for (Throwable t : e)
                        t.printStackTrace();
                }
            }
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
                t.printStackTrace();
        }
    }

    /**
     * Gets a connection from the properties specified in the file database.properties
     * @return the database connection
     */
    public static Connection getConnection() throws SQLException, IOException
    {
        /**
         * Leemos el archivo de propiedades: database.properties y agregamos la propiedad jdbc.drivers al system.properties
         * El DriverManager utiliza la propiedad jdbc.drivers para cargar el apropiado Driver de base de datos
         */
        var props = new Properties();
        try (Reader in = Files.newBufferedReader(
                Path.of("database.properties")))
        {
            props.load(in);
        }
        // pasamos las propiedades
        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) System.setProperty("jdbc.drivers", drivers);

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        // abrimos la conexion a la base de datos.
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Prints a  generic result set.
     * @param result the result set to be printed
     */
    public static void showResultSet(ResultSet result) throws SQLException
    {
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++)
        {
            if (i > 1) System.out.print(", ");
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (result.next())
        {
            for (int i = 1; i <= columnCount; i++)
            {
                if (i > 1) System.out.print(", ");
                System.out.print(result.getString(i));
            }
            System.out.println();
        }
    }
}
