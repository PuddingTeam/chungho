package Pudding.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	private final String command = "Main.pd";
	private final String getPage = "Main";
	

	@RequestMapping(command)
	public ModelAndView doAction(HttpSession session) { 

		ModelAndView mav = new ModelAndView();
		mav.setViewName(getPage);
		return mav;
//		if(session.getAttribute("loginInfo") == null) {
//			session.setAttribute("destination","redirect:/Main.pd");
//			return "redirect:/loginForm.me";
//		}
//		else {
//			return getPage;
//		}

	}
	
}





