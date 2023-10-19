package com.RohanMankame.employeemanager;


import com.RohanMankame.employeemanager.model.Employee;
import com.RohanMankame.employeemanager.service.EmployeeUTILITIES;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeFUNCTIONS {
    private final EmployeeUTILITIES employeeUTILITIES;

    public EmployeeFUNCTIONS(EmployeeUTILITIES employeeUTILITIES) {
        this.employeeUTILITIES = employeeUTILITIES;
    }

///////////////////////////////////////DELETE EXISTING USER

    @DeleteMapping ("/deleteID/{id}")
    public  ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeUTILITIES.deleteExistingEmployee(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping ("/deleteEMPID/{id}")
    public  ResponseEntity<?> deleteEmployeeID(@PathVariable("id") Long id){
        employeeUTILITIES.deleteExistingEmployeeID(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }


///////////////////////////////////////SEARCH USER BY ID

    @GetMapping("/SearchID/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeUTILITIES.findEmployeeId(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

///////////////////////////////////////VIEW ALL DATA ENTRIES

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeUTILITIES.GetAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    ///////////////////////////////////////EDIT

    @PutMapping ("/EditEntry")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeUTILITIES.updateEmployeeTables(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
    }


///////////////////////////////////////ADD

    @PostMapping("/addEmployee")
    public  ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeUTILITIES.addNewEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    ///////////////////////////////////////VIEW ALL Sorted DATA ENTRIES
    @GetMapping("/Sorted")
    public ResponseEntity<List<Employee>> getSortedEmployees(){
        List<Employee> employees = employeeUTILITIES.GetAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }




}
