package org.dp.singleton.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 키워드를 통해 메서드에 쓰레드들을 하나하나씩 접근하게 하도록 설정 (동기화)
 * 하지만 여러개의 모듈들이 매번 객체를 가져올 때 synchronized 메서드를 매번 호출하여 동기화 처리 작업에 overhead가 발생해 성능 하락이 발생.
 */
public class ThreadSafeInitialization {
    private static ThreadSafeInitialization instance;

    private ThreadSafeInitialization() {}

    public static synchronized ThreadSafeInitialization getInstance() {
        if (instance == null) {
            instance = new ThreadSafeInitialization();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeInitialization[] singletons = new ThreadSafeInitialization[50];

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            final int num = i;
            service.submit(() -> {
                singletons[num] = ThreadSafeInitialization.getInstance();
            });
        }

        service.shutdown();

        for (ThreadSafeInitialization singleton:singletons) {
            System.out.println(singleton.toString());
            /*
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * org.dp.singleton.pattern.ThreadSafeInitialization@4554617c
             * 108ms
             */
        }
    }
}
