package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.DepartmentDao;
import web.model.dto.DepartmentDto;

import java.util.ArrayList;

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    // 1. 부서 등록
    public boolean dAdd(DepartmentDto departmentDto) {
        return departmentDao.dAdd(departmentDto);
    }

    // 2. 부서 전체 출력
    public ArrayList<DepartmentDto> dPrint() {
        return departmentDao.dPrint();
    }

    // 3. 부서 수정
    public boolean dUpdate(DepartmentDto departmentDto) {
        return departmentDao.dUpdate(departmentDto);
    }

    // 4. 부서 삭제
    public boolean dDelete(int dno) {
        return departmentDao.dDelete(dno);
    }

}
