package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.model.dto.EmployeeDto;
import web.service.EmployeeService;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // 1. 사원등록
    @PostMapping("/eadd")
    public boolean eAdd(EmployeeDto employeeDto){
        return employeeService.eAdd(employeeDto );
    }
    // 2. 사원출력
    @GetMapping("/eprint")
    public ArrayList<EmployeeDto> ePrint(){
        return employeeService.ePrint();
    }
    // 3. 사원수정
    @PutMapping("/eupdate")
    public boolean eUpdate(EmployeeDto employeeDto){
        return employeeService.eUpdate(employeeDto);
    }
    /// 4. 사원삭제
    @DeleteMapping("/edelete")
    public boolean eDelete(EmployeeDto employeeDto){
        return employeeService.eDelete(employeeDto);
    }


}
