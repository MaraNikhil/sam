package org.example.contollers;

import java.util.List;

import org.example.db.MongoManager;
import org.example.mongoDoc.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Requests{
    @Autowired
    MongoManager mongoManager;
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

}
