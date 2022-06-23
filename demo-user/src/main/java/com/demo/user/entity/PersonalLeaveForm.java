package com.demo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author MBG
 * @since 2022-06-21 01:39:44
 */
@Getter
@Setter
@TableName("personal_leave_form")
@ApiModel(value = "PersonalLeaveForm对象", description = "")
public class PersonalLeaveForm extends Model<PersonalLeaveForm> {

    @ApiModelProperty("UUID")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String employeeId;

    private Integer leaveTypeId;

    private String approverId;

    private Date leaveStartTime;

    private Date leaveEndTime;

    private String jobAgentId;

    private String description;

    private Date createTime;

    private Date lastModifiedTime;

    private String updater;

    @ApiModelProperty("0:initial , 1:waiting for approve, 2:approved, 3:reject")
    private Integer status;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
