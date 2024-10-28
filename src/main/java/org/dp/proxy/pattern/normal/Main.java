package org.dp.proxy.pattern.normal;

public class Main {

    public static void main(String[] args) {
        ISubject sub = new Proxy(new RealSubject());
        sub.action();
    }
}
