package com.highthon.school.domain.comment.service;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.board.exception.BoardNotFoundException;
import com.highthon.school.domain.board.repository.BoardRepository;
import com.highthon.school.domain.comment.Comment;
import com.highthon.school.domain.comment.dto.CommentResponseDto;
import com.highthon.school.domain.comment.exception.CommentNotFoundException;
import com.highthon.school.domain.comment.repository.CommentRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import com.highthon.school.global.exception.ForbiddenException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final UserFacade userFacade;
	private final BoardRepository boardRepository;
	private final CommentRepository commentRepository;

	public CommentResponseDto comment(Integer boardId, String content) {
		Board board = boardRepository.findById(boardId)
			.orElseThrow(BoardNotFoundException::new);

		Comment comment = commentRepository.save(new Comment(content, board, userFacade.getCurrentUser()));
		return new CommentResponseDto(comment.getId());
	}

	public void delComment(Integer commentId) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(CommentNotFoundException::new);

		if (!comment.getUser().equals(userFacade.getCurrentUser())) throw new ForbiddenException();

		commentRepository.delete(comment);
	}
}
