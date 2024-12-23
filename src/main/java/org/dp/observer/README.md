# 옵저버 패턴

- 옵저버(관찰자)들이 관찰하고 있는 대상자의 상태의 변화가 있을 때마다 대상자는 직접 목록의 각 관찰자들에게 통지하고, 관찰자들은 알림을 받아 조치를 취하는 행동 패턴
- 다른 디자인 패턴들과 다르가 **일대 다 의존성**을 가지는데, 주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다. (Pub/Sub - 발행/구독) 모델로도 알려져 있다.
- 프로그래밍적으로 옵저버 패턴은 사실 '관찰'을 하기 보단 갱신을 위한 힌트 정보 '전달' 받기를 기다린다고 보는 것이 적절하다.
- 관찰자라는 단어 뉘앙스에서 능동적으로 대상을 관찰하는 것처럼 느껴지지만, 사실 대상 객체로부터 수동적으로 전달 받기를 기다리고 있기 때문이다.

## 옵저버 패턴 구조

- ISubject
  - 관찰 대상자를 정의하는 인터페이스
- ConcreteSubject
  - 관찰 당하는 대상자 / 발행자 / 게시자
    - Observer들은 리스트(List, Map, Set ..등)로 모아 합성 (Composition)하여 가지고 있음.
    - Subject의 역할은 관찰자인 Observer들을 내부 리스트에 등록/삭제 하는 인프라를 가지고 있다. (register, remove)
    - Subject가 상태를 변경하거나 어떤 동작을 실행할 때, Observer 들에게 이벤트 알림(notify)을 발행한다.
- IObserver
  - 구독자들을 묶는 인터페이스 (다형성)
- Observer
  - 관찰자 / 구독자 / 알림 수신자
    - Observer들은 Subject가 발행한 알림에 대해 현재 상태를 취득한다.
    - Subject의 업데이트에 대해 전후 정보를 처리한다.

- 옵저버 패턴은 여타 다른 디자인 패턴과 똑같이 상호작용할 객체를 합성(composition)을 하고 메서드 위임을 통해 구성하는 코드 패턴임은 똑같지만, 핵심은 합성한 객체를 리스트로 관리하고, 리스트에 있는 관찰자 객체들에게 모두 메서드 위임을 통한 전파 행위를 한다는 점을 기억하면 된다.


## 옵터버 패턴 흐름

1. 옵저버 패턴에서는 한 개의 관찰 대상자 (Subject)와 여러 개의 관찰자 (Observer A, B, C)로 일 대 다 관계로 구성되어 있다.
2. Observer 패턴에서는 관찰 대상 Subject의 상태가 바뀌면 변경사항을 옵저버 한테 통보해준다. (notifyObserver)
3. 대상자로부터 통보를 받은 Observer는 값을 바꿀수도 있고, 삭제하는 등 적절히 대응한다. (update)
4. 또한 Observer들은 언제든 Subject의 그룹에서 추가/삭제될 수 있다. Subject 그룹에 추가되면 Subject로부터 정보를 전달받게 될 것이며, 그룹에서 삭제될 경우 더 이상 Subject의 정보를 받을 수 없게 된다.

## 옵저버 패턴 특징

### 패턴 사용 시기

- 앱이 한정된 시간, 특정한 케이스에만 다른 객체를 관찰해야 하는 경우
- 대상 객체의 상태가 변경될 때마다 다른 객체의 동작을 트리거해야 할 때
- 한 객체의 상태가 변경되면 다른 객체도 변경해야 할 때, 그런데 어떤 객체들이 변경되어야 하는지 몰라도 될 때.
- MVC 패턴에서도 사용됨 (Model, View, Controller)
  - MVC의 Model과 View의 관계는 Observer 패턴의 Subject 역할과 Observer 역할의 관계에 대응된다.
  - 하나의 Model에 복수의 View가 대응한다.

### 패턴 장점

- Subject의 상태 변경을 주기적으로 조회하지 않고 자동으로 감지할 수 있다.
- 발행자의 코드를 변경하지 않고도 새 구독자 클래스를 도입할 수 있어 개방 폐쇄 원칙(OCP)을 준수한다.
- 런타임 시점에서 발행자와 구독 알림 관계를 맺을 수 있다.
- 상태를 변경하는 객체(Subject)와 변경을 감지하는 객체(Observer)의 관계를 느슨하게 유지할 수 있다. (느슨한 결합)

### 패턴 단점

- 구독자는 알림 순서를 제어할 수 없고, 무작위 순서로 알림을 받음.
  - 하드 코딩으로 구현할 수는 있겠지만, 복잡성과 결합성만 높아지기 때문에 추천 X
- 옵저버 패턴을 자주 구성하면 구조와 동작을 알아보기 힘들어져 코드 복잡도가 증가한다.
- 다수의 옵저버 객체를 등록 이후 해지하지 않는다면 메모리 누수가 발생할 수도 있다.


## Ex

- 자바의 내장 옵저버 객체
  - java.util.Observable(인터페이스)
  - java.util.Observer(클래스)
- java.util.EventListener의 모든 구현체
- javax.servlet.http.HttpSessionBindingListener
- javax.servlet.http.HttpSessionAttributeListener
- javax.faces.event.PhaseListener

  
- 출처: https://inpa.tistory.com/entry/GOF-💠-옵저버Observer-패턴-제대로-배워보자 [Inpa Dev 👨‍💻:티스토리]