package com.examania.repositories;

import com.examania.entities.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, String> {

    @Query("SELECT u FROM ExamEntity u WHERE u.isActive = true")
    List<ExamEntity> findAllActiveExams();
}
