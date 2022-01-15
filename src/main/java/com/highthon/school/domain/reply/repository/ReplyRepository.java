package com.highthon.school.domain.reply.repository;

import com.highthon.school.domain.reply.Reply;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReplyRepository extends CrudRepository<Reply, Integer> {
	Long countByCommentId(Integer commentId);
	List<Reply> findByCommentId(Integer commentId);
}
