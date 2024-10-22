package org.dp.strategy.pattern;

public class Main {
    public static void main(String[] args) {
        Context c = new Context();
        c.setAnimalStrategy(new DogStrategy());
        c.speaking();

        c.setAnimalStrategy(new CatStrategy());
        c.speaking();
    }
}
