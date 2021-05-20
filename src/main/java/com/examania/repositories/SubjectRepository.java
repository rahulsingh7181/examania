package com.examania.repositories;

import com.examania.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, String> {

    @Query("SELECT u FROM SubjectEntity u WHERE u.isActive = true")
    List<SubjectEntity> findAllActiveSubjects();
}
