package org.example;

import java.util.HashMap;
import java.util.List;

import org.example.contollers.Requests;
import org.example.mongoDoc.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String version(){
        return "<h2>started application</h2>";
    }

    @RequestMapping("/post")
    public Object post(@RequestBody Profile profile){
       boolean status = requests.insertDoc(profile);
       HashMap<String, Object> response = new HashMap<>();
       if(status)
       response.put("status", 200);
       return  response;
    }

    @GetMapping("/all")
    public List<Profile> getall(){
       return requests.getDoc();
    }
}

