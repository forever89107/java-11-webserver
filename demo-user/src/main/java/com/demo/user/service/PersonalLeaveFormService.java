package com.demo.user.service;

import com.demo.user.entity.PersonalLeaveForm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MBG
 * @since 2022-06-21 01:39:44
 */
public interface PersonalLeaveFormService extends IService<PersonalLeaveForm> {
    int insertleaveForm(PersonalLeaveForm data);

    List<PersonalLeaveForm> getListByEmplId(String emplId);
}
