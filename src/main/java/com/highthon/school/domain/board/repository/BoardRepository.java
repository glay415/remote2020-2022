package com.highthon.school.domain.board.repository;

import com.highthon.school.domain.board.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
}
