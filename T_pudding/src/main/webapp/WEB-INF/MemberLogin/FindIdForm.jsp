<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    findid.jsp<br>
    
    <form action = "findid.me" method = "post">
    	<table border="1" align = "center">
    		
    		<tr>
    			<td bgcolor = "yellow" align="center">이름</td>
    			<td> <input type="text" name="customer_name" value="어드민"/> </td>
    		</tr> 

			<tr>
    			<td bgcolor = "yellow">휴대폰</td>
              <td> 
              	<input type="text" name="customer_hpnumber" > 
                </td>
    		</tr> 
			
			<tr>
				<td colspan = "2" bgcolor="yellow" align="center">
					<input type = "submit" value = "아이디찾기">
				</td>
			</tr> 
    	</table>
    
    
    
    </form>