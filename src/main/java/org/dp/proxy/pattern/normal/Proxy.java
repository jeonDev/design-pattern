package org.dp.proxy.pattern.normal;

public class Proxy implements ISubject {

    private ISubject subject;

    public Proxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        subject.action();
        System.out.println("프록시 객체 액션 !!");
    }
}
