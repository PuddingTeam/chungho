<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common.jsp" %>
<%@include file ="color.jsp" %>

<style>
body {
    width: 100%;
    text-align : center;
}
table {
    margin: 0 auto;
}   

</style>
   

<body bgcolor="<%=bodyback_c %>">


	<b> 글목록</b>
<form action="list.bd" method="post">
	<select name="whatColumn">
		<option value="all">전체검색
		<option value="board_title">제목으로 검색
		<option value="board_writer">작성자 검색
	</select>
	<input type="text" name="keyword" value="홍길동">
	<input type="submit" value="검색">
</form>
    <table border=1>
    
    	<tr>
    		<td align="right"  colspan="6">
    			<a href="insert.bd">게시글 등록</a>
    		</td>
    	</tr>
    	<tr bgcolor= "<%=value_c%>">
    		<th>번호</th>
    		<th>제목</th>
    		<th>작성자</th>
    		<th>작성일</th>
    		<th>조회</th>
    	</tr>
    <c:forEach items ="${lists }" var ="bean">
    	<tr>
    		<td>${bean.boardno }</td>
    		<td><a href="content.bd?boardno=${bean.boardno }">${bean.board_title }</a></td>
    		<td>${bean.board_writer }</td>
    		<td>${bean.board_date }</td>
    		<td>${bean.board_recount }</td>
    	</tr>
    </c:forEach>
    
    
    </table>
    </body>
    ${pageInfo.pagingHtml}