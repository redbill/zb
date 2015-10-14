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