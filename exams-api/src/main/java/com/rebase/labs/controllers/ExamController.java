package com.rebase.labs.controllers;

import com.rebase.labs.ExamToJson;
import com.rebase.labs.model.Exam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    @GetMapping("/exams")
    public List<Exam> list() {
        return new ExamToJson().getExamsFromCSV();
    }
}
