package Boarder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Boarder.model.Boarder;
import Boarder.model.BoarderDao;

@Controller
public class BoardeerUpdateController {
	
	final String command = "/update.bd";
	final String getPage = "boarder_UpdateForm";
	final String gotoPage = "redirect:/list.bd";
	
	@Autowired    
	BoarderDao boardDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction(@RequestParam("boardno")int boardno,
							Model model							
			) {
		Boarder lists = boardDao.getoneBoardList(boardno);
		model.addAttribute("lists", lists);				
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("bo") @Valid Boarder board,
								HttpServletRequest request) {
		 		
		ModelAndView mav = new ModelAndView();
		boardDao.updateBoard(board);
		mav.setViewName(gotoPage);
		return mav;
		
	}
}
