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
function getNavLists(codeModule, id) {
	commonAjax(basePath + "getArticleList", {codeModule: codeModule}, "POST", function(result){
		if(result.isOK === "true"){
			var res = result.jsonData,
				len = res.length,
				totalStr = "";
//			console.log(res)
			for(var i = 0; i < len; i++){
				totalStr += '<li class="item"><a href="arcContent?aid='+ res[i].id +'" title="'+ res[i].title +'">'+ res[i].title +'</a></li>'
			}
			$(id).append(totalStr);
		}else {
			$(id).append("");
		}
	})
}

getNavLists(1000,"#brand-lists");
getNavLists(1002,"#activity-lists")
getNavLists(1003,"#service-lists")
getNavLists(1001,"#product-lists")

