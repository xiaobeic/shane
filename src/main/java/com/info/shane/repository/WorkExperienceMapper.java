package com.info.shane.repository;

import com.info.shane.model.WorkExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkExperience record);

    int insertSelective(WorkExperience record);

    WorkExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkExperience record);

    int updateByPrimaryKey(WorkExperience record);

    List<WorkExperience> selectByUserId(Integer userId);
}