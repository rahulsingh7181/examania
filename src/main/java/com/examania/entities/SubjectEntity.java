package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_subject", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubjectEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "subject_guid")
    private String subjectGuid;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "subject_name_en")
    private String subjectNameEn;

    @Column(name = "subject_name_hi")
    private String subjectNameHi;

    @Column(name = "subject_name_rl")
    private String subjectNameRl;

    @Column(name = "subject_description")
    private String subjectDescription;

    @Column(name = "subject_total_marks")
    private String subjectTotalMarks;

    @Column(name = "subject_pass_marks")
    private String subjectPassMarks;

    @Column(name = "is_active")
    private Boolean isActive;
}
