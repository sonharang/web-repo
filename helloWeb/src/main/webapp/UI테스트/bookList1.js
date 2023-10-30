import { table } from "./bookModule.js";
let xhtp = new XMLHttpRequest();
xhtp.open('get', '../BookListServlet');
xhtp.send();
xhtp.onload = loadXML;

function loadXML() {
	console.log(xhtp.responseXML);
	let doc = xhtp.responseXML;
	let records = doc.getElementsByTagName('record')
	console.log(records);
	//	console.log(records[0].children[0].innerHTML);
	let titles = ["도서코드", "도서명", "저자", "출판사", "가격","삭제"];
	let dataAry = [];
	for (let record of records) {
		let obj = {
			id: record.children[0].textContent,
			name: record.children[1].textContent,
			writer: record.children[2].textContent,
			publish: record.children[3].textContent,
			price: record.children[4].textContent
		}
		dataAry.push(obj);

	}
	let result = table.makeTable(titles, dataAry);
	console.log(result);
	document.getElementById("show").innerHTML = result;
	}