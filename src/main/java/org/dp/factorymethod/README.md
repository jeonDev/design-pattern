# 팩토리 메서드 패턴

- 팩토리 메소드 패턴은 객체 생성을 Factory 클래스로 캠슐화 처리하여 대신 생성하게 하는 생성 디자인 패턴이다.
- 즉, 클라이언트에서 직접 new 연산자를 통해 객체를 생성하는 것이 아닌, 제품 객체들을 도맡아 생성하는 Factory 클래스를 만들고, 이를 상속하는 서브 공장 클래스의 메서드에서 여러가지 객체 생성을 각각 책임 지는 것이다.
- 또한, 객체 생성에 필요한 과정을 템플릿 처럼 미리 구성해놓고, 객체 생성에 관한 전처리나 후처리를 통해 생성 과정을 다양하게 처리하여 객체를 유연하게 정할 수 있다.

## 팩토리 메서드 패턴 구조

- Creator
  - 최상위 Factory 클래스로서, 팩토리 메서드를 추상화하여 서브 클래스로 하여금 구현하도록 함
    - 객체 생성 처리 메서드 (someOperartion)
      - 객체 생성에 관한 전처리, 후처리를 템플릿화한 메서드
    - 팩토리 메서드 (createProduct)
      - 서브 공장 클래스에서 재정의할 객체 생성 추상 메서드
- ConcreteCreator
  - 각 서브 Factory 클래스들은 이에 맞는 객체를 반환하도록 생성 추상 메서드를 재정의한다.
  - 즉, 객체 하나당 그에 맞는 Factory 객체가 위치한다.
- Product
  - 구현체를 추상화
- ConcreteProduct
  - 구현체

- 정리하자면, 팩토리 메서드 패턴은 객체를 만들어내는 공장(Factory 객체)을 만드는 패턴이라고 보면 된다.
- 그리고 어떤 클래스의 인스턴스를 만들지는 미리 정의한 Factory 서브 클래스에서 결정한다.
- 객체 생성가지고 번거롭게 구성하는 이유는 객체간의 결합도가 낮아지고, 유지보수에 용이해지기 때문.

> [Template Method 패턴과 Factory Method 패턴과의 관계]
> 템플릿 메서드는 행동 패턴, 팩토리 메서드는 생성 패턴
> 다만, 클래스 구조의 결은 같음. (인스턴스를 생성하는 공장을 Template Method 패턴으로 구성한 것이 Factory Method 패턴이 된다.)
> Template Method 패턴에서는 하위 클래스에서 구체적인 처리 알고리즘의 내용을 만들도록 추상 메소드를 상속 시켰었다.
> 이 로직을 알고리즘 내용이 아닌 인스턴스 생성에 적용한 것이 Factory Method 패턴.

## 팩토리 메서드 패턴 특징

### 패턴 사용 시기

- 클래스 생성과 사용의 처리 로직을 분리하여 결합도를 낮추고자 할 때
- 코드가 동작해야 하는 객체의 유형과 종속성을 캡슐화를 통해 정보 은닉 처리 할 경우
- 라이브러리 혹은 프레임워크 사용자에게 구성 요소를 확장하는 방법을 제공하려는 경우
- 기존 객체를 재구성하는 대신 기존 객체를 재사용하여 리소스를 절약하고자 하는 경우
  - 상황에 따라 적절한 객체를 생성하는 코드는 자주 중복될 수 있다. 그리고 객체 생성 방식의 변화는 해당되는 모든 코드 부분을 변경해야 하는 문제가 생긴다.
  - 따라서 객체의 생성 코드를 별도의 클래스 / 메서드로 분리함으로써 객체 생성의 변화에 대해 대비를 하기 위해 팩토리 메서드 패턴을 이용한다고 보면 된다.
  - 특정 기능의 구현은 별개의 클래스로 제공되는 것이 바람직한 설계이기 때문이다.

### 패턴 장점

- 생성자 (Creator) 와 구현 객체 (concrete product)의 강한 결합을 피할 수 있다.
- 패곹리 메서드를 통해 객체의 생성 후 공통으로 할 일을 수행하도록 지정해줄 수 있다.
- 캡슐화, 추상화를 통해 생성되는 객체의 구체적인 타입을 감출 수 있다
- 단일 책임 원칙 준수
  - 객체 생성 코드를 한 곳(패키지, 클래스 등)으로 이동하여 코드를 유지보수하기 쉽게 할 수 있음.
- 개방 폐쇠 원칙 준수
  - 기존 코드를 수정하지 않고 새로운 유형의 제품 인스턴스를 프로그램에 도입할 수 있어 원칙을 만족 (확장성 있는 전체 프로젝트 구성이 가능)
- 생성에 대한 인터페이스 부분과 생성에 대한 구현 부분을 따로 나뉘었기 때문에 패키지 분리하여 개별로 여러 개발자가 협업을 통해 개발.

### 패턴 단점

- 각 제품 구현체마다 팩토리 객체들을 모두 구현해주어야 하기 때문에, 구현체가 늘어날 때마다 팩토리 클래스가 증가하여 서브 클래스 수가 폭발한다.
- 코드의 복잡성이 증가한다.


### 예제

- Java
  - java.util.Calendar - getInstance()
  - java.util.ResourceBundle - getBundle()
  - java.text.NumberFormat - getInstance()
  - java.nio.charset.Charset - forName()
  - java.net.URLStreamHandlerFactory - createURLStreamHandler(String)
  - java.util.EnumSet - of()

- Spring Framework
  - BeanFactory


출처: https://inpa.tistory.com/entry/GOF-💠-팩토리-메서드Factory-Method-패턴-제대로-배워보자 [Inpa Dev 👨‍💻:티스토리]