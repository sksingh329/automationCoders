package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {
    public static Logger log;
    public static Logger getLogger(String className){
        String fileName = "src/test/resources/log4j.xml";
        System.setProperty("log4j.configurationFile",fileName);
        log = LogManager.getLogger(className);
        return log;
    }
}
