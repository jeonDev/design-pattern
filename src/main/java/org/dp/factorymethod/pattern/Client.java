package org.dp.factorymethod.pattern;

public class Client {
    public static void main(String[] args) {
        AbstractFactory[] factory = {
                new ConcreteFactoryA(),
                new ConcreteFactoryB()
        };

        IProduct productA = factory[0].createProduct();
        productA.setting();
        IProduct productB = factory[1].createProduct();
        productB.setting();
    }
}
