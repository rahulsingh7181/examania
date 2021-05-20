package com.examania.controllers;

import com.examania.entities.CourseSubjectMapEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "web/api/v1/courseSubjectMap")
public class CourseSubjectMapController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping("/{refCourseSubGuid}")
    public Optional<CourseSubjectMapEntity> getSingleCourseSubject(String refCourseSubGuid) {
        return examaniaService.getSingleCourseSubject(refCourseSubGuid);
    }

    @GetMapping
    public List<CourseSubjectMapEntity> getAllCourseSubject() {
        return examaniaService.getAllCourseSubject();
    }

    @PostMapping
    public ResponseEntity<?> addCourseSubject(@RequestBody CourseSubjectMapEntity courseSubjectMapEntity) {
        return examaniaService.addCourseSubject(courseSubjectMapEntity);
    }

    @PutMapping("/{refCourseSubGuid}")
    public ResponseEntity<?> updateCourseSubject(@PathVariable String refCourseSubGuid, @RequestBody CourseSubjectMapEntity courseSubjectMapEntity) {
        return examaniaService.updateCourseSubject(refCourseSubGuid, courseSubjectMapEntity);
    }

    @DeleteMapping("/{refCourseSubGuid}")
    public ResponseEntity<?> deleteCourseSubject(@PathVariable String refCourseSubGuid) {
        return examaniaService.deleteCourseSubject(refCourseSubGuid);
    }
}
