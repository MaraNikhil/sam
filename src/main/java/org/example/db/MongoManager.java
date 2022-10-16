package org.example.db;

import org.example.mongoDoc.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoManager extends MongoRepository<Profile, String> {
//    List<Profile> findByTitleContaining(String Name);
}
