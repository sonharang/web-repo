//ajax1.js
//Asynchronous JavaScript And XML;

import { table } from "./ajaxModule.js";

//비동기, 동기

//동기 : 순차적 진행
let friends = [];

friends.push('홍길동');

friends.push('김길동');

friends.push('박길동');

//console.log(friends);

//비동기 : 설정값순
let friends1 = [];

setTimeout(function() {
	friends1.push('홍길동');
}, 1000);
setTimeout(function() {
	friends1.push('김길동');
}, 500);
setTimeout(function() {
	friends1.push('박길동');
}, 100);


//console.log(friends1);


//
let newMember ={mid: "M009", pass: "9999", name: "민식", phone: "010-9999-0000"};
//newMember 값을 활용해서 tbody = "list" 추가

//1 ajax 실행
let xhtp = new XMLHttpRequest();

//JSON

//xhtp.open('get', '../MemberListServ'); 
//xhtp.send();
//xhtp.onload = loadJson;

//XML

xhtp.open('get', '../MemberListServ2');
xhtp.send();
xhtp.onload = loadXML;

function loadJson(){
	 console.log(xhtp.responseText);

    let result = JSON.parse(xhtp.responseText);

    console.log(result);

    let titles = ["회원번호", "비밀번호", "이름", "연락처"];

    let tb = table.makeTable(titles, result);

    document.getElementById('show').innerHTML = tb;
}

function loadXML() {
	console.log(xhtp.responseXML);
	let doc = xhtp.responseXML;
	let records = doc.getElementsByTagName('record')
	console.log(records);
	//	console.log(records[0].children[0].innerHTML);
	let titles = ["회원번호", "비밀번호", "이름", "연락처"];
	let dataAry = [];
	for (let record of records) {
		let obj = {
			mid: record.children[0].textContent,//mid
			pass: record.children[1].textContent,//pass
			name: record.children[2].textContent,//name
			phone: record.children[3].textContent//phone
		}
		dataAry.push(obj);
		
	}
	dataAry.push(newMember);
	let result = table.makeTable(titles, dataAry);
	console.log(result);
	document.getElementById("show").innerHTML = result;
	
	//newMember 추가 다른 방법 ajax 실행이 되고 나서 추가하는 기능 실행
//	let tr  = '<tr><td>' + newMember.mid + '</td><td>' + newMember.pass + '</td><td>' + newMember.name + '</td><td>' + newMember.phone + '</td></tr>';
	
//	document.getElementById('list').innerHTML += tr;
}// end of onload 함수.

