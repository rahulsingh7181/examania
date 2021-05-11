package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ref_exam_rule", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExamRuleMapEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "ref_exam_rule_guid")
    private String refExamRuleGuid;

    @ManyToOne
    @JoinColumn(name = "rule_guid", referencedColumnName = "rule_guid", nullable = false)
    private RuleEntity ruleEntity;

    @ManyToOne
    @JoinColumn(name = "exam_guid", referencedColumnName = "exam_guid", nullable = false)
    private ExamEntity examEntity;

    @Column(name = "is_active")
    private Boolean isActive;
}
