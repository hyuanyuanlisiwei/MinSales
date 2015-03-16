// 0,初始化controller路径；
var url = "./../AdminDeliveryController/"
var queryUrl = "";
var saveUrl = "";
var deleteUrl ="";
var updateUrl ="";

$(function() {

	queryUrl = url + "query.do";
	addUrl = url + "add.do";
	deleteUrl = url + "delete.do";
	updateUrl = url + "update.do";
	
	//1,初始化dg;
	initDg();
	
	// 4,模糊搜索按钮绑定事件;
	$("#search").bind("click", function() {
		// query param
		var name = $("#name").val();
		var queryParam={"name":name};
		//set datagrid params;
		$("#dg").datagrid("load",queryParam);
	});
})
// end init

//init datagrid
function initDg()
{
	// 1,设置表格的属性;
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
		// 表格宽度；
		width : '70%',
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
			field : 'name',
			title : '发货方式名字',
			width : 200,
			align : 'center'
		}, ] ]
	});
	// 2,get the pager of the datagrid;
	var pager = $('#dg').datagrid().datagrid('getPager');
	// 3,set the handler of the event;
	pager.pagination({
		buttons : [ {
			iconCls : 'icon-remove',
			handler : function() {
				// delete the selected row;
				remove();
			}
		}, {
			iconCls : 'icon-add',
			handler : function() {
				// add a new province row;
				add();
			}
		}, {
			iconCls : 'icon-edit',
			handler : function() {
				// update a new row;
				update();
			}
		} ]
	});
}



// following is the custome function;
// remvoe
function remove() {
	// 1)得到选择的行;
	var row = $("#dg").datagrid("getSelected");
	if (row == null)// 没有selected
	{
		show("请选择一行数据!", 0);

	} else {
		var id = row.id;
		$.messager.confirm("确认", "您确认要删除吗 ?",
				function(r) {

					if (r)// 选择确认;
					{
						// 后台删除;
						$.post(deleteUrl, {
							"id" : id
						}, function(data) {

							// show result;
							show(data.msg, 100);
							//是否reload datagrid;
							if(data.code==200)
							{
								$("#dg").datagrid("reload");
							}
						}, "json");
					}
				});
	}
}

// add
function add() {
	
	//1)show messager: add name;h
	$.messager.prompt('添加发货方式', '请输入发货方式名字:', 
			function(name){if (name){ 
				
			//后台添加;
			$.post(addUrl,{'name':name},function(data){
				
				//show submit;
				show(data.msg,100);
				if(data.code==200)
				{
					//success-->reload datagrid
					$("#dg").datagrid('reload');
				}
			});
	}});  
}

// edit
function update() {
	
	//1)get the selected row;
	var row=$("#dg").datagrid("getSelected");
	//2)update row;
	if(row!=null)
	{
		$.messager.prompt("修改发货方式",'您要将  '+row.name+" 改为:",function(name){
			
			var param={"id":row.id,"name":name};
			//后台修改数据;
			$.post(updateUrl,param,function(data){
				
					show(data.msg,100);
					if(data.code==200)
				    {
						$("#dg").datagrid('reload');
				    }
			});
		});
	}else
	{
		show("请选择要修改的数据");
	}
}

// 操作提示;
function show(message, time) {
	$.messager.show({
		title : '提示',
		msg : message,
		timeout : time,
		showType : 'slide',
		style : {
			right : $(window).width() / 2,
			top : $(window).height() / 2,
			bottom : ''
		}
	});
}

















