//array5.js

console.log('펭수' < '콘'); //문자열 가나다순으로 비교 맞으면 true 틀리면 false.

// 정렬
const arr1 = ['펭수', '라이언', '어피치', '콘', '무지'];
arr1.sort(); // 가나다순으로 정렬
console.log(arr1); // 배열자체를 변경.

const arr2 = [4, 8, 1, 12, 23, 9];
arr2.sort(function(a, b) {// 정렬기준제시
	if (a < b) {
		return -1;
	} else {
		return 1;
	}
});
console.log(arr2);
console.log(arr2.reverse()); //역순

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
members.sort(function(a, b) {
	if (a.first_name < b.first_name) {
		return -1;
	} else {
		return 1;
	}
})
console.log(members);