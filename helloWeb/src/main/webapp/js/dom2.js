//dom2.js

const fruits = [
	{ id : "1", name: "수박", price: "3000", farmer: "홍길동" },
	{ id : "2", name: "사과", price: "1000", farmer: "김민서" },
	{ id : "3", name: "복숭아", price: "1500", farmer: "최말숙" },
	{ id : "4", name: "포도", price: "2000", farmer: "김선중" }
]
//#show>table>tbody>(tr>td: 사과 + td: 1000) + (tr>td: 수박....

//table
const table = document.createElement('table');
table.setAttribute('border', '1');

const tbody = document.createElement('tbody');

fruits.forEach((fruit) => {
	//console.log(fruit);
	const tr = document.createElement('tr');

	//반복문 활용해서 한 번에 출력
		for(let prop in fruit){
			const td = document.createElement('td');
		td.innerHTML = fruit[prop];
		tr.appendChild(td);
		}
	/*const td1 = document.createElement('td');
	td1.innerHTML = fruit.name;
	tr.appendChild(td1);

	const td2 = document.createElement('td');
	td2.innerHTML = fruit.price;
	tr.appendChild(td2);*/

	tbody.appendChild(tr); //tbody에 tr을 하위요소로 등록
})
table.appendChild(tbody); //table에 tbody를 하위요소로 등록

document.getElementById('show').appendChild(table);

console.log(table);