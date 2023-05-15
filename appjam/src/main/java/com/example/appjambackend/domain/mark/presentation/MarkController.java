package com.example.appjambackend.domain.mark.presentation;

import com.example.appjambackend.domain.mark.service.PostMarkService;
import com.example.appjambackend.domain.mark.service.RemoveMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mark")
public class MarkController {

    private final PostMarkService postMarkService;
    private final RemoveMarkService removeMarkService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postMark(@RequestParam("feed-id") Long feedId) {
        postMarkService.execute(feedId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMark(@RequestParam("feed-id") Long feedId) {
        removeMarkService.execute(feedId);
    }
}
