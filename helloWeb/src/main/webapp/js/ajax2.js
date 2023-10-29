import { table } from "./ajaxModule.js";
let xhtp = new XMLHttpRequest();

//JSON

xhtp.open('get', '../MemberListServ'); 
xhtp.send();
xhtp.onload = loadJson;

//XML

//xhtp.open('get', '../MemberListServ2');
//xhtp.send();
//xhtp.onload = loadXML;

function loadJson(){
	 console.log(xhtp.responseText);

    let result = JSON.parse(xhtp.responseText);

    console.log(result);

    let titles = ["회원번호", "비밀번호", "이름", "연락처"];

    let tb = table.makeTable(titles, result);

    document.getElementById('show').innerHTML = tb;
}