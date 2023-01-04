# playGround
이것저것 실험실입니다.

```
├── src.main.java.com.quid
│   │
│   ├── Design Pattern
│   │   └── 준비중
│   │
│   ├── DockerCompose
│   │   └── compose 간단 설정 정리 / mySQL, kafka, redis
│   │
│   ├── ELK
│   │   └── 준비중
│   │
│   ├── Feign Client
│   │   ├── 기본 설정 및 사용
│   │   ├── interceptor
│   │   ├── Logger
│   │   └── Error Decoder
│   │
│   ├── Java
│   │   ├── Lambda
│   │   ├── RxJava
│   │   └── Thread
│   │
│   ├── JTW 
│   │   └── header, payload, signature 구조로 된 간단한 JWT Kotlin으로 직접 구현
│   │
│   ├── Kotlin
│   │   └── kotlin을 배우며 정리
│   │
│   ├── MongoDB
│   │   └── MongoDB 실습 쿼리 정리
│   │
│   │
│   ├── openAi
│   │   └── openAi를 이용한 간단한 텍스트 IO 컨트롤러
│   │
│   └── Spring
│       ├── config
│       │   └── Spring Boot의 다양한 설정들 정리
│       │
│       ├── diary
│       │   └── mySQL 인덱싱, 벌크인서트 등을 테스트해보기 위한 간단한 다이어리 서비스
│       │
│       └── FanOutTimeline #1
│           └── 팔로우한 사람의 글을 빠르게 가져오기 위한 Fan Out On Write 서비스
│               카프카를 사용한 비동기 처리
│
└─── Readme.md
``` 

### #1 FanOutTimeline

[readme](src/main/java/com/quid/spring/FanOutTimeline/readme.md)