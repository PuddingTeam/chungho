package Boarder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Boarder.model.Boarder;
import Boarder.model.BoarderDao;
  
@Controller
public class BoarderContentController {
	
	
	final String command = "/content.bd";
	final String getPage = "boarder_contentForm";
	
	@Autowired    
	BoarderDao boardDao;
	  
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doAction(@RequestParam(value="boardno",required=true) int boardno) {		
		Boarder lists = boardDao.getoneBoardList(boardno);
		 ModelAndView mav = new ModelAndView();      
		 mav.addObject("lists", lists);
		 mav.setViewName(getPage);
		return mav;
	}
}
