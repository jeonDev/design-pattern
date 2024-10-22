package org.dp.strategy.pattern;

public class CatStrategy implements AnimalStrategy {

    @Override
    public void speak() {
        System.out.println("냥");
    }
}
