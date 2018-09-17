package com.info.shane.utils;

import com.info.shane.constant.CommonCodes;
import com.info.shane.exception.SessionExpiredException;
import com.info.shane.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static User getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute(CommonCodes.CURRENT_USER);

        if (user == null) {
            throw new SessionExpiredException("Please login!");
        }

        return user;
    }

    public static void setCurrentUser(User user){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute(CommonCodes.CURRENT_USER, user);
    }
}
