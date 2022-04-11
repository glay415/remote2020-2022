## String, StringBuffer, StringBuilder

----

### 자바의 문자열

- 자바에서 문자열을 다루는 대표적인 클래스로 String, StringBuffer, StringBuilder라는 3가지 클래스가 있다.
- 연산 횟수가 많아지는 멀티쓰레드, 경쟁상태 등의 상황이 자주 발생 한다면 각 클래스의 특징을 이해하고 상황에 맞는 적절한 클래스를 사용해야 한다.

### 불변성과 가변성

- 객체가 한번 생성되면 할당된 공간이 변하지 않는것을 불변성이라고 하며 String이 이에 속한다.
- 객체의 공간이 부족해지는 경우 버퍼의 크기를 유연하게 늘려주는 것을 가변성이라고 하며 StringBuffer와 StringBuilder가 이에 속한다.

```java
String str = "hello"; //"hello"는 GC수집 대상
str = str + " world!";
```

- 위 코드는 String 클래스의 참조변수 str이 가리키는 곳에 저장된 "hello" 에 " world!" 문자열을 더한 것이 아니다.
- String 클래스는 불변하기 때문에 문자열을 수정하는 시점에 새로운 String 인스턴스가 생성된다.

### String

- String 클래스는 위와 같이 불변성을 가지는 특성이 있다.
  - 변하지 않는 문자열을 자주 읽어들이는 경우에 사용하면 좋고
  - 추가, 수정, 삭제 등의 연산이 빈번하게 발생하는 경우에는 Heap에 많은 임시GC가 생성되어 힙메모리 부족으로 성능에 치명적인 악영향을 끼칠 수 있다.

### StringBuffer(java 1.0도입)

- StringBuffer는 여러 스레드가 동일한 문자열에서 작업 할 때 사용된다.
- 스레드로부터 안전하며 동기화되는 특성이 있다.

### StringBuilder(java 1.5도입)

- StringBuilder는 단일 스레드 환경에서 주로 사용된다.
- 동기화를 지원하지 않기 때문에 단일스레드에서의 성능 만큼은 StringBuffer보다 뛰어남.

---

