<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 등록화면</h3>
	<form action="addBoard.do" method="get">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea cols="40" rows="5" name="writer"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"> <input
					type="reset" value="초기화"></td>
		</table>
	</form>
	<p>
		<a href="boardList.do">목록으로</a>
	</p>
</body>
</html>