console.log('department.js');

// 1. 부서 등록
function dAdd() {   console.log('dAdd()');
  let dname = document.querySelector('#dname').value;
  let dcontact = document.querySelector('#dcontact').value;

  let info = {
    dname : dname, dcontact : dcontact
  }

  $.ajax({
    async : false,
    method : 'post',
    url : '/department/dadd',
    data : info,
    success : (result) => { console.log(result);
      if (result) {
        alert('부서등록성공');
        dPrint();
      } else {
        alert('부서등록실패');
      }
    }

  });
}


// 2. 부서 전체 출력
dPrint();
function dPrint() {
  $.ajax({
    method : 'get',
    url : '/department/dprint',
    success : (result) => { console.log(result);
      let dBox = document.querySelector('#dBox');
      let html = ``;

      result.forEach(departmentDto => {
        html += `
                <tr>
                  <td> ${departmentDto.dno} </td>
                  <td> ${departmentDto.dname} </td>
                  <td> ${departmentDto.dcontact} </td>
                  <td> <button type="button" onclick="dUpdate(${departmentDto.dno})">수정</button> </td>
                  <td> <button type="button" onclick="dDelete(${departmentDto.dno})">삭제</button> </td>
                </tr>
                `;
      });
  
      dBox.innerHTML = html;
    }
    
  });
}


// 3. 부서 수정
function dUpdate(dno) {
  let dname = prompt('수정할 부서명을 입력해주세요.');
  let dcontact = prompt('수정할 대표전화를 입력해주세요.');

  $.ajax({
    method : 'put',
    url : '/department/dupdate',
    data : { 'dname' : dname, 'dcontact' : dcontact, 'dno' : dno },
    success : (result) => {   console.log(result);
      if (result) {
        alert('부서수정성공');
        dPrint();
      } else {
        alert('부서수정실패');
      }
    }
  });

}


// 4. 부서 삭제
function dDelete(dno) {
  $.ajax({
    method : 'delete',
    url : '/department/ddelete',
    data : { 'dno' : dno },
    success : (result) => {   console.log(result);
      if (result) {
        alert('부서삭제성공');
        dPrint();
      } else {
        alert('부서삭제실패');
      }
    }
  });
}
