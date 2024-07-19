package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.DepartmentDto;
import web.service.DepartmentService;

import java.util.ArrayList;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    // 1. 부서 등록
    @PostMapping("/dadd")
    public boolean dAdd(DepartmentDto departmentDto) {
        return departmentService.dAdd(departmentDto);
    }

    // 2. 부서 전체 출력
    @GetMapping("/dprint")
    public ArrayList<DepartmentDto> dPrint() {
        return departmentService.dPrint();
    }

    // 3. 부서 수정
    @PutMapping("/dupdate")
    public boolean dUpdate(DepartmentDto departmentDto) {
        return departmentService.dUpdate(departmentDto);
    }

    // 4. 부서 삭제
    @DeleteMapping("/ddelete")
    public boolean dDelete(int dno) {
        return departmentService.dDelete(dno);
    }

}
