package org.dp.singleton.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 매번 synchronized 동기화를 실행하는 것이 문제라면, 최초 초기화 할 때만 적용하고 이미 만들어진 인스턴스를 반환할 때는 사용하지 않도록 하는 기법
 * 이 때 인스턴스 필드에 volatile 키워드를 붙여주어야 I/O 불일치 문제를 해결할 수 있다.
 * 그러나 volatile 키워드를 이용하기 위해선 JVM 1.5이상이어야 되고, JVM 에 대한 심층적인 이해가 필요하여, JVM 에 따라서 여전히 Thread Safe 하지 않는 경우가 발생하기 때문에 사용하기를 지양하는 편
 *
 * volatile
 *  Java 에서 쓰레드를 여러 개 사용할 경우, 성능을 위해서 각각의 쓰레드들은 변수를 메인 메모리(RAM) 으로부터 가져오는 것이 아니라 캐시 메모리에서 가져오게 된다.
 *  문제는 비동기로 변수 값을 캐시에 저장하다가, 각 쓰레드마다 할당되어 있는 캐시 메모리의 변수 값이 일치하지 않을 수 있다는 점이다.
 *  그래서 volatile 키워드를 통해 이 변수는 캐시에서 읽지 말고 메인 메모리에서 읽어오도록 지정해주는 것.
 *
 */
public class DoubleCheckedLocking {
    private static volatile DoubleCheckedLocking instance;

    private DoubleCheckedLocking() {}

    public static DoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckedLocking[] singletons = new DoubleCheckedLocking[50];

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            final int num = i;
            service.submit(() -> {
                singletons[num] = DoubleCheckedLocking.getInstance();
            });
        }

        service.shutdown();

        for (DoubleCheckedLocking singleton:singletons) {
            System.out.println(singleton.toString());
            /*
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * org.dp.singleton.pattern.DoubleCheckedLocking@4554617c
             * 119ms
             */
        }
    }
}
