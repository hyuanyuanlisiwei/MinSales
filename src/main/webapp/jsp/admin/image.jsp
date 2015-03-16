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
	src="${pageContext.request.contextPath }/adminJs/image.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/adminCss/image.css">


<title>商品图片管理</title>
</head>
<body class="easyui-layout">
   <div data-options="region:'north'" style="background:#E0ECFF;height:35px;font-weight:bold">
   	选择商品分类:<select id="category"></select>&nbsp;&nbsp;&nbsp;
   	选择商品:<select id="goods"></select>&nbsp;&nbsp;&nbsp;
   	<a id="search" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-search">Query</a>
   </div>
	<div data-options="region:'center'">
		<table id="dg"></table>
	</div>
	
	<!-- view the color that the quique goods have -->
	<div id="viewDlg" class="easyui-dialog" style="width:250px;height:250px;padding:0px 0px" closed='true'>
		<table id="viewDg"></table>
	</div>

	<!-- 图片上传 -->
	<!-- dialog for add and update-->
	<div id="uploadDlg" class="easyui-dialog"
		style="width: 400px; height: 400px; padding: 10px 20px" closed="true">

		<form id="ff" action="${pageContext.request.contextPath}/AdminImageController/insertGoodsColorImg.do" method="post"
			enctype="multipart/form-data">
			<table>
				<!-- 保存goodsId -->
				<input name="goodsId" type="hidden">
				<tr>
					<td>选颜色:</td>
					<td><input id="color" name="colorId"></input></td>
				</tr>
				<tr>
					<td>原图片:</td>
					<td><input name="files" class="easyui-filebox"></input></td>
				</tr>
				<tr>
					<td>大图片:</td>
					<td><input name="files" class="easyui-filebox"></input></td>
				</tr>
				<tr>
					<td>小图片:</td>
					<td><input name="files" class="easyui-filebox"></input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="上传"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- end dialog -->
	
	<!-- add color and img buttons -->
	<div id="dlg-buttons">
		<a onClick="saveImage();" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"  style="width: 90px">上传</a> 
		<a onClick="javascript:$('#dlg').dialog('close');" href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px">取消</a>
	</div>
	
</body>
</html>