package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.DepartmentDto;
import web.model.dto.EmployeeDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class EmployeeDao extends  Dao{

    // 1. 사원등록
    public boolean eAdd(EmployeeDto employeeDto){
        try {
            String sql="insert into employee(ename,econtact,erank ,dno ) values( ?, ? , ?, ? );";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, employeeDto.getEname());
            ps.setString(2, employeeDto.getEcontact());
            ps.setString(3,employeeDto.getErank());
            ps.setInt(4,employeeDto.getDno());
            int count= ps.executeUpdate();
            if (count==1){
                return true;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    // 2. 사원출력
    public ArrayList<EmployeeDto> ePrint(){
        ArrayList<EmployeeDto> list = new ArrayList<>();
        try {

            String sql=" select *from employee inner join department on employee.dno=department.dno;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                EmployeeDto employeeDto = EmployeeDto.builder()
                        .dno(rs.getInt("dno"))
                        .ename(rs.getString("ename"))
                        .econtact(rs.getString("econtact"))
                        .erank(rs.getString("erank"))
                        .eno(rs.getInt("eno"))
                        .dname(rs.getString("dname"))
                        .build();
                list.add(employeeDto);
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }
    // 3. 사원수정
    public boolean eUpdate(EmployeeDto employeeDto){
        try {
            String sql="update employee set ename = ? , econtact= ?, erank=? where eno = ?;";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,employeeDto.getEname());
            ps.setString(2,employeeDto.getEcontact());
            ps.setString(3,employeeDto.getErank());
            ps.setInt(4,employeeDto.getEno());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
    /// 4. 사원삭제
    public boolean eDelete(EmployeeDto employeeDto){
        try {
            String sql = "delete from employee where eno = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeDto.getEno());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
