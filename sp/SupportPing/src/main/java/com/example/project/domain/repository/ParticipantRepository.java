package com.example.project.domain.repository;

import com.example.project.domain.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    Optional<Participant> deleteByBoardIdAndUserId(Integer boardId, Integer userId);
}
