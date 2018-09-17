package com.info.shane.service.impl;

import com.info.shane.exception.SessionExpiredException;
import com.info.shane.model.BaseInfo;
import com.info.shane.model.SelfDescription;
import com.info.shane.model.User;
import com.info.shane.model.WorkExperience;
import com.info.shane.repository.BaseInfoMapper;
import com.info.shane.repository.SelfDescriptionMapper;
import com.info.shane.repository.WorkExperienceMapper;
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
            baseInfoMapper.updateByPrimaryKey(baseInfo);
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
            selfDescriptionMapper.updateByPrimaryKey(selfDescription);
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
            workExperienceMapper.updateByPrimaryKey(workExperience);
        }

        return workExperience;
    }

    @Override
    public void deleteWorkInfo(Integer id) {
        workExperienceMapper.deleteByPrimaryKey(id);
    }
}
