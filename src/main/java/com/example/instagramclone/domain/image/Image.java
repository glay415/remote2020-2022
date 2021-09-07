package com.example.instagramclone.domain.image;

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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption;
    private String postImageUrl;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    // + 좋아요 댓글

    private LocalDateTime createDate;

    @PrePersist
    private void createDate(){
        this.createDate = LocalDateTime.now();
    }

}
