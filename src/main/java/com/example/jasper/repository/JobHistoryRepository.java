package com.example.jasper.repository;

import com.example.jasper.model.dto.JobHistoryDTO;
import com.example.jasper.model.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    @Query("""
    SELECT new com.example.jasper.model.dto.JobHistoryDTO(
         j.id, e.name, j.position, j.salary,
         prev.position, prev.salary, j.startDate, j.endDate
    )
    FROM JobHistory j
    JOIN j.employee e
    LEFT JOIN j.previousJob prev
    """)
    List<JobHistoryDTO> findAllJobHistories();
}
