package com.demo.user.controller;


import com.google.gson.Gson;
import com.demo.user.dto.LeaveFormDto;
import com.demo.user.entity.Employee;
import com.demo.user.entity.PersonalLeaveForm;
import com.demo.user.service.EmployeeService;
import com.demo.user.service.PersonalLeaveFormService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author MBG
 * @since 2022-06-21 01:39:44
 */
@RestController
@RequestMapping("/leaveForm")
public class PersonalLeaveFormController {

    private final PersonalLeaveFormService personalLeaveFormService;
    private EmployeeService employeeService;

    public PersonalLeaveFormController(PersonalLeaveFormService personalLeaveFormService, EmployeeService employeeService) {
        this.personalLeaveFormService = personalLeaveFormService;
        this.employeeService = employeeService;
    }

    @PostMapping("/addLeaveForm")
    public String addLeaveForm(@RequestBody LeaveFormDto data) {
        // 檢查是否有該email
        Employee employee = employeeService.selectEmplyByEmailName(data.getEmployeeId());
        if (employee == null) return "查無此申請人";
        PersonalLeaveForm form = new PersonalLeaveForm();
        form.setEmployeeId(employee.getEmployeeId());
        form.setLeaveTypeId(data.getLeaveTypeId());
        form.setApproverId("A0001");
        form.setLeaveStartTime(data.getLeaveStartTime());
        form.setLeaveEndTime(data.getLeaveEndTime());
        Employee agent = employeeService.selectEmplyByEmailName(data.getJobAgentId());
        if (agent == null) return "查無此代理人帳戶";
        form.setJobAgentId(agent.getEmployeeId());
        form.setDescription(data.getDescription());
        form.setUpdater(employee.getEmployeeId());
        int res = personalLeaveFormService.insertleaveForm(form);
        return (res > 0) ? "申請成功" : "新增假單失敗";
    }

    @GetMapping("/leaveList")
    public String leaveList(@RequestParam("emplId") String emplId) {
        Employee employee = employeeService.selectEmplyByEmailName(emplId);
        if (employee == null) return "查無此員工";
        return new Gson().toJson(personalLeaveFormService.getListByEmplId(employee.getEmployeeId()));
    }

}

