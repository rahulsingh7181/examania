package com.examania.services.impl;

import com.examania.entities.*;
import com.examania.exception.ResourceNotFoundException;
import com.examania.repositories.*;
import com.examania.services.ExamaniaService;
import com.examania.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamaniaServiceImpl implements ExamaniaService {

    @Autowired
    private UserRoleGroupRepository userRoleGroupRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private SubjectRepository subjectRepository;


    @Autowired
    private HttpServletRequest httpServletRequest;

    /* ------------------------------------------ UserRoleGroup Services ------------------------------------------------------------------- */
    @Override
    public List<UserRoleGroupEntity> getUserRoles() {
        return userRoleGroupRepository.findAll();
    }

    @Override
    public UserRoleGroupEntity addUserRoles(UserRoleGroupEntity userRoleGroupEntity) {
        userRoleGroupEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
        return userRoleGroupRepository.save(userRoleGroupEntity);
    }

    @Override
    public UserRoleGroupEntity updateUserRoles(String userRoleGroupGuid, UserRoleGroupEntity userRoleGroupEntity) {
        return userRoleGroupRepository.findById(userRoleGroupGuid)
                .map(userRoles -> {
                    userRoles.setUserRoleGroupCode(userRoleGroupEntity.getUserRoleGroupCode().trim());
                    userRoles.setUserRoleGroupName(userRoleGroupEntity.getUserRoleGroupName().trim());
                    userRoles.setUserRoleGroupDescription(userRoleGroupEntity.getUserRoleGroupDescription().trim());
                    userRoles.setIsActive(userRoleGroupEntity.getIsActive());
                    userRoles.setFromDate(userRoleGroupEntity.getFromDate());
                    userRoles.setToDate(userRoleGroupEntity.getToDate());
                    userRoles.setModifiedBy("SUPER_ADMIN".trim());
                    userRoles.setModifiedDate(new Date());
                    userRoles.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    userRoles.setModifiedRemarks(userRoleGroupEntity.getModifiedRemarks());
                    return userRoleGroupRepository.save(userRoles);
                }).orElseThrow(() -> new ResourceNotFoundException("UserRole not found with guid : " + userRoleGroupGuid));
    }

    @Override
    public ResponseEntity<?> deleteUserRoles(String userRoleGroupGuid) {
        return userRoleGroupRepository.findById(userRoleGroupGuid)
                .map(userRole -> {
                    userRoleGroupRepository.delete(userRole);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("UserRole not found with guid : " + userRoleGroupGuid));
    }

    @Override
    public List<UserRoleGroupEntity> getAllActiveUserRoleGroup(){
        List<UserRoleGroupEntity> list = userRoleGroupRepository.findAllActiveUsers();
        return list.stream()
                .sorted(Comparator.comparing(UserRoleGroupEntity::getUserRoleGroupName))
                .collect(Collectors.toList());
    }


    /* ------------------------------------------ CourseEntity Services ------------------------------------------------------------------- */
    @Override
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseEntity addCourses(CourseEntity courseEntity) {
        courseEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
        return courseRepository.save(courseEntity);
    }

    @Override
    public CourseEntity updateCourses(String courseGuid, CourseEntity courseEntity) {
        return courseRepository.findById(courseGuid)
                .map(courses -> {
                    courses.setCourseCode(courseEntity.getCourseCode().trim());
                    courses.setCourseNameEn(courseEntity.getCourseNameEn().trim());
                    courses.setCourseDescription(courseEntity.getCourseDescription().trim());
                    courses.setIsActive(courseEntity.getIsActive());
                    courses.setModifiedBy("SUPER_ADMIN".trim());
                    courses.setModifiedDate(new Date());
                    courses.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    courses.setModifiedRemarks(courseEntity.getModifiedRemarks());
                    return courseRepository.save(courses);
                }).orElseThrow(() -> new ResourceNotFoundException("Course not found with guid : " + courseGuid));
    }

    @Override
    public ResponseEntity<?> deleteCourses(String courseGuid) {
        return courseRepository.findById(courseGuid)
                .map(userRole -> {
                    courseRepository.delete(userRole);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Course not found with guid : " + courseGuid));
    }

    @Override
    public List<CourseEntity> getAllActiveCourses(){
        List<CourseEntity> list = courseRepository.findAllActiveCourses();
        return list.stream()
                .sorted(Comparator.comparing(CourseEntity::getCourseNameEn))
                .collect(Collectors.toList());
    }


    /* ------------------------------------------ ExamEntity Services ------------------------------------------------------------------- */

    @Override
    public List<ExamEntity> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public ExamEntity addExam(ExamEntity examEntity) {
        examEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
        return examRepository.save(examEntity);
    }

    @Override
    public ExamEntity updateExam(String examGuid, ExamEntity examEntity) {
        return examRepository.findById(examGuid)
                .map(exams -> {
                    exams.setExamCode(examEntity.getExamCode().trim());
                    exams.setExamNameEn(examEntity.getExamNameEn().trim());
                    exams.setExamDescription(examEntity.getExamDescription().trim());
                    exams.setStartNoticeDateTime(examEntity.getStartNoticeDateTime());
                    exams.setEndNoticeDateTime(examEntity.getEndNoticeDateTime());
                    exams.setStartDateTime(examEntity.getStartDateTime());
                    exams.setEndDateTime(examEntity.getEndDateTime());
                    exams.setIsActive(examEntity.getIsActive());
                    exams.setModifiedBy("SUPER_ADMIN".trim());
                    exams.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    exams.setModifiedDate(new Date());
                    exams.setModifiedRemarks(examEntity.getModifiedRemarks());
                    return examRepository.save(exams);
                }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with guid : " + examGuid));
    }

    @Override
    public ResponseEntity<?> deleteExam(String examGuid) {
        return examRepository.findById(examGuid)
                .map(exam -> {
                    examRepository.delete(exam);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with guid : " + examGuid));
    }

    @Override
    public List<ExamEntity> getAllActiveExams(){
        List<ExamEntity> list = examRepository.findAllActiveExams();
        return list.stream()
                .sorted(Comparator.comparing(ExamEntity::getExamNameEn))
                .collect(Collectors.toList());
    }

    /* ------------------------------------------ QuestionEntity Services ------------------------------------------------------------------- */

    @Override
    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionEntity addQuestion(QuestionEntity questionEntity) {
        questionEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
        return questionRepository.save(questionEntity);
    }

    @Override
    public QuestionEntity updateQuestion(String questionGuid, QuestionEntity questionEntity) {
        return questionRepository.findById(questionGuid)
                .map(question -> {
                    question.setQuestionCode(questionEntity.getQuestionCode().trim());
                    question.setQuestionDescriptionEn(questionEntity.getQuestionDescriptionEn().trim());
                    question.setAnswerDescriptionEn(questionEntity.getAnswerDescriptionEn().trim());
                    question.setIsActive(questionEntity.getIsActive());
                    question.setModifiedBy("SUPER_ADMIN".trim());
                    question.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    question.setModifiedDate(new Date());
                    question.setModifiedRemarks(questionEntity.getModifiedRemarks());
                    return questionRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with guid : " + questionGuid));
    }

    @Override
    public ResponseEntity<?> deleteQuestion(String questionGuid) {
        return questionRepository.findById(questionGuid)
                .map(question -> {
                    questionRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with guid : " + questionGuid));
    }

    @Override
    public List<QuestionEntity> getAllActiveQuestion(){
        List<QuestionEntity> list = questionRepository.findAllActiveQuestions();
        return list.stream()
                .sorted(Comparator.comparing(QuestionEntity::getQuestionDescriptionEn))
                .collect(Collectors.toList());
    }


    /* ------------------------------------------ RuleEntity Services ------------------------------------------------------------------- */

    @Override
    public List<RuleEntity> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public RuleEntity addRule(RuleEntity ruleEntity) {
        ruleEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
        return ruleRepository.save(ruleEntity);
    }

    @Override
    public RuleEntity updateRule(String ruleGuid, RuleEntity ruleEntity) {
        return ruleRepository.findById(ruleGuid)
                .map(rule -> {
                    rule.setRuleCode(ruleEntity.getRuleCode().trim());
                    rule.setRuleNameEn(ruleEntity.getRuleNameEn().trim());
                    rule.setRuleDescription(ruleEntity.getRuleDescription().trim());
                    rule.setIsActive(ruleEntity.getIsActive());
                    rule.setModifiedBy("SUPER_ADMIN".trim());
                    rule.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    rule.setModifiedDate(new Date());
                    rule.setModifiedRemarks(ruleEntity.getModifiedRemarks());
                    return ruleRepository.save(rule);
                }).orElseThrow(() -> new ResourceNotFoundException("Rule not found with guid : " + ruleGuid));
    }

    @Override
    public ResponseEntity<?> deleteRule(String ruleGuid) {
        return ruleRepository.findById(ruleGuid)
                .map(rule -> {
                    ruleRepository.delete(rule);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Rule not found with guid : " + ruleGuid));
    }

    @Override
    public List<RuleEntity> getAllActiveRules(){
        List<RuleEntity> list = ruleRepository.findAllActiveRules();
        return list.stream()
                .sorted(Comparator.comparing(RuleEntity::getRuleNameEn))
                .collect(Collectors.toList());
    }

    /* ------------------------------------------ SubjectEntity Services ------------------------------------------------------------------- */

    @Override
    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public SubjectEntity addSubject(SubjectEntity subjectEntity) {
        subjectEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public SubjectEntity updateSubject(String subjectGuid, SubjectEntity subjectEntity) {
        return subjectRepository.findById(subjectGuid)
                .map(subject -> {
                    subject.setSubjectCode(subjectEntity.getSubjectCode().trim());
                    subject.setSubjectNameEn(subjectEntity.getSubjectNameEn().trim());
                    subject.setSubjectDescription(subjectEntity.getSubjectDescription().trim());
                    subject.setSubjectTotalMarks(subjectEntity.getSubjectTotalMarks().trim());
                    subject.setSubjectPassMarks(subjectEntity.getSubjectPassMarks().trim());
                    subject.setIsActive(subjectEntity.getIsActive());
                    subject.setModifiedBy("SUPER_ADMIN".trim());
                    subject.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    subject.setModifiedDate(new Date());
                    subject.setModifiedRemarks(subjectEntity.getModifiedRemarks());
                    return subjectRepository.save(subject);
                }).orElseThrow(() -> new ResourceNotFoundException("Rule not found with guid : " + subjectGuid));
    }

    @Override
    public ResponseEntity<?> deleteSubject(String subjectGuid) {
        return subjectRepository.findById(subjectGuid)
                .map(subject -> {
                    subjectRepository.delete(subject);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Rule not found with guid : " + subjectGuid));
    }

    @Override
    public List<SubjectEntity> getAllActiveSubjects(){
        List<SubjectEntity> list = subjectRepository.findAllActiveSubjects();
        return list.stream()
                .sorted(Comparator.comparing(SubjectEntity::getSubjectNameEn))
                .collect(Collectors.toList());
    }

}
