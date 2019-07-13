/**
 * 
 */
package com.performance.logging.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.performance.logging.Employee;

/**
 * @author Sumanth
 *
 */
@Component
public class EmployeeService {
	
	public List<Employee> getEmployees()
	{
		List<Employee> list = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list.add(new Employee("user"+i));
		}
		return list;
	}

}
