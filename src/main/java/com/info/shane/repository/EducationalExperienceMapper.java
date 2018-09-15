package com.info.shane.repository;

import com.info.shane.model.EducationalExperience;

public interface EducationalExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EducationalExperience record);

    int insertSelective(EducationalExperience record);

    EducationalExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EducationalExperience record);

    int updateByPrimaryKey(EducationalExperience record);
}