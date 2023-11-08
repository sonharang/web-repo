<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../layout/menu.jsp"></jsp:include>
<jsp:include page="../layout/header.jsp"></jsp:include>

<h3>게시글 등록화면</h3>
<!-- <form action="addBoard.do" method="get" enctype="multipart/form-data">  GET방식-->
<!-- enctype="multipart/form-data" : 파일전송 -->
<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" class="form-control" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" readonly class="form-control"
				name="writer" value="${logId }" readonly></td>
		</tr>
		<tr>
			<td colspan="2"><textarea cols="40" rows="5"
					class="form-control" name="content"></textarea></td>
		</tr>
		<tr>
			<th>파일명</th>
			<td><input type="file" class="form-control" name="img"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-primary" value="저장"> <input type="reset"
				class="btn btn-warning" value="초기화"></td>
		</tr>
	</table>
</form>
<!-- 
<p>
	<a href="boardList.do">목록으로</a>
</p>
 -->
<jsp:include page="../layout/footer.jsp"></jsp:include>