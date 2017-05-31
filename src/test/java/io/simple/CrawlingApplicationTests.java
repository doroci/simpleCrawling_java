package io.simple;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlingApplicationTests {

    private static final Log log = LogFactory.getLog(CrawlingApplicationTests.class);

    @Autowired
    private RoomRepository roomRepository;


    @Before
    public void setUp() throws Exception {
        roomRepository.deleteAll();
    }

    @Test
	public void testCrawling() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();// HttpClient 인스턴스 생성

        String[] location = {"신도림", "마포", "종로"};
//        Set roomIdDataSet = new HashSet<String>();

        for (String lo: location) {

            HttpGet request = new HttpGet("https://apis.zigbang.com/property/search/rooms/v1?q=" +lo); // request 정보
            request.addHeader("accept", "application/json");	//해더 정보 설정
            HttpResponse response = client.execute(request);	// request 요청
            String contents = IOUtils.toString(response.getEntity().getContent());	//response 정보

            JsonObject jsonObject = new JsonParser().parse(contents).getAsJsonObject();

            JsonArray jarray = jsonObject.getAsJsonArray("buildings");

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


//        roomRepository.findByLocal3("합정동").forEach(System.out::println);

//        roomRepository.findByLocal3("낙동원동").forEach(System.out::println);




	}





}
