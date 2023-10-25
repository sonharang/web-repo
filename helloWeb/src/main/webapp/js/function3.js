//function3.js
//console.log("function3.js");
function Member(name, age, height){
	console.log(this);
	this.name = name;
	this.age = age;
	this.height = height;
	this.showInfo = function(){		
	return `이름은 ${this.name}이고 나이는 ${this.age}입니다.`;
	}
}
var myName = 'Hong';
const member = new Member('홍길동', 20, 123.4);
console.log(member.showInfo());
//window.alert("!!!");
const members = [
	new Member('홍길동', 18, 123.3),
	new Member('김길동', 19, 133.3),
	new Member('박길동', 20, 143.3)
]

//함수: table 생성.
function makeTable(memberAry = []){
	let str ="";
	str += '<table border = "1">';
	str += '<tbody>';
	members.forEach(function(item){
		str += makeTr(item);
	})
	str += '</tbody>';
	str += '</table><br>';
	
	document.getElementById("show").innerHTML = str;
	
function makeTr(member){
	let html = '';	
	html += '<tr>';
	html += '<td>' + member.name + '</td>';
	html += '<td>' + member.age + '</td>';
	html += '<td>'+ member.height +'</td>';
	html += '<td>'+ member.showInfo() +'</td>';
	html += '</tr>';
	return html;
	}
}
makeTable(members);


	let str1 = "";
	function makeTable1(memberAry = []){
		str1 += '<table border = "1"><thead><tr><th>이름</th><th>나이</th><th>신장</th><th>비고</th></tr></thead><tbody>';
		memberAry.forEach(function(item){
			str1 += `<tr><td>${item.name}</td><td>${item.age}</td><td>${item.height}</td><td>${item.showInfo()}</td></tr>`;
		})		
		str1 += '</tbody></table><br>';
		return str1;	
	}
	let show = document.getElementById('show');
	show.innerHTML += makeTable1(members);
