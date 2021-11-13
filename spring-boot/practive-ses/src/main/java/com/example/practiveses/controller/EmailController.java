package com.example.practiveses.controller;

import com.example.practiveses.dto.SenderDto;
import com.example.practiveses.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final SenderService senderService;

    @PostMapping("/send")
    public void send(@RequestBody SenderDto senderDto) {
        senderService.send(senderDto);
    }
}
