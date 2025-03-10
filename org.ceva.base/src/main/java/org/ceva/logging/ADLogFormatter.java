package org.ceva.logging;

import org.ceva.util.Ini;

import java.awt.*;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Application Log Formatter
 */
public class ADLogFormatter extends Formatter {
    private static ADLogFormatter s_formatter = null;
    public static String NL = System.getProperty("line.separator");
    private boolean m_shortFormat = false;

    private ADLogFormatter(){
        super();
    }

    public static synchronized ADLogFormatter get(){
        if(s_formatter == null)
            s_formatter = new ADLogFormatter();
        return s_formatter;
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        long ms = record.getMillis();
        Timestamp ts = null;
        if (ms == 0)
            ts = new Timestamp(System.currentTimeMillis());
        else
            ts = new Timestamp(ms);
        String tsStr = "";
        try
        {
            tsStr = ts.toString() + "00";
        }
        catch (Exception e)
        {
            System.err.println("CLogFormatter.format: Millis="
                    + ms + " - " + e.toString() + " - " + record.getMessage());
            //      1   5    1    5    2    5
            tsStr = "_________________________";
        }


        /**	Time/Error		*/
        if (record.getLevel() == Level.SEVERE)
        {	//		   12:12:12.123
            sb.append(tsStr.substring(11, 23));
            sb.append("===========> ");
            if (Ini.isClient())
                Toolkit.getDefaultToolkit().beep();
        }
        else if (record.getLevel() == Level.WARNING)
        {	//		   12:12:12.123
            sb.append(tsStr.substring(11, 23));
            sb.append("-----------> ");
        }
        else
        {
            sb.append(tsStr.substring(11, 23));
            int spaces = 11;
            if (record.getLevel() == Level.INFO)
                spaces = 1;
            else if (record.getLevel() == Level.CONFIG)
                spaces = 3;
            else if (record.getLevel() == Level.FINE)
                spaces = 5;
            else if (record.getLevel() == Level.FINER)
                spaces = 7;
            else if (record.getLevel() == Level.FINEST)
                spaces = 9;
            sb.append("                          ".substring(0, spaces));
        }

        /**	Class.method	**/
        if (!m_shortFormat)
            sb.append(getClassMethod(record)).append(": ");

        /**	Message			**/
        sb.append(record.getMessage());
        /** Parameters		**/
        String parameters = getParameters(record);
        if (parameters.length() > 0)
            sb.append(" (").append(parameters).append(")");

        /**	Level			**
         sb.append(" ")
         .append(record.getLevel().getLocalizedName());
         /**	Thread			**/
        if (record.getLongThreadID() != 10)
            sb.append(" [").append(record.getLongThreadID()).append("]");

        //
        sb.append(NL);
        if (record.getThrown() != null)
            sb.append(getExceptionTrace(record)).append(NL);
        return sb.toString();
    }

    /**
     * Return the header string for a set of formatted records.
     * @param   h  The target handler.
     * @return  header string
     */
    public String getHead(Handler h)
    {
        String className = h.getClass().getName();
        int index = className.lastIndexOf('.');
        if (index != -1)
            className = className.substring(index+1);
        StringBuilder sb = new StringBuilder()
                .append("*** ")
                .append(new Timestamp(System.currentTimeMillis()))
                .append(" Application Log (").append(className)
                .append(") ***").append(NL);
        return sb.toString();
    }	//	getHead

    /**
     * Return the tail string for a set of formatted records.
     * @param   h  The target handler.
     * @return  tail string
     */
    public String getTail(Handler h)
    {
        String className = h.getClass().getName();
        int index = className.lastIndexOf('.');
        if (index != -1)
            className = className.substring(index+1);
        StringBuffer sb = new StringBuffer()
                .append(NL)
                .append("*** ")
                .append(new Timestamp(System.currentTimeMillis()))
                .append(" Application Log (").append(className)
                .append(") ***").append(NL);
        return sb.toString();
    }	//	getTail

    /**
     * 	Set Format
     *	@param shortFormat format
     */
    public void setFormat (boolean shortFormat)
    {
        m_shortFormat = shortFormat;
    }	//	setFormat

    /**
     * 	Get Class Method from Log Record
     *	@param record record
     *	@return class.method
     */
    public static String getClassMethod (LogRecord record)
    {
        StringBuilder sb = new StringBuilder();
        String className = record.getLoggerName();
        if (className == null
                || className.indexOf("default") != -1	//	anonymous logger
                || className.indexOf("global") != -1)	//	global logger
            className = record.getSourceClassName();
        if (className != null)
        {
            int index = className.lastIndexOf('.');
            if (index != -1)
                sb.append(className.substring(index+1));
            else
                sb.append(className);
        }
        else
            sb.append(record.getLoggerName());
        if (record.getSourceMethodName() != null)
            sb.append(".").append(record.getSourceMethodName());
        String retValue = sb.toString();
        if (retValue.equals("Trace.printStack"))
            return "";
        return retValue;
    }	//	getClassMethod

    /**
     * 	Get Log Parameters
     *	@param record log record
     *	@return parameters empty string or parameters
     */
    public static String getParameters (LogRecord record)
    {
        StringBuilder sb = new StringBuilder();
        Object[] parameters = record.getParameters();
        if (parameters != null && parameters.length > 0)
        {
            for (int i = 0; i < parameters.length; i++)
            {
                if (i > 0)
                    sb.append(", ");
                sb.append(parameters[i]);
            }
        }
        return sb.toString();
    }	//	getParameters

    /**
     * 	Get Log Exception
     *	@param record log record
     *	@return null if exists or string
     */
    public static String getExceptionTrace (LogRecord record)
    {
        Throwable thrown = record.getThrown();
        if (thrown == null)
            return null;

        StringBuffer sb = new StringBuffer();
        try
        {
            /** Print Stack		**
             StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw);
             thrown.printStackTrace(pw);
             pw.close();
             sb.append(sw.toString());
             /**	Create Stack	**/
            fillExceptionTrace(sb, "", thrown);
        }
        catch (Exception ex)
        {
        }
        return sb.toString();
    }	//	getException

    /**
     * 	Fill Exception Trace
     *	@param sb string buffer
     *	@param hdr header
     *	@param thrown thrown
     */
    private static void fillExceptionTrace (StringBuffer sb, String hdr, Throwable thrown)
    {
        sb.append(hdr)
                .append(thrown.toString());
        if (thrown instanceof SQLException)
        {
            SQLException ex = (SQLException)thrown;
            sb.append("; State=").append(ex.getSQLState())
                    .append("; ErrorCode=").append(ex.getErrorCode());
        }
        sb.append(NL);
        //
        StackTraceElement[] trace = thrown.getStackTrace();
        boolean applicationTrace = false;
        int applicationTraceNo = 0;
        for (int i=0; i < trace.length; i++)
        {
            applicationTrace = trace[i].getClassName().startsWith("org.ceva.") || trace[i].getClassName().startsWith("org.ceva.admiral");
            if (thrown instanceof ServerException    //	RMI
                    || applicationTrace)
            {
                if (applicationTrace)
                    sb.append("\tat ").append(trace[i]).append(NL);
            }
//            else if (!SystemProperties.isFullExceptionTraceInLog() && (i > 20 || (i > 10 && applicationTraceNo > 8)))
//                break;
            else
                sb.append("\tat ").append(trace[i]).append(NL);
            if (applicationTrace)
                applicationTraceNo++;
        }
        //
        Throwable cause = thrown.getCause();
        if (cause != null)
            fillExceptionTrace(sb, "caused by: ", cause);
    }	//	fillExceptionTrace
}
