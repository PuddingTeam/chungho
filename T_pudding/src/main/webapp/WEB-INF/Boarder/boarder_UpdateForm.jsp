   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common.jsp" %>    
    
<h2>글쓰기</h2>
    <form:form commandName="bo" method="post" action="update.bd" >   <!--  form에쓸때는 onSubmit, submit에 쓸때는 onClick -->
    <table border="1" align="center" width="450" cellspacing="0">
    <input type="hidden" name="boardno" value="${lists.boardno }">
    <tr>
    <td colspan="2" align="right" ><a href="list.bd">글목록</a></td>
    </tr>
      
    <tr>
    <td width="100" align="center" >이름</td>
    <td><input type="text" size="30" maxlength="10" name="board_writer" value="${lists.board_writer }"></td>
	</tr>
    
    <tr>
    <td width="300" align="center" >제목</td>
    <td><input type="text" name="board_title" size="50" value="${lists.board_title }"></td>
	</tr>
	
    <tr>
    <td width="100" align="center" >내용</td>
    <td><textarea name="board_content" id="abc" rows="13" cols="50">${lists.board_content }</textarea> </td>
	</tr>
	
    <tr>
    <td width="100" align="center" >비밀번호</td>
    <td width="350"><input type="password" size="10" maxlength="12" name="board_passwd" value="${lists.board_passwd }"></td>
	</tr>
    <tr>
    <td colspan="2" align="center">
    <input type="submit" value="수정하기" >
    <input type="reset" value="다시작성">
    <input type="button" value="목록보기" onClick="location.href='list.bd'">
    
    </td>
	</tr>
    
    
    
    </table>
    
    
    
    
    </form:form>
    
    