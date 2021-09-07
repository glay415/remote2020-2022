package com.example.instagramclone.domain.subscribe;

import com.example.instagramclone.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "subscribe-uk",
                        columnNames = {"fromUserId", "toUserId"}
                )
        }
)
public class Subscribe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "fromUserId")
    @ManyToOne
    private User fromUser;

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser;


    private LocalDateTime createDate;

    @PrePersist
    private void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
