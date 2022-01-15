package com.highthon.school.domain.job.dto;

import com.highthon.school.domain.job.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateJabRequestDto {
    private final String name;
    private final Branch branch;
}
