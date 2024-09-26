# Rack

`Rack`이란 주로 데이터 센터에서 여러대의 서버를 효율적으로 설치하고 관리하기 위해 사용되는 물리 장비   

하나의 `Rack`은 여러대의 서버를 수용할 수 있으며, 이러한 `Rack`을 이용하여 서버들을 물리적으로 분리하여 관리할 수 있다.

# Rack Awareness 란?

하나의 렉에 문제가 생기면 해당 렉에 속한 서버들이 모두 다운될 수 있기 때문에,  
여러 렉에 서버를 분산 배치하여 렉 단위로 장애를 격리할 수 있다.
또한 단순 분산 배치 뿐만 아니라, 렉 단위로 데이터를 복제하여 장애가 발생해도 데이터를 안전하게 보관할 수 있다.

이는 HDFS, Apache Cassandra, Apache Kafka 등 여러 시스템에서 사용되는 내결함성을 높이는 방법이다.

정리하자면 아래와 같은 이점을 가진다. 

- 고가용성(High Availability)  
- 내결함성(Fault Tolerance)  
- 네트워크 효율성  
- 재해 복구(Disaster Recovery)

# Kafka의 Rack Awareness

Kafka는 데이터의 파티션을 서로 다른 랙에 복제하여,  
특정 랙의 장애가 발생해도 다른 랙에서 데이터를 읽어올 수 있도록 설정할 수 있다.

즉, `Rack Awareness`는 렉 단위로 장애를 격리하여 시스템의 가용성을 높이는 방법이다.  
물리적으로 분리된 렉에 서버를 배치하여 장애가 발생해도 시스템이 정상적으로 동작할 수 있도록 한다. 

# Rack Awareness 설정

```
broker.rack=<rack ID as string>

ex)
broker.rack=dc1
broker.rack=us-east-1c
```

# 참고

[KIP: Rack aware replica assignment](https://cwiki.apache.org/confluence/display/KAFKA/KIP-36+Rack+aware+replica+assignment)