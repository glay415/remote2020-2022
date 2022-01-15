package com.highthon.school.domain.comment.repository;

import com.highthon.school.domain.comment.Comment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
	Long countByBoardId(Integer boardId);
	List<Comment> findByBoardId(Integer boardId);
}
