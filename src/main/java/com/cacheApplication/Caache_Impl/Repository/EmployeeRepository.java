package com.cacheApplication.Caache_Impl.Repository;

import com.cacheApplication.Caache_Impl.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

