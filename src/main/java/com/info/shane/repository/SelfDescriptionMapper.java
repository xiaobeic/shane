package com.info.shane.repository;

import com.info.shane.model.SelfDescription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SelfDescriptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SelfDescription record);

    int insertSelective(SelfDescription record);

    SelfDescription selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SelfDescription record);

    int updateByPrimaryKey(SelfDescription record);
}