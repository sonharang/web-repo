//array2.js : MOCK_DATA.json 파일의 데이터 활용.
const json = `
[{"id":1,"first_name":"Rahal","email":"rottam0@geocities.jp"},
{"id":2,"first_name":"Rorie","email":"rconnue1@ucla.edu"},
{"id":3,"first_name":"Florencia","email":"fburhill2@bluehost.com"},
{"id":4,"first_name":"Alfie","email":"alifsey3@sfgate.com"},
{"id":5,"first_name":"Anabelle","email":"aflement4@ustream.tv"},
{"id":6,"first_name":"Farah","email":"ffoyster5@aboutads.info"},
{"id":7,"first_name":"Zackariah","email":"zheppner6@reuters.com"},
{"id":8,"first_name":"Felice","email":"ftunder7@netvibes.com"},
{"id":9,"first_name":"Thurston","email":"tcocklin8@wisc.edu"},
{"id":10,"first_name":"Winston","email":"wtrengove9@narod.ru"}]
`; //json -> object.JSON.parse() 사용 : 문자열 json파일을 자바스크립트 객체 파일로
//console.log(json);

let members = JSON.parse(json);
let yourinfo = { name: "Hong", email: "hong@email.com" };

//console.log(members);

//splice, 화살표함수 활용 데이터 삭제.
let delMember = "Alfie";
//삭제
//members.forEach((member, idx) => {
//	if (member.first_name == delMember) {
//		members.splice(idx, 1);
//	}
//})

//생성한 데이터로 수정
//members.splice(1, 1, yourinfo);
members.forEach((member, idx) => {
	if (member.first_name == delMember) {
		members.splice(idx, 1, { id: member.id, first_name: yourinfo.name, email: yourinfo.email });
	}
})

//console.log(members);

let inpVal = prompt("이름과 이메일 입력하세요 예) 홍길동, hong@email.com"); // 원래는 window.prompt인데 window 생략가능
if(inpVal != null){
	let result = inpVal.replace(/\s/g,"");
	//console.log(result);
	
	fn = result.split(',')[0];
	em = result.split(',')[1];
	inpVal = {id: members.length + 1 , first_name:fn, email:em };
	members.push(inpVal);
}
//console.log(inpVal); // 입력 값이 문자열로 들어감
console.log(members);

const dupAry = [["라이언",5], ["어피치",3], ["콘",2], ["무지",4]];
console.log(dupAry);
console.table(dupAry);



