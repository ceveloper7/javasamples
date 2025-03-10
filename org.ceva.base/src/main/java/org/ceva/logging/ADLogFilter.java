package org.ceva.logging;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/*
 * Singleton Class
 */
public class ADLogFilter implements Filter {
    private static ADLogFilter s_filter;

    private ADLogFilter(){}

    // Get Filter
    public static synchronized ADLogFilter get(){
        if(s_filter == null)
            s_filter = new ADLogFilter();
        return s_filter;
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        String loggerName = record.getLoggerName();
        if ("org.eclipse.jetty.annotations.AnnotationParser".equals(loggerName)
                || "org.eclipse.jetty.annotations.ClassInheritanceHandler".equals(loggerName))
            return false;

        if (record.getLevel() == Level.SEVERE
                || record.getLevel() == Level.WARNING)
            return true;
        //
        if (loggerName != null)
        {
            if (loggerName.startsWith("sun.")
                    || loggerName.startsWith("java.awt.")
                    || loggerName.startsWith("javax.")
            )
                return false;
        }
        String className = record.getSourceClassName();
        if (className != null)
        {
            if (className.startsWith("sun.")
                    || className.startsWith("java.awt.")
                    || className.startsWith("javax.")
            )
                return false;
        }
        return true;
    }// isLoggable
}
