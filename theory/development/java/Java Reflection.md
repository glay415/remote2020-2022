## Java Reflection

----

### 개요

- 자바는 정적인 언어로 부족한 부분이 많지만, 동적인 문제를 해결하기 위해 리플렉션을 사용한다.

### Reflection이란?

- 컴파일 시간이 아닌 실행 시간에 동적으로 특정 클래스의 정보를 추출해낼 수 있는 프로그래밍 기법
- 이미 로딩이 완료된 클래스에서 또 다른 클래스를 동적으로 로딩하여 생성자, 멤버 필드, 멤버 메서드등을 사용할 수 있도록 한다.
- Spring 프레임워크의 어노테이션 같은 기능이 이를 통해 이루어져 있다.
- Reflection이 가능한 이유는 자바 클래스 파일이 바이트 코드로 컴파일되어 Static 영역에 위치하기 때문이다.
  - 이러한 이유로 클래스 이름만 알고 있다면, 언제든지 이 Static영역을 뒤져서 클래스에 대한 정보를 가져올 수 있다.

### Refelction사용처

- 동적으로 클래스를 사용해야 할 때 필요하다.
- 다형성으로 인해 사용하지 못하는 멤버변수를 사용할 수 있게 만들 수 있다.
- 이 상황의 대표적인 예가 JDBC이다.
  - 자바 가상머신이 동작을 시작하고, 코드가 실행되기 전까지는 어떠한 JDBC의 드라이버가 사용이 될 지 알 수 없기에 JAVA에서 DB를 연동할때 다음과 같은 코드가 존재한다.

```java
Class.forName("oracle.jdbc.driver.OracleDriver");
```

- 위 코드를 사용하여 런타임 시에 동적으로 OracleDriver를 로딩하게 한다.

### Reflection의 다양한 기능

- Reflection을 통해 클래스, 인터페이스, 메서드들을 찾을 수 있고 객체를 생성, 변수 변경, 메소드 호출등을 할 수 있다.

```java
package test;

public class User {
    private String userName;
    
    public User() {}
    
    public int method(int n) {
        return n;
    }
}
```

- 앞서 다음과 같은 클래스가 있다고 가정한다.

```java
Class cls = User.class;
Class cls2 = Class.forName("test.User");
Constructor cos = cls.getDeclaredConstructor();
Method met = cls.getDeclaredMethod("method", int.class)

/*
 * Output
 * Class name: test.User
*/
```

- 위 예제는 IDE에서 클래스를 알고 있다는 전제에 사용할 수 있다.
- 클래스 이름만으로 클래스의 정보를 가져올 수 있으며, getDeclaredConstructor()를 이용하여 인자 없는 생성자, getDeclaredMethod()를 통해 메소드를 찾을 수 있다.

- https://codechacha.com/ko/reflection/ 여기가면 좋은 예제들이 많다.

---

### reference

- https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=zzang9ha&logNo=222090490272
