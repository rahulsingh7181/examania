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
@Table(name = "mst_rule", schema = "scdata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RuleEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "rule_guid")
    private String ruleGuid;

    @Column(name = "rule_code")
    private String ruleCode;

    @Column(name = "rule_name_en")
    private String ruleNameEn;

    @Column(name = "rule_name_hi")
    private String ruleNameHi;

    @Column(name = "rule_name_rl")
    private String ruleNameRl;

    @Column(name = "rule_description")
    private String ruleDescription;

    @Column(name = "is_active")
    private Boolean isActive;

    public RuleEntity(String ruleGuid){
        this.ruleGuid = ruleGuid;
    }
}
