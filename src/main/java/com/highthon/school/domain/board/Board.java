package com.highthon.school.domain.board;

import com.highthon.school.domain.board.dto.CreateBoardRequestDto;
import com.highthon.school.domain.like.Like;
import com.highthon.school.domain.user.User;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private Step step;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Like> likeList;

    public Board(CreateBoardRequestDto createBoardRequest, User user) {
        this.title = createBoardRequest.getTitle();
        this.content = createBoardRequest.getContent();
        this.step = createBoardRequest.getStep();
        this.user = user;
    }
}
