package com.demo.user.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.user.entity.Employee;
import com.demo.user.mapper.EmployeeMapper;
import com.demo.user.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MBG
 * @since 2022-06-17 02:42:00
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int addEmployee(Employee data) {
        int success = mapper.insert(data);
        return success;
    }

    @Override
    public Employee selectEmplyByEmailName(String mailName) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", mailName.trim() + "@pgtalk.com");
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public Boolean checkEmplyByEmailName(String mailName) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", mailName.trim() + "@pgtalk.com");
        return mapper.exists(queryWrapper);
    }
}
