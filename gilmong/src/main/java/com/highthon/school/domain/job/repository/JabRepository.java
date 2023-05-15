package com.highthon.school.domain.job.repository;

import com.highthon.school.domain.job.Jab;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JabRepository extends CrudRepository<Jab, String> {
    List<Jab> findAllByBranch(int branch);

    List<Jab> findAllByBranchOrderByName(int branch);

    List<Jab> findAllByBranchOrderByInterestCountDesc(int branch);

}
