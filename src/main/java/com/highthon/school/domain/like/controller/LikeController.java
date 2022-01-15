package com.highthon.school.domain.like.controller;

import com.highthon.school.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/likes")
@RestController
public class LikeController {

	private final LikeService likeService;

	@PostMapping
	public void like(@RequestParam Integer boardId) {
		likeService.liked(boardId);
	}
}
