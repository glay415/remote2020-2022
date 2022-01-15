package com.highthon.school.domain.job;

import com.highthon.school.domain.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Jab {
    @Id
    private String name;

    private Branch branch;

    @OneToMany
    private List<Board> boards;
}
