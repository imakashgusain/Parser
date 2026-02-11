package com.resume.parser;

public interface ResumeParser {
    ParsedResume parse(String rawText);
}