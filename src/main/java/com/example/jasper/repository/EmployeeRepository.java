package com.example.jasper.repository;

import com.example.jasper.model.dto.EmployeeDTO;
import com.example.jasper.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("""
        SELECT new com.example.jasper.model.dto.EmployeeDTO(
            e.id, e.name, d.name, e.salary, e.joinedDate)
        FROM Employee e
        JOIN e.department d
    """)
    List<EmployeeDTO> findAllEmployees();
}
