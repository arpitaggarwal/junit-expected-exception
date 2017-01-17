package com.example.junit.expected.exception.service;

import com.example.junit.expected.exception.custom.exception.EmployeeServiceException;
import com.example.junit.expected.exception.model.Request;

public interface IEmployeeService {

	String addEmployee(final Request request) throws EmployeeServiceException;
}
