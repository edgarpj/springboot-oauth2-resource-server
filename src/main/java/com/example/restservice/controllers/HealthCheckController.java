package com.example.restservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class HealthCheckController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity healthCheck(){
        return new ResponseEntity<>(Collections.singletonMap("available", true), HttpStatus.OK);
    }

}
