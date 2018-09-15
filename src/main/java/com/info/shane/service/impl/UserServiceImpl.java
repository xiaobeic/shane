package com.info.shane.service.impl;

import com.info.shane.exception.NoUserException;
import com.info.shane.exception.PasswordErrorException;
import com.info.shane.model.User;
import com.info.shane.model.request.LoginInfo;
import com.info.shane.repository.UserMapper;
import com.info.shane.service.UserService;
import com.info.shane.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new NoUserException("No user found!");
        }

        if(!user.getPassword().equals(password)) {
            throw new PasswordErrorException("Password error!");
        }

        SessionUtil.setCurrentUser(user);

        return true;
    }
}
