<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/login.css"  rel="stylesheet" type="text/css">
<title></title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
<script language="JavaScript">
	function loginCheck(){

		var param = "id" + "=" + $("#id").val() + "&" +"pw" + "="+ $("#pw").val();
		
		$.ajax({
			url : "/login.do",
			type : "POST",
			data : param,
			cache : false,
			async : false,
			dataType : "text",

			success : function(response) {								

				if(response == 1){
					alert("로그인 성공");
					location.href="/main.do";
				}
				else {
					$('.error').css('display', 'block');
					$('#id').focus();
					console.log($("#id").val());
					console.log($("#pw").val());
					return false;
				}	
				alert(check);
			},

			error : function(request, status, error) {
				if (request.status != '0') {
					alert("code : " + request.status + "\r\nmessage : "
							+ request.reponseText + "\r\nerror : " + error);
				}
			}
		});
		
		
	}
	$(document).ready(function() {
		$('#id').focus();
		
		$("#id, #pw").keydown(function(event) {
			if (event.which == 13) {
				event.preventDefault();
				$('#loginBotton').trigger('click');
			}
		});
		
		 $("#id").keyup(function(){$(this).val($(this).val().replace(/[^a-z0-9]/gi,""));});
	     $("#pw").keyup(function(){
	    	 var expUrl = /[^a-z0-9!@#$%^*+=-]/gi;
	    	 if(true == expUrl.test($(this).val())){
	    		alert('허용되지않는 특수문자는 사용하실수 없습니다.');	 
	    	 }
	    	 
	    	 $(this).val( $(this).val().replace(/[^a-z0-9!@#$%^*+=-]/gi,"") );} 
	     );
	     $("#id").bind("keyup", function() {
	         $(this).val($(this).val().toLowerCase());
	     });
	     $("#pw").bind("keyup", function() {
	         $(this).val($(this).val().toLowerCase());
	     });
	});
</script>
</head>
<body style="background:url('resources/img/bg_login.gif') repeat-x;">
<form id="frm" name="frm">
	<div class="logincon_wrap">
   		<div class="login_logo"><img src="resources/img/login_logo.png"/></div>
       	<div class="mgt100">
       		<div class="login_ttl">Member Login</div>
           	<div class="login_box">
               	<label class="login_idtxt">User ID</label><p>
               	<input name="id" id = "id" type="text" class="login_input" />
               	<div class="mgt20"></div>
               	<label class="login_pwtxt">Password</label><p>
               	<input type="password" id = "pw" class="login_input" name="pw"/>
               	<div class = "error">
					<label>로그인 정보가 올바르지 않습니다. 다시 입력해 주세요!</label>
				</div>
               	<div class="cb"></div>
               	<input type = "button" class = "loginbtn" value="LOGIN" id = "loginBotton" onclick='loginCheck()'/>
             	</div>
           	<div class="login_copy">COPYRIGHT ⓒ 2013 CORESTONE.. ALL RIGHTS RESERVED.</div>	
		</div>
	</div>
</form>
</body>
</html>
