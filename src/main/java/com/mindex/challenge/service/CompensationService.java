package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;


public interface CompensationService {
    Compensation create(String employeeID);
    Compensation read(String employeeID);
}
