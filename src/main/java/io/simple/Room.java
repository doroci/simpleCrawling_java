package io.simple.simple;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by lee on 2017. 5. 30..
 */

@Document(collection = "room")
public class Room {

    @Id
    private String id;

    private String name;
    private String address;

    public Room(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }



}
