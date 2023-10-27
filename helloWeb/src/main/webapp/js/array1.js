//array1.js

const arr1 = []
arr1.push(10);
arr1.push('ten');
arr1.push({name:"Hong", age : 20});

arr1.unshift(20); //제일 앞에 위치

arr1.length = 4; //배열 크기 지정가능 넘어서면 undefined

console.log('배열의 크기 : ' + arr1.length);

//제거
//arr1.shift(); // => 앞 에서 부터 배열 제거
//arr1.pop(); // => 뒤 에서 부터 배열 제거

//추가, 삭제, 수정
arr1.splice(1, 0, 30); //추가 (추가 할 인덱스자리, 제거할 요소의 수, 추가 할 요소의 값)
arr1.splice(1, 1, 30); //수정
arr1.splice(1, 1); //삭제

for(let ary of arr1){
	console.log(ary);
}

