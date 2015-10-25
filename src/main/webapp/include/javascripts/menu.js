//menu
$(document).ready(function(){
	$("li.mainlevel").hover(
		function () {
		$(this).find('ul').show();
	},
		function () {
		$(this).find('ul').hide();
		}
	); 
	$(".subnav").hover(
		function(){
		$(this).find('ul').show();	
		},
		function(){
		$(this).find('ul').hide();
		}
	);
});


function resizePic(obj1,maxWidth,maxHeight,setMargin){
	var obj=new Image();
	obj.onload=function(){
		var rate=parseFloat(obj.height)/parseFloat(obj.width);
		var width=parseInt(obj.width);
		var height=rate*width;
		var count=0;
		while((width>maxWidth)&&count<10000){
            //||height>maxHeight
			count++;
			width*=0.99;
			height=rate*width;
		}	
		obj1.width=width;obj1.height=height;
		
		var marginTop=Math.ceil((maxHeight-obj1.height)/2);
		//alert(marginTop);
		if(marginTop<=0)
			marginTop=1;
		if(typeof(setMargin)=="undefined")setMargin=true;
		if(setMargin==true)
			obj1.style.marginTop=marginTop+"px";
	}
	obj.src=obj1.src;
}
/**
 * 共用的ajax
 */
function commonAjax(url, data, type, succFunc) {
    return $.ajax({
        url: url || "",
        data: data || {},
        type: type || "GET",
        success: succFunc || function(res) {
            console.log("url= " + url + " succ方法传入错误")
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            console.log(XMLHttpRequest.status);
            console.log(XMLHttpRequest.readyState);
            console.log(textStatus);
        }
    });
}

/**
 * 活动列表是个单独页面
 */
function getActivityLists() {
	
}


/**
 * 拼接导航文章下拉列表
 * @param codeModule
 * @param id
 */
function getNavLists(codeModule, id) {
	commonAjax(basePath + "getArticleList", {codeModule: codeModule}, "POST", function(result){
		if(result.isOK === "true"){
			var res = result.jsonData,
				len = res.length,
				totalStr = "";
			var code = parseInt(codeModule, 10);
			for(var i = 0; i < len; i++){
				if(code == 1001) {
					totalStr += '<li class="item"><a href="arcContent?aid='+ res[i].id +'&cat='+ res[i].codeModule +'" title="'+ res[i].title +'">'+ res[i].title +'</a></li>'
				} else if(code == 1002) {
					totalStr += '<li><a href="arcContent?aid='+ res[i].id +'" title="'+ res[i].title +'">'+ res[i].title +'</a></li>';
				} else {
					totalStr += '<li class="item"><a href="arcContent?aid='+ res[i].id +'" title="'+ res[i].title +'">'+ res[i].title +'</a></li>'
				}
				
				
			}
			$(id).append(totalStr);
		}else {
			$(id).append("");
		}
	})
}

getNavLists(1000,"#brand-lists");
getNavLists(1002,"#activityLists")
getNavLists(1003,"#service-lists")
getNavLists(1001,"#product-lists")

