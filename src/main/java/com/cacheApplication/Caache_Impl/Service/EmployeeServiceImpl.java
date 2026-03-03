package com.cacheApplication.Caache_Impl.Service;




import com.cacheApplication.Caache_Impl.DTO.EmployeeDto;
import com.cacheApplication.Caache_Impl.Ecxeption.ResourceNotFoundException;
import com.cacheApplication.Caache_Impl.Entity.Employee;
import com.cacheApplication.Caache_Impl.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;
    private final ModelMapper modelMapper;
    private final String CACHE_NAME = "employee";

    private EmployeeDto convertToDto(Employee emp) {
        return modelMapper.map(emp, EmployeeDto.class);
    }

    private Employee convertToEntity(EmployeeDto dto) {
        return modelMapper.map(dto, Employee.class);
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME,key = "#result.id")
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = convertToEntity(dto);
        Employee saved = repo.save(employee);
        return convertToDto(saved);
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME,key = "#id")
    public EmployeeDto getEmployeeById(Long id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return convertToDto(emp);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return repo.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME,key = "#id")
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setSalary(dto.getSalary());

        Employee updated = repo.save(emp);
        return convertToDto(updated);
    }

    @Override
    @CacheEvict(cacheNames = CACHE_NAME,key = "#id")
    public void deleteEmployee(Long id) {

        repo.deleteById(id);
    }
}

