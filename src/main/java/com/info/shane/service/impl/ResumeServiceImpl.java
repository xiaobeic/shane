package com.info.shane.service.impl;

import com.info.shane.exception.SessionExpiredException;
import com.info.shane.model.*;
import com.info.shane.repository.*;
import com.info.shane.service.ResumeService;
import com.info.shane.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Autowired
    private SelfDescriptionMapper selfDescriptionMapper;

    @Autowired
    private WorkExperienceMapper workExperienceMapper;

    @Autowired
    private EducationalExperienceMapper educationalExperienceMapper;

    @Autowired
    private ProjectExperienceMapper projectExperienceMapper;

    @Autowired
    private SkillEvaluationMapper skillEvaluationMapper;

    @Override
    public void saveBaseInfo(BaseInfo baseInfo) {
        User user = SessionUtil.getCurrentUser();
        baseInfo.setUserId(user.getId());

        if (baseInfo.getId() == null) {
            baseInfo.setCreatedDate(new Date());
            baseInfo.setModifiedDate(new Date());
            baseInfoMapper.insert(baseInfo);
        } else {
            baseInfo.setModifiedDate(new Date());
            baseInfoMapper.updateByPrimaryKeySelective(baseInfo);
        }
    }

    @Override
    public void saveDescInfo(SelfDescription selfDescription) {
        User user = SessionUtil.getCurrentUser();
        selfDescription.setUserId(user.getId());

        if (selfDescription.getId() == null) {
            selfDescription.setCreatedDate(new Date());
            selfDescription.setModifiedDate(new Date());
            selfDescriptionMapper.insert(selfDescription);
        } else {
            selfDescription.setModifiedDate(new Date());
            selfDescriptionMapper.updateByPrimaryKeySelective(selfDescription);
        }
    }

    @Override
    public WorkExperience saveWorkInfo(WorkExperience workExperience) {
        User user = SessionUtil.getCurrentUser();
        workExperience.setUserId(user.getId());

        if (workExperience.getId() == null) {
            workExperience.setCreatedDate(new Date());
            workExperience.setModifiedDate(new Date());
            workExperienceMapper.insert(workExperience);
        } else {
            workExperience.setModifiedDate(new Date());
            workExperienceMapper.updateByPrimaryKeySelective(workExperience);
        }

        return workExperience;
    }

    @Override
    public void deleteWorkInfo(Integer id) {
        workExperienceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveEducationInfo(EducationalExperience educationalExperience) {
        User user = SessionUtil.getCurrentUser();
        educationalExperience.setUserId(user.getId());

        if (educationalExperience.getId() == null) {
            educationalExperience.setCreatedDate(new Date());
            educationalExperience.setModifiedDate(new Date());
            educationalExperienceMapper.insert(educationalExperience);
        } else {
            educationalExperience.setModifiedDate(new Date());
            educationalExperienceMapper.updateByPrimaryKeySelective(educationalExperience);
        }
    }

    @Override
    public ProjectExperience saveProjectInfo(ProjectExperience projectExperience) {
        User user = SessionUtil.getCurrentUser();
        projectExperience.setUserId(user.getId());

        if (projectExperience.getId() == null) {
            projectExperience.setCreatedDate(new Date());
            projectExperience.setModifiedDate(new Date());
            projectExperienceMapper.insert(projectExperience);
        } else {
            projectExperience.setModifiedDate(new Date());
            projectExperienceMapper.updateByPrimaryKeySelective(projectExperience);
        }

        return projectExperience;
    }

    @Override
    public void deleteProjectInfo(Integer id) {
        projectExperienceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteSkillInfo(Integer id) {
        skillEvaluationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SkillEvaluation saveSkillInfo(SkillEvaluation skillEvaluation) {
        User user = SessionUtil.getCurrentUser();
        skillEvaluation.setUserId(user.getId());

        if (skillEvaluation.getId() == null) {
            skillEvaluation.setCreatedDate(new Date());
            skillEvaluation.setModifiedDate(new Date());
            skillEvaluationMapper.insert(skillEvaluation);
        } else {
            skillEvaluation.setModifiedDate(new Date());
            skillEvaluationMapper.updateByPrimaryKeySelective(skillEvaluation);
        }

        return skillEvaluation;
    }
}
