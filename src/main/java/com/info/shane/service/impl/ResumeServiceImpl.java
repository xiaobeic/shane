package com.info.shane.service.impl;

import com.info.shane.model.User;
import com.info.shane.repository.UserMapper;
import com.info.shane.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
