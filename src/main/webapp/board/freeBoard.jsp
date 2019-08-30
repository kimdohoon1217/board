<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>
<style>
	table{
		font-size : 15px;
	}
</style>
<%@include file="/commonjsp/basicLib.jsp" %>


<script>
	//문서가 로딩이된후에 
	$(document).ready(function(){
		//<< >> 페이지이동
		//form태그만들어서 form action/freeBoard?page=1할때 파라미터값을 넣어주면될듯
		
		
		
		//사용자 정보 클릭시 이벤트 핸들러
		$(".postTr").on("click", function(){
			postNo = $(this).find("#postNo").val();
			boardNo = $(this).find("#boardNo").val();
			$("#hPostNo").val(postNo);
			$("#hboardNo").val(boardNo);
			
			$("#frm3").submit();
		});
	});
</script>
</head>
<form id = "frm3" action="${cp }/post" method = "get">
	<input type = "hidden" id = "hPostNo" name = "postNo"/>
	<input type = "hidden" id = "hboardNo" name = "boardNo"/>
</form>

<body>
	<!-- header -->
	<%@include file="/commonjsp/header.jsp" %>
	

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<!-- left -->
	<%@include file="/commonjsp/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">자유게시판</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>게시글 번호</th>
					<th>제목</th>
					<th>작성자 아이디</th>
					<th>작성일시</th>
				</tr>
				
				<c:forEach items="${postList }" var="post" varStatus="loop">
					<tr class = "postTr">
						<input type = "hidden" id = "postNo"  value="${post.bullNo }"/>
						<input type = "hidden" id = "boardNo"  value="${param.boardSeq }"/>
						<td>${post.bullNo }</td>
						<td>
						<c:forEach begin="0" end="${post.level }" var="i">
							<c:choose>
								<c:when test="${post.level == 1}">
								</c:when>
								<c:otherwise>
								 &nbsp;
								</c:otherwise>
							</c:choose>
						</c:forEach>
						 <c:if test="${post.parentNo > 0}">
						 	└
						 </c:if>
						 ${post.bullTitle }</td>
						
						<td>${post.userId }</td>
						<td>${post.reg_dt_fmt }</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>

		<a href="${cp }/postForm" class="btn btn-default pull-right">새글 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<%--이전 페이지 가기 : 지금 있는 페이지에서 한 페이지 전으로
					단 1페이지인 경우는 li 태그에 class = "disabled"를 추가를 하고
					이동경로는 차단
			  --%>
			  	 
			  	 <c:choose>
			  	 	<c:when test="${pageVo.page == 1 }">
					 <li class="disabled">
					 		<span aria-hidden="true">&laquo;</span>
			  	 	</c:when>
			  	 	<c:otherwise>
				  	 	<li>
					      <a href="${cp }/freeBoard?boardSeq=${boardSeq }&page=${pageVo.page-1 }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
			  	 	</c:otherwise>
			  	 </c:choose>
			  	 
				<c:forEach begin="1" end="${paginationSize }" var="page">
					
					<c:choose>
						<c:when test="${page == pageVo.page}">
							<li class="active"><span>${page }</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${cp }/freeBoard?boardSeq=${boardSeq }&page=${page }">${page }</a></li>
						</c:otherwise>					
					</c:choose>
					
				</c:forEach>
				
				 <c:choose>
			  	 	<c:when test="${pageVo.page == paginationSize }">
					 <li class="disabled">
					 		<span aria-hidden="true">&raquo;</span>
			  	 	</c:when>
			  	 	<c:otherwise>
				  	 	<li>
					      <a href="${cp }/freeBoard?boardSeq=${boardSeq }&page=${pageVo.page+1 }" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
			  	 	</c:otherwise>
			  	 </c:choose>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
