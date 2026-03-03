package com.cacheApplication.Caache_Impl.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private String message;
    private String path;
    private int status;
    private String timestamp;
}
