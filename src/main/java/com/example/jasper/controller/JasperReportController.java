package com.example.jasper.controller;

import com.example.jasper.service.JasperReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class JasperReportController {

    private final JasperReportService jasperReportService;

    public JasperReportController(JasperReportService jasperReportService) {
        this.jasperReportService = jasperReportService;
    }

    @GetMapping("/employee-report")
    public ResponseEntity<byte[]> getEmployeeReport() {
        byte[] report = jasperReportService.generateEmployeeReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=EmployeeReport.pdf");

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }
}
