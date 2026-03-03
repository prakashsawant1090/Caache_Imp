package com.cacheApplication.Caache_Impl;

import com.cacheApplication.Caache_Impl.DTO.EmployeeDto;
import com.cacheApplication.Caache_Impl.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CaacheImplApplicationTests {

    @Autowired
    private EmployeeService employeeService;

	@Test
	void contextLoads() {
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        for(EmployeeDto employeeDto : allEmployees){
            System.out.println("Name : "+employeeDto.getName());
        }

    }

}
