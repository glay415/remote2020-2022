package com.example.errortest.repository;

import com.example.errortest.entity.Apple;
import org.springframework.data.repository.CrudRepository;

public interface AppleManager extends CrudRepository<Apple, Integer> {
}
