package org.dp.factorymethod.pattern;

public class ConcreteFactoryA extends AbstractFactory {
    @Override
    protected IProduct createProduct() {
        return new ConcreteProductA();
    }
}
