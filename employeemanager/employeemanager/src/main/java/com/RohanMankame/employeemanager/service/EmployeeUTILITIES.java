package com.RohanMankame.employeemanager.service;

import com.RohanMankame.employeemanager.exception.UserNotFoundException;
import com.RohanMankame.employeemanager.model.Employee;
import com.RohanMankame.employeemanager.repo.StaffDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeUTILITIES {
    private final StaffDataRepo staffDataRepo;

    @Autowired
    public EmployeeUTILITIES(StaffDataRepo staffDataRepo){
        this.staffDataRepo = staffDataRepo;
    }

    public Employee addNewEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return staffDataRepo.save(employee);
    }

    public List<Employee> GetAllEmployees(){
        return staffDataRepo.findAll();
    }

    public Employee updateEmployeeTables(Employee employee){
        return staffDataRepo.save(employee);
    }

    public void deleteExistingEmployee(Long id){
        staffDataRepo.deleteEmployeeById(id);
    }

    public void deleteExistingEmployeeID(Long id){
        staffDataRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeId(Long id){
        return staffDataRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("User was not found"));
    }


}
