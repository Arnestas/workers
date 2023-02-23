package com.example.workers.mappers;
import com.example.workers.dto.WorkerDto;
import com.example.workers.repository.WorkerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkerEntityMapStruct {

    WorkerEntityMapStruct INSTANCE = Mappers.getMapper(WorkerEntityMapStruct.class);

    @Mapping(source = "workerDtoList", target = "workerEntityList")
    WorkerEntity dtoToEntity(WorkerDto workerDto);

    @Mapping(source = "workerEntityList", target = "workerDtoList")
    WorkerDto entityToDto(WorkerEntity workerEntity);
    }

}