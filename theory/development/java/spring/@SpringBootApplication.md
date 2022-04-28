## @SpringBootApplication

----

### 개요

- 스프링의 복잡한 디펜던시 관리를 해결하기 위해 Spring Boot가 등장했다.
- Spring Boot 프로젝트를 생성하면 다음과 같은 main method가 생성된다.

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- 위 코드에서 @SpringBootApplication 어노테이션은 뭘까?
- @SpringBootApplication의 안을 확인해 보면 다음과 같다.

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {

	@AliasFor(annotation = EnableAutoConfiguration.class)
	Class<?>[] exclude() default {};

	@AliasFor(annotation = EnableAutoConfiguration.class)
	String[] excludeName() default {};

	@AliasFor(annotation = ComponentScan.class, attribute = "basePackages")
	String[] scanBasePackages() default {};

	@AliasFor(annotation = ComponentScan.class, attribute = "basePackageClasses")
	Class<?>[] scanBasePackageClasses() default {};

	@AliasFor(annotation = ComponentScan.class, attribute = "nameGenerator")
	Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

	@AliasFor(annotation = Configuration.class)
	boolean proxyBeanMethods() default true;
}

```

- @SpringBootApplication 어노테이션은 @SpringBootConfiguration, @ComponentScan, @EnableAutoConfiguration 이렇게 3개의 어노테이션으로 구성된다.

### @SpringBootConfiguration

- 그저 자바 설정파일임을 마킹하는 어노테이션이다.

### @ComponentScan

- 해당 어노테이션이 마킹된 자바파일의 패키지를 기본패키지로 그 패키지의 하위패키지에서 @Component 어노테이션을 찾아서 Bean으로 등록시킨다.

### @EnableAutoConfiguration

- 사전에 정의한 라이브러리들을 Bean으로 등록해 주는 어노테이션이다.
- 일반적으로 스프링부트 환경에서 라이브러리를 추가하면 해당 라이브러리의 자동설정 파일이 spring.factories에 정의되어 있고, 이 자동설정파일을 스프링부트가 가동시 실행하여 빈등록이나 추가 초기화 작업을 수행한다.
  - 각 Bean은 OnBeanCondition, OnClassCondition, OnWebApplicationCondition 어노테이션의 조건에 의해 등록 여부가 결정된다.
- spring-boot-starter 안에는 자동설정을 위해 spring-boot-autoconfigure 라이브러리가 포함되어 있고 @EnableAutoConfiguration도 여기 라이브러리에 포함되어 있다.

---

### reference

- https://bamdule.tistory.com/31
- https://yangbox.tistory.com/29
