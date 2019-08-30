<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            
<form class="form-horizontal" role="form">

               
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">제목</label>
                  <div class="col-sm-10">
                     <label class="control-label">${vo.bullTitle }</label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">글내용</label>
                  <div class="col-sm-10">
                     <label class="control-label">${vo.bullCont }</label>
                  </div>
               </div>
               

               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button id="modi" type="button" class="btn btn-default">사용자 수정</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>