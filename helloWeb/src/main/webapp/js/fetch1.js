//fetch1.js
import { table } from "./ajaxModule.js";

fetch('../MemberListServ') //promise 객체로 생성
	.then((resolve) => {
		console.log(resolve);
		return resolve.json(); //json 문자열을 자바스크립트 객체타입(object)으로 넘겨줌 json -> object
	})
	.then((result) => {
		console.log(result);
		let titles = ["회원번호", "비밀번호", "이름", "연락처"];
		let dataAry = result;

		result = table.makeTable(titles, dataAry);
		document.getElementById("show").innerHTML = result;
	})
	.catch((err) => {
		console.log('error => ', err);
	})