package com.highthon.school.domain.comment.controller;

import com.highthon.school.domain.comment.dto.CommentResponseDto;
import com.highthon.school.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

	private final CommentService commentService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public CommentResponseDto comment(@RequestParam Integer boardId, @RequestParam String content) {
		return commentService.comment(boardId, content);
	}

	@DeleteMapping
	public void delComment(@RequestParam Integer commentId) {
		commentService.delComment(commentId);
	}
}
