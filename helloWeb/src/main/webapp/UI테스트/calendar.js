
const today = new Date(2023,11,1);

const novemberCal = {

	makeHead() {
		const days = ['일', '월', '화', '수', '목', '금', '토']
		return days.reduce((acc, day) => {
			return acc + '<th>' + day + '</th>';
		}, '<thead><tr>')
	},

	makeBody() {
		let tbody = '</tr></thead><tbody><tr>';
		for (let i = 1; i <= 33; i++) {
			let styles = '';
			if(i<4){
				tbody += '<td></td>';
			}else{
				
			if ((i -3)% 7 == 4) {
				if (i == today.getDate()) {
				}
				tbody += '<td style="' + styles + '" align="right">' + (i -3) + '</td>';
			} else if ((i -3) % 7 == 5) {
				if (i == today.getDate()) {
				}
				tbody += '<td style="' + styles + '" align="right">' + (i -3) + '</td>';
			} else {
				if (i == today.getDate()) {
				}
				tbody += '<td style="' + styles + '" align="right">' + (i -3) + '</td>';
			}

			if (i % 7 == 0) {
				tbody += '</tr><tr>';
			}
			}
		}
		tbody += '</tr></tbody>';
		return tbody;
	},

	show() {
		let thead = this.makeHead();
		let tbody = this.makeBody();
		let table = '<p>2023년 11월 달력</p><table border="1">' + thead + tbody + '</table>'
		document.getElementById('show').innerHTML = table;
	}
}

novemberCal.show();
