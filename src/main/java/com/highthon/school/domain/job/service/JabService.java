package com.highthon.school.domain.job.service;

import com.highthon.school.domain.job.Jab;
import com.highthon.school.domain.job.dto.CreateJabRequestDto;
import com.highthon.school.domain.job.repository.JabRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JabService {
    private final JabRepository jabRepository;
    private final InterestRepository interestRepository;

    public void createJab(CreateJabRequestDto req){
        jabRepository.save(
                Jab.builder()
                        .name(req.getName())
                        .intro(req.getIntro())
                        .branch(req.getBranch())
                        .build()
        );
    }
}
