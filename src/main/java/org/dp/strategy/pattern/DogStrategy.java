package org.dp.strategy.pattern;

public class DogStrategy implements AnimalStrategy{

    @Override
    public void speak() {
        System.out.println("멍");
    }
}
