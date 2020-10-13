<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common.jsp" %>
<script type="text/javascript">
	function register(){
		location.href="registerForm.me"; // => MemberRegisterController.java
	}
	function findid(){
		location.href="findid.me"; // => MemberRegisterController.java
	}
	function findpwd(){
		location.href="findpwd.me"; // => MemberRegisterController.java
	}

</script>
<form method="post" action="loginForm.me">
	<table border="1" width="40%" height="150px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="customer_id" value="park"></td>
		</tr>
		
		<tr>
			<td>비번</td>
			<td><input type="password" name="customer_passwd"></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="button" value="아이디 찾기" onClick="findid()">
				<input type="button" value="비밀번호 찾기" onClick="findpwd()">				
				<input type="button" value="회원가입" onClick="register()"> 
			</td>
		</tr>
	</table>
</form>