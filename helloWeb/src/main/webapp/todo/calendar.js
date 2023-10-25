const week = ['일','월','화','수','목','금','토'];
const month = [31,28,31,30,31,30,31,31,30,31,30,31];
const calendar = {
	html : '',
	
	makeHead(){
		let strHead ='';
		strHead += `<table border = '1'><thead><tr>`;
		for(let weekday in week){
			strHead += '<th>' + week[weekday] + '</th>';
		}
		strHead += '</tr></thead>';
		this.html += strHead;
	},
	makeBody(monthday){
		let obj = this;
		let strBody = '';
		strBody += '<tbody><tr>'
		for(let i =1; i<=month[monthday]; i++){
			strBody += `<td>${i}</td>`
			if(i%7==0){
				strBody +='<tr></tr>'
			}
		}
		strBody += '</tr></tbody</table><br>'
		obj.html += strBody;
	},
	makeCalendar(dom){
		dom.innerHTML = this.html;
	}
}
for(let i = 0; i<12; i++){
	calendar.makeHead();
	calendar.makeBody(i);
} 
	calendar.makeCalendar(document.getElementById('show'));