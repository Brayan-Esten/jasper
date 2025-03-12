package com.example.jasper.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobHistoryDTO {
    private Long id;
    private String employeeName;
    private String currentPosition;
    private BigDecimal currentSalary;
    private String previousPosition;
    private BigDecimal previousSalary;
    private Date startDate;
    private Date endDate;
}
