package com.resume.parser;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;

public class RuleBasedResumeParser implements ResumeParser {

    private final SkillExtractor skillExtractor;
    private final ExperienceExtractor experienceExtractor;
    private final EducationExtractor educationExtractor;

    public RuleBasedResumeParser(SkillExtractor skillExtractor,
                                 ExperienceExtractor experienceExtractor,
                                 EducationExtractor educationExtractor) {
        this.skillExtractor = skillExtractor;
        this.experienceExtractor = experienceExtractor;
        this.educationExtractor = educationExtractor;
    }

    @Override
    public ParsedResume parse(String rawText) {

        if (StringUtils.isBlank(rawText)) {
            throw new IllegalArgumentException("Resume text cannot be empty");
        }

        String cleanedText = preprocess(rawText);

        List<String> skills = skillExtractor.extract(cleanedText);
        Experience experience = experienceExtractor.extract(cleanedText);
        Education education = educationExtractor.extract(cleanedText);

        return new ParsedResume(skills, experience, education);
    }

    private String preprocess(String text) {
        return StringUtils.normalizeSpace(text);
    }
}

