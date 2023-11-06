<%@page import="co.yedam.board.service.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<td><%=vo.getBoardNo()%></td>
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
			<td colspan="3"><img width="150px"
				src="images/<%=vo.getImage()%>" width="100px"></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<% if (logId != null && logId.equals(vo.getWriter())) {%> 
				<input type="submit" class="btn btn-primary" value="수정">
				<input type="button" class="btn btn-warning" value="삭제" onclick="location.href='removeBoard.do?bno=<%=vo.getBoardNo()%>'">
			<%} else {%> 
				<input type="submit" value="수정" disabled>
				<input type="button" value="삭제" disabled>
			<%}%>
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
<p>
	<a href="boardList.do">목록으로</a>
</p>
<!--  <script>
	document.querySelector('input[type=button]').addEventListener('click',
			function(e) {
				document.forms.myFrm.action = 'removeForm.do';
				document.forms.myFrm.submit();
			})
</script>
-->
<%@include file="../layout/footer.jsp"%>