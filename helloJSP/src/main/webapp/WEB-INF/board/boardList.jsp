<%@page import="co.yedam.board.service.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- include : 외부파일 끌어쓴다 -->
<%@include file="../layout/menu.jsp"%>
<%@include file="../layout/header.jsp"%>

<h3>게시판 목록</h3>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("list"); //List<BoardVO> 값이 들어있다 -> list
%>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO vo : list) {
		%>
		<tr>
			<td><%=vo.getBoardNo()%></td>
			<td><a href="getBoard.do?bno=<%=vo.getBoardNo()%>"><%=vo.getTitle()%></a></td>
			<td><%=vo.getWriter()%></td>
			<td><%=vo.getWriteDate()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<p>
	<a href="boardForm.do">등록화면</a> 
	<a href="main.do">첫 페이지로</a>
</p>

<%@include file="../layout/footer.jsp"%>