<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<!-- 自定义css js -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/adminCss/login.css">
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/adminJs/login.js"></script> --%>
	
</head>
<body>
<div class="easyui-panel" title="登录" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
		<span id="errorTip"></span>
	    <form id="ff" class="easyui-form" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" id="name" data-options="required:true"/></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="text" id="pass" data-options="required:true"/></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" id="btnLogin">Submit</a>&nbsp;&nbsp;
	    	<a href="javascript:void(0)" class="easyui-linkbutton" id="btnClear">Clear</a>
	    </div>
	    </div>
	</div>
<script type="text/javascript">
	
(function() {

	$("#btnLogin").click(function() {
		var name =$("#name").val();
		var pass =$("#pass").val();
		
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath }/AdminLoginController/index.do",
			data : {
				username : name,
				password : pass
			},
			dataType : "json",
			success : function(result) {
				if (result.result == 0)
					location.href = "${pageContext.request.contextPath }/AdminLoginController/newInfo.do";
				else
					$("#errorTip").html("用户名或密码错误!");
			},
			error : function() {
				$("#errorTip").html("出现异常!");
				return;
			}
		});
	});

	
	$("#btnClear").bind("click",function(){
		
		$("input").val("");
	});
	
})()

</script>
	
	
	
</body>
</html>