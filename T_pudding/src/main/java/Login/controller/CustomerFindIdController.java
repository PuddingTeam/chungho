package Login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Login.model.Customer;
import Login.model.CustomerDao;


@Controller
public class CustomerFindIdController {

	final String command = "/findid.me";
	final String getPage = "FindIdForm";
	

	@Autowired
	CustomerDao customerDao;

	@RequestMapping(value=command , method=RequestMethod.GET)
	public String doAction() {
		return getPage; 
	}

	@RequestMapping(value=command , method=RequestMethod.POST)
	public ModelAndView doAction(Customer customer,HttpServletResponse response) throws IOException {

//		customer.getCustomer_name().length()  select로 설정
//		length.size()  if : != 0 
//						else
//		if(customer.getCustomer_name().length() != 0 or null) 이름이 같으면에 쓰고
//		
//		else {
//			
//		}
							
							
		System.out.println("customer.getCustomer_id():" + customer.getCustomer_id());
		System.out.println("dbcustomer.getCustomer_id():" + dbcustomer.getCustomer_id());
		
		ModelAndView mav = new ModelAndView();
		PrintWriter pw = response.getWriter();

		response.setContentType("text/html;charset=UTF-8"); 
		
		
		
		
		if(customer.getCustomer_name().equals(dbcustomer.getCustomer_name())) {		//이름이  같으면
	
			//Customer dbcustomer = customerDao.getDataList(customer.getCustomer_name()); select 설정
//			한마디로 where = getCustomer_name으로 select 만들 것
			if(customer.getCustomer_hpnumber().equals(dbcustomer.getCustomer_hpnumber())){		//이름과  번호가 같으면 똑같이 length로 만들 것
				System.out.println("이름과  번호가 같으면");
				System.out.println(dbcustomer.getCustomer_id());
				   pw.println("<script type='text/javascript'>");
		            pw.println("alert('id:' + <%=dbcustomer.getCustomer_id())%>");
		            pw.println("</script>");
		            pw.flush();   //내보내기
				mav.setViewName(getPage);
				return mav;
			}else {																		//이름 같고 번호 틀림 똑같이 length로 만들 것
				System.out.println("이름같고 번호틀림");
				pw.println("<script type='text/javascript'>");
				pw.println("alert('이름이 틀렸습니다.');");
				pw.println("</script>");
				pw.flush();   //내보내기
				mav.setViewName(getPage);
				return mav;
			}
		}																			
		else {																			//이름 틀림
			System.out.println("이름 틀림");
			pw.println("<script type='text/javascript'>");
			pw.println("alert('회원정보가 없습니다.');");
			pw.println("</script>");
			pw.flush();   //내보내기
			return new ModelAndView(getPage);
		}

		//	       else {
//					   pw.println("<script type='text/javascript'>");
//			            pw.println("alert('id:' +customer.getCustomer_id());");
//			            pw.println("</script>");
//			            pw.flush();   //내보내기
		//	            return new ModelAndView(getPage);
		//		   }
		//	      return getPage;
		//		   mav.setViewName(getPage);
		//		return mav;
	}
}
