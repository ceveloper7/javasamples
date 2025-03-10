package org.ceva.logging;

import org.ceva.util.Ini;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ADLogFile extends Handler {

    private String m_systemHome = null;
    /**	Printed header			*/
    private boolean 	m_doneHeader = false;
    /**	Output file				*/
    private File m_file = null;
    /**	File writer				*/
    private FileWriter m_writer = null;
    /** Current File Name Date	*/
    private String		m_fileNameDate = "";
    /** Record Counter			*/
    private int			m_records = 0;
    private File m_previousFile;

    public ADLogFile(String systemHome, boolean createLogDir, boolean isClient){
        if (systemHome != null && systemHome.length() > 0)
            m_systemHome = systemHome;
        else
            m_systemHome = Ini.findSystemHome();
        initialize(m_systemHome, createLogDir, isClient);
    }

    private void initialize(String systemHome, boolean createLogDir, boolean isClient)
    {
        //	Close Old File
        if (m_writer != null)
            close();
        m_doneHeader = false;
        //	New File Name
        if (!createFile(systemHome, createLogDir, isClient))
            return;
        //	New Writer
        try
        {
            m_writer = new FileWriter (m_file, true);
            m_records = 0;
        }
        catch (Exception ex)
        {
            reportError ("writer", ex, ErrorManager.OPEN_FAILURE);
            m_writer = null;
        }

        //	Formatting
        setFormatter(ADLogFormatter.get());
        //	Level
        setLevel(Level.ALL);
        //	Filter
        setFilter(ADLogFilter.get());
    }	//	initialize

    /**
     * 	Create Log File
     * 	@param baseDirName base log file directory name
     * 	@param createLogDir create log directory
     * 	@param isClient client
     * 	@return true if created
     */
    private boolean createFile(String baseDirName, boolean createLogDir, boolean isClient)
    {
        String fileName = baseDirName;
        try
        {
            //	Test idempiereHome
            if (fileName != null)
            {
                File dir = new File(fileName);
                if (!dir.exists() || !dir.isDirectory())
                {
                    reportError ("Invalid base directory: " + fileName, null, ErrorManager.OPEN_FAILURE);
                    fileName = null;
                }
            }
            //	Test/Create idempiereHome/log
            if (fileName != null && createLogDir)
            {
                fileName += File.separator + "log";
                File dir = new File(fileName);
                if (!dir.exists())
                    dir.mkdir();
                if (!dir.exists() || !dir.isDirectory())
                {
                    reportError ("Invalid log directory: " + fileName, null, ErrorManager.OPEN_FAILURE);
                    fileName = null;
                }
            }
            //	Test/Create idempiereHome/log/file
            if (fileName != null)
            {
                String dateFileName = fileName + File.separator;
                if (isClient)
                    dateFileName += "client.";
                else
                    dateFileName += "idempiere.";
                m_fileNameDate = getFileNameDate(System.currentTimeMillis());
                dateFileName	+= m_fileNameDate + "_";
                for (int i = 0; i < 100; i++) // max 100 files with date
                {
                    String finalName = dateFileName + i + ".log";
                    File file = new File(finalName);
                    if (!file.exists())
                    {
                        m_file = file;
                        break;
                    }
                }
            }
            if (m_file == null)	{	//	Fallback to date+time filename
                String timeFileName = fileName + File.separator;
                if (isClient)
                    timeFileName += "client.";
                else
                    timeFileName += "system.";
                String fileNameTime = getFileNameDateTime(System.currentTimeMillis());
                String finalName = timeFileName + fileNameTime + ".log";
                File file = new File(finalName);
                if (!file.exists())
                {
                    m_file = file;
                }
            }
            if (m_file == null)	{	//	Fallback create temp file
                // would be very weird to arrive here, but preserving anyways as an extra fallback measure
                m_fileNameDate = getFileNameDate(System.currentTimeMillis());
                m_file = File.createTempFile("system"+m_fileNameDate + "_", ".log");
            }
        }
        catch (Exception ex)
        {
            reportError ("file", ex, ErrorManager.OPEN_FAILURE);
            m_file = null;
            return false;
        }
        return true;
    }	//	createFile

    /**
     * 	Get File Name Date portion
     * 	@param time time in ms
     *	@return Date String
     */
    public static String getFileNameDate (long time)
    {
        Timestamp ts = new Timestamp(time);
        String s = ts.toString();
        return s.substring(0, 10);
    }	//	getFileNameDate

    /**
     * 	Get File Name DateTime portion
     * 	@param time time in ms
     *	@return DateTime String on Seconds
     */
    public static String getFileNameDateTime (long time)
    {
        Timestamp ts = new Timestamp(time);
        String s = ts.toString();
        s = s.replaceAll("[ :]", "-");
        return s.substring(0, 19); // seconds
    }	//	getFileNameDate

    /**
     * 	Rotate Log when day changes
     *	@param time time
     */
    private void rotateLog (long time)
    {
        if (m_fileNameDate == null
                || m_fileNameDate.equals(getFileNameDate(time)))
            return;
        rotateLog();
    }	//	rotateLog

    /**
     * 	Rotate Log
     * 	Called after Initialization
     */
    public void rotateLog ()
    {
        initialize(m_systemHome, true, Ini.isClient());
    }	//	rotateLog

    /**
     * Re-use previous log file (if available).
     */
    public void reopen()
    {
        if (m_previousFile != null && m_previousFile.exists() && m_file == null && m_writer == null)
        {
            try
            {
                m_file = m_previousFile;
                m_writer = new FileWriter (m_file, true);
                m_records = 0;
            }
            catch (Exception ex)
            {
                reportError ("writer", ex, ErrorManager.OPEN_FAILURE);
                m_writer = null;
                m_file = null;
            }
        }
    }

    /**
     * 	Get File Name
     *	@return file name
     */
    public String getFileName()
    {
        if (m_file != null)
            return m_file.getAbsolutePath();
        return "";
    }	//	getFileName

    /**
     * 	Get Log Directory
     *	@return log directory or null
     */
    public File getLogDirectory()
    {
        if (m_file != null)
            return m_file.getParentFile();
        return null;
    }	//	getLogDirectory


    /**
     * 	Set Level
     *	@see java.util.logging.Handler#setLevel(java.util.logging.Level)
     *	@param newLevel new Level
     *	@throws java.lang.SecurityException
     */
    @Override
    public synchronized void setLevel (Level newLevel)
            throws SecurityException
    {
        if (newLevel == null)
            return;
        super.setLevel (newLevel);
    }	//	setLevel

    @Override
    public void publish(LogRecord record) {
        if (!isLoggable (record) || m_writer == null)
            return;

        rotateLog(record.getMillis());

        //	Format
        String msg = null;
        try
        {
            msg = getFormatter().format (record);
        }
        catch (Exception ex)
        {
            reportError ("formatting", ex, ErrorManager.FORMAT_FAILURE);
            return;
        }
        //	Output
        try
        {
            if (!m_doneHeader)
            {
                m_writer.write (getFormatter().getHead (this));
                m_doneHeader = true;
            }
            //
            m_writer.write (msg);
            m_records++;
            //
            if (record.getLevel() == Level.SEVERE
                    || record.getLevel() == Level.WARNING
                    || record.getLevel() == Level.OFF
                    ||	m_records % 10 == 0)	//	flush every 10 records
                flush();
        }
        catch (Exception ex)
        {
            reportError ("writing", ex, ErrorManager.WRITE_FAILURE);
        }
    }

    @Override
    public void flush() {
        try
        {
            if (m_writer != null)
                m_writer.flush();
        }
        catch (Exception ex)
        {
            reportError ("flush", ex, ErrorManager.FLUSH_FAILURE);
        }
    }

    @Override
    public synchronized void close() throws SecurityException {
        if (m_writer == null)
            return;

        //	Write Tail
        try
        {
            if (!m_doneHeader)
                m_writer.write (getFormatter().getHead(this));
            //
            m_writer.write (getFormatter().getTail(this));
        }
        catch (Exception ex)
        {
            reportError ("tail", ex, ErrorManager.WRITE_FAILURE);
        }
        //
        flush();
        //	Close
        try
        {
            m_writer.close();
        }
        catch (Exception ex)
        {
            reportError ("close", ex, ErrorManager.CLOSE_FAILURE);
        }
        m_writer = null;
        m_previousFile = m_file;
        m_file = null;
    }

    /**
     * 	String Representation
     *	@return info
     */
    public String toString ()
    {
        StringBuilder sb = new StringBuilder ("ADLogFile[");
        sb.append(getFileName()).append(",Level=").append(getLevel())
                .append ("]");
        return sb.toString ();
    }	//	toString

    /**
     * Get or create CLogFile handler.
     * @param create
     * @param systemHome
     * @param isClient
     * @return CLogFile handler
     */
    public static ADLogFile get(boolean create, String systemHome, boolean isClient) {
        Handler[] handlers = ADLogMgt.getHandlers();
        for (Handler handler : handlers)
        {
            if (handler instanceof ADLogFile)
                return (ADLogFile) handler;
        }
        if (create)
        {
            ADLogFile handler = new ADLogFile(systemHome, true, isClient);
            ADLogMgt.addHandler(handler);
            return handler;
        }
        return null;
    }
}
