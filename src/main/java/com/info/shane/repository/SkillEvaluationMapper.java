package com.info.shane.repository;

import com.info.shane.model.SkillEvaluation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SkillEvaluationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkillEvaluation record);

    int insertSelective(SkillEvaluation record);

    SkillEvaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkillEvaluation record);

    int updateByPrimaryKey(SkillEvaluation record);

    List<SkillEvaluation> selectByUserId(Integer userId);
}