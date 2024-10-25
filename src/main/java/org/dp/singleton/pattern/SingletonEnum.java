package org.dp.singleton.pattern;

/**
 * 권장되는 두 가지 방법 중 하나
 * enum은 애초에 멤버를 만들 때 private로 만들고, 한 번만 초기화 하기 때문에 Thread safe함
 * enum 내에서 상수 뿐 아니라, 변수나 메서드를 선언해 사용이 가능하기 때문에, 이를 이용해 싱글톤 클래스 처럼 응용 가능
 * Bill Pugh Solution 기법과 달리, 클라이언트에서 Reflection을 통한 공격에도 안전
 * 하지만 만일 싱글톤 클래스를 멀티톤(일반적인 클래스)로 마이그레이션 해야할 때 처음부터 코드를 다시 짜야되는 단점이 존재한다.
 * 클래스 상속이 필요할 때, enum 외의 클래스 상속은 불가능하다.
 */
public enum SingletonEnum {
    INSTANCE;

    private final BillPughSolution billPughSolution;

    SingletonEnum() {
        billPughSolution = BillPughSolution.getInstance();
    }

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }

    public BillPughSolution getBillPughSolution() {
        return billPughSolution;
    }

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.getInstance();
        BillPughSolution billPughSolution1 = singleton.getBillPughSolution();
        BillPughSolution billPughSolution2 = singleton.getBillPughSolution();
        System.out.println(billPughSolution1 == billPughSolution2); // true
    }

}
