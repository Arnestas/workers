package com.example.workers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerDto {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

}