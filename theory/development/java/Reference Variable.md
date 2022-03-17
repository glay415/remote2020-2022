## Reference Variable

----

### 개요

- 자바에는 Data type에 있어 크게 두 가지의 타입을 가지고 있다.

- 그중 참조 타입은 Primitive Variable을 제외한 array, class, interface, enum등을 말한다.

### Reference Variable이란

- Heap Area에 실제 값들을 저장하고 Stack Area에 실제 값들의 주소를 참조하는 방식의 타입이다.

- 더이상 참조하는 변수가 없으면 GC가 작동하여 Heap Area에서 자동으로 제거된다.

- Reference Variable에서의 Null은 객체의 주소를 가리키고 있지 않는 상태를 의미한다.

- 참조타입의 값은 전부 객체이며 자바 소스 파일(xxx.java) 안에는 오로지 하나의 참조타입만 선언해야 한다.

  (자료구조등 예외 케이스 있음)

### Primitive Variable과의 차이

- Heap Area에서 실제 값들을 저장한다.
- Null 사용이 가능하다.
- 제네릭 타입이 사용 가능하다.
- 접근 속도가 훨씬 느리고 메모리 양도 많이사용한다.

### Reference Variable의 메모리 사용크기

- Primitive Variable과는 다르게 따로 크기는 정해져 있지 않지만 표현 범위는 다음과 같다.

- ![화면 캡처 2022-03-17 193851](C:\Users\user\Downloads\화면 캡처 2022-03-17 193851.png)

- Heap이 32Gb(-Xmx32G) 보다 작은 32bit 플랫폼 및 64bit 플랫폼에서 4byte 이며

  32Gb보다 높은 경우에 8byte 이라고 한다.

---

### extra

- wrapper클래스도 Reference Variable의 일종이다.(따로 정리)

---

### reference

- https://velog.io/@doli0913/%EA%B8%B0%EB%B3%B8%ED%98%95%EA%B3%BC-%EC%B0%B8%EC%A1%B0%ED%98%95
- https://www.baeldung.com/java-size-of-object
- https://rang22.tistory.com/8?category=999533
- https://week-year.tistory.com/141

----

