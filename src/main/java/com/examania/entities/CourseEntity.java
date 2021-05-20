package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_course", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "course_guid")
    private String courseGuid;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name_en")
    private String courseNameEn;

    @Column(name = "course_name_hi")
    private String courseNameHi;

    @Column(name = "course_name_rl")
    private String courseNameRl;

    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "is_active")
    private Boolean isActive;

    public CourseEntity(String courseGuid){
        this.courseGuid = courseGuid;
    }
}
