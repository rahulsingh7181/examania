package com.examania.services;

import com.examania.entities.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ExamaniaService {

    /* UserRoleGroup Services */
    Optional<UserRoleGroupEntity> getSingleUserRole(String userRoleGroupGuid);
    List<UserRoleGroupEntity> getUserRoles();
    ResponseEntity<?> addUserRole(UserRoleGroupEntity userRoleGroupEntity);
    ResponseEntity<?> updateUserRole(String userRoleGroupGuid, UserRoleGroupEntity userRoleGroupEntity);
    ResponseEntity<?> deleteUserRole(String userRoleGroupGuid);
    List<UserRoleGroupEntity> getAllActiveUserRoleGroup();

    /* CourseEntity Services */
    Optional<CourseEntity> getSingleCourse(String courseGuid);
    List<CourseEntity> getAllCourses();
    ResponseEntity<?> addCourse(CourseEntity courseEntity);
    ResponseEntity<?> updateCourse(String courseGuid, CourseEntity courseEntity);
    ResponseEntity<?> deleteCourses(String courseGuid);
    List<CourseEntity> getAllActiveCourses();

    /* ExamEntity Services */
    Optional<ExamEntity> getSingleExam(String examGuid);
    List<ExamEntity> getAllExams();
    ResponseEntity<?> addExam(ExamEntity examEntity);
    ResponseEntity<?> updateExam(String examGuid, ExamEntity examEntity);
    ResponseEntity<?> deleteExam(String examGuid);
    List<ExamEntity> getAllActiveExams();

    /* QuestionEntity Services */
    Optional<QuestionEntity> getSingleQuestion(String questionGuid);
    List<QuestionEntity> getAllQuestions();
    ResponseEntity<?> addQuestion(QuestionEntity questionEntity);
    ResponseEntity<?> updateQuestion(String questionGuid, QuestionEntity questionEntity);
    ResponseEntity<?> deleteQuestion(String questionGuid);
    List<QuestionEntity> getAllActiveQuestion();

    /* RuleEntity Services */
    Optional<RuleEntity> getSingleRule(String ruleGuid);
    List<RuleEntity> getAllRules();
    ResponseEntity<?> addRule(RuleEntity ruleEntity);
    ResponseEntity<?> updateRule(String ruleGuid, RuleEntity ruleEntity);
    ResponseEntity<?> deleteRule(String ruleGuid);
    List<RuleEntity> getAllActiveRules();

    /* SubjectEntity Services */
    Optional<SubjectEntity> getSingleSubject(String subjectGuid);
    List<SubjectEntity> getAllSubjects();
    ResponseEntity<?> addSubject(SubjectEntity subjectEntity);
    ResponseEntity<?> updateSubject(String subjectGuid, SubjectEntity subjectEntity);
    ResponseEntity<?> deleteSubject(String subjectGuid);
    List<SubjectEntity> getAllActiveSubjects();

    /* CourseSubjectMap Services */
    Optional<CourseSubjectMapEntity> getSingleCourseSubject(String refCourseSubGuid);
    List<CourseSubjectMapEntity> getAllCourseSubject();
    ResponseEntity<?> addCourseSubject(CourseSubjectMapEntity courseSubjectMapEntity);
    ResponseEntity<?> updateCourseSubject(String refCourseSubGuid, CourseSubjectMapEntity courseSubjectMapEntity);
    ResponseEntity<?> deleteCourseSubject(String refCourseSubGuid);

    /* SubjectRuleMap Services */
    Optional<SubjectRuleMapEntity> getSingleSubjectRule(String refSubRuleGuid);
    List<SubjectRuleMapEntity> getAllSubjectRule();
    ResponseEntity<?> addSubjectRule(SubjectRuleMapEntity courseSubjectMapEntity);
    ResponseEntity<?> updateSubjectRule(String refSubRuleGuid, SubjectRuleMapEntity courseSubjectMapEntity);
    ResponseEntity<?> deleteSubjectRule(String refSubRuleGuid);

    /* SubjectRuleMap Services */
    Optional<ExamRuleMapEntity> getSingleExamRule(String refExamRuleGuid);
    List<ExamRuleMapEntity> getAllExamRule();
    ResponseEntity<?> addExamRule(ExamRuleMapEntity examRuleMapEntity);
    ResponseEntity<?> updateExamRule(String refExamRuleGuid, ExamRuleMapEntity examRuleMapEntity);
    ResponseEntity<?> deleteExamRule(String refExamRuleGuid);

}
