package org.dp.adapter.objectAdaptor;

public class Adapter implements Target {
    private Service adaptee;

    public Adapter(Service adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void method(int data) {
        adaptee.specificMethod(data);
    }
}
