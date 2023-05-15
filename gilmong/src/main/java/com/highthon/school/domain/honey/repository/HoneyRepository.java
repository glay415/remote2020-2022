package com.highthon.school.domain.honey.repository;

import com.highthon.school.domain.honey.Honey;
import com.highthon.school.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface HoneyRepository extends CrudRepository<Honey, Integer> {
	boolean existsByUser(User user);
	void deleteByBoardId(Integer boardId);
	Long countByBoardId(Integer boardId);
}
