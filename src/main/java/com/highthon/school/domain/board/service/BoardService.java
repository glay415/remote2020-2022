package com.highthon.school.domain.board.service;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.board.Step;
import com.highthon.school.domain.board.dto.BoardDetailResponseDto;
import com.highthon.school.domain.board.dto.BoardDetailResponseDto.CommentResponse;
import com.highthon.school.domain.board.dto.BoardDetailResponseDto.ReplyResponse;
import com.highthon.school.domain.board.dto.BoardListResponseDto;
import com.highthon.school.domain.board.dto.BoardListResponseDto.BoardResponse;
import com.highthon.school.domain.board.dto.CreateBoardRequestDto;
import com.highthon.school.domain.board.exception.BoardNotFoundException;
import com.highthon.school.domain.board.repository.BoardRepository;
import com.highthon.school.domain.comment.repository.CommentRepository;
import com.highthon.school.domain.honey.repository.HoneyRepository;
import com.highthon.school.domain.job.Jab;
import com.highthon.school.domain.job.repository.JabRepository;
import com.highthon.school.domain.reply.repository.ReplyRepository;
import com.highthon.school.domain.user.facade.UserFacade;
import com.highthon.school.global.exception.JabNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	private final HoneyRepository honeyRepository;
	private final CommentRepository commentRepository;
	private final ReplyRepository replyRepository;
	private final JabRepository jabRepository;
	private final UserFacade userFacade;

	public void createBoard(CreateBoardRequestDto createBoardRequest) {
		Jab jab = jabRepository.findById(createBoardRequest.getJap())
			.orElseThrow(JabNotFoundException::new);
		boardRepository.save(new Board(createBoardRequest, userFacade.getCurrentUser(), jab));
	}

	public BoardListResponseDto boardList(Step step, String japId) {
		Jab jab = jabRepository.findById(japId)
			.orElseThrow(JabNotFoundException::new);
		return new BoardListResponseDto(
		 	boardRepository.findByStepAndJab(step, jab)
			 .stream()
			 .map(board -> BoardResponse.builder()
				 .id(board.getId())
				 .title(board.getTitle())
				 .content(board.getContent())
				 .likeCount(honeyRepository.countByBoardId(board.getId()))
				 .isLiked(isLiked())
				 .commentCount(countCommentByBoardId(board.getId()))
				 .createdAt(board.getCreatedAt())
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
				.commentCount(countCommentByBoardId(boardId))
				.createdAt(board.getCreatedAt())
				.writer(board.getUser().getNickname())
				.commentResponseList(commentResponseBuilder(boardId))
				.build())
			.orElseThrow(BoardNotFoundException::new);
	}

	public BoardListResponseDto contentSearch(String content){
		return new BoardListResponseDto(boardRepository.findByContentContaining(content)
				.stream().map(b -> BoardResponse.builder()
											.id(b.getId())
											.title(b.getTitle())
											.content(b.getContent())
											.likeCount(honeyRepository.countByBoardId(b.getId()))
											.isLiked(isLiked()).build())
				.collect(Collectors.toList()));
	}

	private boolean isLiked() {
		return honeyRepository.existsByUser(userFacade.getCurrentUser());
	}
	private Long countCommentByBoardId(Integer boardId) { return commentRepository.countByBoardId(boardId); }

	private List<CommentResponse> commentResponseBuilder(Integer boardId) {
		return commentRepository.findByBoardId(boardId)
			.stream()
			.map(comment -> CommentResponse.builder()
				.content(comment.getContent())
				.nickname(comment.getUser().getNickname())
				.replyCount(replyRepository.countByCommentId(comment.getId()))
				.createdAt(comment.getCreateAt())
				.replyResponseList(replyResponseBuilder(comment.getId()))
				.build())
			.collect(Collectors.toList());
	}

	private List<ReplyResponse> replyResponseBuilder(Integer commentId) {
		return replyRepository.findByCommentId(commentId)
			.stream()
			.map(reply -> ReplyResponse.builder()
				.content(reply.getContent())
				.nickname(reply.getUser().getNickname())
				.createdAt(reply.getCreateAt())
				.build())
			.collect(Collectors.toList());
	}
}
