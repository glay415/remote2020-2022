package com.example.jjinreactivestreampractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JjinReactiveStreamPracticeApplication {

    public static void main(String[] args) {
        MyPub pub = new MyPub();
        MySub sub = new MySub();

        pub.subscribe(sub);
    }

}
