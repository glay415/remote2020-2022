package com.highthon.school.domain.board.repository;

import com.highthon.school.domain.board.Board;
import com.highthon.school.domain.board.Step;
import com.highthon.school.domain.job.Jab;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {
	List<Board> findByStepAndJab(Step step, Jab jab);
	List<Board> findByContentContaining(String content);
}
