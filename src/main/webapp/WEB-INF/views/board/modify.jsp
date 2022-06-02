<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/layout/header.jsp" %>
<div class="container">
<h2>글수정 페이지</h2>
<form action="${pageContext.request.contextPath}/board/update" method="post">
	<input type="hidden" name="bno" value="${board.bno}">
	제목: <input type="text" name ="title" value="${board.content}">
	작성자: <input type="text" name="writer" value="${board.writer}"><br>
	<textarea rows="40" cols="62" name="content">${board.content}</textarea><br>
	<button>등록</button>
</form>
</div>
<%@ include file = "/WEB-INF/views/layout/footer.jsp" %>