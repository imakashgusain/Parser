package com.resume.parser;

import java.util.List;
import java.util.Set;

public class ParsedResume {

    private List<String> skills;
    private Experience experience;
    private Education education;

    public ParsedResume(List<String> skills,
                        Experience experience,
                        Education education) {
        this.skills = skills;
        this.experience = experience;
        this.education = education;
    }

    public List<String>getSkills() { return skills; }
    public Experience getExperience() { return experience; }
    public Education getEducation() { return education; }
}

