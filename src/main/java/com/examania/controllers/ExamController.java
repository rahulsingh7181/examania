package com.examania.controllers;

import com.examania.entities.ExamEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "web/api/v1/exams")
public class ExamController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping
    public List<ExamEntity> getAllExams() {
        return examaniaService.getAllExams();
    }

    @PostMapping
    public ExamEntity addExams(@RequestBody ExamEntity examEntity) {
        return examaniaService.addExam(examEntity);
    }

    @PutMapping("/{examGuid}")
    public ExamEntity updateExam(@PathVariable String examGuid, @RequestBody ExamEntity examEntity) {
        return examaniaService.updateExam(examGuid, examEntity);
    }

    @DeleteMapping("/{examGuid}")
    public ResponseEntity<?> deleteExam(@PathVariable String examGuid) {
        return examaniaService.deleteExam(examGuid);
    }

    @GetMapping("/activeList")
    public List<ExamEntity> getAllActiveExams() {
        return examaniaService.getAllActiveExams();
    }
}
