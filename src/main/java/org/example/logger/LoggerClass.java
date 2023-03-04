package org.example.logger;

// import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggerClass {

    public static void info(Class<?> class1, Object... argObjects) {
        final Logger logger = LoggerFactory.getLogger(class1);
        // ObjectMapper Obj = new ObjectMapper();
        String logString = "";
        for (Object object : argObjects) {
            // try {
            // // String jsonStr = Obj.writeValueAsString(object);
            // String jsonStr = object.toString();
            // logString = logString.concat(jsonStr);
            // System.out.println(jsonStr);
            // } catch (IOException exception) {
            // // if (logger.isErrorEnabled()) {
            // // logger.error(logString, exception);
            // // }
            // System.out.println("error: "+exception.toString());
            // }
            if(logger.isInfoEnabled()){
                String jsonStr = object.toString();
                logString = logString.concat(jsonStr);
                // System.out.println(jsonStr);
                logger.info(logString);
            }
        }
        // if (logger.isInfoEnabled()) {
        // logger.info(logString);
        // }
    }
}
