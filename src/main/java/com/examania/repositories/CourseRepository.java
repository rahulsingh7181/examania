package com.examania.repositories;

import com.examania.entities.CourseEntity;
import com.examania.entities.UserRoleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, String> {

    @Query("SELECT u FROM CourseEntity u WHERE u.isActive = true")
    List<CourseEntity> findAllActiveCourses();
}
