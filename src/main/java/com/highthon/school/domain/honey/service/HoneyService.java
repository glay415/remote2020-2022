package com.highthon.school.domain.honey.service;

import com.highthon.school.domain.board.exception.BoardNotFoundException;
import com.highthon.school.domain.board.repository.BoardRepository;
import com.highthon.school.domain.honey.Honey;
import com.highthon.school.domain.honey.repository.HoneyRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HoneyService {

	private final BoardRepository boardRepository;
	private final HoneyRepository honeyRepository;
	private final UserFacade userFacade;

	public void liked(Integer boardId) {

		if (honeyRepository.existsByUser(userFacade.getCurrentUser())) {
			honeyRepository.deleteByBoardId(boardId);
		}
		else {
			Honey honey = Honey.builder()
				.user(userFacade.getCurrentUser())
				.board(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new))
				.build();

			honeyRepository.save(honey);
		}
	}
}
