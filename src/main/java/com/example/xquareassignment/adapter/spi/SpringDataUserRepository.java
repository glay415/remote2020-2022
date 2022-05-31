package com.example.xquareassignment.adapter.spi;

import com.example.xquareassignment.domain.auth.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

interface SpringDataUserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
