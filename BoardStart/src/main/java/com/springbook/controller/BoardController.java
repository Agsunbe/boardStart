package com.springbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.inject.Inject;

import java.util.List;

import com.springbook.dao.BoardDAO;
import com.springbook.domain.BoardVO;
import com.springbook.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController{

	@Inject
	private BoardService service; 
	
	// 게시물 목록
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception {

		List<BoardVO> list = null;
		list = service.list();
		model.addAttribute("list", list);
		
	}

	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
	
	}

	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {
		service.write(vo);
		
		return "redirect:/board/list";
	}
	
	// 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception {
		
		BoardVO vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo) throws Exception {
		
		service.modify(vo);
		
		return  "redirect:/board/list" ;
	//return "redirect:/board/view?bno=" + vo.getBno(); 
	}
	
	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete (@RequestParam("bno") int bno) throws Exception {
		
		service.delete(bno);
		
		return "redirect:/board/list";
		
		
	}

	// 게시물 목록 + 페이징 추가
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void getList(Model model, @RequestParam("num") int num) throws Exception {

	 // 게시물 총 갯수
	 int count = service.count();
	  
	 // 한 페이지에 출력할 게시물 갯수
	 int postNum = 10;
	  
	 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
	 int pageNum = (int)Math.ceil((double)count/postNum);
	  
	 // 출력할 게시물
	 int displayPost = (num - 1) * postNum;
	 
	 // 표시되는 페이지 번호 중 첫번째 번호
	 int pageNumstart = (int)Math.floor((double)(num/10) * 10);
			 
	 
	    
	 List list = null; 
	 list = service.listPage(displayPost, postNum);
	 model.addAttribute("list", list);   
	 model.addAttribute("pageNum", pageNum);
	
	}
}