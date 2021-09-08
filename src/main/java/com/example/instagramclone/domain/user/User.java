package com.example.instagramclone.domain.user;

import com.example.instagramclone.domain.image.Image;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
    private String website;
    private String bio;

    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl;
    private String role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Image> images;

    private LocalDateTime createDate;

    @PrePersist
    private void createDate(){
        this.createDate = LocalDateTime.now();
    }
}
