//ajax3.js
import { table } from "./ajaxModule.js";

//onclick 이벤트 등록 <button onclick="addMember()">
//member ={name:"hong",age:20} member.name
document.getElementById('addBtn').onclick = addMember;

function addMember(e) {
	let mid = document.getElementById('mid').value;
	let pass = document.getElementById('pass').value;
	let name = document.getElementById('name').value;
	let phone = document.getElementById('phone').value;


	const xhtp = new XMLHttpRequest();
	//xhtp.open('get','서블릿?param=val&param=val');
	xhtp.open('get', '../AddMemberServ.html?mid=' + mid + '&pass=' + pass
		+ '&name=' + name + '&phone=' + phone);
	xhtp.send();
	xhtp.onload = function() {
		console.log(xhtp.responseText);
		//사용자 입력값 : retCode = OK => {vo: mid, pass, name, phone}
		//tr 생성해서 td생성 id = list에 누적해서 화면 출력
		//id ="list"의 innerHTML 속성활용 
		//retCode = NG => alert('처리중 에러')
		let result = JSON.parse(xhtp.responseText);
		if (result.retCode == "OK") {
			let tr = '<tr><td>' + result.vo.mid + '</td><td>' + result.vo.pass + '</td><td>' + result.vo.name + '</td><td>' + result.vo.phone + '</td></tr>';
			document.getElementById('list').innerHTML += tr;
		} else {
			alert('처리중 에러');
		}

	}

}

document.getElementById('modBtn').onclick = modMember;

function modMember(e) {
	let mid = document.getElementById('mid').value;
	let pass = document.getElementById('pass').value;
	let name = document.getElementById('name').value;
	let phone = document.getElementById('phone').value;


	const xhtp = new XMLHttpRequest();

	xhtp.open('get', '../ModMemberServ.do?mid=' + mid + '&pass=' + pass
		+ '&name=' + name + '&phone=' + phone);
	xhtp.send();
	xhtp.onload = function() {
		let result = JSON.parse(xhtp.responseText);

		//데이터 영역의 tr
		if (result.retCode == "OK") {
			document.querySelectorAll('#list tr').forEach(tr => {
				console.log(tr.children)
				if (tr.children[0].innerHTML == result.vo.mid) {
					tr.children[1].innerHTML = result.vo.pass;
					tr.children[2].innerHTML = result.vo.name;
					tr.children[3].innerHTML = result.vo.phone;
				}
			})
		} else {
			alert('처리중 에러');
		}
		//다른방법
		/*if (result.retCode == "OK") {
			let tr = '<tr><td>' + result.vo.mid + '</td><td>' + result.vo.pass + '</td><td>' + result.vo.name + '</td><td>' + result.vo.phone + '</td></tr>';
			document.getElementById('list').innerHTML += tr;
		} else {
			alert('처리중 에러');
		}*/

	}
	}
	document.getElementById('delBtn').onclick = delMember;

	function delMember(e) {
		let mid = document.getElementById('mid').value;
		let pass = document.getElementById('pass').value;
		let name = document.getElementById('name').value;
		let phone = document.getElementById('phone').value;

		const xhtp = new XMLHttpRequest();

		xhtp.open('get', '../DelMemberServ.dd?mid=' + mid + '&pass=' + pass
			+ '&name=' + name + '&phone=' + phone);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == "OK") {
				alert('삭제완료');
			} else {
				alert('처리중 에러');
			}

		}
	}
