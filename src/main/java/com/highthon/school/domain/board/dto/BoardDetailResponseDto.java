package com.highthon.school.domain.board.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailResponseDto {

	private final String title;
	private final String content;
	private final String writer;
	private final Long likeCount;
	private final boolean isLiked;
}
