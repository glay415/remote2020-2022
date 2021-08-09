package com.example.project.web;

import com.example.project.config.auth.PrincipalDetails;
import com.example.project.web.dto.BoardRequest;
import com.example.project.web.dto.BoardResponse;
import com.example.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public BoardResponse read() {
        return new BoardResponse(boardService.read());
    }

    @PostMapping("/user/post")
    public String create(@RequestBody BoardRequest boardRequest,
                         @AuthenticationPrincipal PrincipalDetails principal) {
        return boardService.create(boardRequest, principal.getUser());
    }

    @PatchMapping("/user/update/{board-id}")
    public String update(@RequestBody BoardRequest boardRequest,
                         @AuthenticationPrincipal PrincipalDetails principal,
                         @PathVariable(name = "board-id") Integer id) {
        return boardService.update(boardRequest, principal.getUser(), id);
    }

    @DeleteMapping("/user/delete/{board-id}")
    public String delete(@AuthenticationPrincipal PrincipalDetails principal,
                         @PathVariable(name = "board-id") Integer id) {
        return boardService.delete(principal.getUser(), id);
    }

}
