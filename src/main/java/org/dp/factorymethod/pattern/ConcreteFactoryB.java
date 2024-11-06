package org.dp.factorymethod.pattern;

public class ConcreteFactoryB extends AbstractFactory {
    @Override
    protected IProduct createProduct() {
        return new ConcreteProductB();
    }
}
