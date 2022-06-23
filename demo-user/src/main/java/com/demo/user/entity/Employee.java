package com.demo.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-06-17 02:42:00
 */
@Getter
@Setter
@ApiModel(value = "Employee对象", description = "")
public class Employee extends Model<Employee> {

    @ApiModelProperty("UUID")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    private String employeeId;

    private String employeeName;

    private String password;

    private Date birthday;

    @ApiModelProperty("0: female, 1: male, 2: unknow")
    private Integer gender;

    private String email;

    @ApiModelProperty("0: registed, 1:legal, 2:suspend, 3:Blocked")
    private Integer status;

    private Date onboardDate;

    private String description;

    private Date createTime;

    private Date lastModifiedTime;

    private String updater;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
