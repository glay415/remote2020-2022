package com.highthon.school.domain.reply.service;

import com.highthon.school.domain.comment.Comment;
import com.highthon.school.domain.comment.exception.CommentNotFoundException;
import com.highthon.school.domain.comment.repository.CommentRepository;
import com.highthon.school.domain.reply.Reply;
import com.highthon.school.domain.reply.dto.ReplyResponseDto;
import com.highthon.school.domain.reply.repository.ReplyRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import com.highthon.school.global.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyService {

	private final ReplyRepository replyRepository;
	private final CommentRepository commentRepository;
	private final UserFacade userFacade;

	public ReplyResponseDto reply(Integer commentId, String content) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(CommentNotFoundException::new);

		Reply reply = replyRepository.save(new Reply(content, comment, userFacade.getCurrentUser()));

		return new ReplyResponseDto(reply.getId());
	}

	public void delReply(Integer replyId) {
		Reply reply = replyRepository.findById(replyId)
			.orElseThrow(ForbiddenException::new);

		if (!reply.getUser().equals(userFacade.getCurrentUser())) throw new ForbiddenException();

		replyRepository.delete(reply);
	}
}
