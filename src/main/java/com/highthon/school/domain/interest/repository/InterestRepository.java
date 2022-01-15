package com.highthon.school.domain.interest.repository;

import com.highthon.school.domain.interest.Interest;
import com.highthon.school.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InterestRepository extends CrudRepository<Interest, Integer> {
    Optional<Interest> findByJab_NameAndUser_Id(String jab, String userId);
    List<Interest> findByUser(User user);
}
