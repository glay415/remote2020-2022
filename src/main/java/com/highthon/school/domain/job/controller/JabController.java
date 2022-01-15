package com.highthon.school.domain.job.controller;

import com.highthon.school.domain.job.dto.CreateJabRequestDto;
import com.highthon.school.domain.job.service.JabService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JabController {
    private final JabService jabService;

    @PostMapping("/jab")
    public void CreateJab(CreateJabRequestDto req){
        jabService.createJab(req);
    }
}
