package com.paypal.bfs.test.employeeserv.converter;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.employeeserv.persistence.entity.EmployeeEntity;

import java.util.Objects;

public class EmployeeEntityConverter {

    public static Employee convert(EmployeeEntity employeeEntity, AddressEntity addressEntity) {
        Employee employee = convert(employeeEntity);
        Address address = Objects.nonNull(addressEntity) ? convert(addressEntity) : null;
        employee.setAddress(address);
        return employee;
    }

    public static EmployeeEntity convert(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setDateOfBirth(employee.getDateOfBirth());
        return employeeEntity;
    }

    public static AddressEntity convert(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(address.getCity());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setState(address.getState());
        addressEntity.setLine1(address.getLine1());
        addressEntity.setLine2(address.getLine2());
        addressEntity.setZipCode(address.getZipCode());
        return addressEntity;
    }

    public static Employee convert(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();

        employee.setId(Integer.parseInt(employeeEntity.getId()));
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setDateOfBirth(employeeEntity.getDateOfBirth());

        return employee;
    }

    public static Address convert(AddressEntity addressEntity) {
        Address address = new Address();

        address.setId(Integer.parseInt(addressEntity.getId()));
        address.setLine1(addressEntity.getLine1());
        address.setLine2(addressEntity.getLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipCode(addressEntity.getZipCode());

        return address;
    }
}
