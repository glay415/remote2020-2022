package com.highthon.school.domain.job.controller;

import com.highthon.school.domain.job.Branch;
import com.highthon.school.domain.job.dto.CreateJabRequestDto;
import com.highthon.school.domain.job.dto.JabInfoResponseDto;
import com.highthon.school.domain.job.service.JabService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JabController {
    private final JabService jabService;

    @PostMapping("/jab")
    public void createJab(@RequestBody CreateJabRequestDto req){
        jabService.createJab(req);
    }

    @GetMapping("/jab-list/{branch}")
    public List<JabInfoResponseDto> jabList(@PathVariable Branch branch){
        return jabService.jabList(branch, "token");
    }

    @GetMapping("/jab/{name}")
    public JabInfoResponseDto getJab(@PathVariable String name){
        return jabService.getJabDetails(name, "userId");
    }
}
