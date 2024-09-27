# IoC 컨테이너

스프링에서의 IoC 컨테이너란 빈 설정 메타정보를 읽어들여 빈 객체를 생성하고, 빈 객체 간의 의존관계를 관리하는 컨테이너를 말한다. (= 스프링 컨테이너)

## 빈(Bean)

스프링에서 IoC 컨테이너가 관리하는 객체를 빈(Bean)이라고 한다.   
빈은 `ApplicationContext` 인터페이스의 `getBean()` 메서드를 이용해 얻을 수 있다.

```java
@Configuration
class MyConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}

public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    MyBean myBean = context.getBean(MyBean.class);
}
```

빈으로 등록되는 객체는 기본적으로 싱글톤(Singleton) 스코프로 생성된다.
다른 빈들을 주입받아 사용할 수 있으며, 이를 의존성 주입(Dependency Injection)이라고 한다.

## 빈 스코프(Bean Scope)

스프링에서 빈은 기본적으로 싱글톤(Singleton) 스코프로 생성된다.

- **Singleton**: 하나의 IoC 컨테이너에 하나의 빈 객체만 생성된다.
- **Prototype**: IoC 컨테이너에 요청할 때마다 새로운 빈 객체를 생성한다.
- **Request**: HTTP 요청마다 새로운 빈 객체를 생성한다.
- **Session**: HTTP 세션마다 새로운 빈 객체를 생성한다.
- **Application**: ServletContext 수명 주기에 따라 새로운 빈 객체를 생성한다.
- **WebSocket**: WebSocket 수명 주기에 따라 새로운 빈 객체를 생성한다.

## 빈 생명주기(Bean Lifecycle)

스프링에서 빈은 생성, 초기화, 소멸의 생명주기를 가진다.   
IoC 컨테이너 생성 => 빈 생성 => 의존 관계 주입(DI) => 초기화 콜백 => 사용 => 소멸 전 콜백 => 소멸

- **생성**: 빈 객체가 생성되고, 의존성 주입이 이루어진다.
- **초기화**: 빈 객체가 초기화되는 단계로, `@PostConstruct` 어노테이션을 사용해 초기화 메서드를 지정할 수 있다.
- **소멸**: 빈 객체가 소멸되는 단계로, `@PreDestroy` 어노테이션을 사용해 소멸 메서드를 지정할 수 있다.

```java
@Component
public class MyBean {
    @PostConstruct
    public void init() {
        // 초기화 작업
    }

    @PreDestroy
    public void destroy() {
        // 소멸 작업
    }
}
```

## BeanFactory와 ApplicationContext

스프링에서 IoC 컨테이너는 `BeanFactory`와 `ApplicationContext` 인터페이스를 제공한다.

- **BeanFactory**: IoC 컨테이너의 최상위 인터페이스로, 빈을 등록, 조회, 관리하는 기본적인 기능을 제공한다.
- **ApplicationContext**: `BeanFactory`의 기능을 확장한 인터페이스로, 메시지, 이벤트, 리소스 로딩 등의 기능을 제공한다.
