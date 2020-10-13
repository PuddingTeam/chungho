package Boarder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Boarder.model.Boarder;
import Boarder.model.BoarderDao;
import utility.Paging;

@Controller
public class BoarderListController {

	final String command = "/list.bd";
	final String getPage = "boarder_list";
	
	@Autowired
	BoarderDao boardDao;
	
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(HttpSession session){
		
		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination","redirect:/list.bd");
			return "redirect:/loginForm.me";
		}
		else {
			return getPage;
		}
		
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(HttpServletRequest request,
		@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="pageSize", required = false) String pageSize) {
		     
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn",whatColumn); 
		map.put("keyword", "%"+keyword+"%"); 
		
		int totalCount =boardDao.getTotalCount(map);
		String url = request.getContextPath() +  command; 
		ModelAndView mav = new ModelAndView();   
		
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		 List<Boarder> lists = boardDao.getBoardList(pageInfo,map);
	   
		 mav.addObject("lists", lists);
		 mav.addObject("pageInfo",pageInfo);
		 mav.setViewName(getPage);
		return mav;
	} 
}
