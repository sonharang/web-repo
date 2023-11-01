//dom3.js
//table>(thead>tr>th*5)+(tbody>tr>td*5)*데이터 건수
import table from './domTable.js';
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=v%2F9%2FIIDn2VjqPXos4t5o7740lT%2BLprIAAz5bsXe9r58puco9GoHTvcz20N0I2dMmCux8I2dwrqBpoGtlwv6kbg%3D%3D'
let titles = ['센터 id', '센터명', '의료원', '연락처'/*, '위도', '경도'*/];



fetch(url)
	//function(resolve){return resolve.json()}
	.then(resolve => resolve.json())
	.then(fetchCallback)
	.catch(err => console.log('error => ', err));

//fetch 호출되는 함수 callback함수
function fetchCallback(result) {
	let rawData = result.data; //원래 데이터
	console.log(rawData); //전체 값
	//console.log(rawData[0]);
	let sidoAry = []; //sidoAry에 sido 정보를 중복된 값 제거
	rawData.forEach(center => {
		if (sidoAry.indexOf(center.sido) == -1) {
			sidoAry.push(center.sido);
		}
	})

	let sidoSel = document.querySelector('#sidoList')
	sidoAry.forEach(sido => {
		let opt = document.createElement('option');
		opt.innerHTML = sido;
		sidoSel.append(opt);
	})

	// select 태그에 change 이벤트 발생
	sidoSel.addEventListener('change', changeCallback);
	function changeCallback(e) {
		console.log(e.target.value);
		let searchSido = e.target.value;

		//선택된 시도 값에 맞는 센터명만 출력
		let filterAry = rawData.filter(center => center.sido == searchSido);
		genTable(filterAry);
	}
	genTable(rawData); // 초기 데이터로 화면출력
	//let filterAry = rawData.filter(center => center.sido == '서울특별시'); //서울특별시를 첫화면에 출력
	//let filterAry = rawData.filter((center, idx) => idx < 5); //5건만 출력
	//genTable(filterAry);// 선택 데이터로 출력
}

function genTable(rawData = [], page = 1) {
	//초기화
	document.querySelector('#show').innerHTML = '';

	//첫번째, 마지막 => 계산
	let startNo = (page - 1) * 5;
	let endNo = page * 5;

	//첫번째, 마지막 페이지 => 계산
	//5단위씩
	let totalCnt = rawData.length;
	//lastPage는 버튼수
	let lastPage = Math.ceil(totalCnt / 5); //ceil : 올림	
	
	let endPage = Math.ceil(page / 5) * 5;
	let beginPage = endPage -4;
	let prevPage = false, nextPage = false;
	
	//10단위씩
	/*
	let startNo = (page - 1) * 10;
	let endNo = page * 10;	
	
	let totalCnt = rawData.length;
	let lastPage = Math.ceil(totalCnt / 10); //ceil : 올림	
	
	let endPage = Math.ceil(page / 10) * 10;
	let beginPage = endPage -9;
	let prevPage = false, nextPage = false;
	*/
	if (beginPage > 1) {
		prevPage = true;
	}
	if (endPage < lastPage) {
		nextPage = true;
	}
	if (endPage > lastPage) {
		endPage = lastPage;
	}
	document.querySelector('.pagination').innerHTML = '';

	//이전 페이지 존재 여부 <==
	if (prevPage) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.innerHTML = '&laquo;';
		aTag.addEventListener('click', function(e) {
			genTable(rawData, beginPage - 1);
		})
		document.querySelector('.pagination').append(aTag);
	}
	//전체 페이지
	for (let i = beginPage; i <= endPage; i++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.innerHTML = i;
		if (i == page) {
			aTag.setAttribute('class', 'active')
		}
		//aTag.setAttribute('data-page', i);
		aTag.addEventListener('click', function(e) {
			genTable(rawData, i);
		})
		document.querySelector('.pagination').append(aTag);
	}
	//이후 페이지 존재 여부 ==>
	if (nextPage) {
		let aTag = document.createElement('a');
		aTag.setAttribute('href', '#');
		aTag.innerHTML = '&raquo;';
		aTag.addEventListener('click', function(e) {
			genTable(rawData, endPage + 1);
		})
		document.querySelector('.pagination').append(aTag);
	}

	//전체 rawData로 출력
	let thead = table.makeHead(titles); //헤더 정보

	//map활용
	/*let mapData = rawData.map(center => { //매핑 정보 출력
		let newCenter = {
			id: center.id,
			centerName: center.centerName.replace('코로나19', ''),
			org: center.org,
			phoneNumber: center.phoneNumber,
			lat: center.lat,
			lng: center.lng
		}
		return newCenter;
	});
	*/

	//reduce 활용
	let mapData = rawData.reduce((acc, center, idx) => { //매핑 정보 출력시킴 
		//내가 가져오고 싶은 데이터만 출력하기 위해 reduce가 돌아갈때, 각각의 객체를 만들고 있음.
		if (idx >= startNo && idx < endNo) {
			let newCenter = {
				id: center.id,
				centerName: center.centerName.replace('코로나19', ''),
				org: center.org,
				phoneNumber: center.phoneNumber,
				lat: center.lat,
				lng: center.lng
			}
			acc.push(newCenter);
		}
		return acc;
	}, []);

	let tbody = table.makeBody(mapData);//[{},{}}...]

	let tb1 = document.createElement('table');
	tb1.setAttribute('border', '1');
	tb1.append(thead, tbody);
	document.getElementById('show').append(tb1);

	//tr 클릭 이벤트 등록
	let targetTr = document.querySelectorAll('tbody tr');
	targetTr.forEach(tr => {
		tr.addEventListener('click', function(e) {
			//console.log(tr);
			//console.log(tr.children[4].innerHTML, tr.children[5].innerHTML);
			// 위도, 경도 숨기기
			let lat = tr.dataset.lat; //let lat = tr.children[4].innerHTML;
			let lng = tr.dataset.lng; //let lng = tr.children[5].innerHTML;
			//location.href = 'daumapi.html?x=' + lat + '&y=' + lng; //현재창에서 열기
			window.open('daumapi.html?x=' + lat + '&y=' + lng); //새탭에서 열기
		})
	})
}