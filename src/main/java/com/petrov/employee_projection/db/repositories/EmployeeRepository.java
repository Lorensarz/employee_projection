package com.petrov.employee_projection.db.repositories;

import com.petrov.employee_projection.db.entities.Employee;
import com.petrov.employee_projection.db.repositories.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) AS fullName, e.position AS position, d.name AS department " +
            "FROM Employee e JOIN e.department d")
    List<EmployeeProjection> findAllProjections();

}
