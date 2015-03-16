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
	src="${pageContext.request.contextPath }/adminJs/goods.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/adminCss/goods.css">

<title>商品管理</title>
</head>
<body class="easyui-layout">
   <div data-options="region:'north'" style="background:#E0ECFF;height:35px;font-weight:bold">
  商品分类名称:<input id="category" class="easyui-combobox" type="text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  商品名称:<input id="name" class="easyui-textbox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	  <a id="search" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search">Query</a>
   
   </div>
	<div data-options="region:'center'">
		<table id="dg"></table>
	</div>

	<!-- dialog for add and update-->
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 400px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		
		
		<div class="ftitle">商品信息</div>
		<form id="fm">
			
			<div class="fitem">
				<label>分类:</label> <input id="dlgCategory"
					class="easyui-combobox" type="text">
			</div>
			<div class="fitem">
				<label>标题:</label> <input id="title"
					class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>库存:</label> <input id="stock"
					class="easyui-numberbox" required="true">
			</div>
			<div class="fitem">
				<label>单价:</label> <input id="price" class="easyui-numberbox" required="true">
			</div>
			<div class="fitem">
				<label>描述:</label> <input id="description" class="easyui-textbox" data-options="multiline:true" style="height:160px">
			</div>
		</form> 
	</div>
	<!-- end dialog -->
	
	<!-- dialog buttons -->
	<div id="dlg-buttons">
		<a onClick="saveGoods();" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  style="width: 90px">保存</a> 
		<a onClick="javascript:$('#dlg').dialog('close');" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px">取消</a>
	</div>

</body>
</html>