package com.resume.parser;

import org.apache.commons.lang3.StringUtils;

public class RuleBasedEducationExtractor implements EducationExtractor {

    @Override
    public Education extract(String text) {

        if (StringUtils.containsIgnoreCase(text, "b.tech"))
            return new Education("B.Tech");

        if (StringUtils.containsIgnoreCase(text, "bachelor"))
            return new Education("Bachelor");

        if (StringUtils.containsIgnoreCase(text, "master"))
            return new Education("Master");

        return new Education("UNKNOWN");
    }
}

