var ajaxPostSend =  function() {
	
	parent.startLayer();
	var url = "loginAjax.do";
	var postString = "";
	postString   = "id=" + $('#id').val();
	postString += "&password=" + $('#password').val();
	
	var id_check = $('#id').val();
	var password_check = $('#password').val();
	
	if(id_check == "") {
		alert('히힣');
	}
	
	else {
		$.ajax({

		type: "POST",
		url: url,
		data: postString,
		success: function(msg) {
			setTimeout('parent.stopLayer('+msg+')',2500);
		}
		});
	}
 };