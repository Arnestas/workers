package com.example.workers.service;

import com.example.workers.dto.WorkerDto;
import com.example.workers.mappers.WorkerEntityMapStruct;
import com.example.workers.repository.WorkerEntity;
import com.example.workers.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository repository;
    private final WorkerEntityMapStruct mapper;


    public Optional<List<WorkerDto>> saveWorkers(List<WorkerDto> workerDtoList){


        List<WorkerEntity> workerEntityList = mapper.dtoToEntity(workerDtoList);
        repository.saveAll(workerEntityList);

        return Optional.of(workerDtoList);

    }
}
