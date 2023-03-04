package org.example.json;

// import java.io.IOException;

// import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String jsonToString(Object jsonObject) {
        // ObjectMapper Obj = new ObjectMapper();
        String string = "";
        // try {
        //     string = Obj.writeValueAsString(jsonObject);
        // } catch (IOException exception) {
        //     return null;
        // }
        return string;
    }

    public static Object stringToJson(String string) {
        // ObjectMapper Obj = new ObjectMapper();
        // try {
        //     // Object jsonNode = Obj.readValue(string, Object.class);
        //     Object jsonNode = Obj.readTree(string);
        //     return jsonNode;
        // } catch (IOException exception) {
        //     return null;
        // }
        return null;
    }
}
