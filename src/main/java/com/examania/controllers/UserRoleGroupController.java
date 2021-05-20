package com.examania.controllers;

import com.examania.entities.UserRoleGroupEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "web/api/v1/user-roles")
public class UserRoleGroupController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping("/{userRoleGroupGuid}")
    public Optional<UserRoleGroupEntity> getSingleUserRoles(@PathVariable String userRoleGroupGuid) {
        return examaniaService.getSingleUserRole(userRoleGroupGuid);
    }

    @GetMapping
    public List<UserRoleGroupEntity> getUserRoles() {
        return examaniaService.getUserRoles();
    }

    @PostMapping
    public ResponseEntity<?> addUserRoles(@RequestBody UserRoleGroupEntity userRoleGroupEntity) {
        return examaniaService.addUserRole(userRoleGroupEntity);
    }

    @PutMapping("/{userRoleGroupGuid}")
    public ResponseEntity<?> updateUserRoles(@PathVariable String userRoleGroupGuid, @RequestBody UserRoleGroupEntity userRoleGroupEntity) {
        return examaniaService.updateUserRole(userRoleGroupGuid, userRoleGroupEntity);
    }

    @DeleteMapping("/{userRoleGroupGuid}")
    public ResponseEntity<?> deleteUserRoles(@PathVariable String userRoleGroupGuid) {
        return examaniaService.deleteUserRole(userRoleGroupGuid);
    }

    @GetMapping("/activeList")
    public List<UserRoleGroupEntity> getAllActiveUserRoleGroup() {
        return examaniaService.getAllActiveUserRoleGroup();
    }
}
