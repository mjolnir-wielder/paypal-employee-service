package com.paypal.bfs.test.employeeserv.persistence.repo;

import com.paypal.bfs.test.employeeserv.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeResourceRepository extends JpaRepository<EmployeeEntity, String> {
}
