package com.highthon.school.domain.board.controller;

import com.highthon.school.domain.board.Step;
import com.highthon.school.domain.board.dto.BoardDetailResponseDto;
import com.highthon.school.domain.board.dto.BoardListResponseDto;
import com.highthon.school.domain.board.dto.CreateBoardRequestDto;
import com.highthon.school.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

	private final BoardService boardService;

	@PostMapping
	public void createBoard(@RequestBody CreateBoardRequestDto createBoardRequest) {
		boardService.createBoard(createBoardRequest);
	}

	@GetMapping("/list")
	private BoardListResponseDto boardList(@RequestParam Step step) {
		return boardService.boardList(step);
	}

	@GetMapping
	public BoardDetailResponseDto boardDetail(@RequestParam Integer boardId) {
		return boardService.boardDetail(boardId);
	}

	@GetMapping("/{content}")
	public BoardListResponseDto contentSearch(@PathVariable String content){
		return boardService.contentSearch(content);
	}
}
