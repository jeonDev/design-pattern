package org.dp.singleton.pattern;

/**
 * 권장되는 두 가지 방법 중 하나
 * 멀티쓰레드 환경에서 안전하고 Lazy Loading 도 가능한 완벽한 싱글톤 기법
 * 클래스 안에 내부 클래스 (holder)를 두어 JVM의 클래스 로더 매커니즘과 클래스가 로드되는 시점을 이용한 방법 (Thread Safe 함)
 * static 메소드에서는 static 멤버만을 호출할 수 있기 때문에 내부 클래스를 static으로 설정
 * 이 밖에도 내부 클래스의 치명적인 문제점인 메모리 누수 문제를 해결하기 위해 내부 클래스를 static으로 설정
 * 다만 클라이언트가 임의로 싱글톤을 파괴할 수 있다는 단점을 지님 (Reflection API, 직렬화/역질렬화를 통해)
 */
public class BillPughSolution {

    private BillPughSolution() {}

    private static class BillPughSolutionHolder {
        private static final BillPughSolution INSTANCE = new BillPughSolution();
    }

    public static BillPughSolution getInstance() {
        return BillPughSolutionHolder.INSTANCE;
    }

    /**
     * 우선 내부클래스를 static으로 선언하였기 때문에, 싱글톤 클래스가 초기화되어도 Holder 내부 클래스는 메모리에 로드되지 않음
     * 어떠한 모듈에서 getInstance() 메서드를 호출할 때, Holder 내부 클래스의 static 멤버를 가져와 리턴하게 되는데, 이 때 내부 클래스가 한 번만 초기화되면서 싱글톤 객체를 최초로 생성 및 리턴하게 된다.
     * 마지막으로 final로 지정함으로서 다시 값이 할당되지 않도록 방지한다.
     *
     */
}
