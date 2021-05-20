package com.examania.entities;

import com.examania.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "user_role_group", schema = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRoleGroupEntity extends AuditModel {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "user_role_group_guid")
    private String userRoleGroupGuid;

    //@NotEmpty(message = "UserRoleGroupCode is mandatory.")
    @Column(name = "user_role_group_code")
    private String userRoleGroupCode;

    //@NotEmpty(message = "UserRoleGroupName is mandatory.")
    @Column(name = "user_role_group_name")
    private String userRoleGroupName;

    @Column(name = "user_role_group_description")
    private String userRoleGroupDescription;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name = "is_active")
    private Boolean isActive;
}
