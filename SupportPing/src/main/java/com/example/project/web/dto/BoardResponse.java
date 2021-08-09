package com.example.project.web.dto;

import com.example.project.domain.model.Participant;
import com.example.project.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {
    List<BoardInfo> boardInfos;

    @Getter
    @AllArgsConstructor
    public static class BoardInfo {
        private Integer id;
        private String title;
        private String content;
        private String place;
        private Integer mp;
        private Integer pp;
        private User user;
        private List<Participant> participants;
    }

}
