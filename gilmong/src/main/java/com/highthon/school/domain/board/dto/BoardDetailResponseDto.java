package com.highthon.school.domain.board.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailResponseDto {

	private final String title;
	private final String content;
	private final String writer;
	private final Long likeCount;
	private final Long commentCount;
	private final boolean isLiked;
	private final LocalDateTime createdAt;
	private final List<CommentResponse> commentResponseList;

	@Getter
	@Builder
	public static class CommentResponse{
		private final String content;
		private final String nickname;
		private final Long replyCount;
		private final LocalDateTime createdAt;
		private final List<ReplyResponse> replyResponseList;
	}

	@Getter
	@Builder
	public static class ReplyResponse{
		private final String content;
		private final String nickname;
		private final LocalDateTime createdAt;
	}
}
