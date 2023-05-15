package com.example.appjambackend.domain.mark.service;

import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.mark.entity.Mark;
import com.example.appjambackend.domain.mark.entity.MarkRepository;
import com.example.appjambackend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostMarkService{

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final MarkRepository markRepository;

    public void execute(Long feedId) {
        markRepository.save(
                new Mark(feedFacade.getFeedId(feedId), userFacade.getCurrentUser())
        );
    }
}
