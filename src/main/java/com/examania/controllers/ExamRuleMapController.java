package com.examania.controllers;

import com.examania.entities.ExamRuleMapEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "web/api/v1/examRuleMap")
public class ExamRuleMapController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping("/{refExamRuleGuid}")
    public Optional<ExamRuleMapEntity> getSingleExamRule(String refExamRuleGuid) {
        return examaniaService.getSingleExamRule(refExamRuleGuid);
    }

    @GetMapping
    public List<ExamRuleMapEntity> getAllExamRule() {
        return examaniaService.getAllExamRule();
    }

    @PostMapping
    public ResponseEntity<?> addExamRule(@RequestBody ExamRuleMapEntity examRuleMapEntity) {
        return examaniaService.addExamRule(examRuleMapEntity);
    }

    @PutMapping("/{refExamRuleGuid}")
    public ResponseEntity<?> updateExamRule(@PathVariable String refExamRuleGuid, @RequestBody ExamRuleMapEntity examRuleMapEntity) {
        return examaniaService.updateExamRule(refExamRuleGuid, examRuleMapEntity);
    }

    @DeleteMapping("/{refExamRuleGuid}")
    public ResponseEntity<?> deleteExamRule(@PathVariable String refExamRuleGuid) {
        return examaniaService.deleteExamRule(refExamRuleGuid);
    }
}
