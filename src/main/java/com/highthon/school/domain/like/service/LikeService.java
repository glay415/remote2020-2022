package com.highthon.school.domain.like.service;

import com.highthon.school.domain.board.exception.BoardNotFoundException;
import com.highthon.school.domain.board.repository.BoardRepository;
import com.highthon.school.domain.like.Like;
import com.highthon.school.domain.like.repository.LikeRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {

	private final BoardRepository boardRepository;
	private final LikeRepository likeRepository;
	private final UserFacade userFacade;

	public void liked(Integer boardId) {

		if (likeRepository.existsByUser(userFacade.getCurrentUser())) {
			likeRepository.deleteByBoardId(boardId);
		}
		else {
			Like like = Like.builder()
				.user(userFacade.getCurrentUser())
				.board(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new))
				.build();

			likeRepository.save(like);
		}
	}
}
