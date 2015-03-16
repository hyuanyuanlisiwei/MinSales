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

<!-- 自定义css js -->
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/clientCss/index.css"> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/clientJs/index.js"></script>

<title>网上家电销售管理系统</title>

<style>
        .footer {
            width: 100%;
            text-align: center;
            line-height: 35px;
        }
 
 
    </style>
</head>
<body class="easyui-layout">
    <!-- 南部区域 -->
    <div region="south" border="false" split="false" style="overflow:hidden;height: 40px;">
        <div class="footer">版权所有:HYY工作室</a></div>
    </div>
    
    <!--西部区域 -->
    <div region="west" split="false" style="width:300px;">
		<!--1 商品搜索和个人信息的页面 -->
		<div id="cc" class="easyui-layout" data-options="fit:true" style="height:665px">
			<!--中部 搜索商品 -->
			<div data-options="region:'center',title:'商品分类',split:false" style="height:365px;overflow:hidden;">
				
				<input id="search" class="easyui-searchbox" data-options="prompt:'输入内容',menu:'#mm'" style="width: 300px; height: 35px;">
				 <table id="categoryDg"></table>
			</div>
			<!-- 南边个人信息, -->
			<div data-options="region:'south',split:true,title:'我的资料'" style="height:300px;overflow:hidden;background: blue">
					<!-- 这里添加个人信息 -->
			</div>
		</div>
		<!-- end 1 -->
	</div>
    <!-- 中部区域 -->
    <div class="content_right" region="center" style="overflow:hidden;background:green">
		<div class="easyui-layout" data-options="fit:true">
			<!-- 广告展示 -->
			<div data-options="region:'north',split:false" style="width:1138px;height:181px;background:black">
				<!-- 广告 -->
				<div class="easyui-layout" data-options="fit:true" style="overflow:hidden;">
					<div id="ad" data-options="region:'west',title:'广告展示'" style="width:586px;overflow:hidden;background:yellow">
						<img src="${pageContext.request.contextPath}/clientImages/ads/1.gif">
					</div>
					<div data-options="region:'center',title:'今日公告'" style="width:552px;background:green;overflow-x:hidden">
						<!-- 加载今日公告 -->
						<table id="noticeDg"></table>
					</div>
				
				</div>
			
			</div>
			<!-- 商品展示 -->
			<div data-options="region:'center',split:false,title:'商品展示'" style="width:1138px;height:484px">
				<!-- 商品展示的table -->
				<table id="goodsDg"></table>	
			</div>
		</div>
	</div>
    
    <div id="mm" style="width:120px">
    	<div data-options="name:'0',iconCls:'icon-ok'">商品</div>
    	<div data-options="name:'1',iconCls:'icon-ok'">分类</div>
	</div>
    
</body>
</html>