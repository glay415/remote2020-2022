package com.highthon.school.domain.board.dto;

import com.highthon.school.domain.board.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequestDto {
	private String title;
	private String content;
	private Step step;
	private String jap;
}
