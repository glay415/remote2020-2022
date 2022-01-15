package com.highthon.school.domain.job.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateJabRequestDto {
    private String name;
    private int branch;
    private String intro;
}
