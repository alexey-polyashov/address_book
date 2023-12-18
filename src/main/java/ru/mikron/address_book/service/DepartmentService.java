package ru.mikron.address_book.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikron.address_book.dto.DepartmentData;
import ru.mikron.address_book.dto.DepartmentsList;
import ru.mikron.address_book.dto.PersonData;
import ru.mikron.address_book.entity.Department;
import ru.mikron.address_book.entity.Person;
import ru.mikron.address_book.mapper.DepartmentMapper;
import ru.mikron.address_book.mapper.PersonMapper;
import ru.mikron.address_book.repository.DepartmentRepo;
import ru.mikron.address_book.exception.NotFoundException;
import ru.mikron.address_book.utility.DepartmentIDs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;
    private final PersonMapper personMapper;

    private List<DepartmentData> deepDepartmentsPass(List<Department> depList, Department parent){
        List<DepartmentData> depListDto = new ArrayList<>();
        for(Department d: depList){
            if(d.getParent() == parent) {
                DepartmentData depData = departmentMapper.toDepartmentData(d);
                depData.setSubDepartments(deepDepartmentsPass(depList, d));
                depListDto.add(depData);
            }
        }
        return depListDto;
    }

    private List<Long> getDepartmentsIDs(List<DepartmentIDs> depList, Long parentId){
        List<Long> depIDs= new LinkedList<>();
        for(DepartmentIDs d: depList){
            if(parentId.equals(d.getParentID())) {
                depIDs.add(d.getId());
                depIDs.addAll(getDepartmentsIDs(depList, d.getId()));
            }
        }
        return depIDs;
    }

    public DepartmentsList getDepartmentList(){
        List<Department> depList = departmentRepo.findAllDepartment();
        DepartmentsList depListDto = new DepartmentsList();
        depListDto.setDepartments(deepDepartmentsPass(depList, null));
        return  depListDto;
    }

    public List<Long> collectSunDepartmentsIDs(Long parentId){
        List<DepartmentIDs> depList = departmentRepo.getAllIDs();
        List<Long> depIDs = new ArrayList<>();
        depIDs = getDepartmentsIDs(depList, parentId);
        return  depIDs;
    }

    public List<PersonData> getEmployees(Long departmentId, Boolean deeply){
        deeply = deeply != null;
        List<Long> departmentIDs = new LinkedList<>();
        if(deeply){
            departmentIDs = collectSunDepartmentsIDs(departmentId);
        }else{
            departmentIDs.add(departmentId);
        }
        List<Person> employees = departmentRepo.getEmployees(departmentIDs);
        return employees.stream()
                .map(personMapper::toPersonData)
                .collect(Collectors.toList());
    }

    public PersonData getHead(Long departmentId){
        return personMapper.toPersonData(departmentRepo.findDepartmentById(departmentId)
                .orElseThrow(()->new NotFoundException("Подразделение с id '" + departmentId + "' не найдено")).getHead());
    }


}
