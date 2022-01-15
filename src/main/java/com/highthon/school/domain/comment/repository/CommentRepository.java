package com.highthon.school.domain.comment.repository;

import com.highthon.school.domain.comment.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
