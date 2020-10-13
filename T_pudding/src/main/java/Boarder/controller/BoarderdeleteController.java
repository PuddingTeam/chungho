package Boarder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Boarder.model.BoarderDao;

@Controller
public class BoarderdeleteController {
	
	final String command = "/delete.bd";
	final String gotoPage = "redirect:/list.bd";
	
	@Autowired    
	BoarderDao boardDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="boardno",required=true) int boardno) {
		
		boardDao.deleteboard(boardno);
		
		return gotoPage;
	}
}
