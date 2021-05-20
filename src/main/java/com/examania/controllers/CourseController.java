package com.examania.controllers;

import com.examania.entities.CourseEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "web/api/v1/courses")
public class CourseController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping("/{courseGuid}")
    public Optional<CourseEntity> getSingleCourse(String courseGuid) {
        return examaniaService.getSingleCourse(courseGuid);
    }

    @GetMapping
    public List<CourseEntity> getCourses() {
        return examaniaService.getAllCourses();
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CourseEntity courseEntity) {
        return examaniaService.addCourse(courseEntity);
    }

    @PutMapping("/{courseGuid}")
    public ResponseEntity<?> updateCourse(@PathVariable String courseGuid, @RequestBody CourseEntity courseEntity) {
        return examaniaService.updateCourse(courseGuid, courseEntity);
    }

    @DeleteMapping("/{courseGuid}")
    public ResponseEntity<?> deleteCourse(@PathVariable String courseGuid) {
        return examaniaService.deleteCourses(courseGuid);
    }

    @GetMapping("/activeList")
    public List<CourseEntity> getAllActiveCourses() {
        return examaniaService.getAllActiveCourses();
    }
}
