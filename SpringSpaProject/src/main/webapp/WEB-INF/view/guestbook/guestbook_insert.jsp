<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
<form name='frm_guestbook' class='frm_guestbook_insert' method='post'>
	<label>작성자</label>
	<input type='text' name='id'>
	<label>작성일 / </label>
	<output>
			<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd"/>
	</output><br/>
	<textarea rows="5" cols="40" name='doc'></textarea>
	<br/>
	<label>암호</label>
	<input type='password' name='pwd'>
	<input type='button' value='작성' class='btnGuestbookSave'>
</form>
</body>
</html>