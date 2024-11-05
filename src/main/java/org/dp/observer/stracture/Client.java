package org.dp.observer.stracture;

public class Client {

    public static void main(String[] args) {
        ISubject publisher = new ConcreteSubject();

        IObserver o1 = new ObserverA();
        IObserver o2 = new ObserverB();
        publisher.registerObserver(o1);
        publisher.registerObserver(o2);

        publisher.notifyObserver();

        publisher.removeObserver(o2);

        publisher.notifyObserver();
    }
}
