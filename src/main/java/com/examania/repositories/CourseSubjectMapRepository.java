package com.examania.repositories;

import com.examania.entities.CourseSubjectMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSubjectMapRepository extends JpaRepository<CourseSubjectMapEntity, String> {
}
