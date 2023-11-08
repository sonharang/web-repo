<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
ul>li {
	list-style: none;
}

#list span {
	margin: 10px;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<%@include file="../layout/menu.jsp"%>
<%@include file="../layout/header.jsp"%>


<h3>게시글 상세(조회)화면</h3>
<%
BoardVO vo = (BoardVO) request.getAttribute("bno");
%>
<form action="modifyForm.do" name="myFrm">
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td class="boardNo"><%=vo.getBoardNo()%></td>
			<th>작성일시</th>
			<td><%=vo.getWriteDate()%></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3"><%=vo.getTitle()%></td>
		</tr>
		<tr>
			<td colspan="4"><textarea rows="5" cols="40"><%=vo.getContent()%></textarea>
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td colspan="3">
				<%
				if (vo.getImage() != null) {
				%> <img width="150px" src="images/<%=vo.getImage()%>" width="100px">
			</td>
			<%
			}
			%>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<%
				if (logId != null && logId.equals(vo.getWriter())) {
				%> <input type="submit" class="btn btn-primary" value="수정">
				<input type="button" class="btn btn-warning" value="삭제"
				onclick="location.href='removeBoard.do?bno=<%=vo.getBoardNo()%>'">
				<%
				} else {
				%> <input type="submit" value="수정" disabled> <input
				type="button" value="삭제" disabled> <%
 }
 %>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=vo.getWriter()%></td>
			<th>조회수</th>
			<td><%=vo.getViewCnt()%></td>
		</tr>
	</table>
</form>

<h3>댓글등록</h3>
<table class="table">
	<tr>
		<th>댓글내용</th>
		<td><input type="text" id="replyContent"></td>
		<td><button id="addReply">댓글등록</button></td>
	</tr>
</table>

<h3>댓글목록</h3>
<ul id="list">
	<li style="display: none;" id="template"><span>댓글번호</span><b>댓글내용</b><span>유저아이디</span><span>작성일자</span>
		<button>삭제</button></li>
</ul>

<div class="pagination"></div>
<!--  
<p>
	<a href="boardList.do">목록으로</a>
</p>
-->
<!--  <script>
	document.querySelector('input[type=button]').addEventListener('click',
			function(e) {
				document.forms.myFrm.action = 'removeForm.do';
				document.forms.myFrm.submit();
			})
</script>
-->
<script>
	//댓글목록
	let bno = "<%=vo.getBoardNo()%>";
	bno = document.querySelector('.boardNo').innerHTML;
	let writer = "<%=logId%>";
	let page = 1;
	console.log(bno);
	console.log(writer);

	function showList(pg = 1) {
		document.querySelectorAll('#list li:not(:nth-of-type(1))').forEach(li => li.remove());
		fetch('replyList.do?bno=' + bno + '&page=' + pg)
			.then(resolve => resolve.json())
			.then(result => {
				//console.log(result);
				if(pg < 0){
					page = (Math.ceil(result.dto.total/5))
					showList(page);
					return;
				}else if(pg == 0){
					document.querySelector('.pagenation').innerHTML ='';
					return;
				}
				result.list.forEach(reply => {
					// let li = document.createElement('li');
					// let bnoSpan = document.createElement('span');
					// span.innerHTML = reply.boardNo;
					// let writerSpan = document.createElement('span');
					// writerSpan.innerHTML = reply.writer;
					// let dateSpan = document.createElement('span');
					// dateSpan.innerHTML = reply.writerDate;
					//다른방법
					//
					let li = makeRow(reply);
					//ul>li 생성
					document.querySelector('#list').append(li);

				})
				//page 생성
				makePaging(result.dto);
			})
			.catch(err => console.log(err));
	}
	showList();
	//페이지 링크 생성
	function makePaging(dto = {}) {
		document.querySelector('.pagination').innerHTML = '';
		if (dto.prev) {
			let aTag = document.createElement('a');
			aTag.setAttribute('href', dto.startPage - 1);
			aTag.innerHTML = "&laquo;";
			document.querySelector('.pagination').append(aTag);
		}
		for (let i = dto.startPage; i <= dto.endPage; i++) {
			let aTag = document.createElement('a');
			aTag.setAttribute('href', i);
			aTag.innerHTML = i;
			//active 녹색
			if (i == page) {
				aTag.className = 'active'; // class 속성을 지정할때 className
			}
			document.querySelector('.pagination').append(aTag);
		} //end of for
		if (dto.next) {
			let aTag = document.createElement('a');
			aTag.setAttribute('href', dto.endPage + 1);
			aTag.innerHTML = "&raquo;";
			document.querySelector('.pagination').append(aTag);
		}
		
		//a태그  클릭이벤트 등록
		document.querySelectorAll('.pagination a').forEach(ele => {
			ele.addEventListener('click', function (e) {
				e.preventDefault(); //form, a => 링크기능 차단
				page = ele.getAttribute('href');
				showList(page);
			})
		})
		
	} //end of makePaging

	//댓글생성함수

	function makeRow(reply) {
		let temp = document.querySelector('#template').cloneNode(true);
		temp.style.display = "block";
		//console.log(temp);
		temp.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
		temp.querySelector('b').innerHTML = reply.reply;
		temp.querySelector('span:nth-of-type(2)').innerHTML = reply.replyer;
		temp.querySelector('span:nth-of-type(3)').innerHTML = reply.replyDate;

		temp.querySelector('#template> button').addEventListener('click', function (e) {

			if (writer == 'null' || writer != reply.replyer) {
				alert('권한 없음');
				return;
			}
			fetch('removeReply.do', {
					method: 'post',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: 'replyNo=' + reply.replyNo
				})
				.then(resolve => resolve.json())
				.then(result => {
					if (result.retCode == 'OK') {
						e.target.parentElement.remove();
						showList(-1);
					} else {
						alert('삭제 실패');
					}
				})
				.catch(err => console.log(err));
		})

		return temp;
	}
	//등록버튼
	document.querySelector('#addReply').addEventListener('click', function (e) {
		let reply = document.querySelector('#replyContent').value;
		if (!bno || writer == 'null' || !reply) {
			alert("값을 확인하세요.");
			return;
		}
		//ajax호출 bno,writer,reply => 전달(서블릿으로)
		fetch('addReply.do', {
				method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + writer
			})
			.then(resolve => resolve.json())
			.then(result => {
				if (result.retCode == 'OK') {
					//document.querySelector('#list').append(makeRow(result.vo));
					showList(-1);	
				} else {
					alert('Error.');
				}
			})
	})
</script>
<%@include file="../layout/footer.jsp"%>