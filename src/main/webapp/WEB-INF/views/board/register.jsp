<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/layout/header.jsp" %>
<div class="container">
<form action="${pageContext.request.contextPath}/board/register" method="post">
	제목: <input type="text" name ="title">
	작성자: <input type="text" name="writer"><br>
	<textarea rows="40" cols="62" name="content"></textarea><br>
	<button>등록</button>
</form>
</div>	
<%@ include file = "/WEB-INF/views/layout/footer.jsp" %>