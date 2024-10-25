package org.dp.singleton.pattern;

/***
 * 한 번만 미리 만들어두는, 가장 직관적이면서도 심플한 기법
 * static final 이라 멀티 쓰레드 환경에서도 안전함
 * 그러나 static 멤버는 당장 객체를 사용하지 않더라도 메모리에 적재하기 때문에 만일 리소스가 큰 객체일 경우, 공간 자원 낭비가 발생함.
 * 예외 처리를 할 수 없음
 */
public class EagerInitialization {
    private static final EagerInitialization INSTANCE = new EagerInitialization();

    private EagerInitialization() {}

    public static EagerInitialization getInstance() {
        return INSTANCE;
    }
}
