package com.highthon.school.domain.board.controller;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.board.dto.CreateBoardRequestDto;
import com.highthon.school.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

	private final BoardRepository boardRepository;

	@PostMapping
	public void createBoard(@RequestBody CreateBoardRequestDto createBoardRequest) {
		boardRepository.save(new Board(createBoardRequest));
	}
}
