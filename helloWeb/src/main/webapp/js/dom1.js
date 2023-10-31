//dom1.js

const fruits = ['수박', '사과', '복숭아', '포도']

//#show>ul>li:수박 + li:사과 + li:복숭아 + li:포도
//createElement, appendChild, innerHTML 속성.

//html생성

//ui
const ul = document.createElement('ul');
fruits.forEach((fruit) => {
	const li = document.createElement('li'); //리스트태그 생성 <li></li>
	li.innerHTML = fruit; //<li>수박</li><li>사과</li>...
	ul.appendChild(li); //<ul><li>수박</li><li>사과</li></ul>...
})
document.getElementById('show').appendChild(ul); //화면에 출력

