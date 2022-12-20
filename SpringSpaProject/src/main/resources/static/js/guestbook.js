/**
 * guestbook.js
 */
 
(gb = function(){

	$('.btnSearch').on('click', function(){
		let frm = $('.frm_gb_search')[0];
		frm.nowPage.value = 1;
		let param = $(frm).serialize();
		$('#section').load('/guestbook/guestbook_select', param);
	});

	$('.btnPrev').on('click', function(){
		let frm = $('.frm_gb_search')[0];
		frm.nowPage.value = Number(frm.nowPage.value)-1;
		let param = $(frm).serialize();
		$('#section').load('/guestbook/guestbook_select', param);
	});
	$('.btnNext').on('click', function(){
		let frm = $('.frm_gb_search')[0];
		frm.nowPage.value = Number(frm.nowPage.value)+1;
		let param = $(frm).serialize();
		$('#section').load('/guestbook/guestbook_select', param);
	});
	
	
	$('.btnGuestbookSave').on('click', function(){
		let frm = $('.frm_guestbook_insert')[0];
		let param = $(frm).serialize();
		$.post('/guestbook/guestbook_insert', param,function(msg){
			if(msg != '') 	alert(msg);
			
			frm = $('.frm_gb_search')[0];
			param = $(frm).serialize();
			$('#section').load('/guestbook/guestbook_select', param);		  
		});
	});
	
	gb.modifyView = function(frm){
		let div = frm.querySelector('.updateZone');
		let bz = frm.querySelector('.btnZone');
		div.style.visibility='visible';
		frm.doc.readOnly=false;
		$(bz).css('display','none');
	
	}
	gb.modifyCancel = function(frm){
		let div = frm.querySelector('.updateZone');
		let bz = frm.querySelector('.btnZone');

		div.style.visibility='hidden';
		frm.doc.readOnly=true;
		$(bz).css('display','block');
	
	}
	
	/* modal box ------ */
	$('#btnClose').on('click', function(){
		$('#modal').css('display', 'none');
	});
	
	var delForm;
	gb.modalView = function(frm){
		delForm = frm;
		$('#modal').css('display', 'block');
	}
	
	/* 방명록 삭제 -------------- */
	$('#btnCheck').on('click', function(){
		delForm.pwd.value = $('#pwd').val();
		
		let frm = delForm;
		let param = $(frm).serialize();
		
		$.post('/guestbook/guestbook_delete', param,function(msg){
			if(msg !='') alert(msg);
			
			frm = $('.frm_gb_search')[0];
			param = $(frm).serialize();
			$('#section').load('/guestbook/guestbook_select', param);		  
		});
		
	});
	
	/* 방명록 수정 --------------- */
	gb.update = function(frm){
		let param = $(frm).serialize();
		
		$.post('/guestbook/guestbook_update', param,function(msg){
			if(msg != '') alert(msg);
			
			frm = $('.frm_gb_search')[0];
			param = $(frm).serialize();
			$('#section').load('/guestbook/guestbook_select', param);		  
		});
		
	};
	
	
	

})();
 
 
 
 
 
 
 
 
 
 
 
 