package com.highthon.school.domain.interest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class InterestJabResponseDto {
    private final String name;
    private final String intro;
}
