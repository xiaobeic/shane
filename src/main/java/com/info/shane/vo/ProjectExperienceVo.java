package com.info.shane.vo;

import java.util.Date;
import java.util.List;

public class ProjectExperienceVo {
    private String projectName;

    private Date startDate;

    private Date endDate;

    private List<String> projectContent;

    private String url;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(List<String> projectContent) {
        this.projectContent = projectContent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
