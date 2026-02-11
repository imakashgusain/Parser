package com.resume.parser;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RuleBasedSkillExtractor implements SkillExtractor {

    private static final Set<String> KNOWN_SKILLS = Set.of(
            "java", "spring boot", "sql", "docker", "aws", "rest", "kafka"
    );

    @Override
    public List<String> extract(String text) {
        List<String> detectedSkills = new ArrayList<>();

        for (String skill : KNOWN_SKILLS) {
            if (StringUtils.containsIgnoreCase(text, skill)) {
                detectedSkills.add(skill);
            }
        }

        return detectedSkills;
    }
}

