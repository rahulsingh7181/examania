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
import java.util.Optional;
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
    private CourseSubjectMapRepository courseSubjectMapRepository;
    @Autowired
    private SubjectRuleMapRepository subjectRuleMapRepository;
    @Autowired
    private ExamRuleMapRepository examRuleMapRepository;


    @Autowired
    private HttpServletRequest httpServletRequest;

    /* ------------------------------------------ UserRoleGroup Services ------------------------------------------------------------------- */
    @Override
    public Optional<UserRoleGroupEntity> getSingleUserRole(String userRoleGroupGuid){
        return userRoleGroupRepository.findById(userRoleGroupGuid)
                .map(userRole -> {
                    return userRoleGroupRepository.findById(userRole.getUserRoleGroupGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("UserRole not found with guid : " + userRoleGroupGuid));
    }

    @Override
    public List<UserRoleGroupEntity> getUserRoles() {
        return userRoleGroupRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addUserRole(UserRoleGroupEntity userRoleGroupEntity) {
        if(userRoleGroupEntity != null){
            userRoleGroupEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            userRoleGroupRepository.save(userRoleGroupEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }

    }

    @Override
    public ResponseEntity<?> updateUserRole(String userRoleGroupGuid, UserRoleGroupEntity userRoleGroupEntity) {
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
                    userRoleGroupRepository.save(userRoles);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("UserRole not found with guid : " + userRoleGroupGuid));
    }

    @Override
    public ResponseEntity<?> deleteUserRole(String userRoleGroupGuid) {
        return userRoleGroupRepository.findById(userRoleGroupGuid)
                .map(userRole -> {
                    userRoleGroupRepository.delete(userRole);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
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
    public Optional<CourseEntity> getSingleCourse(String courseGuid){
        return courseRepository.findById(courseGuid)
                .map(course -> {
                    return courseRepository.findById(course.getCourseGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Course not found with guid : " + courseGuid));
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addCourse(CourseEntity courseEntity) {
        if (courseEntity != null){
            courseEntity.setCreatedBy("SUPER_ADMIN".trim());
            courseEntity.setCreatedDate(new Date());
            courseEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest).trim());
            courseRepository.save(courseEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateCourse(String courseGuid, CourseEntity courseEntity) {
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
                    courseRepository.save(courses);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Course not found with guid : " + courseGuid));
    }

    @Override
    public ResponseEntity<?> deleteCourses(String courseGuid) {
        return courseRepository.findById(courseGuid)
                .map(userRole -> {
                    courseRepository.delete(userRole);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
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
    public Optional<ExamEntity> getSingleExam(String examGuid){
        return examRepository.findById(examGuid)
                .map(exam -> {
                    return examRepository.findById(exam.getExamGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with guid : " + examGuid));
    }

    @Override
    public List<ExamEntity> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addExam(ExamEntity examEntity) {
        if (examEntity != null){
            examEntity.setStartNoticeDateTime(examEntity.getStartNoticeDateTime());
            examEntity.setEndNoticeDateTime(examEntity.getEndNoticeDateTime());
            examEntity.setStartDateTime(examEntity.getStartDateTime());
            examEntity.setEndDateTime(examEntity.getEndDateTime());
            examEntity.setCreatedBy("SUPER_ADMIN".trim());
            examEntity.setCreatedDate(new Date());
            examEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            examRepository.save(examEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateExam(String examGuid, ExamEntity examEntity) {
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
                    examRepository.save(exams);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Exam not found with guid : " + examGuid));
    }

    @Override
    public ResponseEntity<?> deleteExam(String examGuid) {
        return examRepository.findById(examGuid)
                .map(exam -> {
                    examRepository.delete(exam);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
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
    public Optional<QuestionEntity> getSingleQuestion(String questionGuid){
        return questionRepository.findById(questionGuid)
                .map(question -> {
                    return questionRepository.findById(question.getQuestionGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with guid : " + questionGuid));
    }

    @Override
    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addQuestion(QuestionEntity questionEntity) {
        if (questionEntity != null){
            questionEntity.setCreatedBy("SUPER_ADMIN".trim());
            questionEntity.setCreatedDate(new Date());
            questionEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            questionRepository.save(questionEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateQuestion(String questionGuid, QuestionEntity questionEntity) {
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
                    questionRepository.save(question);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with guid : " + questionGuid));
    }

    @Override
    public ResponseEntity<?> deleteQuestion(String questionGuid) {
        return questionRepository.findById(questionGuid)
                .map(question -> {
                    questionRepository.delete(question);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
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
    public Optional<RuleEntity> getSingleRule(String ruleGuid){
        return ruleRepository.findById(ruleGuid)
                .map(rule -> {
                    return ruleRepository.findById(rule.getRuleGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Rule not found with guid : " + ruleGuid));
    }

    @Override
    public List<RuleEntity> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addRule(RuleEntity ruleEntity) {
        if (ruleEntity != null){
            ruleEntity.setCreatedBy("SUPER_ADMIN".trim());
            ruleEntity.setCreatedDate(new Date());
            ruleEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            ruleRepository.save(ruleEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateRule(String ruleGuid, RuleEntity ruleEntity) {
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
                    ruleRepository.save(rule);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Rule not found with guid : " + ruleGuid));
    }

    @Override
    public ResponseEntity<?> deleteRule(String ruleGuid) {
        return ruleRepository.findById(ruleGuid)
                .map(rule -> {
                    ruleRepository.delete(rule);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
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
    public Optional<SubjectEntity> getSingleSubject(String subjectGuid){
        return subjectRepository.findById(subjectGuid)
                .map(subject -> {
                    return subjectRepository.findById(subject.getSubjectGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + subjectGuid));
    }

    @Override
    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addSubject(SubjectEntity subjectEntity) {
        if (subjectEntity != null){
            subjectEntity.setCreatedBy("SUPER_ADMIN".trim());
            subjectEntity.setCreatedDate(new Date());
            subjectEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            subjectRepository.save(subjectEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateSubject(String subjectGuid, SubjectEntity subjectEntity) {
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
                    subjectRepository.save(subject);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + subjectGuid));
    }

    @Override
    public ResponseEntity<?> deleteSubject(String subjectGuid) {
        return subjectRepository.findById(subjectGuid)
                .map(subject -> {
                    subjectRepository.delete(subject);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + subjectGuid));
    }

    @Override
    public List<SubjectEntity> getAllActiveSubjects(){
        List<SubjectEntity> list = subjectRepository.findAllActiveSubjects();
        return list.stream()
                .sorted(Comparator.comparing(SubjectEntity::getSubjectNameEn))
                .collect(Collectors.toList());
    }

    /* ------------------------------------------ CourseSubjectMap Services ------------------------------------------------------------------- */
    @Override
    public Optional<CourseSubjectMapEntity> getSingleCourseSubject(String refCourseSubGuid){
        return courseSubjectMapRepository.findById(refCourseSubGuid)
                .map(courseSubject -> {
                    return courseSubjectMapRepository.findById(courseSubject.getRefCourseSubGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refCourseSubGuid));
    }

    @Override
    public List<CourseSubjectMapEntity> getAllCourseSubject() {
        return courseSubjectMapRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addCourseSubject(CourseSubjectMapEntity courseSubjectMapEntity) {
        if (courseSubjectMapEntity != null){
            courseSubjectMapEntity.setCourseEntity(new CourseEntity(courseSubjectMapEntity.getCourseEntity().getCourseGuid()));
            courseSubjectMapEntity.setSubjectEntity(new SubjectEntity(courseSubjectMapEntity.getSubjectEntity().getSubjectGuid()));
            courseSubjectMapEntity.setCreatedBy("SUPER_ADMIN".trim());
            courseSubjectMapEntity.setCreatedDate(new Date());
            courseSubjectMapEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            courseSubjectMapRepository.save(courseSubjectMapEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateCourseSubject(String refCourseSubGuid, CourseSubjectMapEntity courseSubjectMapEntity) {
        return courseSubjectMapRepository.findById(refCourseSubGuid)
                .map(courseSubject -> {
                    courseSubject.setCourseEntity(new CourseEntity(courseSubjectMapEntity.getCourseEntity().getCourseGuid()));
                    courseSubject.setSubjectEntity(new SubjectEntity(courseSubjectMapEntity.getSubjectEntity().getSubjectGuid()));
                    courseSubject.setIsActive(courseSubjectMapEntity.getIsActive());
                    courseSubject.setModifiedBy("SUPER_ADMIN".trim());
                    courseSubject.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    courseSubject.setModifiedDate(new Date());
                    courseSubject.setModifiedRemarks(courseSubjectMapEntity.getModifiedRemarks());
                    courseSubjectMapRepository.save(courseSubject);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refCourseSubGuid));
    }

    @Override
    public ResponseEntity<?> deleteCourseSubject(String refCourseSubGuid) {
        return courseSubjectMapRepository.findById(refCourseSubGuid)
                .map(courseSubject -> {
                    courseSubjectMapRepository.delete(courseSubject);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refCourseSubGuid));
    }

    /* ------------------------------------------ SubjectRuleMap Services ------------------------------------------------------------------- */
    @Override
    public Optional<SubjectRuleMapEntity> getSingleSubjectRule(String refSubRuleGuid){
        return subjectRuleMapRepository.findById(refSubRuleGuid)
                .map(subjectRule -> {
                    return subjectRuleMapRepository.findById(subjectRule.getRefSubRuleGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refSubRuleGuid));
    }

    @Override
    public List<SubjectRuleMapEntity> getAllSubjectRule() {
        return subjectRuleMapRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addSubjectRule(SubjectRuleMapEntity subjectRuleMapEntity) {
        if (subjectRuleMapEntity != null){
            subjectRuleMapEntity.setSubjectEntity(new SubjectEntity(subjectRuleMapEntity.getSubjectEntity().getSubjectGuid()));
            subjectRuleMapEntity.setRuleEntity(new RuleEntity(subjectRuleMapEntity.getRuleEntity().getRuleGuid()));
            subjectRuleMapEntity.setCreatedBy("SUPER_ADMIN".trim());
            subjectRuleMapEntity.setCreatedDate(new Date());
            subjectRuleMapEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            subjectRuleMapRepository.save(subjectRuleMapEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateSubjectRule(String refSubRuleGuid, SubjectRuleMapEntity subjectRuleMapEntity){
        return subjectRuleMapRepository.findById(refSubRuleGuid)
                .map(subjectRule -> {
                    subjectRule.setSubjectEntity(new SubjectEntity(subjectRuleMapEntity.getSubjectEntity().getSubjectGuid()));
                    subjectRuleMapEntity.setRuleEntity(new RuleEntity(subjectRuleMapEntity.getRuleEntity().getRuleGuid()));
                    subjectRule.setIsActive(subjectRuleMapEntity.getIsActive());
                    subjectRule.setModifiedBy("SUPER_ADMIN".trim());
                    subjectRule.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    subjectRule.setModifiedDate(new Date());
                    subjectRule.setModifiedRemarks(subjectRuleMapEntity.getModifiedRemarks());
                    subjectRuleMapRepository.save(subjectRule);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refSubRuleGuid));
    }

    @Override
    public ResponseEntity<?> deleteSubjectRule(String refSubRuleGuid) {
        return subjectRuleMapRepository.findById(refSubRuleGuid)
                .map(subjectRule -> {
                    subjectRuleMapRepository.delete(subjectRule);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refSubRuleGuid));
    }

    /* ------------------------------------------ SubjectRuleMap Services ------------------------------------------------------------------- */

    @Override
    public Optional<ExamRuleMapEntity> getSingleExamRule(String refExamRuleGuid){
        return examRuleMapRepository.findById(refExamRuleGuid)
                .map(examRule -> {
                    return examRuleMapRepository.findById(examRule.getRefExamRuleGuid());
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refExamRuleGuid));
    }

    @Override
    public List<ExamRuleMapEntity> getAllExamRule() {
        return examRuleMapRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addExamRule(ExamRuleMapEntity examRuleMapEntity) {
        if (examRuleMapEntity != null){
            examRuleMapEntity.setExamEntity(new ExamEntity(examRuleMapEntity.getExamEntity().getExamGuid()));
            examRuleMapEntity.setRuleEntity(new RuleEntity(examRuleMapEntity.getRuleEntity().getRuleGuid()));
            examRuleMapEntity.setCreatedBy("SUPER_ADMIN".trim());
            examRuleMapEntity.setCreatedDate(new Date());
            examRuleMapEntity.setCreatedIpAddr(Utility.getClientIp(httpServletRequest));
            examRuleMapRepository.save(examRuleMapEntity);
            return ResponseEntity.ok("RECORD SAVED SUCCESSFULLY.");
        }else{
            return ResponseEntity.ok("BAD REQUEST");
        }
    }

    @Override
    public ResponseEntity<?> updateExamRule(String refExamRuleGuid, ExamRuleMapEntity examRuleMapEntity){
        return examRuleMapRepository.findById(refExamRuleGuid)
                .map(examRule -> {
                    examRuleMapEntity.setExamEntity(new ExamEntity(examRuleMapEntity.getExamEntity().getExamGuid()));
                    examRuleMapEntity.setRuleEntity(new RuleEntity(examRuleMapEntity.getRuleEntity().getRuleGuid()));
                    examRule.setIsActive(examRuleMapEntity.getIsActive());
                    examRule.setModifiedBy("SUPER_ADMIN".trim());
                    examRule.setModifiedIpAddr(Utility.getClientIp(httpServletRequest).trim());
                    examRule.setModifiedDate(new Date());
                    examRule.setModifiedRemarks(examRuleMapEntity.getModifiedRemarks());
                    examRuleMapRepository.save(examRule);
                    return ResponseEntity.ok("RECORD UPDATED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refExamRuleGuid));
    }

    @Override
    public ResponseEntity<?> deleteExamRule(String refExamRuleGuid) {
        return examRuleMapRepository.findById(refExamRuleGuid)
                .map(courseSubject -> {
                    examRuleMapRepository.delete(courseSubject);
                    return ResponseEntity.ok("RECORD DELETED SUCCESSFULLY.");
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with guid : " + refExamRuleGuid));
    }

}
