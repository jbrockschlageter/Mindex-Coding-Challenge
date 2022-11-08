package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CompensationServiceImpl implements CompensationService {
    
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired CompensationRepository compensationRepository;

    @Override
    public Compensation create(String employeeID) {
        LOG.debug("Creating Compensation for employee # [{}]", employeeID);
        
        Compensation c = new Compensation();

        c.setEmployee(employeeService.read(employeeID));
        c.setEmployeeId();

        // TODO: Salary and Eff. Date missing?

        compensationRepository.insert(c); 
        return c;
    }

    @Override
    public Compensation read(String employeeID) {
        LOG.debug("Reading Compensation for employee # [{}]", employeeID);

        Compensation c = compensationRepository.findCompensationByEmployeeId(employeeID);

        if (c == null) {
            LOG.debug("Existing Compensation not found for employee # [{}]. Please create one instead.", employeeID);
        }
        return c;
    }
}
