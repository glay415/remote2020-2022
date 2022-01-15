package com.highthon.school.domain.job.repository;

import com.highthon.school.domain.job.Branch;
import com.highthon.school.domain.job.Jab;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JabRepository extends CrudRepository<Jab, String> {
    List<Jab> findAllByBranch(Branch branch);

    List<Jab> findAllByBranchOrderByName(Branch branch);

    List<Jab> findAllByBranchOrderByInterestCount(Branch branch);

}
