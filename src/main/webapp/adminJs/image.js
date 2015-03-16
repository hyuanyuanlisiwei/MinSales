// 0,初始化controller路径；
var url = "./../AdminImageController/"
var queryUrl = "";
var queryGoodsColorImgUrl= "";
var	queryGoodsNotColorImgUrl="";
var deleteGoodsColorImgUrl= "";
var insertGoodsColorImgUrl= "";

// get all category;
var queryAllCategoryUrl = "";
// get all goods by category id;
var queryAllGoodsByCategoryIdUrl= "";

// 当提交表单的时候,使用的url;
var submitUrl = "";

$(function() {

	// 1,增删该查路径；
	queryUrl=url+"query.do";
	queryGoodsColorImgUrl=url+"queryGoodsColorImg.do";
	queryGoodsNotColorImgUrl=url+"queryGoodsNotColorImg.do";
	deleteGoodsColorImgUrl=url+"deleteGoodsColorImg.do";
	insertGoodsColorImgUrl=url+"insertGoodsColorImg.do";
	

	queryAllCategoryUrl = url + "queryAllCategory.do";
	queryAllGoodsByCategoryIdUrl = url + "queryAllGoodsByCategoryId.do";

	// 4,goods;
	$("#goods").combobox({
		width : 150,
		valueField : 'id',
		textField : 'title'
	});

	// 2,初始化categery和goods的事件;
	$("#category").combobox(
			{
				width : 150,
				url : queryAllCategoryUrl,
				valueField : 'id',
				textField : 'name',
				// 当选择一个分类时,就加载相应的goods;
				onSelect : function(data) {
					$("#goods").combobox(
							'reload',
							queryAllGoodsByCategoryIdUrl+ "?categoryId="
									+ $("#category").combobox('getValue'));
				}
			});

	// 3,init datagrid;
	initDg();

	// 4,模糊搜索按钮绑定事件;
	$("#search").bind("click", function() {
		// query param
		var goodsId = $("#goods").combobox('getValue');
		queryParam = {
			"goodsId" : goodsId,
		};
		// set datagrid params;
		$("#dg").datagrid("load", queryParam);
	});
});
// ends init;
function initDg() {
	$('#dg')
			.datagrid(
					{
						// 初始化页面大小;
						pageSize : 3,
						// 页面大小的list;
						pageList : [ 1, 3, 5, 7, 9 ],
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
						// 列名,
						// 列名;
						columns : [ [
								{
									field : 'goodsId',
									title : '商品Id',
									width : 200,
									align : 'center',
								},
								{
									field : 'goodsName',
									title : '商品标题',
									width : 200,
									aligh : 'center'
								},
								{
									field : 'viewColor',
									title : '查看已有颜色',
									formatter : function(value, row, index) {
										var e = '<a href="javascript:void(0);" onclick="viewColor(this)">已有颜色</a> ';
										return e;
									}
								},
								{
									field : 'uploadImg',
									title : '上传图片',
									formatter : function(value, row, index) {
										var e = '<a href="javascript:void(0);" onclick="uploadImg(this)">上传图片</a> ';
										return e;
									}
								}] ],
					});
}
//删除颜色，上传图片都需要goodsId;
var goodsId='';

//upload img;
function uploadImg(target) {
	// 获得id;
	$('#dg').datagrid('unselectAll');
	$('#dg').datagrid('selectRow', getRowIndex(target));
	goodsId= $('#dg').datagrid('getSelected').goodsId;
	//打开uploadDlg
	$('#uploadDlg').dialog('open').dialog('setTitle','上传图片');
	//给id=color添加 该商品没有的颜色;
	$("#color").combobox({
		valueField:'colorId',
		textField:'colorName',
		url:queryGoodsNotColorImgUrl+"?goodsId="+goodsId,
	});
	//在form表单中，存储goodsId;
	$("input[name='goodsId']").val(goodsId);
}

//view color;
function viewColor(target)
{
	// 获得id;
	$('#dg').datagrid('unselectAll');
	$('#dg').datagrid('selectRow', getRowIndex(target));
	goodsId= $('#dg').datagrid('getSelected').goodsId;
	//打开viewDlg;
	$("#viewDlg").dialog('open').dialog('setTitle','已有颜色');
	
	//给viewDg加载数据;
	$('#viewDg').datagrid({
		url:queryGoodsColorImgUrl,
		//查询参数;
		queryParams:{'goodsId':goodsId},
		columns:[[ 
		{field:'colorId',title:'颜色ID',width:60}, 
		{field:'colorName',title:'颜色名字',width:60}, 
		{field:'deleteColor',title:'操作',width:60,
			formatter : function(value, row, index) {
				var e = '<a href="javascript:void(0);" onclick="deleteColor(this)">删除</a> ';
				return e;
			}
		} 
		]] 
	});
}

//delete color;
function deleteColor(target)
{
	//得到colorId;
	$('#viewDg').datagrid('unselectAll');
	$('#viewDg').datagrid('selectRow', getRowIndex(target));
	var colorId= $('#viewDg').datagrid('getSelected').colorId;
	//得到参数;
	var param={'goodsId':goodsId,'colorId':colorId};
	//发送post请求,删除该图片的颜色和图片;
	$.post(deleteGoodsColorImgUrl,param,function(data){
		
		show(data.msg)
		if(data.code==200)//删除成功,
		{
			//重新加载已有数据;
			$("#viewDg").datagrid('reload',{'goodsId':goodsId});
		}
		
	},'json');
}





//tools:get upload row index;
function getRowIndex(target) {
	var return_tr;
	if (target == "javascript:void(0);") {
		var tr = $(target).closest('tr.datagrid-row');
		return_tr = parseInt(tr.attr('datagrid-row-index'));
	} else {
		return_tr = $('#dg').datagrid("getRowIndex", target);
	}
	return return_tr;
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
