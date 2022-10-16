package org.example.mongoDoc;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Profile {
    @Id
    private String id;
    private String name;
    private Object address;
    private int seqNo;
    private boolean isvalid;

    Profile(){

    }
}
