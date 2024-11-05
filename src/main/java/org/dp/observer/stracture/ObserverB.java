package org.dp.observer.stracture;

public class ObserverB implements IObserver {

    @Override
    public void update() {
        System.out.println("ObserverB 한테 이벤트 알림이 왔습니다.");
    }

    public String toString() {
        return "ObserverB";
    }
}
