package com.cacheApplication.Caache_Impl.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;
    private String name;
    private String email;
    private double salary;
}

