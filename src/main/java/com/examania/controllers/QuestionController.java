package com.examania.controllers;

import com.examania.entities.QuestionEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "web/api/v1/questions")
public class QuestionController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping("/{questionGuid}")
    public Optional<QuestionEntity> getSingleExam(@PathVariable String questionGuid) {
        return examaniaService.getSingleQuestion(questionGuid);
    }

    @GetMapping
    public List<QuestionEntity> getQuestions() {
        return examaniaService.getAllQuestions();
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@RequestBody QuestionEntity questionEntity) {
        return examaniaService.addQuestion(questionEntity);
    }

    @PutMapping("/{questionGuid}")
    public ResponseEntity<?> updateQuestion(@PathVariable String questionGuid, @RequestBody QuestionEntity questionEntity) {
        return examaniaService.updateQuestion(questionGuid, questionEntity);
    }

    @DeleteMapping("/{questionGuid}")
    public ResponseEntity<?> deleteQuestion(@PathVariable String questionGuid) {
        return examaniaService.deleteQuestion(questionGuid);
    }

    @GetMapping("/activeList")
    public List<QuestionEntity> getAllActiveQuestions() {
        return examaniaService.getAllActiveQuestion();
    }
}
