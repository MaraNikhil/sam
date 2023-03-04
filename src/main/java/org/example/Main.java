package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.example.contollers.Requests;
import org.example.json.Json;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.example.logger.LoggerClass;

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
    @ResponseBody
    public Object post(@RequestBody Profile profile, HttpServletResponse response) {
        LoggerClass.info(Main.class, "in post with", profile);
        boolean status = requests.insertDoc(profile);
        Cookie cookie = new Cookie("platform", "mobile");
        cookie.setPath("/");
        if (status)
            response.addCookie(cookie);
        response.setStatus(200);
        return Json.jsonToString(profile);
        // return profile.toString();
        // catch(IOException exception){
        // exception.printStackTrace();
        // return exception.toString();
        // }
    }

    @GetMapping("/all")
    public List<Profile> getall() {
        return requests.getDoc();
    }
}
