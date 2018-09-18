package com.info.shane.repository;

import com.info.shane.model.BaseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    BaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);

    BaseInfo selectByUserId(Integer userId);
}