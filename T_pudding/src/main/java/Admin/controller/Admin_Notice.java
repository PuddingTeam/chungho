package Admin.controller;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Admin.model.Notice;
import Admin.model.NoticeDao;
import utility.Paging;

@Controller
public class Admin_Notice {
	final String command = "addNotice.ad";
	final String getPage = "a_notice";

	@Autowired
	NoticeDao dao;
	
	@RequestMapping(command)
	public ModelAndView doAction(ModelAndView mav) {

		List<Notice> lists = dao.getDataList();
		mav.addObject("lists", lists);
		mav.setViewName(getPage);
		return mav;
	}

}
