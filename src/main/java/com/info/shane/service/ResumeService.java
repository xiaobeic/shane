package com.info.shane.service;

import com.info.shane.model.BaseInfo;
import com.info.shane.model.SelfDescription;
import com.info.shane.model.User;
import com.info.shane.model.WorkExperience;

public interface ResumeService {

    void saveBaseInfo(BaseInfo baseInfo);

    void saveDescInfo(SelfDescription selfDescription);

    WorkExperience saveWorkInfo(WorkExperience workExperience);

    void deleteWorkInfo(Integer id);
}
