## 직방 사이트 방정보 크롤링하기

## 카테고리 선정
```
https://www.zigbang.com/search/officetel
직방 사이트에서 "원룸*투룸 오피스/도시형생활주택" 카테고리를 선택.
```

## 검색(지역명) URI 추출
검색(지역명)에 따른 서버 쪽에 요청하는 http Get Method 정보를 추출한다.

`https://apis.zigbang.com/property/search/rooms/v1?q="검색어(지역명)"`

![검색어 URI 추출](/img/getRoomIds.jpg)


## spring-data-mongodb
json Data를 적재하기 위해 mongodb를 사용
- [spring-data-mongodb](http://projects.spring.io/spring-data-mongodb)
- [accessing-data-mongodb](https://spring.io/guides/gs/accessing-data-mongodb)

## mongoDB 설치
- [mongoDB install](https://docs.mongodb.com/manual/administration/install-community)

## mongodb Client
- [robomongo](https://robomongo.org)
- [인텔리J 플러그인](https://plugins.jetbrains.com/plugin/7141-mongo-plugin)
  

## run CrawlingApplicationTests
```
/src/test/java/io/simple/CrawlingApplicationTests
```


