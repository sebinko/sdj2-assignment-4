package utility;

import java.util.logging.Level;

public class LogFacade {
    private static final Log log = Log.getInstance();

    public static void info(String message) {
        log.log(Level.INFO, message);
        ConsoleLog.log(Level.INFO, message);
    }

    public static void warning(String message) {
        log.log(Level.WARNING, message);
        ConsoleLog.log(Level.WARNING, message);
    }

    public static void severe(String message) {
        log.log(Level.SEVERE, message);
        ConsoleLog.log(Level.SEVERE, message);
    }
}
