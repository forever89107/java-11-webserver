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
 * @since 2022-06-21 12:17:38
 */
@Getter
@Setter
@TableName("leave_type")
@ApiModel(value = "LeaveType对象", description = "")
public class LeaveType extends Model<LeaveType> {

    @TableId(value = "leave_type_id", type = IdType.ASSIGN_UUID)
    private Integer leaveTypeId;

    @ApiModelProperty("annual leave 年假(1); sick leave 病假(2); personal leave 事假(3); official leave 公假(4); menstrual leave 生理假(5); marriage leave 婚假(6);   funeral leave 喪假(7); maternity leave 產假(8); paternity leave 陪產假(9); parental leave 育嬰假(10);")
    private Integer leaveType;

    @ApiModelProperty("paid leave:1; unpaid leave:0 (屬於有薪或無薪假)")
    private Integer paidLeave;

    private String description;

    private Date createTime;

    private Date lastModifiedTime;

    private String updater;

    private String leaveName;


    @Override
    public Serializable pkVal() {
        return this.leaveTypeId;
    }

}
