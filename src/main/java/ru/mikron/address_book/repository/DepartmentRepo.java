package ru.mikron.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mikron.address_book.entity.Department;
import ru.mikron.address_book.entity.Person;
import ru.mikron.address_book.utility.DepartmentIDs;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findAllDepartment();
    Optional<Department> findDepartmentById(Long id);
    List<Department> findDepartmentByName(String name);
    List<Department> findDepartmentByCode(String code);

    @Query("Select p From Person p Where p.department in (" +
            "Select d From Department d Where d.id in :departmentIDs" +
            ")")
    List<Person> getEmployees(List<Long> departmentIDs);

    @Query("Select d.id, d.parent.id From Department d")
    List<DepartmentIDs> getAllIDs();
}
