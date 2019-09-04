<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
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
<%@include file="/commonjsp/basicLib.jsp" %>

<script>
	$(function(){
		$("#modi").on("click", function(){
			$("#frm").submit();
		});
		
		$("#regCom").on("click", function(){
			$("#comfrm").submit();
		});
		
		$(".rbtn").click(function(){
			var idx = $(this).attr("idx");
			$("#div"+idx).remove();
		});
		
		
	})
</script>

</head>

<body>

<!-- header -->
<%@include file="/commonjsp/header.jsp" %>
<div class="container-fluid">
      <div class="row">
         
<div class="col-sm-3 col-md-2 sidebar">
   <%@include file="/commonjsp/left.jsp" %>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

<form id = "frm" action="${cp }/" method = "get">
	<input type = "hidden" id = "" name = "" value=""/>
</form> 
            
            <div class="form-group">
                <label for="title" class="col-sm-1 control-label">제목</label>
                <div class="col-sm-10">
                    <label id="title" class="control-label">${vo.bullTitle }</label>
                </div>
            </div>
            <br>

            <div class="form-group">
                <label for="post_file" class="col-sm-10 control-label">내용</label>
                <div class="col-sm-10">
                    <label id="post_file" class="control-label">${vo.bullCont }</label>
                </div>
            </div>
            <br>

            <div class="form-group">
                <label for="post_cont" class="col-sm-10 control-label">첨부파일</label>
                <div id="fileList" class="col-sm-10 btnLine">
                    <c:forEach items="${fileList }" var="file">
                        <a href="${cp }/fileDownload?filNo=${file.filNo}" download = "${file.uploadFile }">${file.uploadFile }</a><br>
                    </c:forEach>
                </div>
                <div class="col-sm-4 btnLine">
           		
                    <c:if test="${vo.userId == S_USERVO.userId}">
                        <a href="${cp }/modifyPost?postNo=${vo.bullNo}&boardNo=${vo.boardNo}" class="modify btn btn-success pull-right">수정</a>
                        <a href="${cp }/deletePost?postNo=${vo.bullNo}&boardNo=${vo.boardNo}" class="modify btn btn-success pull-right">삭제</a>
                    </c:if>
                    <a href="${cp }/reply?postNo=${vo.bullNo}&boardNo=${vo.boardNo}" class="modify btn btn-success pull-right">답글</a>
                </div>
            </div>
            <br><br><br>
			
            <div class="form-group">
                <label for="post_com" class="col-sm-10 control-label">댓글</label>
                <div id="commentList" class="col-sm-10">
                    <c:forEach items="${com }" var="com">
                    <c:choose>
                    	<c:when test="${com.DELSTATUS == 'X' }">
	                    	<div id="div${com.REPLYNO }">
	                        	<span>${com.REPLYCONT}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>[ ${com.USERID} / <fmt:formatDate value="${com.C_DATE}" pattern="yyyy-MM-dd"/>  ]</span>
	                        	<a class="rbtn" href="${cp }/deleteCom?replyNo=${com.REPLYNO}&postNo=${vo.bullNo}&boardNo=${vo.boardNo}" idx="${com.REPLYNO }">X</a>
	                        </div>
                    	</c:when>
                    	<c:otherwise>
                    		<div id="div${com.REPLYNO }">
                    			[삭제된댓글입니다.]
                    		</div>
                    	</c:otherwise>
                     </c:choose>   
                    </c:forEach>
                </div>
            </div>
            <br><br>

            <div class="form-group">
                <div class="col-sm-1"> </div>
                <div class="col-sm-4">
				<form id="comfrm" action="${cp }/comment" method="get">
					<input type="hidden" name="postNo" value="${vo.bullNo }">
					<input type="hidden" name="boardNo" value="${vo.boardNo }">
                    <textarea class="form-control" rows="3" id="cont" name="cont"></textarea>
                </form>
                </div>
                <div class="col-sm-2">
                    <button id="regCom" type="button" class="modify btn btn-success">댓글 저장</button>
                </div>
            </div>
            <br>
         </div>
      </div>
   </div>
</body>
</html>