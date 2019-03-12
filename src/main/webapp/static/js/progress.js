function t1(){
	$('#myModalUpLoad').modal({
		backdrop:"static"		
	});
	$("#footerid").hide();
	var interval = setInterval(function(){
		$.ajax({
			url:"QryProgressData",
			dataType:"json",
			type:"post",
			success:function(data){
				$("#modal_message").css("width",data+"%");
				if(data==100){
					window.clearInterval(interval);
					$("#loadingDiv").html("");
					$("#successDiv").html("");
					$("#successDiv").append("<p>下载成功</p>");
					$("#footerid").show();
				}
			}
		})
	}, 1000);
}
