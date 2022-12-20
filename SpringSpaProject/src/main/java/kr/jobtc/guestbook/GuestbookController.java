package kr.jobtc.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GuestbookController {

	@Autowired
	GuestbookDao dao;
	
	@RequestMapping("/guestbook/guestbook_select")
	public ModelAndView select(GPageVo gVo) {
		ModelAndView mv = new ModelAndView();
		// service or dao

		// 검색어에 다른 List 가져옴
		List<GuestbookVo> list = dao.select(gVo);
		// List를 mv에 추가
		gVo = dao.getgVo();//새로 갱신된 페이지 정보
		
		mv.addObject("gVo", gVo);
		mv.addObject("list", list);
		mv.setViewName("guestbook/guestbook_select");
		return mv;
	}

	@RequestMapping("/guestbook/guestbook10")
	public ModelAndView select10() {
		ModelAndView mv = new ModelAndView();
		// service or dao

		// 검색어에 다른 List 가져옴
		List<GuestbookVo> list = dao.select10();
		// List를 mv에 추가
		mv.addObject("list", list);
		mv.setViewName("guestbook/guestbook_select10");
		return mv;
	}

	
	
	@RequestMapping("/guestbook/guestbook_insert")
	public String insert(GuestbookVo vo, HttpServletResponse resp) {
		String msg="";
		boolean b = dao.insert(vo);
		
		if( !b ) {
			msg = "입력중 오류 발생";
		}
		
		return msg;
	}
	
	@RequestMapping("/guestbook/guestbook_delete")
	public String delete(GuestbookVo vo, HttpServletResponse resp) {
		String msg = "";
		boolean b = dao.delete(vo);
		if( !b ) {
			msg = "삭제중 오류 발생";
		}
		return msg;
	}
	
	@RequestMapping("/guestbook/guestbook_update")
	public String update(GuestbookVo vo, HttpServletResponse resp) {
		String msg = "";
		boolean b = dao.update(vo);
		if( !b ) {
			msg = "수정중 오류 발생";
		}
		return msg;
	}
	
	
	
}
