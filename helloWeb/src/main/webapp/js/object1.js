//object1.js


Member.prototype.setBloodType = function(bloodType){
	this.bloodType = bloodType;
}; //prototype 원형
Member.prototype.getBloodType = function(){
	return this.bloodType;
}
const mem2 = new Member('홍길동', 22, 178.5);
mem2.setBloodType('AB'); 
console.log(mem2.showInfo() ,'혈액형은 ' + mem2.getBloodType(),'형 입니다.' );

//javascript 클래스 추가 가능
String.prototype.truncate = function(){
	console.log(this);
	return this.substring(0, 5);
}
let result = "HellowWorld".truncate();
console.log(result);