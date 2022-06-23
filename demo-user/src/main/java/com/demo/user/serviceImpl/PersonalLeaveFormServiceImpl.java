package com.demo.user.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.user.entity.PersonalLeaveForm;
import com.demo.user.mapper.PersonalLeaveFormMapper;
import com.demo.user.service.PersonalLeaveFormService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MBG
 * @since 2022-06-21 01:39:44
 */
@Service
public class PersonalLeaveFormServiceImpl extends ServiceImpl<PersonalLeaveFormMapper, PersonalLeaveForm> implements PersonalLeaveFormService {

    private final PersonalLeaveFormMapper mapper;

    public PersonalLeaveFormServiceImpl(PersonalLeaveFormMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int insertleaveForm(PersonalLeaveForm data) {
        data.setCreateTime(new Date());
        data.setLastModifiedTime(new Date());
        data.setStatus(1);//Pending
        return mapper.insert(data);
    }

    @Override
    public List<PersonalLeaveForm> getListByEmplId(String emplId) {
        QueryWrapper<PersonalLeaveForm> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id", emplId.trim());
        return mapper.selectList(queryWrapper);
    }
}

