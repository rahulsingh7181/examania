package com.examania.repositories;

import com.examania.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, String> {

    @Query("SELECT u FROM QuestionEntity u WHERE u.isActive = true")
    List<QuestionEntity> findAllActiveQuestions();
}
