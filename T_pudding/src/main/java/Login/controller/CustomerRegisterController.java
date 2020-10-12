package Login.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Login.model.Customer;
import Login.model.CustomerDao;



@Controller
public class CustomerRegisterController {

	final String command = "/registerForm.me";
	final String getPage = "RegisterForm";
	final String gotoPage = "redirect:/loginForm.me"; // MemberListController

	@Autowired
	CustomerDao customerDao;

	// MemberLoginForm.jsp 
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doAction() {

		return getPage;
	}

	//MemberRegisterForm.jsp ���� ��û�� 
	@RequestMapping(value=command, method=RequestMethod.POST) // MemberLoginForm.jsp���� �Ѿ��
	public ModelAndView doAction(@Valid Customer customer,BindingResult result,HttpServletResponse response) throws IOException {

		Customer dbcustomer = customerDao.getData(customer.getCustomer_id());
		PrintWriter pw = response.getWriter();

		response.setContentType("text/html;charset=UTF-8");
		ModelAndView mav = new ModelAndView();
		
			if(result.hasErrors()) { 
				mav.setViewName(getPage);
				return mav;
			}
			else {
				customerDao.insertData(customer);
				mav.setViewName(gotoPage);
				return mav;
			}
	}
	
	
}

//if(customer.getCustomer_id().equals(dbcustomer.getCustomer_id())){
//	System.out.println("아이디와 db아이디가 중복됨");
//	pw.println("<script type='text/javascript'>");
//	pw.println("alert('아이디가 중복됩니다.');");
//	pw.println("</script>");
//	pw.flush();   //내보내기
//	return new ModelAndView(getPage);
//
//}
//else if(result.hasErrors()) { 
//	mav.setViewName(getPage);
//	return mav;
//
//}
//
//else {
//
//	customerDao.insertData(customer);
//
//	mav.setViewName(gotoPage);
//	return mav;
//}

	