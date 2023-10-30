import { table } from "./ajaxModule.js";
let xhtp = new XMLHttpRequest();

//JSON

xhtp.open('get', '../MemberListServ');
xhtp.send();
xhtp.onload = loadJson;

function loadJson() {
	console.log(xhtp.responseText);

	let result = JSON.parse(xhtp.responseText);

	console.log(result);

	let titles = ["회원번호", "비밀번호", "이름", "연락처"];

	let tb = table.makeTable(titles, result);

	document.getElementById('show').innerHTML = tb;

	//	교수님 방식
	// console.log(xhtp.responseText);
	//let result = JSON.parse(xhtp.responseText);
	//console.log(result);
	//let titles = ["회원번호", "비밀번호", "이름", "연락처"];
	//let dataAry = [];
	//	result.forEach(member => {
	//		dataAry.push({
	//			mid : member.mid, pass: member.pass, 
	//			name: member.name, phone: member.phone
	//		})
	//	})
	//	 result = table.makeTable(titles, dataAry);
	//	 document.getElementById("show").innerHTML = result;
}

