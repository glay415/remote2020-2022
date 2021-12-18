package com.example.appjambackend.domain.feed.service;

import com.example.appjambackend.domain.feed.entity.Feed;
import com.example.appjambackend.domain.feed.facade.FeedFacade;
import com.example.appjambackend.domain.feed.presentation.dto.requset.ModifyFeedRequest;
import com.example.appjambackend.domain.image.facade.ImageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModifyFeedService {

    private final FeedFacade feedFacade;
    private final ImageFacade imageFacade;

    public void execute(Long feedId, ModifyFeedRequest request, List<MultipartFile> images) {

        Feed feed = feedFacade.getFeedId(request.getFeedId());

        feed
                .changeTitle(request.getTitle())
                .changeDescription(request.getTitle());

        if(images != null) {
            imageFacade.modifyImages(feed, images);
        }
    }

}
