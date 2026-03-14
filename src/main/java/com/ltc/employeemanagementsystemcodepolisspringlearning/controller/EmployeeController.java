package com.ltc.employeemanagementsystemcodepolisspringlearning.controller;

import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.request.EmployeRequest;
import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.response.EmployeeResponse;
import com.ltc.employeemanagementsystemcodepolisspringlearning.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") //localhost:8080/employee
@Tag(name = "EMployee yaradiram",description = "Istifadechi CRUD edir")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @PostMapping("/create") //localhost:8080/employee/create POST
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Ugurla yaradildi"),
            @ApiResponse(responseCode = "400",description = "Method ishlemir"),
            @ApiResponse(responseCode = "500", description = "Server xetasi"),
    })
    @Operation(summary = "Istifadechi yaratmaq uchun yazmisham bu methodu",method = "200")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeRequest employeeRequest) {
        EmployeeResponse employeeResponse = employeeService.createEmployee(employeeRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    @GetMapping("/getAll") // localhost:8080/employee/getAll GET
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @GetMapping("/{indexId}") //localhost:8080/employee/5
    public ResponseEntity<EmployeeResponse> getById(@PathVariable int indexId){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(indexId));
    }

}
