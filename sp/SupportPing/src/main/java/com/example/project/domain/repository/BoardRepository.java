package com.example.project.domain.repository;

import com.example.project.domain.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAllByUserId(Integer userId);
}
