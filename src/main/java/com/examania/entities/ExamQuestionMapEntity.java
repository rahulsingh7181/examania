package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ref_exam_que", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamQuestionMapEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "ref_exam_que_guid")
    private String refExamQueGuid;

    @ManyToOne
    @JoinColumn(name = "question_guid", referencedColumnName = "question_guid", nullable = false)
    private QuestionEntity questionEntity;

    @ManyToOne
    @JoinColumn(name = "exam_guid", referencedColumnName = "exam_guid", nullable = false)
    private ExamEntity examEntity;

    @Column(name = "is_active")
    private Boolean isActive;
}
