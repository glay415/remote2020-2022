package com.highthon.school.domain.board.service;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.board.Step;
import com.highthon.school.domain.board.dto.BoardDetailResponseDto;
import com.highthon.school.domain.board.dto.BoardListResponseDto;
import com.highthon.school.domain.board.dto.BoardListResponseDto.BoardResponse;
import com.highthon.school.domain.board.dto.CreateBoardRequestDto;
import com.highthon.school.domain.board.exception.BoardNotFoundException;
import com.highthon.school.domain.board.repository.BoardRepository;
import com.highthon.school.domain.honey.repository.HoneyRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	private final HoneyRepository honeyRepository;
	private final UserFacade userFacade;

	public void createBoard(CreateBoardRequestDto createBoardRequest) {
		boardRepository.save(new Board(createBoardRequest, userFacade.getCurrentUser()));
	}

	public BoardListResponseDto boardList(Step step) {
		 return new BoardListResponseDto(
		 	boardRepository.findByStep(step)
			 .stream()
			 .map(board -> BoardResponse.builder()
				 .id(board.getId())
				 .title(board.getTitle())
				 .content(board.getContent())
				 .likeCount(honeyRepository.countByBoardId(board.getId()))
				 .isLiked(isLiked())
				 .build())
			 .collect(Collectors.toList())
		 );
	}

	public BoardDetailResponseDto boardDetail(Integer boardId) {
		return boardRepository.findById(boardId)
			.map(board -> BoardDetailResponseDto.builder()
				.title(board.getTitle())
				.content(board.getContent())
				.likeCount(honeyRepository.countByBoardId(boardId))
				.isLiked(isLiked())
				.build())
			.orElseThrow(BoardNotFoundException::new);
	}

	public BoardListResponseDto contentSearch(String content){
		return new BoardListResponseDto(boardRepository.findByContentContaining(content)
				.stream().map(b -> BoardResponse.builder()
											.id(b.getId())
											.title(b.getTitle())
											.content(b.getContent()).build())
//											.likeCount(likeRepository.countByBoardId(b.getId()))
//											.isLiked(isLiked()).build())
				.collect(Collectors.toList()));
	}

	private boolean isLiked() {
		return honeyRepository.existsByUser(userFacade.getCurrentUser());
	}
}
