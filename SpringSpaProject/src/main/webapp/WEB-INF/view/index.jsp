<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring SPA Project</title>
<link rel='stylesheet' href='css/index.css'>
<link rel='icon' href='images/favicon.png'>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script defer src='js/index.js'></script>
</head>
<body>
<main>
	<header>
		<div class='main_title'>
			<img src='images/noname4.png'>
		</div>
		<nav>
			<a href="/">HOME</a>
			<a href='#' class='btnGuestBook'>방명록</a>
			<a href='#' class='btnBoard'>게시판</a>
		</nav>
	</header>
	
	
	<div id='section'>
		<div class='guestbook'>최신 방명록</div>
		<div class='board'>최신 게시물</div>
	</div>
	
	
	<footer>
		Spring SPA Project<br/>
		2022-08
	</footer>
	
	
	
</main>

</body>
</html>