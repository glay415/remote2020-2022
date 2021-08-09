package com.example.project.service;

import com.example.project.web.dto.BoardResponse;
import com.example.project.domain.model.Participant;
import com.example.project.domain.model.User;
import com.example.project.domain.repository.BoardRepository;
import com.example.project.domain.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final BoardRepository boardRepository;
    private final ParticipantRepository participantRepository;

    public List<BoardResponse.BoardInfo> myposts(Integer userId) {
        List<BoardResponse.BoardInfo> boards = boardRepository.findAllByUserId(userId)
                .stream()
                .map(board -> new BoardResponse.BoardInfo(board.getId(), board.getTitle(), board.getContent(),
                        board.getPlace(), board.getPp(), board.getMp(), board.getUser(), board.getParticipants()))
                .collect(Collectors.toList());
        return boards;
    }

    public String enter(Integer id, User user) {
        Participant participant = Participant.builder()
                .name(user.getName())
                .board(boardRepository.getById(id))
                .user(user)
                .build();
        participantRepository.save(participant);

        List<Participant> participants = boardRepository.findById(id).get().getParticipants();
        participants.add(participant);

        Integer pp = boardRepository.findById(id).get().getPp();
        Integer finalPp = pp+1;

        boardRepository.findById(id)
                .map(board -> {
                    board.setParticipants(participants);
                    board.setPp(finalPp);
                    boardRepository.save(board);
                    return board;
                });

        return "success enter";
    }

    public String exit(Integer id, User user) {
        participantRepository.deleteByBoardIdAndUserId(id, user.getId());

        Integer pp = boardRepository.findById(id).get().getPp();
        Integer finalPp = pp-1;

        boardRepository.findById(id)
                .map(board -> {
                    board.setPp(finalPp);
                    boardRepository.save(board);
                    return board;
                });

        return "success exit";
    }

}
