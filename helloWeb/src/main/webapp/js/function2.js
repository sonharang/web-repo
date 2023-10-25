//function2.js
console.log("function2.js");
//Member member = new Member()
const member = {
    name: "홍길동",
    age: 18,
    height: 178.9,
    showInfo : function(){
        return (`이름은 ${this.name}이고 나이는 ${this.age} 입니다.` )
    }
}
member.showInfo();


console.log(member);
//
const member1 = {
    name: "김길동",
    age: 20,
    height: 198.9,
    showInfo : function(){
        return (`이름은 ${this.name}이고 나이는 ${this.age} 입니다.` )
    }
}

const member2 = {
    name: "박길동",
    age: 28,
    height: 218.9,
    showInfo : function(){
        return (`이름은 ${this.name}이고 나이는 ${this.age} 입니다.` )
    }
}

const members = [member, member1, member2];

//DOM : Document Object Model
let show = document.getElementById("show"); //table>(thead>tr>th) + (tbody>tr>td)
let str = "";
//코드 작성
str += '<table border = "1" >';
str += '<tbody>';
members.forEach(function(item){
    str += makeTr(item);
})
str += '</tbody>';
str += '</table>';

show.innerHTML = str; //table>tbody>(tr>td*4)*3
// console.log(typeof show);
// show.innerHTML = "<ul><li>Apple</li><li>Banana</li></ul>";
// show.innerText = "<ul><li>Apple</li><li>Banana</li></ul>"; 텍스트로만 나옴
console.log(show);

function makeTr(member //= {name, age, height, showInfo}
    ){
    let html = '';
    html += '<tr>';
    html += '<td>' + member.name + '</td>';
    html += '<td>' + member.age + '</td>';
    html += '<td>' + member.height + '</td>';
    html += '<td>' + member.showInfo() + '</td>';
    html += '</tr>';
    return html;
}

// console.log(makeTr(member));