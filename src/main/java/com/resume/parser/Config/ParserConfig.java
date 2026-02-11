package com.resume.parser.Config;

import com.resume.parser.ResumeParser;
import com.resume.parser.RuleBasedResumeParser;
import com.resume.parser.RuleBasedSkillExtractor;
import com.resume.parser.RuleBasedExperienceExtractor;
import com.resume.parser.RuleBasedEducationExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserConfig {

    @Bean
    public ResumeParser resumeParser() {
        return new RuleBasedResumeParser(
                new RuleBasedSkillExtractor(),
                new RuleBasedExperienceExtractor(),
                new RuleBasedEducationExtractor()
        );
    }
}

