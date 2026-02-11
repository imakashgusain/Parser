package com.resume.parser.Controller;

import com.resume.parser.ParsedResume;
import com.resume.parser.ResumeParseRequest;
import com.resume.parser.ResumeParser;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeParser resumeParser;

    public ResumeController(ResumeParser resumeParser) {
        this.resumeParser = resumeParser;
    }

    @PostMapping("/parse")
    public ParsedResume parseResume(@RequestBody ResumeParseRequest request) {

        return resumeParser.parse(request.getResumeText());
    }
}


