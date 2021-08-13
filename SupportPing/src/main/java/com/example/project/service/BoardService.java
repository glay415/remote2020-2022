package com.example.project.service;

import com.example.project.web.dto.BoardRequest;
import com.example.project.web.dto.BoardResponse;
import com.example.project.domain.model.Board;
import com.example.project.domain.model.User;
import com.example.project.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardResponse.BoardInfo> read() {
        List<BoardResponse.BoardInfo> boards = boardRepository.findAll()
                .stream()
                .map(board -> new BoardResponse.BoardInfo(board.getId(), board.getTitle(), board.getContent(),
                        board.getPlace(), board.getPp(), board.getMp(), board.getUser(), board.getParticipants()))
                .collect(Collectors.toList());
        return boards;
    }

    public String create(BoardRequest boardRequest, User user) {
        Board board = Board.builder()
                .title(boardRequest.getTitle())
                .content(boardRequest.getContent())
                .place(boardRequest.getPlace())
                .pp(0)
                .mp(boardRequest.getMp())
                .user(user)
                .build();
        board.setUser(user);
        boardRepository.save(board);

        return "success create";
    }

    public String update(BoardRequest boardRequest, User user, Integer boardId) {

        boardRepository.findById(boardId)
                .map(board -> {
                    board.setTitle(boardRequest.getTitle());
                    board.setContent(boardRequest.getContent());
                    board.setPlace(boardRequest.getPlace());
                    board.setMp(boardRequest.getMp());
                    board.setUser(user);
                    boardRepository.save(board);
                    return board;
                });

        return "success update";
    }

    public String delete(Integer boardId) {
        boardRepository.deleteById(boardId);
        return "success delete";
    }

}
