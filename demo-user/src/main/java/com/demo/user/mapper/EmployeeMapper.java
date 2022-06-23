package com.demo.user.mapper;

import com.demo.user.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MBG
 * @since 2022-06-17 02:42:00
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
