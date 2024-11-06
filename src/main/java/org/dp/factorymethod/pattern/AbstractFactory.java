package org.dp.factorymethod.pattern;

public abstract class AbstractFactory {
    final IProduct createOperation() {
        IProduct product = createProduct();
        product.setting();
        return product;
    }

    abstract protected IProduct createProduct();
}
