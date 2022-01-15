package com.highthon.school.domain.board.controller;

import com.highthon.school.domain.board.dto.CreateBoardRequestDto;
import com.highthon.school.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

	private final BoardService boardService;

	@PostMapping
	public void createBoard(@RequestBody CreateBoardRequestDto createBoardRequest) {
		boardService.createBoard(createBoardRequest);
	}
}
