package com.highthon.school.domain.interest;

import com.highthon.school.domain.job.Jab;
import com.highthon.school.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num;

    @JoinColumn(name = "id")
    @ManyToOne
    private Jab jab;

    @JoinColumn(name = "id")
    @ManyToOne
    private User user;
}
