package org.dp.templatemethod.pattern;

public abstract class AbstractTemplate {

    public final void method() {
        methodA();
    }

    protected abstract void methodA();
}
