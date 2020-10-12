package Login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Login.model.Customer;
import Login.model.CustomerDao;

@Controller
public class CustomerLoginController {
   
   final String command = "/loginForm.me";
   final String getPage = "LoginForm";
   final String gotoPage = "redirect:/Main.pd";
   
   
   @Autowired
   CustomerDao customerDao;
   
   @RequestMapping(value=command , method=RequestMethod.GET)
   public String doAction() {
      return getPage; 
   }
   
   @RequestMapping(value=command , method=RequestMethod.POST)
   public ModelAndView doAction(Customer customer,HttpServletResponse response, HttpSession session) throws IOException {
      
	   Customer dbcustomer = customerDao.getData(customer.getCustomer_id());  
      
      System.out.println("입력한 아이디:" + customer.getCustomer_id());
      System.out.println("입력한 password:" + customer.getCustomer_passwd());
      
      
      PrintWriter pw = response.getWriter();
      
      response.setContentType("text/html;charset=UTF-8");
      
      //ModelAndView mav = new ModelAndView();
      
      if(dbcustomer == null) {
         System.out.println("존재 하지 않은 회원");
         
         pw.println("<script type='text/javascript'>");
         pw.println("alert('해당 아이디가 존재하지 않습니다.');");
         pw.println("</script>");
         pw.flush();   //내보내기
         //return getPage;
         return new ModelAndView(getPage);
      }
      else {
         System.out.println("존재하는 회원");
         
//         pw.println("<script type='text/javascript'>");
//         pw.println("alert('해당 아이디가 존재하지 않습니다.');");
//         pw.println("</script>");
//         pw.flush();   //내보내기
         
         if(customer.getCustomer_passwd().equals(dbcustomer.getCustomer_passwd())) {
            
        	 session.setAttribute("loginInfo", dbcustomer);
            //return (String)session.getAttribute("destination");
            
            //mav.setViewName((String)session.getAttribute("destination"));
            //return mav;
        	//return new ModelAndView((String)session.getAttribute("destination"));
            return new ModelAndView(gotoPage);
            // "redirect:/insert.prd"로 이동
         }
         else {
            System.out.println("아이디는 일치, 비밀번호는 불일치");
            pw.println("<script type='text/javascript'>");
            pw.println("alert('비밀번호가 일치하지 않습니다.');");
            pw.println("</script>");
            pw.flush();   //내보내기
            return new ModelAndView(getPage);
         }
         
      }
      
      //return getPage; //MemberLoginForm
   }
   
   
}