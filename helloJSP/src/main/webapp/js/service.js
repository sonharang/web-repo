/**
 * service.js
 */
//목록처리
/*async function studentList() {
	let req = await fetch('../studentList.do');
	let json = await req.json(); // {"retCode" : "OK"} -> {"retCode" : "ON"}
	let tbody = document.querySelector('#list');
	try {
		json.forEach(student => {
			tbody.append(makeTr(student));
		})
	} catch (err) {
		console.log('error=> ', err);
	}
}
*/
export default {
	//메소드 생성
	//목록처리 //매개값 2개 성공했을때 successCallback 실패 -> errorCallback
	async studentList(successCallback, errorCallback) {
		let req = await fetch('../studentList.do');
		let json = await req.json();
		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}
	},
	//추가
	async addStudent(optionObj, successCallback, errorCallback) {
		let req = await fetch('../addStudent.do', optionObj);
		let json = await req.json();
		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}
	},
	//수정
	async editStudent(optionObj, successCallback, errorCallback) {
		let req = await fetch('../editStudent.do', optionObj);
		let json = await req.json();
		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}
	},
	//삭제
	async delStudent(id, successCallback, errorCallback) {
		let req = await fetch('../delStudent.do?sid=' +id);
		let json = await req.json();
		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}
	},
	//단건 조회
	async getStudent(id, successCallback, errorCallback) {
		let req = await fetch('../getStudent.do?sid=' +id);
		let json = await req.json();
		try {
			successCallback(json);
		} catch (err) {
			errorCallback(err);
		}


	}

}//end of defualt