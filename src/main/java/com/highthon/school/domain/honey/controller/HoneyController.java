package com.highthon.school.domain.honey.controller;

import com.highthon.school.domain.honey.service.HoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/likes")
@RestController
public class HoneyController {

	private final HoneyService honeyService;

	@PostMapping
	public void like(@RequestParam Integer boardId) {
		honeyService.liked(boardId);
	}
}
