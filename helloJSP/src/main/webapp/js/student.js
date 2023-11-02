
//페이지 로딩되면서 바로 실행
fetch('../studentList.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result); //result -> 배열
		let tbody = document.querySelector('#list');
		result.forEach(student => {
			tbody.append(makeTr(student));
		})
	})
	.catch(err => console.log('error=> ', err));

//등록버튼 이벤트	
document.querySelector('#addBtn').addEventListener('click', addCallback);

//callback 함수 입력 querySelector,getElementById 둘다 사용가능
function addCallback(e) {
	//학생아이디 입력값
	let sid = document.querySelector('input[name=sid]').value;
	//학생이름 입력값
	//let sname = document.querySelector('#sname').value;
	let sname = document.getElementById('sname').value;
	//비밀번호 입력값
	let pass = document.querySelector('input[name=spassword]').value;
	//전공 입력값 선택해야하는거라 select 사용 input은 입력값
	let dept = document.querySelector('select[name=sdept]').value;
	//생년월일 입력값
	let birth = document.querySelector('input[name=sbirth]').value;
	//파라메터 이름, = 뒤에는 값, 엠퍼센트&로 연결 ,공백넣으면 오류
	let param = `id=${sid}&name=${sname}&password=${pass}&dept=${dept}&birth=${birth}`;
	console.log(param);

	//ajax 호출
	//기본 get 방식 호출(주소창 입력가능) , get: url패턴, 입력 값 제한있음
	//fetch('../addStudent.do?' + param)
	//옵션 post방식 , post: 파라메터(url) 표현X, 입력 값 제한없음, Content-type 지정
	fetch('../addStudent.do?', {
		method: 'post',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: param
	})
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('성공');
				let tr = makeTr({ studentId: sid, studentName: sname, studentPassword: pass, studentDept: dept, studentBirthday: birth });
				document.querySelector('#list').append(tr);
			} else {
				alert('실패');

			}
		})
		.catch(err => console.log('error =>', err));
}

//tr 생성함수
function makeTr(obj) {
	let showFields = ['studentId', 'studentName', 'studentDept', 'studentBirthday']
	let tr = document.createElement('tr');
	tr.addEventListener('dblclick', showModal);

	for (let prop of showFields) {
		let td = document.createElement('td');
		td.innerHTML = obj[prop];
		tr.append(td);
	}

	//삭제 버튼
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('data-sid', obj.studentId);
	btn.innerHTML = '삭제';
	btn.addEventListener('click', function(e) {
		//ajax호출 -> 서블릿실행
		fetch('../delStudent.do?sid=' + obj.studentId)
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result);
				if (result.retCode == 'OK') {
					alert('삭제성공');
					tr.remove();
				} else {
					alert('삭제실패');
				}
			})
			.catch(err => ('error: ', err));
	})
	td.append(btn);
	tr.append(td);

	return tr;
}//end of makeTr

//modal 보여주기
function showModal(e) {
	console.log(e.target.parentElement,this);
	let id = this.children[0].innerHTML;
	console.log(id);
	// Get the modal
	var modal = document.getElementById("myModal");
	modal.style.display = "block";
	
	let data = {id:"st1",name: "홍길동",pass:"1234",birth:"2004-01-01"};
	
	
	//헤더
	modal.querySelector('h2').innerHTML = data.name;
	modal.querySelector('input[name=pass').value=data.pass;
	modal.querySelector('input[name=name').value=data.name;
	modal.querySelector('input[name=birth').value=data.birth;
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	//바깥 기능
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}

