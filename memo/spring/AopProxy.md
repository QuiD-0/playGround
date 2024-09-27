# AOP Proxy

AOP 프록시는 AOP 프레임워크가 제공하는 핵심 기능 중 하나로,  
AOP 프레임워크가 타겟 객체를 감싸서 타겟 객체의 메서드 호출을 가로채는 역할을 한다.  

Spring Context 로 관리되는 Bean 들은 Proxy 객체로 감싸져서 사용된다.  
이때 모든 Bean 들이 프록시로 감싸지는 것은 아니고,  
특정 조건을 만족하는 Bean 들만 프록시로 감싸진다.

```java
AbstractAutoProxyCreator.java

Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);
if (specificInterceptors != DO_NOT_PROXY) {
    this.advisedBeans.put(cacheKey, Boolean.TRUE);
    Object proxy = createProxy(bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(bean));
    this.proxyTypes.put(cacheKey, proxy.getClass());
    return proxy;
}
```

즉 getAdvicesAndAdvisorsForBean 메서드를 통해 advice 와 advisor 들을 사용하는 Bean 들만 프록시로 감싸진다.

이때 Spring AOP 는 JDK Dynamic Proxy 와 CGLIB Proxy 두 가지 방식을 지원하는데  
아래와 같은 조건을 통해 어떤 방식으로 프록시 객체를 생성할지 결정한다.

```java
DefaultAopProxyFactory.java

@Override
public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
    if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
        Class<?> targetClass = config.getTargetClass();
        if (targetClass == null) {
            throw new AopConfigException("TargetSource cannot determine target class: " +
                    "Either an interface or a target is required for proxy creation.");
        }
        if (targetClass.isInterface() || Proxy.isProxyClass(targetClass) || ClassUtils.isLambdaClass(targetClass)) {
            return new JdkDynamicAopProxy(config);
        }
        return new ObjenesisCglibAopProxy(config);
    }
    else {
        return new JdkDynamicAopProxy(config);
    }
}
```

Target Class 가 interface, Proxy Class, Lambda Class 인 경우 JDK Dynamic Proxy 를 사용하고,
그 외의 경우 CGLIB Proxy 를 사용한다.

## JDK Dynamic Proxy

자바 표준 라이브러리를 사용하여 동적으로 프록시를 생성.  
프록시할 인터페이스가 필요함. 즉, 인터페이스를 상속받은 클래스만 프록시를 만들 수 있음.  
런타임 시 인터페이스 기반의 프록시 객체 생성.  

## CGLIB Proxy

CGLIB 라이브러리를 사용하여 동적으로 프록시를 생성.  
프록시할 클래스가 필요함. 즉, 클래스를 상속받은 클래스만 프록시를 만들 수 있음.  
상속 기반이기 때문에 final 클래스나 final 메서드는 프록시가 적용되지 않음.
런타임 시 클래스 기반의 프록시 객체 생성.  




