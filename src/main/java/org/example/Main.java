package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import javax.xml.ws.Response;

import org.example.contollers.Requests;
import org.example.mongoDoc.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableMongoRepositories
public class Main {

    @Autowired
    Requests requests;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String version() {
        try {

            String fileName = System.getProperty("user.dir") + "/src/main/java/org/example/index.html";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String html = "";
            String line;
            while ((line = br.readLine()) != null) {
                html += line;
            }
            br.close();
            return html;
        } catch (Exception e) {
            return "<h2>started application</h2> <p>error in pasing html file</p>";
        }
    }

    @RequestMapping(value = "/post", produces = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public Object post(@RequestBody Profile profile) {
        System.out.println("in post with" + profile.toString());
        boolean status = requests.insertDoc(profile);
        // Response response = new Response<T>() {
            
        // };
        HashMap<String, Object> response = new HashMap<>();
        if (status)
            response.put("status", 200);
        return response;
    }

    @GetMapping("/all")
    public List<Profile> getall() {
        return requests.getDoc();
    }
}
