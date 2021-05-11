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
@Table(name = "mst_question", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "question_guid")
    private String questionGuid;

    @Column(name = "question_code")
    private String questionCode;

    @Column(name = "question_description_en")
    private String questionDescriptionEn;

    @Column(name = "question_description_hi")
    private String questionDescriptionHi;

    @Column(name = "question_description_rl")
    private String questionDescriptionRl;

    @Column(name = "answer_description_en")
    private String answerDescriptionEn;

    @Column(name = "answer_description_hi")
    private String answerDescriptionHi;

    @Column(name = "answer_description_rl")
    private String answerDescriptionRl;

    @Column(name = "is_active")
    private Boolean isActive;
}
