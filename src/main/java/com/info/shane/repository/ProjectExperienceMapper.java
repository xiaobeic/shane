package com.info.shane.repository;

import com.info.shane.model.ProjectExperience;

public interface ProjectExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectExperience record);

    int insertSelective(ProjectExperience record);

    ProjectExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectExperience record);

    int updateByPrimaryKey(ProjectExperience record);
}