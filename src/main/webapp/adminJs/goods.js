// 0,初始化controller路径；
var url = "./../AdminGoodsController/"
var queryUrl = "";
var saveUrl = "";
var deleteUrl ="";
var updateUrl ="";
//get all category;
var queryAllCategoryUrl="";
//当提交表单的时候,使用的url;
var submitUrl="";

$(function(){
	
	//1,增删该查路径；
	queryUrl = url + "query.do";
	saveUrl = url + "add.do";
	deleteUrl = url + "delete.do";
	updateUrl = url + "update.do";
	
	queryAllCategoryUrl=url+"queryAllCategory.do";
	
	//2,初始化categery;
	$("#category").combobox({
		 url:queryAllCategoryUrl,
		 valueField:'id',
		 textField:'name'
	});
	
	//2.1添加修改的对话框也需要加载数据;
	$("#dlgCategory").combobox({
		 url:queryAllCategoryUrl,
		 valueField:'id',
		 textField:'name'
	});
	
	//3,init datagrid;
	initDg();
	
	// 4,模糊搜索按钮绑定事件;
	$("#search").bind("click", function() {
		// query param
		var title = $("#name").val();
		var categoryId=$("#category").combobox('getValue');
		//解决后台报错categoryId为空字符串的问题;
		if(categoryId==0)
		{
			categoryId=0;
		}
		queryParam={"title":title,"categoryId":categoryId};
		//set datagrid params;
		$("#dg").datagrid("load",queryParam);
	});
});
//ends init;
function initDg()
{
	$('#dg').datagrid({
		// 初始化页面大小;
		pageSize : 3,
		// 页面大小的list;
		pageList : [ 1,3, 5, 7, 9 ],
		// 显示行号
		rownumbers : true,
		// 单选;
		singleSelect : true,
		// 显示pagination;
		pagination : true,
		// 高度自适应；
		fit : "auto",
		// 数据来源,total,rows;
		url : queryUrl,
		// 列名;
		columns : [ [ {
			field : 'id',
			title : 'Id',
			width : 100,
			align : 'center'
		}, {
			field : 'categoryName',
			title : '商品分类',
			width : 200,
			align : 'center'
		}, {
			field:'title',
			title:'商品标题',
			width:200,
			aligh:'center'
		},
		{
			field:'price',
			title:'商品单价',
			width:200,
			aligh:'center'
		},{
			field:'stock',
			title:'商品库存',
			width:200,
			aligh:'center'
		},{
			field:'description',
			title:'商品详情',
			width:200,
			aligh:'center'
		},{
			field:'categoryId',
			title:'商品分类Id',
		}
		] ],
		//工具栏;
		toolbar: [{
			iconCls: 'icon-edit',
			text:'编辑商品',
			handler: function(){  
				update();
				
			}
		},'-',{
			iconCls: 'icon-add',
			text:'添加商品',
			handler: function(){
				add();
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除商品',
			handler: function(){
				
				remove();
			}
		}]
	});
	
	//隐藏分类列：
	$("#dg").datagrid('hideColumn','categoryId');
	
}


function remove() {
	
	var row=$("#dg").datagrid('getSelected');
	if(row)
	{
		$.post(deleteUrl,{'id':row.id},function(data){
			
			show(data.msg);
			if(data.code==200)
			{
				//重新加载数据;
				$("#dg").datagrid('reload');
			}
			
		},'json');
		
	}else
	{
		show("请选择要删除的一行数据!");
		
	}
}

// update
function update() {
	var row = $("#dg").datagrid("getSelected");
	if (row) {
		// 反显数据;
		var categoryId=row.categoryId;
		var title=row.title;
		var price=row.price;
		var stock=row.stock;
		var description=row.description;
		$("#dlg").dialog("open");
		$("#dlgCategory").combobox('setValue',categoryId);
		$("#title").textbox('setValue',title);
		$("#price").numberbox('setValue',price);
		$("#stock").numberbox('setValue',stock);
		$("#description").textbox('setValue',description);
		
		
		
		//alert(categoryId+","+title+","+price+","+stock+","+description);
		$('#dlg').dialog('open');
		
		
		
	}else
	{
		show('请选择要编辑的数据!');
	}
	submitUrl = updateUrl+"?id="+row.id;
}

// add
function add() {
	
	//打开dialog
	$("#dlg").dialog("open");
	//清除form
	$("#fm").form('clear');
	//设置dlgCategory的默认值;
	var value=$("#category").combobox('getValue');
	$("#dlgCategory").combobox('setValue',value);
	//之后就是输入商品的内容了;
	submitUrl=saveUrl;
}

// saveGoods;
function saveGoods() {

	//prepare param
	var categoryId=$("#dlgCategory").combobox('getValue');
	var title=$("#title").val();
	var price=$("#price").val();
	var stock=$("#stock").val();
	var description=$("#description").val();
	
	//check the param is required;
	if(categoryId=='')
	{
		show('请选择一个分类');
	}else if(title=="")
	{
		show('标题不能为空!');
		$("#title").focus();
	}else if(price=='')
	{
		show('单价不能为空!');
		$("#price").focus();
	}else if(stock=='')
	{
		show('库存不能为空!');
		$("#stock").focus();
	}else
	{
		//提交表单数据;
		var param={'categoryId':categoryId,'title':title,'price':price,'stock':stock,'description':description};
		$.post(submitUrl,param,function(data){
			
			show(data.msg);
			if(data.code==200)
			{
				//重新加载数据;
				$("#dg").datagrid('reload');
			}
			
		},"json");
		//关闭dialog;
		$("#dlg").dialog('close');
	}
}


// show tip message
function show(message) {
	$.messager.show({
		title : '执行结果',
		msg : message,
		showType : 'show',
		timeout : 300,
		style : {
			right : '',
			top : document.body.scrollTop + document.documentElement.scrollTop,
			bottom : ''
		}
	});

}




