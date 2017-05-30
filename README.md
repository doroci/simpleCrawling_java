## 직방 사이트 방정보 크롤링하기

## 카테고리 선정
```
https://www.zigbang.com/search/officetel
직방 사이트에서 "원룸*투룸 오피스/도시형생활주택" 카테고리를 선택.
```

## 검색(지역명) URI 추출
검색(지역명)에 따른 서버 쪽에 요청하는 http Get Method 정보를 추출한다.

[검색어 URI 추출]("/img/getRoomIds.jpg")

`https://apis.zigbang.com/property/search/rooms/v1?q="검색어(지역명)"`
