package com.highthon.school.domain.job.dto;

import com.highthon.school.domain.job.Branch;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JabInfoResponseDto {
    public boolean interest;
    public String jab;
    public String intro;

    public Branch branch;
}
