// string3.js

let today = new Date(); // Date 자바 내장객체 생성
today.getFullYear(); // 2023
today.getMonth(); // 9 (0부터 시작)
today.getDate(); // 26
//today.setFullYear(2023);
//today.setMonth(0);
//today.setDate(1);
//today.setHours(10);
//today.setMinutes(10);
 
 console.log(today.toISOString()); //현재시간 -9 => 
 console.log(today.toString()); 
 console.log(today.toLocaleDateString());
 
 function dateFormat(today){
	 //YYYY-MM-DD hh24:mm:ss
	 return today.getFullYear() + "-" + ("0" + (today.getMonth()+1)).slice(-2) + 
	 "-" + ("0" + today.getDate()).slice(-2) + "-" + today.getHours() + ":" +
	 today.getMinutes() + ":" + today.getSeconds();
 } 
 dateFormat(today);
 console.log(dateFormat(today));