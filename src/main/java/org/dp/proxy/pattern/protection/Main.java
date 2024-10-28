package org.dp.proxy.pattern.protection;

public class Main {

    public static void main(String[] args) {
        ISubject sub = new Proxy();
        sub.action();
    }
}
