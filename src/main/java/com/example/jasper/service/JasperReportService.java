package com.example.jasper.service;

import com.example.jasper.model.dto.EmployeeDTO;
import com.example.jasper.model.entity.Employee;
import com.example.jasper.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    private final ResourceLoader resourceLoader;

    private final EmployeeRepository employeeRepository;

    public JasperReportService(ResourceLoader resourceLoader,
        EmployeeRepository employeeRepository)
    {
        this.resourceLoader = resourceLoader;
        this.employeeRepository = employeeRepository;
    }

    public byte[] generateEmployeeReport () {
        try {
            InputStream jrxmlStream = resourceLoader.getResource("classpath:jasper-report/employee_report.jrxml").getInputStream();
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlStream);

            List<EmployeeDTO> employees = employeeRepository.findAllEmployees();
            JRBeanCollectionDataSource employeeDataSource = new JRBeanCollectionDataSource(employees);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("employeeDataset", employeeDataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating report");
        }
    }
}
