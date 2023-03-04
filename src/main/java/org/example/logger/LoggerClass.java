package org.example.logger;

import org.example.json.Json;

// import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerClass {

    public static void info(Class<?> class1, Object... argObjects) {
        final Logger logger = LoggerFactory.getLogger(class1);
        String logString = "";
        for (Object object : argObjects) {
            String jsonStr = Json.jsonToString(object);
            if(logger.isInfoEnabled()){
                logString = logString.concat(jsonStr);
                logger.info(logString);
            }
        }
        // if (logger.isInfoEnabled()) {
        // logger.info(logString);
        // }
    }
}
