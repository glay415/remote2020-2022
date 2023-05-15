package com.highthon.school.domain.reply.controller;

import com.highthon.school.domain.reply.dto.ReplyResponseDto;
import com.highthon.school.domain.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/reply")
@RestController
public class ReplyController {

	private final ReplyService replyService;

	@PostMapping
	private ReplyResponseDto reply(@RequestParam Integer commentId, @RequestParam String content) {
		return replyService.reply(commentId, content);
	}

}
