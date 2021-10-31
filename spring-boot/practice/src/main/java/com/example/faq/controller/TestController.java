package com.example.faq.controller;

import com.example.faq.entity.Board;
import com.example.faq.payload.BoardDto;
import com.example.faq.payload.CateDto;
import com.example.faq.repository.BoardRepository;
import com.example.faq.repository.Cate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final BoardRepository boardRepository;

    @PostMapping("/board")
    public String board(@RequestBody BoardDto boardDto){
        Board board = Board.builder()
                .name(boardDto.getName())
                .category(boardDto.getCategory())
                .build();
        boardRepository.save();
        return "create board success";
    }

    @GetMapping("/board")
    public List<Board> board2(){
        return boardRepository.findAll();
    }

    @GetMapping("/board/cate")
    public List<String> board3(){
        List<String> cate = boardRepository.findAllBy().stream().map(Cate::getcategory).distinct().collect(Collectors.toList());
        return cate;
    }

    @PostMapping("/board/cate")
    public List<Board> board4(@RequestBody CateDto cate){
        return boardRepository.findAllByCategory(cate.getCategory());
    }
}
