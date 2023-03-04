package org.example.db;

import java.util.List;

import org.example.mongoDoc.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
public class Requests{
    @Autowired
    MongoManager mongoManager;

    @RequestMapping("/version")
    public String version(){
        return "<h2>started application</h2>";
    }


    public boolean insertDoc(Profile profile){
        mongoManager.insert(profile);
        return true;
    }
    public List<Profile> getDoc(){
       List<Profile> profileList =  mongoManager.findAll();
       return profileList;
    }

    public boolean deleteDoc(Profile profile){
        mongoManager.delete(profile);
        return true;
    }

    public void deleteAllDoc(){
        mongoManager.deleteAll();
    }

}
