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
    private String intro;
    private Branch branch;
    private int interestCount;
    @OneToMany
    private List<Board> boards;

    public void minusInterestCount(){ // 리팩토링 후 protected
        this.interestCount--;
    }

    public void plusInterestCount(){
        this.interestCount++;
    }
}
