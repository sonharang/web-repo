const table = {

	makeHead(titles = ['도서코드', '도서명', '저자', '출판사', '가격','삭제']) {
		let headTag = "<thead><tr>";
		headTag += "<th>" + "<input type = 'checkbox'>" + "</th>";
		titles.forEach(title => {
			headTag += "<th>" + title + "</th>";
		})
		headTag += "</tr></thead>";
		return headTag;
	},
	makeBody(dataAry = [{ id, name, writer, publish, price }]) { 
		let bodyTag = "<tbody id = 'list'>";
		dataAry.forEach(item => {
			bodyTag += this.makeTr(item);
		})
		bodyTag += "</tbody>";
		return bodyTag;
	},

	makeTable(titleAry, dataAry) {

		let tableTag = "<table border = '1'>";
		tableTag += this.makeHead(titleAry) + this.makeBody(dataAry);
		tableTag += "</table>";
		return tableTag;
	},
	makeTr(member = {}) {
		let trTag = "<tr>"; 
		trTag +="<td><input type = 'checkbox'></td>"
		for (let prop in member) {
			trTag += "<td>" + member[prop] + "</td>";
		}
		trTag += '<td><button onclick = "this.parentElement.parentElement.remove()">삭제</button></td>';
		trTag += "</tr>";
		return trTag;
	}
}
export { table };

/**
 * 
 */