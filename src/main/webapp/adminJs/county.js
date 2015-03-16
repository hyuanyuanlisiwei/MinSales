// 0,初始化controller路径；
//need change;
var url = "./../AdminCountyController/"
var queryUrl = "";
var saveUrl = "";
var deleteUrl ="";
var updateUrl ="";
//add url;
var provinceUrl=url+"queryAllProvince.do";
var cityUrl=url+"queryAllCityByProvince.do";


$(function() {

	queryUrl = url + "query.do";
	addUrl = url + "add.do";
	deleteUrl = url + "delete.do";
	updateUrl = url + "update.do";
	
	//初始化 所有province;
	$("#province").combobox({
			width:150,
			valueField:'id',		
			textField:'name',
			url:provinceUrl,
			//当用户选择省份时,加载该省份的数据到市区combobox;
			onSelect:function(data)
			{
				$("#city").combobox("reload",cityUrl+"?id="+$("#province").combobox('getValue'));
			}
	});
	//1,初始化dg;
	initDg();
	
	// 4,模糊搜索按钮绑定事件;
	$("#search").bind("click", function() {
		// query param
		var name = $("#name").val();
		var parentId=$("#province").combobox('getValue');
		var cityId=$("#city").combobox('getValue');
		queryParam={"name":name,"parentId":parentId,'cityId':cityId};
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
		pageList : [1,3, 5, 7, 9 ],
		// 显示行号
		rownumbers : true,
		// 单选;
		singleSelect : true,
		// 显示pagination;
		pagination : true,
		// 表格宽度；
		width : '85%',
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
			field : 'provinceName',
			title : '省份名字',
			width : 200,
			align : 'center'
		},{
			field : 'cityName',
			title : '市区名字',
			width : 200,
			align : 'center'
		},{
			field : 'name',
			title : '县级名字',
			width : 200,
			align : 'center'
		} 
		] ]
	});
	//设置id隐藏列;
    $("#dg").datagrid("hideColumn","id");
	
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
	
	//confirm has the province and city;
	var provinceId=$("#province").combobox("getValue");
	var cityId=$("#city").combobox("getValue");

	if(provinceId==null || provinceId==0)
	{
		show("请选择省份!",100);
		
	}else if(cityId==null || cityId==0)
	{
		show("请选择市区!",100);
		
	}else
	{
		//1)show messager: add name;h
		$.messager.prompt('添加县级', 
				'在省份:'+$("#province").combobox('getText') +',市区:'+$("#city").combobox('getText')+"中添加县级:", 
				function(name){if (name){ 
				//后台添加;
				var param={"cityId":cityId,'name':name}
				$.post(addUrl,param,function(data){
					
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
}

// edit
function update() {
	
	//1)get the selected row;
	var row=$("#dg").datagrid("getSelected");
	//2)update row;
	if(row!=null)
	{
		$.messager.prompt("修改市区",'您要将市区  '+row.name+" 改为:",function(name){
			
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