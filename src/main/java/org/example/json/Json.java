package org.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String jsonToString(Object jsonObject) {
        ObjectMapper Obj = new ObjectMapper();
        String string = "";
        try {
            string = Obj.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static <T> T stringToJson(String string, Class<T> class1) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(string, class1);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T objectToClass(Object object, Class<T> class1) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(object, class1);
    }

    // public static <T> List<T> objectToClass(Class<T> class1, Object object) {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     return objectMapper.convertValue(object, List.class);
    //     // return ((class1)string);
    // }
}
