<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<h2>최근 방명록</h2><hr/>
<div>
	<c:forEach var='vo' items="${list }">
		<div>
			<b>[${vo.id }]</b> <span>${vo.doc }</span>
		</div>
	</c:forEach>
</div>