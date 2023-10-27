//array4.js
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
`;
let members = JSON.parse(json);
//1 find
let result = members.find(function(item, idx, ary) {
	//console.log(item,idx,ary);
	if (item.id > 5) {
		return true;
	}
	return false;
})
//2 filter
result = members.filter(function(item, idx, ary) {
	return item.id > 5;
})
console.log(result);

result = members.filter(function(item, idx, ary) {
	return idx >= 1 && idx < 3;
})
for (let rs of result) {
	console.log(rs);
}
//3 reduce
//위에 구문과 같음
//for(let i = 0; i<result.length; i++){	
//console.log(result[i]);
//}

result = members.reduce((acc, item, idx) => {
	if (idx >= 1 && idx < 3) {
		acc.push(item);
	}
	return acc;
}, [])
for (let i = 0; i < result.length; i++) {
	console.log(result[i]);

	//4 some(하나만 만족), every(모두 만족) => true / false.
	result = members.some((member) => {
		//console.log(member);
		return member.first_name.length > 5;
	})

	console.log(result);

	result = members.every((member) => {
		//console.log(member);
		return member.first_name.length > 5;
	})

	console.log(result);

	//* map : A -> B
	result = members.map(member => {
		let obj = { id: member.id, name: member.first_name, email: member.email, grade: 'c' };
		return obj;
	})
	console.log(result);


}