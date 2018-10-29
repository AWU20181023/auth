package com.gree.auth.dao;

import com.gree.auth.entity.po.UserOperation;

import java.util.List;

/**
 * Created by 260152(AWU) on 2018/10/29 18:52.
 */
public interface UserOperationMapper {

    int deleteByPrimaryKey(Integer userOperationId);

    int insert(UserOperation record);

    int insertSelective(UserOperation record);

    UserOperation selectByPrimaryKey(Integer userOperationId);

    int updateByPrimaryKeySelective(UserOperation record);

    int updateByPrimaryKey(UserOperation record);

    List<UserOperation> getAll();

    Long getCount();
}
