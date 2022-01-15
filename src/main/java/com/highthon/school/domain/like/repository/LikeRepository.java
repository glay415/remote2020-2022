package com.highthon.school.domain.like.repository;

import com.highthon.school.domain.like.Like;
import com.highthon.school.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Integer> {
	boolean existsByUser(User user);
	void deleteByBoardId(Integer boardId);
	Long countByBoardId(Integer boardId);
}
