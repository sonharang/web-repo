<%@page import="co.yedam.board.service.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/menu.jsp"%>
<%@include file="../layout/header.jsp"%>

<h3>회원 상세화면</h3>
<%
MemberVO vo = (MemberVO) request.getAttribute("bno");
%>
<table class="table">
		<tr>
			<th>회원아이디</th>
			<td><%=vo.getMid()%></td>
			<th>비밀번호</th>
			<td><%=vo.getPass()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td colspan="3"><%=vo.getName()%></td>
			<th>전화번호</th>
			<td><%=vo.getPhone()%>
		</tr>
		</table>
<%@include file="../layout/footer.jsp"%>