package org.dp.proxy.pattern.protection;

/**
 * 지연 초기화 방식
 * 가끔 필요하지만 항상 메모리에 적재되어 있는 무거운 서비스 객체가 있는 경우
 * 이 구현은 실제 객체의 생성에 많은 자원이 소모 되지만 사용 빈도는 낮을 때 쓰는 방식
 * 서비스가 시작될 때 객체를 생성하는 대신에 객체 초기화가 실제로 필요한 시점에 초기화될 수 있도록 지연할 수 있다.
 */
public class Proxy implements ISubject {

    private ISubject subject;

    public Proxy() {
    }

    @Override
    public void action() {
        if (subject == null) {
            subject = new RealSubject();
        }
        subject.action();
        System.out.println("프록시 객체 액션 !!");
    }
}
