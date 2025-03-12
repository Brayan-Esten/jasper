package com.example.jasper.service;

import com.example.jasper.model.dto.EmployeeDTO;
import com.example.jasper.model.dto.JobHistoryDTO;
import com.example.jasper.model.entity.Employee;
import com.example.jasper.repository.EmployeeRepository;
import com.example.jasper.repository.JobHistoryRepository;
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
    private final JobHistoryRepository jobHistoryRepository;

    public JasperReportService(ResourceLoader resourceLoader,
                               EmployeeRepository employeeRepository, JobHistoryRepository jobHistoryRepository)
    {
        this.resourceLoader = resourceLoader;
        this.employeeRepository = employeeRepository;
        this.jobHistoryRepository = jobHistoryRepository;
    }

    public byte[] generateEmployeeReport () {
        try {
            InputStream employeeReport = resourceLoader.getResource("classpath:jasper-report/employee_report.jrxml").getInputStream();
            JasperReport mainReport = JasperCompileManager.compileReport(employeeReport);

            InputStream jobHistoryReport = resourceLoader.getResource("classpath:jasper-report/job_history_report.jrxml").getInputStream();
            JasperReport subReport = JasperCompileManager.compileReport(jobHistoryReport);

            List<EmployeeDTO> employees = employeeRepository.findAllEmployees();
            JRBeanCollectionDataSource employeeDataSource = new JRBeanCollectionDataSource(employees);

            List<JobHistoryDTO> jobHistories = jobHistoryRepository.findAllJobHistories();
            JRBeanCollectionDataSource jobHistoriesDataSource = new JRBeanCollectionDataSource(jobHistories);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("employeeDataset", employeeDataSource);
            parameters.put("jobHistoryReport", subReport);
            parameters.put("jobHistoryReportParameter", new HashMap<String, Object>().put("jobHistoryDataset", jobHistoriesDataSource));

            JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, parameters, new JREmptyDataSource());

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating report");
        }
    }
}
