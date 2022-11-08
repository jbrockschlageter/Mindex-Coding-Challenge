package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure create(String employeeID){
        LOG.debug("Creating ReportingStructure with Employee ID [{}]", employeeID);

        ReportingStructure rs = new ReportingStructure();

        Employee employee =  employeeService.read(employeeID);
        int numOfReports = findNumberOfReports(employee);

        rs.setEmployee(employee);
        rs.setNumberOfReports(numOfReports);
        return rs;
    }

    private int findNumberOfReports(Employee employee){
        int num = findNumberOfReportsRecurrsively(employee);
        return num;
    }

    // Simplified DFS for a structured tree.
    private int findNumberOfReportsRecurrsively(Employee employee){
        int num = 0;

        if(employee.getDirectReports() == null){
            LOG.warn("Employee's direct reports have come up as null while creating ReportingStructure.");
            return 0;
        }

        if(employee.getDirectReports().isEmpty()){
            return 0;
        }

        for (Employee e : employee.getDirectReports()) {
            Employee nextEmployee = employeeService.read(e.getEmployeeId()); // To account for employee utility only reading in ID's
            num = num + findNumberOfReportsRecurrsively(nextEmployee) + 1;
        }
        return num;
    }
}
