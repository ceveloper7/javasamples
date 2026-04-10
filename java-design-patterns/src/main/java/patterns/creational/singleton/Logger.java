package patterns.creational.singleton;

import patterns.creational.singleton.enums.LogLevel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Logger {
    // almacenamos writers para archivos individuales log
    private Map<String, FileWriter> writers;

    private static Logger instace;

    private Logger(){}

    public static Logger getInstance(){
        if (instace == null)
            return new Logger();

        return instace;
    }

    public void log(LogLevel logLevel, String logFile, String message) throws IOException {
        writers.get(logFile).append(logLevel.getLogAcronym()).append(message).append(System.lineSeparator());
        writers.get(logFile).flush();
    }

    public void log(String logFile, String message) throws IOException{
        log(LogLevel.INFO, logFile, message);
    }
}
