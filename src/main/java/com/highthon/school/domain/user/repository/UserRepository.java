package com.highthon.school.domain.user.repository;

import com.highthon.school.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
