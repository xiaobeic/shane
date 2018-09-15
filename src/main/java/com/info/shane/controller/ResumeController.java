package com.info.shane.controller;

import com.info.shane.model.User;
import com.info.shane.service.ResumeService;
import com.info.shane.vo.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/user")
    public ResponseEntity getUser(@RequestParam("id") Integer id) {
        return new ResponseEntity(resumeService.getUser(id));
    }

}
