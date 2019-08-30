<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Jsp-Main</title>
<%@include file="/commonjsp/basicLib.jsp"%>

<script>
	<%int idxVal = 0;%>
	$(function(){
		$("#creatbtn").on('click', function(){
			$("#frm").submit();
		});
		
		$(".postDiv").on('click', '.modibtn', function(){
			idxVal = $(this).attr('idx')
			opVal = $(this).parent().find(".op").val();
			nameVal = $(this).parent().find(".names").val();
			$("#inputIdx").val(idxVal);
			$("#inputIdx2").val(opVal);
			$("#inputIdx3").val(nameVal);
			
			$("#frm2").submit();
		});
	})
</script>
</head>

<body>


	<!-- header -->
	<%@include file="/commonjsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@include file="/commonjsp/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<form id = "frm" action="${cp }/boardForm" method="get">
			<input type = "hidden" name = "userId" value="${S_USERVO.userId}"/>			
				<div class="blog-header">
						<label>게시판 이름</label><input type = "text" id="name" name = "name"/>
						<select id = "opt" name = "opt">
							<option value="사용">사용</option>
							<option value="미사용">미사용</option>
						</select>
						<button id="creatbtn"type="button" class="btn btn-primary btn">생성</button>
				</div>
			</form>
				<br>
				<form id = "frm2" action="${cp }/boardForm" method="post">
					<input id = "inputIdx" type = "hidden" name = "idx"/>
					<input id = "inputIdx2" type = "hidden" name = "opVal"/>
					<input id = "inputIdx3" type = "hidden" name = "nameVal"/>
				<c:forEach items="${boardList }" var="board">
						<div id = "postDiv" class="blog-header postDiv">
								<label>게시판 이름</label><input type = "text" class="names" name = "names"/ value="${board.boardNm }">
								<c:choose>
									<c:when test="${board.useStatus=='사용' }">
										<select name = "opts" class = "op">
											<option value="${board.useStatus }">${board.useStatus }</option>
											<option value="미사용">미사용</option>
										</select>
									</c:when>
									<c:otherwise>
										<select name = "opts" class = "op">
											<option value="${board.useStatus }">${board.useStatus }</option>
											<option value="사용">사용</option>
										</select>
									</c:otherwise>
								</c:choose>
								 <button idx="${board.boardNo}" type="button" class="btn btn-info modibtn">수정</button>
						</div>
				</c:forEach>
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
