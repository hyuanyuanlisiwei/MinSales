var url="./ClientIndexController/";
var queryNoticeUrl="";
var queryCategoryUrl="";
var queryAllGoodsUrl=url+"queryAllGoods.do";
//进入详情页面的url;
var enterIntoDetailUrl=url+"detail.do";

$(function(){
	
	//初始化goodsDg
	initGoodsDg();
	
	//公告noticeDg
	queryNoticeUrl=url+"queryAllNotice.do";
	$("#noticeDg").datagrid({
		width:550,
		fit:true,
		striped:false,
		loadMsg:'加载公告',
		columns:[[
		    {field:'id',hidden:true},
		    {field:'noticeName',title:'',width:548,align:'center'}
		]],
		url:queryNoticeUrl
	});
	
	
	//商品分类categoryDg;
	queryCategoryUrl=url+"queryAllCategory.do";
	$("#categoryDg").datagrid({
		width:300,
		fit:true,
		striped:false,
		loadMsg:'加载分类',
		columns:[[
		    {field:'categoryId',hidden:true},
		    {field:'categoryName',title:'所有分类',width:300,align:'center'}
		]],
		url:queryCategoryUrl,
		//点击商品分类时,执行搜索;
		onClickRow:function(rowIndex,rowData)
		{
			//将searchbox:分类,反显数据;
			$("#search").searchbox('selectName',1);
			$("#search").searchbox('setValue',rowData.categoryName);
			//查询数据,即 重新加载数据到goodsDg;
			//按照categoryId查询;
			$("#goodsDg").datagrid("load",{"queryType":'categoryId','categoryId':rowData.categoryId});
		}
	});
	
	
	
	
	//获得搜索框中的内容,查询显示图片：
	$('#search').searchbox({
	    searcher:function(value,name){
	       
	    	//按分类
	    	if(name==1)
	    	{
	    		//从所有分类中查询出所有的商品展示出来;
	    		//商品展示的table:goodsDg;
	    		//按categoryName查询;
	    		$("#goodsDg").datagrid('load',{'queryType':'categoryName','categoryName':value});
	    		
	    	}else if(name==0)//按商品
	    	{
	    		//按商品名称查询;
	    		$("#goodsDg").datagrid('load',{'queryType':'title','title':value});
	    	}
	    }
	});
});
//初始化商品展示的goodsDg;
function initGoodsDg()
{
	// 1,设置表格的属性;
	$('#goodsDg').datagrid({
		width:1130,
		height:484,
		// 初始化页面大小;
		pageSize : 3,
		// 页面大小的list;
		pageList : [ 1,3, 5, 7, 9 ],
		// 单选;
		singleSelect : true,
		// 显示pagination;
		pagination : true,
		// 数据来源,total,rows;
		url : queryAllGoodsUrl,
		//请求参数：
		queryParams:{'title':''},
		// 列名;
		columns : [ [ {
			field : 'goodsId',
			title : 'Id',
			hidden:true
		}, {
			field : 'addressSmall',
			title : '图片地址',
			align : 'center',
			width:100,
			height:100,
			formatter:function(value,row,index)
			{
				if(value)
				{
					return '<img src="upload/'+row.addressSmall+'"/>';
				}
				return value;
				
			}
		}, {
			
			field : 'title',
			title : '商品名称',
			align : 'center',
			width:200
		},
		{
			field : 'price',
			title : '单价',
			align : 'center',
			width:150
		}, {
			field : 'stock',
			title : '库存',
			align : 'center',
			width:150
		}, {
			field : 'description',
			title : '详情',
			align : 'center',
			width:400
		}, {
			field : 'scores',
			title : '好评分',
			align : 'center',
		    width:110
		}
		] ],
		//每次一点击商品所在的行,就进入商品的详情页面;
		onClick:function(rowIndex,rowData)
		{
			//带着goodsId,进入详情页面;
			var goodsId=rowData.goodsId;
			var param={'goodsId':goodsId};
			
			$.post(enterIntoDetailUrl,param);
		}
	});
}











