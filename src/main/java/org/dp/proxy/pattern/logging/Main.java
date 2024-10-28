package org.dp.proxy.pattern.logging;

public class Main {

    public static void main(String[] args) {
        ISubject sub = new Proxy(new RealSubject());
        sub.action();
    }
}
