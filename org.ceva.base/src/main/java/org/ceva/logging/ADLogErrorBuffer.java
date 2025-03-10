package org.ceva.logging;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ADLogErrorBuffer extends Handler {

    private static final String ISSUE_ERROR_KEY = "org.ceva.util.ADLogErrorBuffer.issueError";
    private static final String HISTORY_KEY = "org.ceva.util.ADLogErrorBuffer.history";
    private static final String ERRORS_KEY = "org.ceva.util.ADLogErrorBuffer.errors";
    private static final String LOGS_KEY = "org.ceva.util.ADLogErrorBuffer.logs";

    /** Error Buffer Size			*/
    private static final int		ERROR_SIZE = 20;

    /** Log Size					*/
    private static final int		LOG_SIZE = 100;

    /**************************************************************************
     * 	Constructor
     */
    public ADLogErrorBuffer ()
    {
        initialize();
    }	//	CLogErrorBuffer

    /**
     * 	Initialize
     */
    private void initialize()
    {
        //	Formatting
        setFormatter(ADLogFormatter.get());
        //	Default Level
        super.setLevel(Level.INFO);
        //	Filter
        setFilter(ADLogFilter.get());
    }	//	initialize

    @Override
    public void publish(LogRecord record) {

    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
