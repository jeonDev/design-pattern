package org.dp.proxy.pattern.dynamic;

public class AImpl implements AInterface {

    @Override
    public String call() {
        System.out.println("A 호출");
        return "a";
    }
}
