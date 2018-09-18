package com.info.shane.service;

import com.info.shane.model.*;
import com.info.shane.vo.Resume;

public interface ResumeService {

    void saveBaseInfo(BaseInfo baseInfo);

    void saveDescInfo(SelfDescription selfDescription);

    WorkExperience saveWorkInfo(WorkExperience workExperience);

    void deleteWorkInfo(Integer id);

    void saveEducationInfo(EducationalExperience educationalExperience);

    ProjectExperience saveProjectInfo(ProjectExperience projectExperience);

    void deleteProjectInfo(Integer id);

    void deleteSkillInfo(Integer id);

    SkillEvaluation saveSkillInfo(SkillEvaluation skillEvaluation);

    Resume getResume();

    Resume findResume();
}
