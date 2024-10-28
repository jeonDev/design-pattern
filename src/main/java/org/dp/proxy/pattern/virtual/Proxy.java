package org.dp.proxy.pattern.virtual;

/**
 * 프록시가 대상 객체에 대한 자원으로의 액세서 제어 (접근 권한)
 * 특정 클라이언트만 서비스 객체를 사용할 수  있도록 하는 경우
 * 프록시 객체를 통해 클라이언트의 자격 증명이 기준과 일치하는 경우에만 서비스 객체에 요청을 전달할 수 있게 한다.
 */
public class Proxy implements ISubject {

    private ISubject subject;
    boolean access;

    public Proxy(ISubject subject, boolean access) {
        this.subject = subject;
        this.access = access;
    }

    @Override
    public void action() {
        if (access) {
            subject.action();
            System.out.println("프록시 객체 액션 !!");
        }
    }
}
