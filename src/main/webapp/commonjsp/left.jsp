<%@page import="kr.or.ddit.board.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.service.BoardService"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav nav-sidebar">

	<%
		IBoardService service = new BoardService();
		List<Board> list = service.selectAll();
		request.setAttribute("list", list);
	%>

		
		<li class="active"><a href="${cp }/boardCreate">게시판생성<span class="sr-only">(current)</span></a></li>
		<br>
		<%--생성 버튼을 누르면 <li>가진 게시판을 만들어줘야한다 list만큼 뽑아서 --%>
		<c:forEach items="${list }" var="board" varStatus="status">
			<c:choose>
				<c:when test="${board.useStatus == '사용' }">
					<%-- <c:choose>
						<c:when test="${status.count == 1 }">
							<li class="active"><a href="${cp }/freeBoard">${board.boardNm }<span class="sr-only">(current)</span></a></li>
						</c:when>
						<c:when test="${status.count == 2 }">
							<li class="active"><a href="${cp }/QnABoard">${board.boardNm }<span class="sr-only">(current)</span></a></li>
						</c:when>
						<c:otherwise> --%>
							<li class="active"><a href="${cp }/freeBoard?boardSeq=${board.boardNo}">${board.boardNm }<span class="sr-only">(current)</span></a></li>
					<%-- 	</c:otherwise>
					</c:choose> --%>
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
		</c:forEach>
</ul>