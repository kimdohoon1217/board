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
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script src="/SE2/js/HuskyEZCreator.js"></script>

<title>Jsp-basicLib</title>
<%@include file="/commonjsp/basicLib.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
	
	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, 
			}
		});
	});
	
	// 필수값 Check
	function validation(){
		var contents = $.trim(oEditors[0].getContents());
		if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}
	
		return true;
	}

</script>
</head>
<body>
	<!-- header -->
	<%@include file="/commonjsp/header.jsp" %>
	

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<!-- left -->
	<%@include file="/commonjsp/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


					<div class="form-group">
						<label for="postTitle" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="pTitle" name="pTitle">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label for="postCont" class="col-sm-2 control-label">글내용</label>
						<form action="/result.jsp" method="post" id="frm">
							<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea> 
						</form>
					</div>
					<br>
					<div class="form-group">
						<label for="postFile" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-8">
							<input type="file" class="form-control" id="reg_dt" name="reg_dt" multiple="multiple">
						</div>
					</div>
					<br>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="regBtn" class="btn btn-default">저장</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>