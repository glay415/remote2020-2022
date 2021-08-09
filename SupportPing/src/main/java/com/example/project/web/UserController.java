package com.example.project.web;

import com.example.project.config.auth.PrincipalDetails;
import com.example.project.web.dto.BoardResponse;
import com.example.project.domain.model.User;
import com.example.project.domain.repository.UserRepository;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/user/me/{user-id}")
    public BoardResponse mypage(@PathVariable(name = "user-id") Integer id) {
        return new BoardResponse(userService.myposts(id));
    }

    @PostMapping("/user/enter/{board-id}")
    public String enter(@AuthenticationPrincipal PrincipalDetails principal,
                                   @PathVariable(name = "board-id") Integer id) {
        return userService.enter(id, principal.getUser());
    }

    @DeleteMapping("/user/exit/{board-id}")
    public String exit(@AuthenticationPrincipal PrincipalDetails principal,
                       @PathVariable(name = "board-id") Integer id) {
        return userService.exit(id, principal.getUser());
    }

    // 어드민이 접근 가능
    @GetMapping("/admin/users")
    public List<User> users(){
        return userRepository.findAll();
    }

}