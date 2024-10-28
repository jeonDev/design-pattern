package org.dp.proxy.pattern.virtual;

public class Main {

    public static void main(String[] args) {
        ISubject sub1 = new Proxy(new RealSubject(), true);
        ISubject sub2 = new Proxy(new RealSubject(), false);
        sub1.action();
        sub2.action();
    }
}
