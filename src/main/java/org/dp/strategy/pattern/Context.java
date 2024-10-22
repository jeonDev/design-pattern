package org.dp.strategy.pattern;

public class Context {
    private AnimalStrategy animalStrategy;

    public void setAnimalStrategy(AnimalStrategy animalStrategy) {
        this.animalStrategy = animalStrategy;
    }

    public void speaking() {
        animalStrategy.speak();
    }
}
