package kr.jobtc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.jobtc.board.BoardService;
import kr.jobtc.board.BoardVo;
import kr.jobtc.board.PageVo;

@RestController
public class BoardController {
	
	JdbcTemplate jdbcTemp;//mybatis를 사용하게되면 불필요

	@Autowired
	BoardService service;
	
	@Autowired
	public BoardController(JdbcTemplate temp) {
		this.jdbcTemp = temp;
	}
	
	@RequestMapping("/board/board_select")
	public ModelAndView select(PageVo pVo) {
		ModelAndView mv = new ModelAndView();
		List<BoardVo> list = service.select(pVo);
		pVo = service.getpVo();
		
		mv.addObject("list", list);
		mv.addObject("pVo", pVo);
		mv.setViewName("board/board_select");/* WEB-INF/view/board/board_select.jsp */
		return mv;
	}
	
	
	@RequestMapping("/board/board10")
	public ModelAndView board10(){
		ModelAndView mv = new ModelAndView();
		List<BoardVo> list = service.board10();
		
		mv.addObject("list", list);
		mv.setViewName("/board/board_board10");
		
		return mv;
	}
	
	@RequestMapping("/board/board_view")
	public ModelAndView view(BoardVo bVo, PageVo pVo){
		ModelAndView mv = new ModelAndView();
		// 조회수 증가
		bVo = service.view(bVo.getSno(), "up");

		// doc안에 있는 \n 기호를 <br/>로 변경
		String temp = bVo.getDoc();
		bVo.setDoc(temp.replace("\n", "<br/>"));
		mv.addObject("bVo", bVo);
		mv.addObject("pVo", pVo);
	
		mv.setViewName("/board/board_view");
		return mv;
	}
	
	@RequestMapping("/board/board_delete")
	public ModelAndView delete(BoardVo bVo, PageVo pVo){
		String msg = "";
		ModelAndView mv = new ModelAndView();
		// 조회수 증가
		boolean b= service.delete(bVo);
		if( !b ) {
			msg = "삭제중 오류 발생";
		}
		mv = select(pVo);
		mv.addObject("msg", msg);
		mv.addObject("pVo", pVo);
		mv.setViewName("/board/board_select");
		return mv;
	}
	
		
	@RequestMapping("/board/board_insert")
	public ModelAndView insert(PageVo pVo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("pVo", pVo);
		mv.setViewName("/board/board_insert");
		return mv;
		
	}
	
	@RequestMapping("/board/board_update")
	public ModelAndView update(PageVo pVo) {
		ModelAndView mv = new ModelAndView();
		BoardVo bVo = service.view(pVo.getSno(), "");
		mv.addObject("bVo", bVo);
		mv.addObject("pVo", pVo);
		mv.setViewName("/board/board_update");
		return mv;
		
	}
	
	@RequestMapping("/board/board_repl")
	public ModelAndView repl(PageVo pVo, BoardVo bVo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bVo", bVo);
		mv.addObject("pVo", pVo);
		mv.setViewName("/board/board_repl");
		return mv;
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/board/test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		List<String> subjects = null;
		try {
			
			Connection conn = jdbcTemp.getDataSource().getConnection();
			String sql = "select subject from board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			subjects = new ArrayList<String>();
			while(rs.next()) {
				subjects.add(rs.getString("subject"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mv.addObject("subjects", subjects);
		mv.setViewName("board/board_select");/* WEB-INF/view/board/board_select.jsp */
		return mv;
		
	}
	
}
