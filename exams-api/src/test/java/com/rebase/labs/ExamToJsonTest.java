package com.rebase.labs;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rebase.labs.model.Exam;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExamToJsonTest {

    @Test
    void jsonReader() throws IOException {
        var json = new ExamToJson().getExamsFromCSV();

        var mapper = new ObjectMapper();
        List<Exam> exams = null;
        try {
            exams = mapper.readValue((JsonParser) json, new TypeReference<List<Exam>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(json);
        assertNotNull(json);
        assertEquals(3900, exams.size());
        assertEquals("048.973.170-88", exams.get(0).getCpf());
    }
}