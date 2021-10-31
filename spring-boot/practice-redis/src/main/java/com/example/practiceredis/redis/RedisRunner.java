package com.example.practiceredis.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RedisRunner implements ApplicationRunner {

    private final StringRedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) {
        ValueOperations<String, String> data = this.redisTemplate.opsForValue();
        data.set("001", "rrrrrrr");
        data.set("002", "1234");
        data.set("003", "aaa");

    }

}