//function5.js
let sum1 = 0;
[10, 20, 30].forEach(function(num) {
	sum1 += num; //consumer : 매개값을 소진, 반환값은 없음.
});
console.log('forEach:', sum1);

sum1 = 0; //초기화
sum1 = [10, 20, 30].reduce(function(acc, item, idx, ary) { //acc : 초기값 item : 배열에 들어있는 값 idx : 배열 번호 ary : 배열
	console.log(acc, item, idx);
	return acc + item; //function : 매개값을 소진해서 반환값을 생성 
}, 0);
console.log('reduce:', sum1);

function sum2(a = 0, b = 0, c = 0) {// 매개변수 parameters 
	console.log(arguments);
	return a + b + c + arguments[3] + arguments[4]; //150이 나옴
}
console.log(sum2(10, 20, 30, 40, 50)); // 매개값 arguments

function sum3(a = 0, b = 0, ...args) {
	console.log(args);
	//forEach 사용, function 생략 let result = 0; result = a + b; args.forEach(num => result += num); return result;
	return a + b + args.reduce(function(acc,item){return acc + item}); //화살표 함수 return a + b + args.reduce(acc.item) => acc + item;
}
console.log(sum3(10, 20, 30, 40, 50, 60));

//reduce 연습
const numAry = [4,2,6,9,1,7];
let max = 0;
max = numAry.reduce((acc,item) => acc > item ? acc : item); //삼항 연산자
console.log('최댓값 : ' + max);