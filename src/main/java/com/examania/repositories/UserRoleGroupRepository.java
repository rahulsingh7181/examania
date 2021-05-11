package com.examania.repositories;

import com.examania.entities.UserRoleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleGroupRepository extends JpaRepository<UserRoleGroupEntity, String> {

    @Query("SELECT u FROM UserRoleGroupEntity u WHERE u.isActive = true")
    List<UserRoleGroupEntity> findAllActiveUsers();
}
