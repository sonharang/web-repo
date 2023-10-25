//object3.js

const member = {
	name: "홍길동",
	age: 10,
	height: 190,
	showInfo: function() {
		return `이름은 ${this.name}이고, 나이는 ${this.age}세 입니다.`
	},
	html: '',

	makeTr: function(student) {
		let tr = ''
		tr += '<tr>';
		for (let prop in student) {
			tr += '<td>' + student[prop] + '</td>';
		}
		//tr += '<td>' + student.sno + '</td>';
		//tr += '<td>' + student.sname + '</td>';
		//tr += '<td>' + student.engScore + '</td>';
		//tr += '<td>' + student.mathScore + '</td>';
		tr += '<td><button onclick = "this.parentElement.parentElement.remove()">삭제</button></td>';
		tr += '</tr>';
		return tr;
	},
	makeHtml(studAry) {
		let table = '<table border = "1"><tbody>';
		table += studAry.reduce((acc, stud) => acc + this.makeTr(stud), '');
		table += '</tbody></table>';
		this.html = table;
	},
	showPage(dom) {
		dom.innerHTML += this.html;
	}
}
//객체의 속성 for ..in
for (let prop in member) {
	//member.name / member['age'] / 가져오는방식 2가지	
	console.log(prop);
	console.log(member[prop]);
	console.log(typeof member[prop]);
	if (typeof member[prop] != 'function') {
		console.log(member[prop]);
	}
}

const students = [
	{ sno: '001', sname: "최해주", engScore: 80, mathScore: 85 },
	{ sno: '002', sname: "김채민", engScore: 82, mathScore: 83 },
	{ sno: '003', sname: "최다예", engScore: 84, mathScore: 88 },
]

member.makeHtml(students);
member.showPage(document.getElementById('show'));
