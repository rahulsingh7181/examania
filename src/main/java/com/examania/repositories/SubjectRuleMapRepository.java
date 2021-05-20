package com.examania.repositories;

import com.examania.entities.SubjectRuleMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRuleMapRepository extends JpaRepository<SubjectRuleMapEntity, String> {
}
