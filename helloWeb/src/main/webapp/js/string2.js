//string2.js
const words = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum eligendi aliquid a minima fugiat minus qui placeat neque, voluptatum modi veritatis ipsa ipsum quae esse animi reiciendis. Repellat';
// 1. 공백을 기준으로 가져온 단어의 크기가 5보다 큰 문장을 콘솔에 출력.
const wordsAry = words.split(' ');
for(let i=0; i<wordsAry.length; i++){
	if (wordsAry[i].length > 5) {
		console.log(wordsAry[i]);
	}
}
	
// 2. 생년월일 입력 => 남자/여자,
const ssn = "";
//console.log(ssn.substr(7,1));
function checkGender(ssn) {
	//950305 1=> 남자 950305 2=> 여자 
	if (ssn.substr(7, 1) == 1 || ssn.substr(7, 1) == 3 ) {
		return ("남자입니다.");
	} else if (ssn.substr(7, 1) == 2 || ssn.substr(7, 1) == 4) {
		return ("여자입니다.");
	}
	
}
console.log(checkGender("970825 1"));
console.log(checkGender("970825 2"));
console.log(checkGender("970825 3"));


// 3. 파일명과 파일의 확장자.
let file = "d:/temp/sample/hi/game.exe";
let fileName, fileExt;	

fileName =  file.split('.').reverse()[1].split('/').reverse()[0];
fileExt = file.split('.').reverse()[0];
console.log("파일명 : " + fileName);
console.log("확장자 : " + fileExt);