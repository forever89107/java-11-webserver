package com.demo.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LeaveFormDto {
    public String employeeId;
    public int leaveTypeId;
    public Date leaveStartTime ;
    public Date leaveEndTime;
    public String jobAgentId;
    public String description;
}
