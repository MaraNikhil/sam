package org.example.services;

import org.example.logger.LoggerClass;
import org.springframework.web.client.RestTemplate;

public class WsCall {
    public static String makeWsCall(String URL, Object payload) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(URL, String.class);
        LoggerClass.info(WsCall.class, result);
        return result;
    }
}
