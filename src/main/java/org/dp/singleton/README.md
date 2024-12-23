- 싱글톤 패턴이란 단 하나의 유일한 객체를 만들기 위한 코드 패턴
  - 메모리 절약을 위해, 인스턴스가 필요할 때 똑같은 인스턴스를 새로 만들지 않고 기존의 인스턴스를 가져와 활용하는 기법
- 따라서 싱글톤 패턴이 적용된 객체가 필요한 경우는 그 객체가 리소스를 많이 차지하는 역할을 하는 무거운 클래스일 때 적합하다.
- ex) 데이터베이스 연결 모듈
  - 데이터베이스에 접속하는 작업(I/O)은 그 자체로 무거운 작업에 속하며 또한 한 번만 객체를 생성하고 돌려쓰면 굳이 여러 번 생성할 필요가 없다.
  - 이 외에도 디스크 연결, 네트워크 통신, DBCP 커넥션풀, 스레드풀, 캐시, 로그 기록 객체 등
- 이러한 객체들은 또 새로 만들어서 사용될 일도 없거니와 사용해도 리소스 낭비일 뿐이다.
- 따라서 어플리케이션에서 유일해야 하며 유일한 것이 좋은 것을 싱글톤 객체로 만들면 된다고 보면 된다.

# 멀티 쓰레드 환경에서의 문제점
- 자바는 멀티 쓰레드 언어인데, 이 멀티 쓰레드 환경에서는 Thread Safe 하지 않다.
- 동시성으로 인한 코드 실행의 문제점이 발생할 수 있다.

# 싱글톤 패턴은 안티 패턴?
- 싱글톤 패턴은 얻는 이점과 더불어 많은 문제점들을 수반하기 때문에 trade-off를 잘 고려해야 한다.

1. 모듈간 의존성이 높아진다.
2. SOLID 원칙에 위배되는 사례가 많다.
3. TDD 단위 테스트에 애로사항이 있음.

# 종류
- Eager Initialization
- Static block initialization
- Lazy Initialization
- Thread safe initialization
- Double-Check Locking
- <span style="background:#ffdce0">Bill Pugh Solution</span>
- <span style="background:#ffdce0">Enum 이용</span>

출처: https://inpa.tistory.com/entry/GOF-💠-싱글톤Singleton-패턴-꼼꼼하게-알아보자 [Inpa Dev 👨‍💻:티스토리]