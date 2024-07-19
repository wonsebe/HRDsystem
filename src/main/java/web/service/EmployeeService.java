package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.EmployeeDao;
import web.model.dto.EmployeeDto;

import java.util.ArrayList;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    // 1. 사원등록
    public boolean eAdd(EmployeeDto employeeDto){
        return employeeDao.eAdd(employeeDto);
    }
    // 2. 사원출력
    public ArrayList<EmployeeDto> ePrint(){
        return employeeDao.ePrint();
    }
    // 3. 사원수정
    public boolean eUpdate(EmployeeDto employeeDto){
        return employeeDao.eUpdate(employeeDto);
    }
    /// 4. 사원삭제
    public boolean eDelete(EmployeeDto employeeDto){
        return employeeDao.eDelete(employeeDto);
    }
}
