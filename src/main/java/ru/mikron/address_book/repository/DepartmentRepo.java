package ru.mikron.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikron.address_book.entity.Department;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findAllDepartment();
    Department findDepartmentById(Long id);
    List<Department> findDepartmentByName(String name);
    List<Department> findDepartmentByCode(String code);

}
