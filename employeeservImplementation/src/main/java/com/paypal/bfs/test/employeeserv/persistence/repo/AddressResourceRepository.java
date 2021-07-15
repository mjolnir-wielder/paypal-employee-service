package com.paypal.bfs.test.employeeserv.persistence.repo;

import com.paypal.bfs.test.employeeserv.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressResourceRepository extends JpaRepository<AddressEntity, String> {
}
