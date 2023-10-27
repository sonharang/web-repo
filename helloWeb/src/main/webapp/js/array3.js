//array3.js

let pos = "Hello, World".indexOf(",");
let pos1 = "Hello, World".indexOf(".");
console.log(pos);
console.log(pos1); //존재하지않으면 -1 반환

let names = ["콘","무지", "라이언", "어피치"];

pos = names.indexOf("무지");
if(pos == -1){
	console.log("찾는 값은 없습니다.")
}else{
console.log("무지는 " + (pos + 1) + "번째 위치에 있습니다.");
}
	
// {name: "", age: 20}
let members = [
	{name: "김무식", age: 20 },
	{name: "무무식", age: 30 },
	{name: "차무식", age: 40 }
]

let search = "무식";

	let cnt = 0;
members.forEach(member =>{
	if(member.name.indexOf(search) != -1){
		cnt++;
		}
})

//for(member of members){
//	if(member.name.indexOf(search) != -1){
//		cnt++;
//	}
//}
console.log(search + "은 " +  cnt + " 명이 있습니다.");