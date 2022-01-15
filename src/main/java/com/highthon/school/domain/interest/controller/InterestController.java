package com.highthon.school.domain.interest.controller;

import com.highthon.school.domain.interest.dto.InterestJabResponseDto;
import com.highthon.school.domain.interest.service.InterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class InterestController {
    private final InterestService interestService;

    @PostMapping("/interest/{name}")
    public void interestJab(@PathVariable(name = "name") String jabName){
        interestService.interestJab(jabName);
    }

    @GetMapping("/interest")
    public List<InterestJabResponseDto> getMyInterestJab(){
        return interestService.getInterestJab();
    }
}
