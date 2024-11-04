package org.dp.adapter.classAdaptor;

public class Adapter extends Service implements Target {

    @Override
    public void method(int data) {
        specificMethod(data);
    }
}
