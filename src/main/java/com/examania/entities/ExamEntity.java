package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_exam", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "exam_guid")
    private String examGuid;

    @Column(name = "exam_code")
    private String examCode;

    @Column(name = "exam_name_en")
    private String examNameEn;

    @Column(name = "exam_name_hi")
    private String examNameHi;

    @Column(name = "exam_name_rl")
    private String examNameRl;

    @Column(name = "exam_description")
    private String examDescription;

    @Column(name = "start_notice_date_time", nullable = false)
    private Date startNoticeDateTime;

    @Column(name = "end_notice_date_time", nullable = false)
    private Date endNoticeDateTime;

    @Column(name = "start_date_time", nullable = false)
    private Date startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private Date endDateTime;

    @Column(name = "is_active")
    private Boolean isActive;

    public ExamEntity(String examGuid){
        this.examGuid = examGuid;
    }
}
