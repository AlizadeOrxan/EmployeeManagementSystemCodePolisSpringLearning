package com.ltc.employeemanagementsystemcodepolisspringlearning.service;

import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.request.EmployeRequest;
import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.response.EmployeeResponse;
import com.ltc.employeemanagementsystemcodepolisspringlearning.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<EmployeRequest> employee = new ArrayList<>();


    public EmployeeResponse createEmployee(EmployeRequest employeeRequest) {
        employee.add(employeeRequest);

        /// Entity

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employeeRequest.getFirstName());
        employeeResponse.setLastName(employeeRequest.getLastName());
        employeeResponse.setEmail(employeeRequest.getEmail());

        return employeeResponse;
    }

    public List<EmployeeResponse> getAllEmployees() {
      return   employee.stream()
                .map(employe -> {
                    EmployeeResponse employeeResponse = new EmployeeResponse();
                    employeeResponse.setFirstName(employe.getFirstName());
                    employeeResponse.setLastName(employe.getLastName());
                    employeeResponse.setEmail(employe.getEmail());
                    return employeeResponse;

                }).toList();
    }

    public EmployeeResponse getById(int indexId){
        if (employee.isEmpty() || indexId >= employee.size()) {
            throw new EmployeeNotFoundException("Employee tapilmadi bu id ile " + indexId);
        }

        EmployeRequest employeeRequest = employee.get(indexId);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setFirstName(employeeRequest.getFirstName());
        employeeResponse.setLastName(employeeRequest.getLastName());
        employeeResponse.setEmail(employeeRequest.getEmail());
        return employeeResponse;
    }


}
