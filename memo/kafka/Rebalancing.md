# Kafka의 파티션 할당

`파티션`은 데이터를 분산 저장하고 병렬 처리하기 위한 단위

컨슈머가 데이터를 읽을때는 파티션을 기준으로 데이터를 분산하여 읽어온다.  
또한 프로듀서가 데이터를 발행할때도 파티션을 기준으로 데이터를 분산하여 저장한다.  

컨슈머가 컨슈머 그룹에 조인하게 되면 파티션 할당이 시작 된다.  
파티션 할당에는 기본적으로 세 가지의 전략을 제공한다.  

1. RoundRobinAssignor
2. RangeAssignor
3. StickyAssignor

## RoundRobinAssignor

`RoundRobinAssignor`는 컨슈머 그룹에 조인한 컨슈머에게 파티션을 순차적으로 할당한다.

3개의 파티션이 있고 5개의 컨슈머가 조인

- Consumer1: Partition0, Partition3
- Consumer2: Partition1, Partition4
- Consumer3: Partition2

## RangeAssignor

`RangeAssignor`는 파티션의 범위를 기준으로 컨슈머에게 파티션을 할당한다.

3개의 파티션이 있고 6개의 컨슈머가 조인하면

- Consumer1: Partition0 ~ Partition1
- Consumer2: Partition2 ~ Partition3
- Consumer3: Partition4 ~ Partition5

## StickyAssignor

`StickyAssignor`는 가능한 기존 할당을 유지하며 파티션을 재할당한다.
즉, 불필요한 파티션 이동을 줄여 리밸런싱에 따른 성능 저하를 최소화합니다.

파티션이 할당 되면 컨슈머는 해당 파티션을 읽어 메시지를 소비한다.

# Rebalancing

컨슈머 그룹에 새로운 컨슈머가 조인하거나 컨슈머가 나가면 파티션을 재할당하는 과정으로 `Rebalancing`이라고 한다.

카프카의 리밸런싱은 `컨슈머 그룹 코디네이터`와 `그룹 리더`가 관리하며  
그룹 코디네이터는 컨슈머 그룹의 상태를 관리하며 컨슈머들이 그룹에 조인하거나 떠날때 이를 감지하여 리밸런싱을 트리거 한다.  
그룹 리더는 리밸런싱이 시작되면 각 컨슈머의 상태를 수집하고, 각 파티션을 어떤 컨슈머가 담당할지 결정함  

## 리밸런싱은 언제 발생할까?

- 컨슈머 그룹에 새로운 컨슈머가 조인할때
- 컨슈머 그룹에서 컨슈머가 나갈때
- 파티션 수나 토픽이 변경될때
- 브로커가 추가되거나 제거될때

# 리밸런싱 최적화

리밸런싱은 컨슈머 그룹의 상태를 수집하고 파티션을 재할당하는 과정이기 때문에  
리밸런싱이 자주 발생하면 성능에 영향을 줄 수 있다. 

따라서 이러한 문제를 줄이기 위해 

- StickyAssignor
  - 기존 파티션 할당을 유지하려고 하며, 필요할 때만 파티션 할당을 변경 / 불필요한 파티션 이동을 줄여 성능 저하를 최소화
- Incremental Cooperative Rebalancing 
  - 리밸런싱 중에 모든 컨슈머가 동시에 중단되는 대신, 일부 컨슈머가 순차적으로 리밸런싱에 참여 / 전체 컨슈머 그룹이 동시에 중단되는 문제를 완화
- Session Timeout/ Heartbeat
  - 컨슈머가 죽었을때 빠르게 감지하여 리밸런싱을 트리거 / `session.timeout.ms`를 적절히 설정하여 불필요한 리밸런싱을 방지  

를 고려해 볼 수 있다.