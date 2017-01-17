package com.example.junit.expected.exception.service;

import com.example.junit.expected.exception.custom.exception.EmployeeServiceException;
import com.example.junit.expected.exception.helper.ClassWithStaticMethod;
import com.example.junit.expected.exception.model.Request;

public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public String addEmployee(final Request request)
			throws EmployeeServiceException {
		if (request == null) {
			throw new EmployeeServiceException("Invalid Request");
		} else {
			return ClassWithStaticMethod.getDetails(request.getName());
		}
	}
}
