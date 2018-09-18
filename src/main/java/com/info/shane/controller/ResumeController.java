package com.info.shane.controller;

import com.info.shane.model.*;
import com.info.shane.service.ResumeService;
import com.info.shane.vo.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/save_education_info")
    public ResponseEntity saveEducationInfo(EducationalExperience educationalExperience) {
        resumeService.saveEducationInfo(educationalExperience);
        return new ResponseEntity();
    }

    @RequestMapping("/save_project_info")
    public ResponseEntity<ProjectExperience> saveProjectInfo(ProjectExperience projectExperience) {
        return new ResponseEntity(resumeService.saveProjectInfo(projectExperience));
    }

    @RequestMapping("/delete_project_info")
    public ResponseEntity deleteProjectInfo(Integer id) {
        resumeService.deleteProjectInfo(id);
        return new ResponseEntity();
    }

    @RequestMapping("/save_skill_info")
    public ResponseEntity<SkillEvaluation> saveSkillInfo(SkillEvaluation skillEvaluation) {
        return new ResponseEntity(resumeService.saveSkillInfo(skillEvaluation));
    }

    @RequestMapping("/delete_skill_info")
    public ResponseEntity deleteSkillInfo(Integer id) {
        resumeService.deleteSkillInfo(id);
        return new ResponseEntity();
    }

    @RequestMapping("/get_resume")
    public ModelAndView getResume() {
        ModelAndView modelAndView = new ModelAndView("console");
        modelAndView.addObject("resume", resumeService.getResume());
        return modelAndView;
    }

    @RequestMapping("/find_resume")
    public ModelAndView findResume() {
        ModelAndView modelAndView = new ModelAndView("resume");
        modelAndView.addObject("resume", resumeService.findResume());
        return modelAndView;
    }
}
