package com.examania.controllers;

import com.examania.entities.CourseEntity;
import com.examania.services.ExamaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "web/api/v1/courses")
public class CourseController {

    @Autowired
    private ExamaniaService examaniaService;

    @GetMapping
    public List<CourseEntity> getCourses() {
        return examaniaService.getAllCourses();
    }

    @PostMapping
    public CourseEntity addCourse(@RequestBody CourseEntity courseEntity) {
        return examaniaService.addCourses(courseEntity);
    }

    @PutMapping("/{courseGuid}")
    public CourseEntity updateCourse(@PathVariable String courseGuid, @RequestBody CourseEntity courseEntity) {
        return examaniaService.updateCourses(courseGuid, courseEntity);
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
