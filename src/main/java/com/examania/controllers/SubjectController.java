package com.examania.controllers;

import com.examania.entities.ExamEntity;
import com.examania.entities.SubjectEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "web/api/v1/subjects")
public class SubjectController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping
    public List<SubjectEntity> getAllSubjects() {
        return examaniaService.getAllSubjects();
    }

    @PostMapping
    public SubjectEntity addSubject(@RequestBody SubjectEntity subjectEntity) {
        return examaniaService.addSubject(subjectEntity);
    }

    @PutMapping("/{subjectGuid}")
    public SubjectEntity updateSubject(@PathVariable String subjectGuid, @RequestBody SubjectEntity subjectEntity) {
        return examaniaService.updateSubject(subjectGuid, subjectEntity);
    }

    @DeleteMapping("/{subjectGuid}")
    public ResponseEntity<?> deleteSubject(@PathVariable String subjectGuid) {
        return examaniaService.deleteSubject(subjectGuid);
    }

    @GetMapping("/activeList")
    public List<SubjectEntity> getAllActiveSubject() {
        return examaniaService.getAllActiveSubjects();
    }
}
