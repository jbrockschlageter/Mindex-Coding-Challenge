package com.mindex.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @GetMapping("/compensation/create/{id}")
    public Compensation create(@PathVariable String id) {
        LOG.debug("Received compensation create request for [{}]", id);

        return compensationService.create(id);
    }

    @GetMapping("/compensation/read/{id}")
    public Compensation read(@PathVariable String id) {
        LOG.debug("Received compensation read request for id [{}]", id);

        return compensationService.read(id);
    }
}
