package org.dp.adapter.classAdaptor;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.method(1);
    }
}
