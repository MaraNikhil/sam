package org.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// import java.io.IOException;

// import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String jsonToString(Object jsonObject) {
        ObjectMapper Obj = new ObjectMapper();
        String string = "";
        try {
            string = Obj.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return string;
    }

    public static <T> T stringToJson(String string, Class<T> class1) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(string, class1);
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
