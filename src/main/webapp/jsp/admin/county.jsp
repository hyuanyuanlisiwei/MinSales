<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/easyui/themes/default/easyui.css">

<!-- 自定义 css js-->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/adminJs/county.js"></script>

<title>县级管理</title>
</head>
<body class="easyui-layout">
   <div data-options="region:'north'" style="background:#E0ECFF;height:35px;font-weight:bold">
   	选择省名:<select id="province"></select>&nbsp;&nbsp;&nbsp;
   	选择市区:<select id="city" class="easyui-combobox" data-options="valueField:'id',textField:'name'" style="width:150px" ></select>&nbsp;&nbsp;&nbsp;
   	
   	
   	县名:<input id="name" class="easyui-textbox"   type="text">&nbsp;&nbsp;&nbsp;
   	  <a id="search" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search">Query</a>
   </div>
	<div data-options="region:'center'">
		<table id="dg"></table>
	</div>
</body>
</html>