package com.example.workers.web.controller;

import com.example.workers.dto.WorkerDto;
import com.example.workers.mappers.WorkerEntityMapStruct;
import com.example.workers.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.record.Record;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/workers")
@RestController
public class WorkerController {

    @Autowired
    private WorkerService service;

    private WorkerEntityMapStruct mapper;

    @PostMapping("/")
    public String uploadData(@RequestParam("file")MultipartFile file) throws Exception{

        List<WorkerDto> workerDtoList = new ArrayList<>();

        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);

        parseAllRecords.forEach(record -> {
            WorkerDto worker = new WorkerDto();
            worker.setId(Long.valueOf(record.getInt("id")));
            worker.setName(record.getString("name"));
            worker.setEmail(record.getString("email"));
            worker.setPhoneNumber(record.getString("phone_number"));
            workerDtoList.add(worker);
        });

        service.saveWorkers(workerDtoList);

        return "Upload is successful";
    }

}