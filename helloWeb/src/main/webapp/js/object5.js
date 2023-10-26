//object5.js 객체 복사
const obj1 = {
	name : "Hong",
	age : 20,
	weight : 100
	//추가 속성 정의
	//bloodType
}
console.log(obj1);

const obj3 = obj1 //참조

const obj2 = Object.assign({name : "Hwang" , age : 25 , height : 180}, obj1);  //새로운 객체생성 ,없는 값은 초기값에 덮어씀
console.log(obj2);

//상속
const obj4 = Object.create(obj1);
//상속을 통해서 자식 객체를 생성하면 부모객체를 참조
//자식속성이 변경되면 부모값과 다른 값 유지.
obj4.name = "kim";
obj4.age = 33;

obj1.name = "Hwang";
console.log(obj4); //{}
console.log(obj4.name);
console.log(obj4.age);

//객체의 속성 정의, 객체의 속성기술자
//obj1.bloodType = "ab";
Object.defineProperty(obj1, 'bloodType', {
	set : function(bt){
		if(bt == "A" || bt == "B" || bt == "AB"|| bt == "O"){
			this._bloodType = bt;
		}else{
			console.log("잘못된 유형입니다.");
			this._bloodType = "A";
		}
	},
	get: function(){
		return this._bloodType;
	}
})
obj1.bloodType = "AB"; //set
console.log(obj1.bloodType); //get