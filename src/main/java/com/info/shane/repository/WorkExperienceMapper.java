package com.info.shane.repository;

import com.info.shane.model.WorkExperience;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkExperience record);

    int insertSelective(WorkExperience record);

    WorkExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkExperience record);

    int updateByPrimaryKey(WorkExperience record);
}