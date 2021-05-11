package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ref_course_sub", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseSubjectMapEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "ref_course_sub_guid")
    private String refCourseSubGuid;

    @ManyToOne
    @JoinColumn(name = "course_guid", referencedColumnName = "course_guid", nullable = false)
    private CourseEntity courseEntity;

    @ManyToOne
    @JoinColumn(name = "subject_guid", referencedColumnName = "subject_guid", nullable = false)
    private SubjectEntity subjectEntity;

    @Column(name = "is_active")
    private Boolean isActive;
}
