package com.demo.user.serviceImpl;

import com.demo.user.entity.LeaveType;
import com.demo.user.mapper.LeaveTypeMapper;
import com.demo.user.service.LeaveTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MBG
 * @since 2022-06-21 12:17:38
 */
@Service
public class LeaveTypeServiceImpl extends ServiceImpl<LeaveTypeMapper, LeaveType> implements LeaveTypeService {

}
