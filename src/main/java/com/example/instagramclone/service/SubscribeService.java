package com.example.instagramclone.service;

import com.example.instagramclone.domain.subscribe.Subscribe;
import com.example.instagramclone.domain.subscribe.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void subscribe(int fromUserId, int toUserId) {
        subscribeRepository.mSubscribe(fromUserId, toUserId);
    }

    @Transactional
    public void unsubscribe(int fromUserId, int toUserId) {
        subscribeRepository.mUnSubscribe(fromUserId, toUserId);
    }
}
