package org.dp.singleton.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 객체 생성에 대한 관리를 내부적으로 처리
 * 메서드를 호출했을 때 인스턴스 변수의 null 유무에 따라 초기화 하거나 있는 것을 반환하는 기법
 * 위의 미사용 고정 메모리 차지의 한계점을 극복
 * 그러나 Thread Safe 하지 않는 치명적인 단점을 가지고 있음.
 */
public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {}

    public static LazyInitialization getInstance() {
        // 이 부분 Thread Safe 하지 않음. 16 Line ~ 17 Line
        if (instance == null) {
            instance = new LazyInitialization();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazyInitialization[] singletons = new LazyInitialization[50];

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            final int num = i;
            service.submit(() -> {
                singletons[num] = LazyInitialization.getInstance();
            });
        }

        service.shutdown();

        for (LazyInitialization singleton:singletons) {
            System.out.println(singleton.toString());
            /*
             * org.dp.singleton.pattern.LazyInitialization@4554617c
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * org.dp.singleton.pattern.LazyInitialization@74a14482
             * 2 개 생성....!
             * 72ms
             */
        }
    }
}
