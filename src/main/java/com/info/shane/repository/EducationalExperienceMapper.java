package com.info.shane.repository;

import com.info.shane.model.EducationalExperience;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EducationalExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EducationalExperience record);

    int insertSelective(EducationalExperience record);

    EducationalExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EducationalExperience record);

    int updateByPrimaryKey(EducationalExperience record);

    EducationalExperience selectByUserId(Integer userId);
}