package com.examania.services;

import com.examania.entities.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExamaniaService {

    /* UserRoleGroup Services */
    List<UserRoleGroupEntity> getUserRoles();
    UserRoleGroupEntity addUserRoles(UserRoleGroupEntity userRoleGroupEntity);
    UserRoleGroupEntity updateUserRoles(String userRoleGroupGuid, UserRoleGroupEntity userRoleGroupEntity);
    ResponseEntity<?> deleteUserRoles(String userRoleGroupGuid);
    List<UserRoleGroupEntity> getAllActiveUserRoleGroup();

    /* CourseEntity Services */
    List<CourseEntity> getAllCourses();
    CourseEntity addCourses(CourseEntity courseEntity);
    CourseEntity updateCourses(String courseGuid, CourseEntity courseEntity);
    ResponseEntity<?> deleteCourses(String courseGuid);
    List<CourseEntity> getAllActiveCourses();

    /* ExamEntity Services */
    List<ExamEntity> getAllExams();
    ExamEntity addExam(ExamEntity examEntity);
    ExamEntity updateExam(String examGuid, ExamEntity examEntity);
    ResponseEntity<?> deleteExam(String examGuid);
    List<ExamEntity> getAllActiveExams();

    /* QuestionEntity Services */
    List<QuestionEntity> getAllQuestions();
    QuestionEntity addQuestion(QuestionEntity questionEntity);
    QuestionEntity updateQuestion(String questionGuid, QuestionEntity questionEntity);
    ResponseEntity<?> deleteQuestion(String questionGuid);
    List<QuestionEntity> getAllActiveQuestion();

    /* RuleEntity Services */
    List<RuleEntity> getAllRules();
    RuleEntity addRule(RuleEntity ruleEntity);
    RuleEntity updateRule(String ruleGuid, RuleEntity ruleEntity);
    ResponseEntity<?> deleteRule(String ruleGuid);
    List<RuleEntity> getAllActiveRules();

    /* SubjectEntity Services */
    List<SubjectEntity> getAllSubjects();
    SubjectEntity addSubject(SubjectEntity subjectEntity);
    SubjectEntity updateSubject(String subjectGuid, SubjectEntity subjectEntity);
    ResponseEntity<?> deleteSubject(String subjectGuid);
    List<SubjectEntity> getAllActiveSubjects();

}
