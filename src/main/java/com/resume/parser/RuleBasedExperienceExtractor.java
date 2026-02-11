package com.resume.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleBasedExperienceExtractor implements ExperienceExtractor {

    private static final Pattern EXPERIENCE_PATTERN =
            Pattern.compile("(\\d+)\\+?\\s*(years|yrs)", Pattern.CASE_INSENSITIVE);

    @Override
    public Experience extract(String text) {

        Matcher matcher = EXPERIENCE_PATTERN.matcher(text);

        if (matcher.find()) {
            int years = Integer.parseInt(matcher.group(1));
            return new Experience(years);
        }

        return new Experience(0);
    }
}

