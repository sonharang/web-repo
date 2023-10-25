//object4.js

const obj = {
	sno : 1001,
	sname : '홍길동',
	adress : '대구 중구 100번지',
	friends : [
		{name : '김민수', phone : '010-1111-1234'},
		{name : '최민수', phone : '010-2222-1234'},
		{name : '박민수', phone : '010-3333-1234'}
	],
	hobbies : [
		'독서', '영화보기', '여행', '요리'
	]
}//

//console.log(obj['sname']);
console.log(`이름 : `,obj.sname);
console.log(`친구는 `,obj.friends.length, '명 입니다.');
console.log(`첫번째 친구 이름 : `, obj['friends'][0].name);
//console.log(`두번째 친구 연락처 : `, obj['friends'][1]['phone']);
console.log(`두번째 친구 연락처 : `, obj['friends'][1].phone);
obj['friends'][1].phone = '010-1212-1234';
console.log(`두번째 친구 연락처 : `, obj['friends'][1].phone);

obj.pets = [];

obj.pets = ['고양이', '강아지', '고슴도치'];
obj.pets[2] = '금붕어'; 
console.log(obj.pets[2]);
obj.pets.forEach(pet => console.log(pet));
obj.hobbies.forEach(hobby => console.log(hobby));
obj.addFriend = function(friend){
	this.friends.push(friend);
}
obj.addFriend({name : '이민수', phone : '010-4444-1234'});
console.log(`친구는 `,obj.friends.length, '명 입니다.');