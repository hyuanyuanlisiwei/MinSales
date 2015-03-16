$(function(){
	
	//给左侧的超链接增加tab功能;
	$("#accord div a").bind('click', function() {
		
		var tab_title = $(this).text();
		var url = this.href;
		
		if($("#tabs").tabs('exists',tab_title))
	    {
			$("#tabs").tabs('select',tab_title);
	    }else
	    {
	    	$("#tabs").tabs('add',{
	    		title:tab_title,
	    		selected:true,
	    		content:createIframe(url),
	    		closable:true
	    		
	    	});
	    }
		return false;
	});		
});

//创建iframe;
function createIframe(url)
{
	return "<iframe scrolling='auto' frameborder='0'  src='" + url
	+ "' style='width:100%;height:100%;'></iframe>";
}











