package com.info.shane.vo;

import com.info.shane.model.*;

import java.util.List;

public class Resume {
    private BaseInfo baseInfo;
    private EducationalExperience educationalExperience;
    private List<ProjectExperience> projectExperiences;
    private List<ProjectExperienceVo> projectExperienceVos;
    private SelfDescription selfDescription;
    private SelfDescriptionVo selfDescriptionVo;
    private List<SkillEvaluation> skillEvaluations;
    private List<WorkExperience> workExperiences;

    public List<ProjectExperienceVo> getProjectExperienceVos() {
        return projectExperienceVos;
    }

    public void setProjectExperienceVos(List<ProjectExperienceVo> projectExperienceVos) {
        this.projectExperienceVos = projectExperienceVos;
    }

    public SelfDescriptionVo getSelfDescriptionVo() {
        return selfDescriptionVo;
    }

    public void setSelfDescriptionVo(SelfDescriptionVo selfDescriptionVo) {
        this.selfDescriptionVo = selfDescriptionVo;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public EducationalExperience getEducationalExperience() {
        return educationalExperience;
    }

    public void setEducationalExperience(EducationalExperience educationalExperience) {
        this.educationalExperience = educationalExperience;
    }

    public List<ProjectExperience> getProjectExperiences() {
        return projectExperiences;
    }

    public void setProjectExperiences(List<ProjectExperience> projectExperiences) {
        this.projectExperiences = projectExperiences;
    }

    public SelfDescription getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(SelfDescription selfDescription) {
        this.selfDescription = selfDescription;
    }

    public List<SkillEvaluation> getSkillEvaluations() {
        return skillEvaluations;
    }

    public void setSkillEvaluations(List<SkillEvaluation> skillEvaluations) {
        this.skillEvaluations = skillEvaluations;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }
}
