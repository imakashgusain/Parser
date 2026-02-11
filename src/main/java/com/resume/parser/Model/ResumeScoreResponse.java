package com.resume.parser.Model;

import java.util.List;

public class ResumeScoreResponse {
    private int overallScore;
    private int skillScore;
    private int experienceScore;
    private int educationScore;
    private List<String> missingSkills;

    public ResumeScoreResponse() {
    }

    public ResumeScoreResponse(int overallScore, int skillScore, int experienceScore, int educationScore, List<String> missingSkills) {
        this.overallScore = overallScore;
        this.skillScore = skillScore;
        this.experienceScore = experienceScore;
        this.educationScore = educationScore;
        this.missingSkills = missingSkills;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getSkillScore() {
        return skillScore;
    }

    public void setSkillScore(int skillScore) {
        this.skillScore = skillScore;
    }

    public int getExperienceScore() {
        return experienceScore;
    }

    public void setExperienceScore(int experienceScore) {
        this.experienceScore = experienceScore;
    }

    public int getEducationScore() {
        return educationScore;
    }

    public void setEducationScore(int educationScore) {
        this.educationScore = educationScore;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }
}

