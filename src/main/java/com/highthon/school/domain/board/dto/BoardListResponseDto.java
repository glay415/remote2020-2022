package com.highthon.school.domain.board.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListResponseDto {

	private final List<BoardResponse> boardList;

	@Getter
	@Builder
	public static class BoardResponse {
		private final Integer id;
		private final String title;
		private final String content;
		private final Long likeCount;
		private final Long commentCount;
		private final boolean isLiked;
		private final String writer;
		private final LocalDateTime createdAt;
	}
}
