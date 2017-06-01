package io.simple;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lee on 2017. 5. 30..
 */
public interface RoomRepository extends MongoRepository<Room, String> {

}
