package com.example.appjambackend.domain.mark.service;

import com.example.appjambackend.domain.mark.entity.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RemoveMarkService {

    private final MarkRepository markRepository;

    public void execute(Long feedId) {
        markRepository.deleteById(feedId);
    }
}
