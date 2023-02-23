package com.example.workers.service;

import com.example.workers.dto.WorkerDto;

import java.util.List;
import java.util.Optional;

public interface WorkerService {

    Optional<List<WorkerDto>> saveWorkers(List<WorkerDto> workerDtoList);

}
