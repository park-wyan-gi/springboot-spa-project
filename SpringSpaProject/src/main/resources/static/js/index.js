/**
 * index.js
 */
 
$('.btnBoard').on('click', function(){
  $('#section').load('/board/board_select');
} );

$('.btnGuestBook').on('click', function(){
  	$('#section').load('/guestbook/guestbook_select');
});

/* 방명록 최근 10개 ------- */
$('#section>.guestbook').load("/guestbook/guestbook10");

/* 게시물 최근 10개 ------- */
$('#section>.board').load("/board/board10");
