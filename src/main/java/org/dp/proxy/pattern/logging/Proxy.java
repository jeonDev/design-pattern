package org.dp.proxy.pattern.logging;

/**
 * 대상 객체에 대한 로깅을 추가하려는 경우
 */
public class Proxy implements ISubject {

    private ISubject subject;

    public Proxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        System.out.println("----Logging----");
        subject.action();
        System.out.println("프록시 객체 액션 !!");
        System.out.println("----Logging----");
    }
}
