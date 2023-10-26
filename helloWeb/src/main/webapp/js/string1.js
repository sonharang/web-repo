//string1.js

let str1 = "Hello"; // 기본 데이터 타입.
let str2 = new String("Hello"); //객체.

console.log(typeof str1, typeof str2);
console.log(str1 == str2); //값만 비교.
//값, 타입까지 비교
console.log(str1 === str2); //값만 비교.

console.log(str1.toUpperCase());

//공백 제거
let result = " 공백 제거 합니다.   ".trim();
console.log(result, '문자갯수: ', result.length);

result = "Hello, World, Nice, World".replace(",", ".");
console.log(result);
result = "Hello, World, Nice, World".replace(/,/g, ".");
console.log(result);
result = "Hello, World, Nice, World".replace(/\s/g, "");
console.log(result);