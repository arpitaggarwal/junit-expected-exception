package com.example.junit.expected.exception.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.junit.expected.exception.custom.exception.EmployeeServiceException;
import com.example.junit.expected.exception.helper.ClassWithStaticMethod;
import com.example.junit.expected.exception.model.Request;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithStaticMethod.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addEmployeeForNull() throws EmployeeServiceException {
		expectedException.expect(EmployeeServiceException.class);
		expectedException.expectMessage("Invalid Request");
		employeeServiceImpl.addEmployee(null);
	}

	@Test
	public void addEmployee() throws EmployeeServiceException {
		PowerMockito.mockStatic(ClassWithStaticMethod.class);
		PowerMockito.when(ClassWithStaticMethod.getDetails(anyString()))
				.thenAnswer(new Answer<String>() {
					@Override
					public String answer(InvocationOnMock invocation)
							throws Throwable {
						Object[] args = invocation.getArguments();
						return (String) args[0];
					}
				});
		final String response = employeeServiceImpl.addEmployee(new Request(
				"Arpit"));
		PowerMockito.verifyStatic();
		assertThat(response, is("Arpit"));
	}

}
