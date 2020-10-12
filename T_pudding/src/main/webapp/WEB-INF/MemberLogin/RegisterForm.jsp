<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<style type="text/css">
	.err{
	font-size: 9pt;
	color: red;
	font-weight: bold;
	}
</style>

<script type="text/javascript">

</script>
MemberRegisterForm.jsp<br>
<h2>회원 가입 화면</h2>
<table border="1">
	<form:form commandName="customer" method="post" action="registerForm.me"> 
	
		<tr>
			<td>아이디</td>
			<td>
			<input type="text" name="customer_id" id="id" value="park">
			<form:errors cssClass="err" path="customer_id" />
			
			</td>
			
		</tr>
		<tr>
			<td>이름</td>
			<td>
			<input type="text" name="customer_name" id="name" value="박청호">
			<form:errors cssClass="err" path="customer_name" />
			</td>
			
		</tr>
		<tr>
			<td>비번</td>
			<td>
			<input type="text" name="customer_passwd" id="password" value="1234">
			<form:errors cssClass="err" path="customer_passwd" />
			</td>
			
		</tr>	
		<tr>
			<td>이메일</td>
			<td>
			<input type="email" name="customer_email" id="email" value="cjdghqkr6143@gmail.com">
			<form:errors cssClass="err" path="customer_email" />
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입하기">
				 
			</td>
		</tr>

	</form:form>
</table>