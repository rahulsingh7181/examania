package com.examania.controllers;

import com.examania.entities.SubjectRuleMapEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "web/api/v1/subjectRuleMap")
public class SubjectRuleMapController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping("/{refSubRuleGuid}")
    public Optional<SubjectRuleMapEntity> getSingleSubjectRule(String refSubRuleGuid) {
        return examaniaService.getSingleSubjectRule(refSubRuleGuid);
    }

    @GetMapping
    public List<SubjectRuleMapEntity> getAllSubjectRule() {
        return examaniaService.getAllSubjectRule();
    }

    @PostMapping
    public ResponseEntity<?> addSubjectRule(@RequestBody SubjectRuleMapEntity courseSubjectMapEntity) {
        return examaniaService.addSubjectRule(courseSubjectMapEntity);
    }

    @PutMapping("/{refSubRuleGuid}")
    public ResponseEntity<?> updateSubjectRule(@PathVariable String refSubRuleGuid, @RequestBody SubjectRuleMapEntity courseSubjectMapEntity) {
        return examaniaService.updateSubjectRule(refSubRuleGuid, courseSubjectMapEntity);
    }

    @DeleteMapping("/{refSubRuleGuid}")
    public ResponseEntity<?> deleteSubjectRule(@PathVariable String refSubRuleGuid) {
        return examaniaService.deleteSubjectRule(refSubRuleGuid);
    }
}
