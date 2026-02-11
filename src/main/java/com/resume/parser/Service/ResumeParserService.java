package com.resume.parser.Service;

import com.resume.parser.Model.ResumeScoreResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ResumeParserService {

    /**
     * Parses a resume file and job description to calculate matching scores
     * @param resumeFile the resume file to parse
     * @param jobDescription the job description to match against
     * @return ResumeScoreResponse with calculated scores
     * @throws IOException if file reading fails
     */
    public ResumeScoreResponse parseResume(MultipartFile resumeFile, String jobDescription) throws IOException {
        String resumeContent = readFileContent(resumeFile);

        int skillScore = calculateSkillScore(resumeContent, jobDescription);
        int experienceScore = calculateExperienceScore(resumeContent);
        int educationScore = calculateEducationScore(resumeContent);

        int overallScore = (skillScore + experienceScore + educationScore) / 3;

        List<String> missingSkills = findMissingSkills(resumeContent, jobDescription);

        return new ResumeScoreResponse(overallScore, skillScore, experienceScore, educationScore, missingSkills);
    }

    /**
     * Reads the content of a multipart file
     */
    private String readFileContent(MultipartFile file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().toLowerCase();
    }

    /**
     * Calculates skill score by checking for skill keywords in resume vs job description
     */
    private int calculateSkillScore(String resumeContent, String jobDescription) {
        List<String> requiredSkills = extractSkills(jobDescription);
        if (requiredSkills.isEmpty()) {
            return 0;
        }

        int matchedSkills = 0;
        for (String skill : requiredSkills) {
            if (resumeContent.contains(skill.toLowerCase())) {
                matchedSkills++;
            }
        }

        return (int) ((matchedSkills * 100.0) / requiredSkills.size());
    }

    /**
     * Extracts skills from job description
     */
    private List<String> extractSkills(String jobDescription) {
        String[] commonSkills = {
            "java", "python", "javascript", "typescript", "golang", "rust",
            "spring", "hibernate", "kafka", "docker", "kubernetes", "aws",
            "microservices", "rest api", "sql", "nosql", "mongodb", "postgresql",
            "html", "css", "react", "angular", "vue", "node.js",
            "git", "ci/cd", "jenkins", "maven", "gradle"
        };

        List<String> foundSkills = new ArrayList<>();
        String lowerDescription = jobDescription.toLowerCase();

        for (String skill : commonSkills) {
            if (lowerDescription.contains(skill)) {
                foundSkills.add(skill);
            }
        }

        return foundSkills;
    }

    /**
     * Calculates experience score based on keywords like "years", "experience", "worked"
     */
    private int calculateExperienceScore(String resumeContent) {
        int experienceIndicators = 0;

        if (resumeContent.contains("years of experience")) experienceIndicators += 15;
        if (resumeContent.contains("worked")) experienceIndicators += 10;
        if (resumeContent.contains("developed")) experienceIndicators += 10;
        if (resumeContent.contains("led")) experienceIndicators += 10;
        if (resumeContent.contains("managed")) experienceIndicators += 10;
        if (resumeContent.contains("project")) experienceIndicators += 5;
        if (resumeContent.contains("team")) experienceIndicators += 5;

        return Math.min(experienceIndicators, 100);
    }

    /**
     * Calculates education score based on education keywords
     */
    private int calculateEducationScore(String resumeContent) {
        int educationIndicators = 0;

        if (resumeContent.contains("bachelor")) educationIndicators += 25;
        if (resumeContent.contains("master")) educationIndicators += 35;
        if (resumeContent.contains("phd")) educationIndicators += 40;
        if (resumeContent.contains("degree")) educationIndicators += 15;
        if (resumeContent.contains("certification")) educationIndicators += 10;
        if (resumeContent.contains("certified")) educationIndicators += 10;

        return Math.min(educationIndicators, 100);
    }

    /**
     * Finds skills that are required but missing from the resume
     */
    private List<String> findMissingSkills(String resumeContent, String jobDescription) {
        List<String> requiredSkills = extractSkills(jobDescription);
        List<String> missingSkills = new ArrayList<>();

        for (String skill : requiredSkills) {
            if (!resumeContent.contains(skill.toLowerCase())) {
                missingSkills.add(skill);
            }
        }

        return missingSkills;
    }
}

