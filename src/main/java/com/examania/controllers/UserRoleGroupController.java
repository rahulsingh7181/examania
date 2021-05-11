package com.examania.controllers;

import com.examania.entities.UserRoleGroupEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "web/api/v1/user-roles")
public class UserRoleGroupController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping
    public List<UserRoleGroupEntity> getUserRoles() {
        return examaniaService.getUserRoles();
    }

    @PostMapping
    public UserRoleGroupEntity addUserRoles(@RequestBody UserRoleGroupEntity userRoleGroupEntity) {
        return examaniaService.addUserRoles(userRoleGroupEntity);
    }

    @PutMapping("/{userRoleGroupGuid}")
    public UserRoleGroupEntity updateUserRoles(@PathVariable String userRoleGroupGuid, @RequestBody UserRoleGroupEntity userRoleGroupEntity) {
        return examaniaService.updateUserRoles(userRoleGroupGuid, userRoleGroupEntity);
    }

    @DeleteMapping("/{userRoleGroupGuid}")
    public ResponseEntity<?> deleteUserRoles(@PathVariable String userRoleGroupGuid) {
        return examaniaService.deleteUserRoles(userRoleGroupGuid);
    }

    @GetMapping("/activeList")
    public List<UserRoleGroupEntity> getAllActiveUserRoleGroup() {
        return examaniaService.getAllActiveUserRoleGroup();
    }
}
