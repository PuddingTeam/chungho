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
<script>
//아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#user_id").blur(function() {
		// id = "id_reg" / name = "userId"
		var user_id = $('#user_id').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/user/idCheck?userId='+ user_id,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_id)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#id_check").text("");
							$("#reg_submit").attr("disabled", false);
				
						} else if(user_id == ""){
							
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
</script>
</script>



MemberRegisterForm.jsp<br>
<h2>회원 가입 화면</h2>
<table border="1">
	<form:form commandName="customer" method="post" action="registerForm.me" > 
	
		<tr>
			<td>아이디</td>
			<td>
			<input type="text" name="customer_id" id="user_id">
			<form:errors cssClass="err" path="customer_id" />
			
			</td>
			
		</tr>
		<tr>
			<td>이름</td>
			<td>
			<input type="text" name="customer_name" id="name">
			<form:errors cssClass="err" path="customer_name" />
			</td>
			
		</tr>
		<tr>
			<td>비번</td>
			<td>
			<input type="text" name="customer_passwd" id="password">
			<form:errors cssClass="err" path="customer_passwd" />
			</td>
			
		</tr>
		
		<tr>
			<td>이메일</td>
			<td>
			<input type="email" name="customer_email" id="email" >
			<form:errors cssClass="err" path="customer_email" />
			</td>
		</tr>
		
		<tr>
			<td>휴대폰 번호</td>
			<td>
			<input type="text" name="customer_hpnumber" id="hpnumber"> 
			<form:errors cssClass="err" path="customer_hpnumber" />
			</td>
			
		</tr>	
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입하기">
				 
			</td>
		</tr>

	</form:form>
</table>