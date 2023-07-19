package com.rebase.labs;

import com.rebase.labs.model.Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ExamToJson {

    public List<Exam> getExamsFromCSV() {
        var inputStream = getClass().getClassLoader().getResourceAsStream("data.csv");

        var count = new AtomicInteger(0);

        try (BufferedReader data = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            return data.lines().skip(1).map(line -> {
                var fields = line.split(";");
                return createExam(fields);
            }).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Exam createExam(String[] fields) {
        var exam = new Exam();
        exam.setCpf(fields[0]);
        exam.setName(fields[1]);
        exam.setEmail(fields[2]);
        exam.setBirthDate(fields[3]);
        exam.setAddress(fields[4]);
        exam.setCity(fields[5]);
        exam.setState(fields[6]);
        exam.setDoctor_crm(fields[7]);
        exam.setDoctor_state(fields[8]);
        exam.setDoctor_name(fields[9]);
        exam.setDoctor_email(fields[10]);
        exam.setToken(fields[11]);
        exam.setExam_date(fields[12]);
        exam.setExam_name(fields[13]);
        exam.setExam_reference(fields[14]);
        exam.setResult(fields[15]);
        return exam;
    }
}
