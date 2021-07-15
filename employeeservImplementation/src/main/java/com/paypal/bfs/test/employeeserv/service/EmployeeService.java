package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

public interface EmployeeService {

    Employee getById(String id);

    Employee create(Employee employee);
}
