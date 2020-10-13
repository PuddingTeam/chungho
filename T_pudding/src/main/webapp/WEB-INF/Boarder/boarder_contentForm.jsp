
<%@page import="Boarder.model.Boarder"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="../common.jsp" %>  
 <%@ include file="color.jsp" %> 
<style type="text/css">
body {
    width: 100%;
    text-align : center;
}
table {
    margin: 0 auto;  
}   
</style>     
	content.jsp<br>
	<body bgcolor="<%=bodyback_c %>">
	
	
	  
	
	
	
	글내용 보기
	<table border="1" width="450" align="center" cellspacing="0">
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>" >글번호 </td>
		<td width="125"  align="center">${lists.boardno }</td>  
		<td width="125"  align="center" bgcolor="<%=value_c %>">조회수 </td>
		<td width="125"  align="center"></td>
		
	</tr>
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>">작성자 </td>
		<td width="125"  align="center" >${lists.board_writer }</td>
		<td width="125"  align="center" bgcolor="<%=value_c %>" >작성일</td>
		<td width="125"  align="center" >${lists.board_date }
		
	</tr>
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>">글제목 </td>
		<td colspan="3" align="center" >${lists.board_title }</td>
		
		
	</tr>
	<tr>
		<td width="125"  align="center" bgcolor="<%=value_c %>">글내용 </td>
		<td colspan="3">${lists.board_content }</td>
		
		
	</tr>
	<tr>
			<td colspan=4  align="center" height="30" bgcolor="<%=value_c %>">
				<input type="submit" value="글수정" onClick="location.href='update.bd?boardno=${lists.boardno }'">  
				<input type="button" value="글삭제" onClick="location.href='delete.bd?boardno=${lists.boardno}'"> 
				<%-- <input type="reset"	value="답글쓰기" onClick="location.href='reply.bd?boardno=${lists.boardno }">  --%>
				<input type="button" value="목록보기" onClick="location.href='list.bd'">
			</td>
		</tr>
	
	</table>
	
	
	
		댓글
		<form:form action="insert.rc" method="post">
		<table  border=1>
		<!-- 글번호 --><input type="hidden" name="recontent_boardno" value="${lists.boardno }">
		<tr>
		<td>작성자</td>
		<td><input type="text" name="recontent_writer" value="홍길동 "></td>
		</tr>
		<tr>
		<td>댓글 내용</td>
		<td><textarea name="recontent_content" id="abc" rows="5" cols="50"></textarea></td>
		</tr>
		<tr>
		<td>작성자</td>
		<td><input type="password" name="recontent_passwd" value="1234 "></td>
		</tr>
		<tr>
		<td colspan=2><input type="button" value="댓글쓰기"></td>
		</tr>
	</table>
	</form:form>
	
	
	
	
	