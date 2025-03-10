package org.ceva.logging;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/*
 * Handler that publish log record to the system standard output stream
 */
public class ADLogConsole extends Handler{

    /**	Printed header			*/
    private boolean 	m_doneHeader = false;
    /** Normal Writer			*/
    private PrintWriter	m_writerOut = null;
    /** Error Writer			*/
    private PrintWriter	m_writerErr = null;

    /**
     *	Constructor
     */
    public ADLogConsole ()
    {
        initialize();
    }	// CLogConsol

    /**
     * 	Initialize
     */
    private void initialize()
    {
        //	System.out.println("CLogConsole.initialize");
        //	Set Writers
        String encoding = getEncoding();
        if (encoding != null)
        {
            try
            {
                m_writerOut = new PrintWriter(new OutputStreamWriter(System.out, encoding));
                m_writerErr = new PrintWriter(new OutputStreamWriter(System.err, encoding));
            }
            catch (UnsupportedEncodingException ex)
            {
                reportError ("Opening encoded Writers", ex, ErrorManager.OPEN_FAILURE);
            }
        }
        if (m_writerOut == null)
            m_writerOut = new PrintWriter(System.out);
        if (m_writerErr == null)
            m_writerErr = new PrintWriter(System.err);

        //	Formatting
        setFormatter(ADLogFormatter.get());
        //	Default Level
        setLevel(Level.INFO);
        //	Filter
        setFilter(ADLogFilter.get());
        //
    }	//	initialize

    /**
     * 	Set Encoding
     *	@param encoding encoding
     *	@throws SecurityException
     *	@throws java.io.UnsupportedEncodingException
     */
    public void setEncoding (String encoding)
            throws SecurityException, java.io.UnsupportedEncodingException
    {
        super.setEncoding (encoding);
        // Replace the current writer with a writer for the new encoding.
        flush ();
        initialize();
    }	//	setEncoding

    /**
     * 	Set Level
     *	@see java.util.logging.Handler#setLevel(java.util.logging.Level)
     *	@param newLevel new Level
     *	@throws java.lang.SecurityException
     */
    public synchronized void setLevel (Level newLevel)
            throws SecurityException
    {
        if (newLevel == null)
            return;
        super.setLevel (newLevel);
        boolean enableJDBC = newLevel == Level.FINEST;
        if (enableJDBC)
            DriverManager.setLogWriter(m_writerOut);	//	lists Statements
        else
            DriverManager.setLogWriter(null);
    }	//	setLevel


    @Override
    public void publish(LogRecord record) {
        if (!isLoggable (record) || m_writerOut == null)
            return;

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
                m_writerOut.write (getFormatter().getHead (this));
                m_doneHeader = true;
            }
            if (record.getLevel() == Level.SEVERE
                    || record.getLevel() == Level.WARNING)
            {
                flush();
                m_writerErr.write (msg);
                flush();
            }
            else
            {
                m_writerOut.write (msg);
                m_writerOut.flush();
            }
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
            if (m_writerOut != null)
                m_writerOut.flush();
        }
        catch (Exception ex)
        {
            reportError ("flush out", ex, ErrorManager.FLUSH_FAILURE);
        }
        try
        {
            if (m_writerErr != null)
                m_writerErr.flush();
        }
        catch (Exception ex)
        {
            reportError ("flush err", ex, ErrorManager.FLUSH_FAILURE);
        }
    }

    @Override
    public void close() throws SecurityException {
        if (m_writerOut == null)
            return;

        //	Write Tail
        try
        {
            if (!m_doneHeader)
                m_writerOut.write (getFormatter().getHead(this));
            //
            m_writerOut.write (getFormatter().getTail(this));
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
            m_writerOut.close();
        }
        catch (Exception ex)
        {
            reportError ("close out", ex, ErrorManager.CLOSE_FAILURE);
        }
        m_writerOut = null;
        try
        {
            m_writerErr.close();
        }
        catch (Exception ex)
        {
            reportError ("close err", ex, ErrorManager.CLOSE_FAILURE);
        }
        m_writerErr = null;
    }

    public String toString ()
    {
        StringBuilder sb = new StringBuilder ("CLogConsole[");
        sb.append("Level=").append(getLevel())
                .append ("]");
        return sb.toString ();
    } //	toString
}
