package org.dp.proxy.pattern.dynamic;

import java.lang.reflect.Proxy;

/**
 * 동적 프록시(Dynamic Proxy) : 컴파일 시점이 아닌 런타임 시점에 프록시 클래스를 만들어주는 방식
 * java.lang.reflect.Proxy 패키지에서 제공해주는 API를 이용하여 동적으로 프록시 인스턴스르 만들어 등록하는 방법으로서, 자바의 리플렉션 API 기법을 응용한 연장선
 *
 * newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 *  - ClassLoader : 프록시 객체가 구현할 Interface에 Class Loader를 얻어오는 것이 일반적
 *  - Class<?>[] interfaces : 메서드를 통해 생성될 Proxy 객체가 구현할 Interface를 정의
 *  - InvocationHandler : 프록시의 메서드가 호출되었을 때 실행되는 핸들러 메서드
 *
 * InvocationHandler 인터페이스 : invoke() 메서드는 동적 프록시의 메서드가 호출되었을 때, 이를 낚아채어 대신 실행되는 메서드
 * invoke(Object proxy, Method method, Object[] args)
 *  - Object : 프록시 객체
 *  - Method : 호출한 메서드 정보
 *  - Object[] args : 메서드에 전달된 매개변수
 */
public class DynamicProxy {

    public static void main(String[] args) {
        AInterface proxyA = (AInterface) Proxy.newProxyInstance(
                AInterface.class.getClassLoader(),
                new Class[]{AInterface.class},
                new MyProxyHandler(new AImpl())
        );
        proxyA.call();

        BInterface proxyB = (BInterface) Proxy.newProxyInstance(
                BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                new MyProxyHandler(new BImpl())
        );
        proxyB.call();
    }
}
