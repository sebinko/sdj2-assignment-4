package utility;

import java.util.logging.Level;

public class ConsoleLog {
    public static void log(Level level, String message) {
        System.out.println(level.getName() + ": " + message);
    }
}