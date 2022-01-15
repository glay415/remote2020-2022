package com.highthon.school.domain.job;

import com.highthon.school.domain.board.Board;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Jab {
    @Id
    private String name;

    @OneToMany
    private List<Board> boards;
    // 카테고리 이넘
}
