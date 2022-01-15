package com.highthon.school.domain.job.dto;

import com.highthon.school.domain.job.Branch;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateJabRequestDto {
    private String name;
    private Branch branch;
    private String intro;
}
