package com.highthon.school.domain.job.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JabInfoResponseDto {
    public boolean interest;
    public String jab;
    public String intro;

    public int branch;
}
