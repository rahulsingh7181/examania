package com.examania.repositories;

import com.examania.entities.ExamRuleMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRuleMapRepository extends JpaRepository<ExamRuleMapEntity, String> {
}
