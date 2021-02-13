package com.pim.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pim.domain.entity.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

}
