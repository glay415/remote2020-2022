package com.example.appjambackend.domain.feed.presentation.dto.requset;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ModifyFeedRequest {

    @NotNull
    private Long feedId;

    @NotBlank(message = "title은 공백이면 안됩니다.")
    private String title;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'hh:mm:ss")
    private LocalDateTime modifyTime;
}
