package org.dp.proxy.pattern.virtual;

public class RealSubject implements ISubject {

    @Override
    public void action() {
        System.out.println("원본 객체 액션 !!");
    }
}
