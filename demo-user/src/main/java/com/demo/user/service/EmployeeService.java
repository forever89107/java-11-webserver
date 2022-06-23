package com.demo.user.service;

import com.demo.user.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MBG
 * @since 2022-06-17 02:42:00
 */
public interface EmployeeService extends IService<Employee> {
    /** 自定義服務 */

    int addEmployee(Employee data);

    Employee selectEmplyByEmailName(String emailName);

    Boolean checkEmplyByEmailName(String mailName);
}
