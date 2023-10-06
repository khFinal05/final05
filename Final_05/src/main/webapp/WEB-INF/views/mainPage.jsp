<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${ empty mem }">
			<form action="login.me">
				아디 : <input type="text" name="memId">
				비번 : <input type="password" name="memPwd">
				<button>로그인ㅋ</button>
			</form>
		</c:when>
		<c:otherwise>
			<div>${ mem.memId }님 환영합니다.</div>
		</c:otherwise>
	</c:choose>

</body>
</html>