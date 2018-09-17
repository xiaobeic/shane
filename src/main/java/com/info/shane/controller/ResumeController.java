package com.info.shane.controller;

import com.info.shane.model.BaseInfo;
import com.info.shane.model.SelfDescription;
import com.info.shane.model.WorkExperience;
import com.info.shane.service.ResumeService;
import com.info.shane.vo.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/save_base_info")
    public ResponseEntity saveBaseInfo(BaseInfo baseInfo) {
        resumeService.saveBaseInfo(baseInfo);
        return new ResponseEntity();
    }


    @RequestMapping("/save_desc_info")
    public ResponseEntity saveDescInfo(SelfDescription selfDescription) {
        resumeService.saveDescInfo(selfDescription);
        return new ResponseEntity();
    }


    @RequestMapping("/save_work_info")
    public ResponseEntity<WorkExperience> saveWorkInfo(WorkExperience workExperience) {
        return new ResponseEntity(resumeService.saveWorkInfo(workExperience));
    }

    @RequestMapping("/delete_work_info")
    public ResponseEntity deleteWorkInfo(Integer id) {
        resumeService.deleteWorkInfo(id);
        return new ResponseEntity();
    }

}
