package com.demo.user.controller;


import com.demo.user.entity.Employee;
import com.demo.user.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MBG
 * @since 2022-06-17 02:42:00
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 新增玩家
    @PostMapping
    public String newPlayer(@RequestBody Employee data) {
        int res = employeeService.addEmployee(data);

        return res > 0 ? "success" : "fail";
    }
}

