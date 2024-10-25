package org.dp.singleton.pattern;

/***
 * static block 을 이용해 예외를 잡을 수 있음
 * 그러나 여전히 static의 특성으로 사용하지도 않는데도 공간을 차지함
 */
public class StaticBlockInitialization {
    private static StaticBlockInitialization instance;

    private StaticBlockInitialization() {}

    static {
        try {
            instance = new StaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static StaticBlockInitialization getInstance() {
        return instance;
    }
}
