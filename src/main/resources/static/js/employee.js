console.log('employee.js');



// 1. 사원 등록
function eAdd() {   console.log('eAdd()');
  let ename = document.querySelector('#ename').value;
  let econtact = document.querySelector('#econtact').value;
  let erank = document.querySelector('#erank').value;
  let dno = document.querySelector('#dno').value;

  let info = {
    ename : ename, econtact : econtact ,erank: erank ,
    dno :dno
  }

  $.ajax({
    async : false,
    method : 'post',
    url : '/employee/eadd',
    data : info,
    success : (result) => { console.log(result);
      if (result) {
        alert('사원등록성공');
        ePrint();
      } else {
        alert('사원등록실패');
      }
    }

  });
}


// 2. 사원 전체 출력
ePrint();
function ePrint() {
  $.ajax({
    method : 'get',
    url : '/employee/eprint',
    success : (result) => { console.log(result);
      let eBox = document.querySelector('#eBox');
      let html = ``;

      result.forEach(employeeDto => {
        html += `
                <tr>
                  <td> ${employeeDto.eno} </td>
                  <td> ${employeeDto.ename} </td>
                  <td> ${employeeDto.econtact} </td>
                  <td> ${employeeDto.erank} </td>
                  <td> ${employeeDto.dname} </td>
                  <td> <button type="button" onclick="eUpdate(${employeeDto.eno})">수정</button> </td>
                  <td> <button type="button" onclick="eDelete(${employeeDto.eno})">삭제</button> </td>
                </tr>
                `;
      });
  
      eBox.innerHTML = html;
    }
    
  });
}


// 3. 사원 수정
function eUpdate(eno) {
  let ename = prompt('수정할 사원이름을 입력해주세요.');
  let econtact = prompt('수정할 연락처를 입력해주세요.');
  let erank = prompt('수정할 직급을 입력해주세요.');

  $.ajax({
    method : 'put',
    url : '/employee/eupdate',
    data : { 'ename' : ename, 'econtact' : econtact, 'erank' : erank , 'eno':eno },
    success : (result) => {   console.log(result);
      if (result) {
        alert('사원수정성공');
        ePrint();
      } else {
        alert('사원수정실패');
      }
    }
  });

}


// 4. 사원 삭제
function eDelete(eno) {
  $.ajax({
    method : 'delete',
    url : '/employee/edelete',
    data : { 'eno' : eno },
    success : (result) => {   console.log(result);
      if (result) {
        alert('사원삭제성공');
        ePrint();
      } else {
        alert('사원삭제실패');
      }
    }
  });
}
