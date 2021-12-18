package com.example.appjambackend.domain.feed.presentation.requset;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostFeedRequest {

    @NotBlank(message = "title은 비어있으면 안됩니다.")
    private String title;

    @NotBlank(message = "description은 비어있으면 안됩니다.")
    private String description;

    @DateTimeFormat(pattern = "YYYY-MM-DD'T'hh:mm:ss")
    private LocalDateTime createTime;

}
