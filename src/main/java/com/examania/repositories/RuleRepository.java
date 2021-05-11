package com.examania.repositories;

import com.examania.entities.RuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends JpaRepository<RuleEntity, String> {

    @Query("SELECT u FROM RuleEntity u WHERE u.isActive = true")
    List<RuleEntity> findAllActiveRules();
}
