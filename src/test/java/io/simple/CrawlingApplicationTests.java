package io.simple;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlingApplicationTests {

    @Autowired
    private RoomRepository roomRepository;



    @Before
    public void setUp() throws Exception {
        roomRepository.deleteAll();
    }



    public boolean isTrue(RoomRepository roomRepository) {

        boolean result = true;

        if (roomRepository.count() == 0) {
            result = false;
            return result;
        }

        List<Room> rooms = roomRepository.findAll();

        for (Room r: rooms) {

            if (r.getLocal2().contains("구로구") || r.getLocal2().contains("마포구") || r.getLocal2().contains("종로구")
                || r.getLocal2().contains("중구") || r.getLocal2().contains("영도구") ){

            } else {
                result = false;
            }
        }
        return result;
    }


    @Test
	public void testCrawling() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();// HttpClient 인스턴스 생성

        String[] location = {"신도림", "마포", "종로"};

        for (String lo: location) {

            HttpGet request = new HttpGet("https://apis.zigbang.com/property/search/rooms/v1?q=" +lo); // request 정보
            request.addHeader("accept", "application/json");	//해더 정보 설정
            HttpResponse response = client.execute(request);	// request 요청
            String contents = IOUtils.toString(response.getEntity().getContent());	//response 정보

            JsonObject jsonObject = new JsonParser().parse(contents).getAsJsonObject();

            JsonArray jarray = jsonObject.getAsJsonArray("buildings");

            // "name", "local1", "local2", "local3", "신주소" 의 정보를 가져와 mongoDB에 저장
            //  mongoDBName: "room", collection = "seoul"
            for (final JsonElement e: jarray) {
                roomRepository.save(
                        new Room(
                            e.getAsJsonObject().get("name").toString()
                            ,e.getAsJsonObject().get("local1").toString()
                            ,e.getAsJsonObject().get("local2").toString()
                            ,e.getAsJsonObject().get("local3").toString()
                            ,e.getAsJsonObject().get("신주소").toString())
                );

            }
        }

        System.out.println("roomRepository.count() :" +roomRepository.count());
        assertTrue(isTrue(roomRepository));
	}


    @Test
    public void testInputData() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();// HttpClient 인스턴스 생성

        String[] location = {"a", "b", "c"};

        for (Object lo: location) {

            HttpGet request = new HttpGet("https://apis.zigbang.com/property/search/rooms/v1?q=" +lo); // request 정보
            request.addHeader("accept", "application/json");	//해더 정보 설정
            HttpResponse response = client.execute(request);	// request 요청
            String contents = IOUtils.toString(response.getEntity().getContent());	//response 정보

            JsonObject jsonObject = new JsonParser().parse(contents).getAsJsonObject();

            JsonArray jarray = jsonObject.getAsJsonArray("buildings");

            // "name", "local1", "local2", "local3", "신주소" 의 정보를 가져와 mongoDB에 저장
            //  mongoDBName: "room", collection = "seoul"
            for (final JsonElement e: jarray) {
                roomRepository.save(
                        new Room(
                                e.getAsJsonObject().get("name").toString()
                                ,e.getAsJsonObject().get("local1").toString()
                                ,e.getAsJsonObject().get("local2").toString()
                                ,e.getAsJsonObject().get("local3").toString()
                                ,e.getAsJsonObject().get("신주소").toString())
                );

            }
        }

        assertFalse(isTrue(roomRepository));

    }


    @Test
    public void testType() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();// HttpClient 인스턴스 생성

        int[] location = {1, 2, 3};

        for (int lo: location) {

            HttpGet request = new HttpGet("https://apis.zigbang.com/property/search/rooms/v1?q=" +lo); // request 정보
            request.addHeader("accept", "application/json");	//해더 정보 설정
            HttpResponse response = client.execute(request);	// request 요청
            String contents = IOUtils.toString(response.getEntity().getContent());	//response 정보

            JsonObject jsonObject = new JsonParser().parse(contents).getAsJsonObject();

            JsonArray jarray = jsonObject.getAsJsonArray("buildings");

            // "name", "local1", "local2", "local3", "신주소" 의 정보를 가져와 mongoDB에 저장
            //  mongoDBName: "room", collection = "seoul"
            for (final JsonElement e: jarray) {
                roomRepository.save(
                        new Room(
                                e.getAsJsonObject().get("name").toString()
                                ,e.getAsJsonObject().get("local1").toString()
                                ,e.getAsJsonObject().get("local2").toString()
                                ,e.getAsJsonObject().get("local3").toString()
                                ,e.getAsJsonObject().get("신주소").toString())
                );

            }
        }
        assertFalse(isTrue(roomRepository));
    }
}
