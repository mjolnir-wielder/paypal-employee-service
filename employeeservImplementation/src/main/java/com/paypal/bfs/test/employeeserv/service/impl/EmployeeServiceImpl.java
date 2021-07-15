package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.converter.EmployeeEntityConverter;
import com.paypal.bfs.test.employeeserv.exception.EmployeeErrorCode;
import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import com.paypal.bfs.test.employeeserv.persistence.entity.AddressEntity;
import com.paypal.bfs.test.employeeserv.persistence.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.persistence.repo.AddressResourceRepository;
import com.paypal.bfs.test.employeeserv.persistence.repo.EmployeeResourceRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.validator.EmployeeValidator;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final AddressResourceRepository addressResourceRepository;
    private final EmployeeResourceRepository employeeResourceRepository;

    public EmployeeServiceImpl(AddressResourceRepository addressResourceRepository, EmployeeResourceRepository employeeResourceRepository) {
        this.addressResourceRepository = addressResourceRepository;
        this.employeeResourceRepository = employeeResourceRepository;
    }

    @Override
    public Employee getById(String id) {

        EmployeeEntity employeeEntity = employeeResourceRepository.findById(id)
                .orElseThrow(() -> new EmployeeException(EmployeeErrorCode.EMPLOYEE_ID_NOT_FOUND));

        AddressEntity addressEntity = addressResourceRepository.findById(employeeEntity.getAddressId())
                .orElseThrow(() -> new EmployeeException(EmployeeErrorCode.ADDRESS_ID_NOT_FOUND));

        return EmployeeEntityConverter.convert(employeeEntity, addressEntity);
    }

    @Override
    public Employee create(Employee employee) {

        EmployeeValidator.validate(employee);
        AddressEntity addressEntity = EmployeeEntityConverter.convert(employee.getAddress());
        addressEntity = addressResourceRepository.save(addressEntity);

        EmployeeEntity employeeEntity = EmployeeEntityConverter.convert(employee);
        employeeEntity.setAddressId(addressEntity.getId());
        employeeEntity = employeeResourceRepository.save(employeeEntity);

        return EmployeeEntityConverter.convert(employeeEntity, addressEntity);
    }
}
