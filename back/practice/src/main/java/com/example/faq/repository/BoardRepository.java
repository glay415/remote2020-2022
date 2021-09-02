package com.example.faq.repository;

import com.example.faq.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Cate> findAllBy();
    List<Board> findAllByCategory(String cate);
}
