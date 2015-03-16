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

<!-- 自定义css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/adminCss/index.css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/adminCss/layout.css">	
 <script type="text/javascript" src="${pageContext.request.contextPath}/adminJs/index.js"></script>	




<title>网上家电销售管理系统</title>
</head>
<body class="easyui-layout">

		<!-- 北部区域 -->
	 <div  data-options="region:'north'" style="overflow: hidden;height:40px;background: url(${pageContext.request.contextPath }/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
			
			<!-- north content -->
			<div class="north_content">
			    <span style="float:right;padding-right:20px;">
			    	<font color="red" style="font-weight:bold">欢迎:${sessionScope.admin}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	
			    	<a id="upadePwd" href="javascript:void(0);">
			    		<font color="red" style="font-weight:bold">修改密码</font>&nbsp;&nbsp;&nbsp;&nbsp;
			    	</a>
			    	
			    	<a id="exit" href="javascript:void(0);">
			    		<font color="red" style="font-weight:bold">安全退出</font>&nbsp;&nbsp;&nbsp;&nbsp;
			    	</a>
			    </span>
			</div>
		    <!-- end north content -->
		    <span style="padding-left:10px;font-size:16px;">
		       <img src="${pageContext.request.contextPath}/images/blocks.gif" width="20px"/>
		       	网上家电销售管理系统
		    </span>
		     
		</div>
		<!-- end 北部区域 -->
		
		<!-- east -->
		<div data-options="region:'west',split:true" title="管理列表" style="width:200px;">
		
			<div id="accord" class="easyui-accordion" style="width:200px;height:95%;fit:true">	
			    <!-- 第一个accordion -->
    			<div class="content" title="基本信息管理" iconCls="icon-ok" selected="true" style="overflow:auto;padding:10px;">
                    <!-- 发货方式管理 -->
                    <a href="${pageContext.request.contextPath}/AdminPrimaryController/delivery.do">
                    	发货方式管理
                    </a><br/></br>
                    <!-- 省份管理 -->
                     <a href="${pageContext.request.contextPath}/AdminPrimaryController/province.do">
                    	省份管理
                    </a><br/><br/>
                     <!-- 市区管理 -->
                     <a href="${pageContext.request.contextPath}/AdminPrimaryController/city.do">
                    	市区管理
                    </a><br/><br/>
                     <!-- 县级管理 -->
                     <a href="${pageContext.request.contextPath}/AdminPrimaryController/county.do">
                    	县级管理
                    </a><br/><br/>
                    <!-- 颜色管理 -->
                     <a href="${pageContext.request.contextPath}/AdminPrimaryController/color.do">
                    	 颜色管理 
                    </a><br/><br/>
                     <!-- 评价等级管理 -->
                     <a href="${pageContext.request.contextPath}/AdminPrimaryController/evaluateLevel.do">
                    	 评价等级管理 
                    </a><br/><br/>
                     <!-- 今日公告管理 -->
                     <a href="${pageContext.request.contextPath}/AdminPrimaryController/notice.do">
                    	 今日公告管理 
                    </a><br/><br/>
                </div>
                    
                <!-- 第二个 accordion -->
                <div  class="content" title="商品管理" iconCls="icon-reload" style="padding:10px;">
                    <!-- 商品分类管理 -->
                    <a href="${pageContext.request.contextPath}/AdminPrimaryController/category.do">
                    	 商品分类管理
                    </a><br/><br/>
                    <!-- 商品管理 -->
                    <a href="${pageContext.request.contextPath}/AdminPrimaryController/goods.do">
                    	 商品管理
                    </a><br/><br/>
                    <!-- 商品图片管理 -->
                    <a href="${pageContext.request.contextPath}/AdminPrimaryController/image.do">
                    	 商品图片管理
                    </a><br/><br/>
                    
                </div>
            </div>
		</div>
		<!-- end east -->
		
		<!-- center -->
		<div data-options="region:'center',title:'主页',iconCls:'icon-ok'">
			<div id="tabs" class="easyui-tabs" data-options="fit:true">
			<div title="首页" data-options="fit:true">
				<div style="background-color: #FAFAFA">
					<img src="${pageContext.request.contextPath }/images/welcome.png" />
				</div>
			</div>
		</div>
		</div>

</body>
</html>