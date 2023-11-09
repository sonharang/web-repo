<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Simple Sidebar - Start Bootstrap Template</title>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/styles.css" rel="stylesheet" />
</head>

<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<c:choose>
				<c:when test="${empty logId }">
					<div class="sidebar-heading border-bottom bg-light">Guest입니다.</div>
				</c:when>
				<c:otherwise>
					<div class="sidebar-heading border-bottom bg-light">${userName }님 환영합니다.</div>
				</c:otherwise>
			</c:choose>
			<div class="list-group list-group-flush">
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글 목록</a>
				<c:choose>
					<c:when test="${empty logId }">
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
					</c:when>
					<c:otherwise>
						<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
					</c:otherwise>
				</c:choose>
				<c:if test="${!empty responsibility && responsibility == 'ADMIN'}">
					<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원 관리</a>
				</c:if>
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="chartForm.do">차트</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
			</div>
		</div>