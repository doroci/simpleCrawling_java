package io.simple;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * Created by lee on 2017. 5. 30..
 */

@Document(collection = "seoul")
public class Room {

    @Id
    private String id;

    private String name;
    private String local1;
    private String local2;
    private String local3;
    private String address;

    public Room() {}

    public Room(String name, String local1, String local2, String local3, String address) {
        this.name = name;
        this.local1 = local1;
        this.local2 = local2;
        this.local3 = local3;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocal1() {
        return local1;
    }

    public String getLocal2() {
        return local2;
    }

    public String getLocal3() {
        return local3;
    }

    public String getAddress() {
        return address;
    }

//    @Override
//    public String toString() {
//        return String.format(
//                "%s, [지번주소: %s %s %s], [도로명 주소: %s]",
//                name, local1, local2, local3, address);
//    }

}
