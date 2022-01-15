package com.highthon.school.domain.user.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyInformationResponseDto {

	private final String nickname;
	private final List<BoardResponse> boardList;

	@Getter
	@Builder
	public static class BoardResponse {
		private final Integer id;
		private final String title;
		private final String content;
	}
}
