function GetNowDateByMonth()  // 今天
		 {  
			  var myDate,myDateStr;  
			  myDate = new Date();
			  var yyyy = myDate.getFullYear();// 取四位年份
			  var MM= myDate.getMonth()+1;// 取月份
			  if(MM<10)
			  {
			  	MM="0"+MM;
			  }  
			  myDateStr=yyyy+"-"+MM;
			  return myDateStr;  
		 }
function GetNowDateTimeByMonth()  // 今天
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  var dd=myDate.getDate();
	  var hh=myDate.getHours();
	  var mm=myDate.getMinutes();
	  var ss=myDate.getSeconds();
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  if(dd<10)
	  {
		  dd="0"+dd;
	  }
	  if(hh<10)
	  {
		  hh="0"+hh; 
	  }
	  if(mm<10)
	  {
		  mm="0"+mm; 
	  }
	  if(ss<10)
	  {
		  ss="0"+ss; 
	  }
	  myDateStr=yyyy+"-"+MM+"-"+dd+" "+hh+":"+mm+":"+ss;
	  return myDateStr;  
}

function NowDateTimeStr()  // 今天
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  var dd=myDate.getDate();
	  var hh=myDate.getHours();
	  var mm=myDate.getMinutes();
	  var ss=myDate.getSeconds();
	  if(hh<10)
	  {
		  hh="0"+hh; 
	  }
	  if(mm<10)
	  {
		  mm="0"+mm; 
	  }
	  if(ss<10)
	  {
		  ss="0"+ss; 
	  }
	  myDateStr=hh+":"+mm+":"+ss;
	  return myDateStr;  
}


function NowDateTimeForStr()  //异常瀑布图传值
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  var dd=myDate.getDate();
	  var hh=myDate.getHours();
	  var mm=myDate.getMinutes();
	  var ss=myDate.getSeconds();
	  if(MM<10)
	  {
		  MM="0"+MM; 
	  }
	  if(hh<10)
	  {
		  hh="0"+hh; 
	  }
	  if(mm<10)
	  {
		  mm="0"+mm; 
	  }
	  if(ss<10)
	  {
		  ss="0"+ss; 
	  }
	  myDateStr=yyyy+""+MM+""+dd+""+hh+""+mm+""+ss;
	  return myDateStr;  
}

function CurentTime()
{ 
    var now = new Date();
   
    var year = now.getFullYear();       // 年
    var month = now.getMonth() + 1;     // 月
    
    var clock = year + "";
    if(month < 10)
        clock += "0";
    clock += month + "";
    return(clock); 
} 
function GetNowDate()  // 今天
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  var dd= myDate.getDate();// 取日
	  if(dd<10)
	  {
	  	dd="0"+dd;
	  } 
	  myDateStr=yyyy+"-"+MM+"-"+dd;
	  return myDateStr;  
} 
function GetNowDateWithNoSlash()  // 今天
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  var dd= myDate.getDate();// 取日
	  if(dd<10)
	  {
	  	dd="0"+dd;
	  } 
	  myDateStr=yyyy+MM+dd;
	  return myDateStr;  
} 

// 昨天
function GetYesterday(){    
	 var date=new Date();
	 var yesterday_milliseconds=date.getTime()-1000*60*60*24;     
	 var yesterday = new Date();     
	     yesterday.setTime(yesterday_milliseconds);     
	   
	 var strYear = yesterday.getFullYear();  
	 var strDay = yesterday.getDate();  
	 var strMonth = yesterday.getMonth()+1;
	 if(strMonth<10)  
	 {  
	  strMonth="0"+strMonth;  
	 }  
	 if(strDay<10)  
	 {  
		 strDay="0"+strDay;  
	 }  
	 datastr = strYear+"-"+strMonth+"-"+strDay;
	 return datastr;
	  }



function GetLastYearMonth(){ //取当前月份前12个月
	var count=0;
	var months=new String();
	var myDate = new Date();
	 var yyyy = myDate.getFullYear();// 取四位年份
	 var MM= myDate.getMonth();// 取月份
	// var yyyy =2014;//取四位年份
	// var MM= 5;//取月份
	 var mm=MM;
	  for(var i=0;i<mm;i++){
		var h;
		if(MM<10){
			 h="0"+MM;  
		  }else{
			  h=MM;
		  }
		  MM--;
		  months+=yyyy+""+h+",";
		  count++;
	  }
	  var result=12-count;
      var num=12;
      var nn=yyyy-1;
	  for(var i=0;i<result;i++){
		  var h
		  if(num<10){
			  h ="0"+num;  
			  }else{
				  h=num;
			  }
		  num--;
		  months+=nn+""+h+",";
	  }
	  months= months.substring(0, months.length-1);
	  return months;
	
}

function GetYearMonth(){//取当前年份的月份

	var months=new String();
	var myDate = new Date();
    var yyyy = myDate.getFullYear();// 取四位年份
	 
	 for(var i=1;i<13;i++){
		 var month;
		 if(i<10){
			      month ="0"+i;  
			  }else{
				  month=i;
			  }
		 months+=yyyy+""+month+","; 
	 }
	  months= months.substring(0, months.length-1);
	  return months;
}


function GetYearMonthArray(){//取当前年份的月份中间带-
	
	var months=new Array();
	var myDate = new Date();
    var yyyy = myDate.getFullYear();// 取四位年份
	 
	 for(var i=1;i<13;i++){
		 var month;
		 if(i<10){
			      month ="0"+i;  
			  }else{
				  month=i;
			  }
		  months[i-1]=yyyy+"-"+month; 
	 }
	  return months;
}



function GetLastYearMonthArray(){
	var count=0;
	var months=new Array();
	var myDate = new Date();
	 var yyyy = myDate.getFullYear();// 取四位年份
	 var MM= myDate.getMonth();// 取月份
	// var yyyy =2014;//取四位年份
	// var MM= 5;//取月份
	 var opop=0;
	 var mm=MM;
	  for(var i=0;i<mm;i++){
		var h;
		if(MM<10){
			 h="0"+MM;  
		  }else{
			  h=MM;
		  }
		  MM--;
		  months[opop]=yyyy+"-"+h;
		  opop++;
		  count++;
	  }
	  var result=12-count;
      var num=12;
      var nn=yyyy-1;
	  for(var i=0;i<result;i++){
		  var h;
		  if(num<10){
			  h ="0"+num;  
			}else{
				  h=num;
			  }
		  months[opop]=nn+"-"+h;
		  num--;
		  opop++;
	  }
	  return months;
	
}

function GetBDateByLastMonth()  // 上个月份
{
    var myDate,myDateStr;
    myDate = new Date();
    var yyyy = myDate.getFullYear();// 取四位年份
    var MM= myDate.getMonth();// 取月份
    if(MM==0){
        yyyy=yyyy-1;
        MM=12;
    }else{
        if(MM<10)
        {
            MM="0"+MM;
        }
    }
    myDateStr=yyyy+"-"+MM;//MM;
    return myDateStr;
}
//获取任务立即启动的时间
function GetTaskStartTime()  // 今天
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  var dd=myDate.getDate();
	  var hh=myDate.getHours();
	  var mm=myDate.getMinutes();
	  var ss=myDate.getSeconds();
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  if(dd<10)
	  {
		  dd="0"+dd;
	  }
	
		  
		  if(mm>0)
			  {
			  hh=hh+1;
			  	if(hh<10)
				{
					  hh="0"+hh;
				}
			  }
		  else
			  {
			  if(hh<10)
				{
					  hh="0"+hh;
				}
			  }
		  
		 // hh=hh; 
	  
	 
	  myDateStr=yyyy+"/"+MM+"/"+dd+" "+hh+":00:00";
	  return myDateStr;  
}
function FormateTime(obj)
{ 
	var nmonth='';
	var da=obj.split('-');
	nmonth+=da[0]+"";
	nmonth+=da[1]+"";
	nmonth+=da[2]+"";

    return nmonth; 
} 
function removeNullForArray(obj)
{
	var urls_list=new Array();
	for(var i=0;i<obj.length;i++)
	{
		if(obj[i]!=null)
		{
			urls_list.push(obj[i]);
		}
	}
	return urls_list;
}
function converterMB(obj)
{ 
    var mb =obj/1048576;// 字节转化为MB
    var mbb=parseInt(mb);// 取整
    return mbb; 
} 
function textcontent(){
// 读取CDN信息
var cdncontext="";
for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
      var cdntext=CdnData.cdn[i].split("-");
      var cdnid=cdntext[0];
      var cdnname=cdntext[1];
        if(cdnid === "000"){    //去掉源站
            continue;
        }
      cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='checkbox' /><label for='"+cdnid+"'>"+cdnname+"</label></li>";
}
$("#cdn").html(cdncontext);

// 加载省份数据
var provincecontext="";
provincecontext+="<select id='province'>";
for (var i = 0, n = ProvinceData.province.length; i < n; i++) { 
      var provincetext=ProvinceData.province[i].split("-");
      var provinceid=provincetext[0];
      var provincename=provincetext[1];
      provincecontext+="<option value="+provinceid+">"+provincename+"</option>";
}
provincecontext+="</select>";
$("#provincedata").html(provincecontext);


}
/* v0.3.1版本为条件选择框赋值 */
function getConditionValue1()
{
	// 读取CDN信息
	var cdncontext="";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      if(cdnid=="109"||cdnid=="110"||cdnid=="111"||cdnid=="112"){
	    	   continue;
	      }
	      
	      if(i==0)
	      {
	    	  cdncontext+="<em><span id='cdnEmItem'>请选择CDN</span><i></i></em><ul id='cdn'>";
	    	  cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='checkbox' /><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	      }
	      else
	      {
	    	  cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='checkbox' /><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	      }
	}
	cdncontext+="</ul>"
	$("#cdncondition").html(cdncontext);

	// 加载省份数据
	var provincecontext="";
	for (var i = 0, n = ProvinceData.province.length; i < n; i++) 
	{ 
	    var provincetext=ProvinceData.province[i].split("-");
	    var provinceid=provincetext[0];
	    var provincename=provincetext[1];
	    if(i==0)
	    {
	    	provincecontext+="<em><span id='provinceEmItem'>请选择区域</span><i></i></em><ul id='province'>";
	    	provincecontext+="<li><input id="+provinceid+" name=\"areaMessage\" value="+provincename+" type=\"radio\"/><label for='"+provinceid+"'>"+provincename+"</label></li>"  
	    }  
	    else
	    {
	    	provincecontext+="<li><input id="+provinceid+" name=\"areaMessage\" value="+provincename+" type=\"radio\"/><label for='"+provinceid+"'>"+provincename+"</label></li>"  
	    }
	}
	provincecontext+="</ul>";
	$("#locationcondition").html(provincecontext);
	// 加载ISP
	var ispcontext="";
	for(var i=0,n=IspData.isp.length;i<n;i++)
	{
		var isptext=IspData.isp[i].split("-");
		var ispid=isptext[0];
		var ispname=isptext[1];
		if(i==0)
		{
			ispcontext+="<em><span id='ispEmItem'>请选择ISP</span><i></i></em><ul id='isp'>";
			ispcontext+="<li><input id="+ispid+" name=\"ispMessage\" value="+ispname+" type=\"radio\"/><label for='"+ispid+"'>"+ispname+"</label></li>"  
		}
		else
		{
			ispcontext+="<li><input id="+ispid+" name=\"ispMessage\" value="+ispname+" type=\"radio\"/><label for='"+ispid+"'>"+ispname+"</label></li>"  
		}
	}
	ispcontext+="</ul>";
	$("#ispcondition").html(ispcontext);
	
	
}
function getConditionValue2()
{
	// 读取CDN信息
	var cdncontext="";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      if(i==0)
	      {
	    	  cdncontext+="<em><span id='cdnEmItem'>请选择CDN</span><i></i></em><ul id='cdn'>";
	    	  cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='radio'/><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	      }
	      else
	      {
	    	  cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='radio'/><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	      }
	}
	cdncontext+="</ul>"
	$("#cdncondition").html(cdncontext);

	// 加载省份数据
	var provincecontext="";
	for (var i = 0, n = ProvinceData.province.length; i < n; i++) 
	{ 
	    var provincetext=ProvinceData.province[i].split("-");
	    var provinceid=provincetext[0];
	    var provincename=provincetext[1];
	    if(i==0)
	    {
	    	provincecontext+="<em><span id='provinceEmItem'>请选择省份</span><i></i></em><ul id='province'>";
	    	provincecontext+="<li><input id="+provinceid+" name=\"areaMessage\" value="+provincename+" type=\"radio\"/><label for='"+provinceid+"'>"+provincename+"</label></li>"  
	    }  
	    else
	    {
	    	provincecontext+="<li><input id="+provinceid+" name=\"areaMessage\" value="+provincename+" type=\"radio\"/><label for='"+provinceid+"'>"+provincename+"</label></li>"  
	    }
	}
	provincecontext+="</ul>";
	$("#locationcondition").html(provincecontext);
	// 加载ISP
	var ispcontext="";
	for(var i=0,n=IspData.isp.length;i<n;i++)
	{
		var isptext=IspData.isp[i].split("-");
		var ispid=isptext[0];
		var ispname=isptext[1];
		if(i==0)
		{
			ispcontext+="<em><span id='ispEmItem'>请选择ISP</span><i></i></em><ul id='isp'>";
			ispcontext+="<li><input id="+ispid+" name=\"ispMessage\" value="+ispname+" type=\"checkbox\" /><label for='"+ispid+"'>"+ispname+"</label></li>"  
		}
		else
		{
			ispcontext+="<li><input id="+ispid+" name=\"ispMessage\" value="+ispname+" type=\"checkbox\"/><label for='"+ispid+"'>"+ispname+"</label></li>"  
		}
	}
	ispcontext+="</ul>";
	$("#ispcondition").html(ispcontext);
	
	
}
function getConditionValue3()
{
	// 读取CDN信息
	var cdncontext="";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      if(i==0)
	      {
	    	  cdncontext+="<em><span id='cdnEmItem'>请选择CDN</span><i></i></em><ul id='cdn'>";
	    	  cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='radio'/><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	      }
	      else
	      {
	    	  cdncontext+="<li><input id="+cdnid+" name='cdnMessage' value="+cdnname+" type='radio' /><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	      }
	}
	cdncontext+="</ul>";
	$("#cdncondition").html(cdncontext);

	// 加载省份数据
	var provincecontext="";
	for (var i = 1, n = ProvinceData.province.length; i < n; i++) 
	{ 
	    var provincetext=ProvinceData.province[i].split("-");
	    var provinceid=provincetext[0];
	    var provincename=provincetext[1];
	    if(i==1)
	    {
	    	provincecontext+="<em><span id='provinceEmItem'>请选择区域</span><i></i></em><ul id='province'>";
	    	provincecontext+="<li><input id="+provinceid+" name=\"areaMessage\" value="+provincename+" type=\"checkbox\" /><label for='"+provinceid+"'>"+provincename+"</label></li>"  
	    }  
	    else
	    {
	    	provincecontext+="<li><input id="+provinceid+" name=\"areaMessage\" value="+provincename+" type=\"checkbox\"/><label for='"+provinceid+"'>"+provincename+"</label></li>"  
	    }
	}
	provincecontext+="</ul>";
	$("#locationcondition").html(provincecontext);
	// 加载ISP
	var ispcontext="";
	for(var i=0,n=IspData.isp.length;i<n;i++)
	{
		var isptext=IspData.isp[i].split("-");
		var ispid=isptext[0];
		var ispname=isptext[1];
		if(i==0)
		{
			ispcontext+="<em><span id='ispEmItem'>请选择ISP</span><i></i></em><ul id='isp'>";
			ispcontext+="<li><input id="+ispid+" name=\"ispMessage\" value="+ispname+" type=\"radio\"/><label for='"+ispid+"'>"+ispname+"</label></li>"  
		}
		else
		{
			ispcontext+="<li><input id="+ispid+" name=\"ispMessage\" value="+ispname+" type=\"radio\"/><label for='"+ispid+"'>"+ispname+"</label></li>"  
		}
	}
	ispcontext+="</ul>";
	$("#ispcondition").html(ispcontext);
	
	
}
function textLocation()
{
	// 读取CDN信息
	var cdncontext="";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      cdncontext+="<li><input id="+cdnid+" name='cdnMessage' type='checkbox' /><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	}
	$("#cdnctext").html(cdncontext);
	
	// 加载省份数据
	var provincecontext="";
	for (var i = 0, n = ProvinceData.province.length; i < n; i++) { 
	      var provincetext=ProvinceData.province[i].split("-");
	      var provinceid=provincetext[0];
	      var provincename=provincetext[1];
	      provincecontext+="<li><input id="+provinceid+" name='cdnMessage' type='checkbox' /><label for='"+provinceid+"'>"+provincename+"</label></li>";
	}
	$("#provincedata1").html(provincecontext);
}
function textContext1()
{
	// 读取CDN信息
	var cdncontext="";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      cdncontext+="<li><input id="+cdnid+" name='cdnMessage' type='checkbox' /><label for='"+cdnid+"'>"+cdnname+"</label></li>";
	}
	$("#cdnctext").html(cdncontext);
	
	
	// 加载省份数据
	var provincecontext="";
	for (var i = 0, n = ProvinceData.province.length; i < n; i++) { 
	      var provincetext=ProvinceData.province[i].split("-");
	      var provinceid=provincetext[0];
	      var provincename=provincetext[1];
	      provincecontext+="<li><input id="+provinceid+" name='cdnMessage' type='checkbox' /><label for='"+provinceid+"'>"+provincename+"</label></li>";
	}
	$("#provincedata1").html(provincecontext);
}


function cdnmessage(){
	// 读取CDN信息
	var cdncontext="";
	cdncontext+="<select id='operator'>";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      cdncontext+="<option value="+cdnid+">"+cdnname+"</option>";
	}
	cdncontext+="</select>";
	$("#cdnctext").html(cdncontext);
}


function loadcdn(){
	// 读取CDN信息
	var cdncontext="";
	for (var i = 0, n = CdnData.cdn.length; i < n; i++) { 
	      var cdntext=CdnData.cdn[i].split("-");
	      var cdnid=cdntext[0];
	      var cdnname=cdntext[1];
	      //加速测评需要使用"109-安全宝","110-360","111-云加速","112-加速乐"这四个创建任务显示，内部使用，生产环境不需要
	      if(cdnid!="000"&&cdnid!="109"&&cdnid!="110"&&cdnid!="111"&&cdnid!="112"){
	    		  cdncontext+="<a href=\"#\"><input type=\"checkbox\" name="+cdnname+" value="+cdnid+" id="+cdnid+" />"+cdnname+"</a>";     
	      }
	}
	$("#cdnmessage").html(cdncontext);
}

function provincemessage(){
	
	// 加载省份数据
	var provincecontext="";
	for (var i = 1, n = ProvinceData.province.length; i < n; i++) { 
	      var provincetext=ProvinceData.province[i].split("-");
	      var provinceid=provincetext[0];
	      var provincename=provincetext[1];
	      provincecontext+="<li><input id="+provinceid+" name='locMessage' value='"+provincename+"' type='checkbox' /><label for='"+provinceid+"' id='"+provincename+"'>"+provincename+"</label></li>";
	}
	$("#locationtext").html(provincecontext);
	
}


function provinceforWebpage(){
	
	// 加载省份数据
	var provincecontext="";
	for (var i = 0, n = ProvinceData.province.length; i < n; i++) { 
	      var provincetext=ProvinceData.province[i].split("-");
	      var provinceid=provincetext[0];
	      var provincename=provincetext[1];
	      if(province==provincename){
	    	  provincecontext+="<option selected=\"selected\" value="+provinceid+">"+provincename+"</option>";
	      }else{
	    	  provincecontext+="<option value="+provinceid+">"+provincename+"</option>";
	      }
	    
	}
	$("#province").html(provincecontext);
	
}


function formatNum(strNum) {
		if(strNum!=null){
		if (strNum.length <= 3) {
		   return strNum;
		}

		if (!/^(\+|-)?(\d+)(\.\d+)?$/.test(strNum)) {
		    return strNum;
		}
		
		var a = RegExp.$1, b = RegExp.$2, c = RegExp.$3;
		var re = new RegExp();
		re.compile("(\\d)(\\d{3})(,|$)");
				while (re.test(b)) {
				b = b.replace(re, "$1,$2$3");
				}
		return a + "" + b + "" + c;
		}else{
			return strNum;
		}
		
		}
	

/*
 * 获取url传递的值(对url进行decodeURI之后)
 */
function getQueryStringRegExp(name)
{
	var reg = new RegExp("(^|\\?|&)"+ name +"=([^&]*)(\\s|&|$)", "i");  
  	if (reg.test(decodeURI(location.href))) return unescape(RegExp.$2.replace(/\+/g, " ")); return "";
	
};
//BUG #4686 超时再登录后 在当前页面， 没有调用接口 ，提示 条件设置错误  薛磊 2015年3月3日
function getQueryStringRegExp2(name)
{
  	if(location.href.lastIndexOf("redirect=") != -1){
  		return location.href.substring(location.href.lastIndexOf("redirect=")+9,  location.href.length); 
  	}else{
  		return "";
  	}
	
};
/*
 * function errprMsg(id,errprMsgs){ $(id).css({border:"2px solid
 * #E74C3C",marginRight:"10px"}).siblings("i").text(errprMsgs).css("color","#E74C3C"); } /*
 * 从错误信息恢复
 */
/*
 * function okMsg(id){
 * 
 * $(id).css({border:"2px solid
 * #D8E2E5",marginRight:"10px"}).siblings("i").text("").css("color","#E74C3C"); }
 */
/*
 * 错误信息提示
 */
function errprMsg(id,errprMsgs){
	$(id).parent().siblings("em").removeClass("ok-tip").addClass("table-icon error-tip c-f00");
	//$(id).css({border:"1px solid #E74C3C",marginRight:"0px"}).parent().siblings("em").text(errprMsgs).css("color","#E74C3C");
	$(id).parent().siblings("em").text(errprMsgs).css("color","#E74C3C");
}
/*
 * 从错误信息恢复
 */
function okMsg(id){
	$(id).parent().siblings("em").removeClass("error-tip c-f00").addClass("table-icon ok-tip");
	//$(id).css({border:"1px solid #c5c5c5",marginRight:"0px"}).parent().siblings("em").text("").css({color:"#c5c5c5"});
	$(id).parent().siblings("em").text("").css({color:"#c5c5c5"});
}
/* 验证是否有汉字 */
function checkChinese(obj) 
{ 
	 obj = $.trim(obj);
	 var reg = /.*[\u4e00-\u9fa5]+.*$/;
	 if(reg.test(obj)) {
	  return false;
	 }
	 return true;
}

/* 验证Url地址的合法性(包含http头) */
	function isUrlContainsProtocolHead(obj){   
	    // (http|https|ftp):(\\/\\/|\\\\)+([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?
	    reg=/^((http|https):\/\/)+(\w(\:\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?(\:[0-9]{2,6})?)((\/[^?#<>\/\\*":]*)+(\?[^#]*)?(#.*)?)?$/;
	    if(!reg.test(obj)){        
	        // jAlert("Please enter a correct email address!");
	        return false;
	    }else{   
	        return true;
	    }
	} 
	/* 验证Url地址的合法性(不包含http头) */
	function isUrlNoneProtocolHead(obj){
	    reg=/^(\w(\:\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?(\:[0-9]{2,6})?)((\/[^?#<>\/\\*":]*)+(\?[^#]*)?(#.*)?)?$/;
	    if(!reg.test(obj)){  
	        return false;
	    }else{   
	        return true;
	    }
	} 
	function isDomain(obj){
		reg=/^(\\w(\\:\\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?)$/;
		if(!reg.test(obj)){  
	        return false;
	    }else{   
	        return true;
	    }
	}
	function isDomainWithHTTP(obj){
		reg=/^((http|https):\/\/)+(\\w(\\:\\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?)$/;
		if(!reg.test(obj)){  
	        return false;
	    }else{   
	        return true;
	    }
	}
	/* 验证IP地址的合法性(仅限IPv4) */
	function isIP(obj){
		
		if (obj.length < 7)
      {
          return false;
      }
		var lidx=obj.indexOf("255");
      if(-1!=lidx)
      {
      	 // 如果包含255，则认为是错误的（包括广播地址）
      	return false;
      }
      // 不能以网络号和广播地址为结尾
      lidx=obj.lastIndexOf(".0");
      if((obj.length-2)==lidx)
      {
          // 如果0在最后
          return false;
      }

		// 简单的不可用的IP地址的判断
	// 一些简单的IP地址
		if((obj=="127.0.0.1")
				||(obj=="0.0.0.0")
				||(obj=="255.255.255.255")
			)
		{

			return false;
		}
		// 去掉内网ip
		/*
		 * 10.0.0.0~10.255.255.255 172.16.0.0~172.31.255.255
		 * 192.168.0.0~192.168.255.255
		 */
		if((obj.indexOf("10.")==0)  				
				||(obj.indexOf("172.16.")==0)
				||(obj.indexOf("172.17.")==0)
				||(obj.indexOf("172.18.")==0)
				||(obj.indexOf("172.19.")==0)
				||(obj.indexOf("172.20.")==0)
				||(obj.indexOf("172.21.")==0)
				||(obj.indexOf("172.22.")==0)
				||(obj.indexOf("172.23.")==0)
				||(obj.indexOf("172.24.")==0)
				||(obj.indexOf("172.25.")==0)
				||(obj.indexOf("172.26.")==0)
				||(obj.indexOf("172.27.")==0)
				||(obj.indexOf("172.28.")==0)
				||(obj.indexOf("172.29.")==0)
				||(obj.indexOf("172.30.")==0)
				||(obj.indexOf("172.31.")==0)
				||(obj.indexOf("192.168.")==0)
			)
		{
			//
			return false;
		}
		
		// 正则表达式判断
	    reg=/^((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]\d)|[1-9])(\.((25[0-5])|(2[0-4]\d)|(1\d\d)|([1-9]\d)|\d)){3}$/;
	    if(!reg.test(obj)){  
	        return false;
	    }  		    
	    else{   
	        return true;
	    }
	} 
	
	 /* 验证公司名称的合法性 */
	function isCompanyName(obj)
	{  			
		if(obj.indexOf("\\")>-1){
			return false;
		}
		if(obj.indexOf(" ")>-1){
			return false;
		}
		var reg = new RegExp("[_`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*|{}【】‘；：”“’。，、？]+");  			
		    if(reg.test(obj)){
		    // 如果包含了特殊字符，则返回，验证不通过的信息
		       return false;
		   }else{   
		       return true;
		    }
	} 
	/* 验证taskName地址的合法性 */
	function isTaskName(obj)
	{  	
			if(obj.indexOf('\\') != -1){
			return false;
		}	
		//var reg = new RegExp("[`+~!@#$%^&*=|{}':;',\\[\\].<>/?~！@#%￥……&*|{}【】‘；：”“’。，、？]+"); 
		var reg = new RegExp("[`+~!@/#?%$^&*=|{}':;',\\[\\].<>《》~！@#￥……&*|{}【】‘；：”“’。，、？]+");
	    if(reg.test(obj)){
	    	// 如果包含了特殊字符，则返回，验证不通过的信息
	        return false;
	    }else{   
	        return true;
	    }
	}
	
	/* URL中最后一位如果是"/"，则将"/"去掉 */
function getBackslach(name)
	{
   var lastChar=name.substr(name.length-1); 
	if(lastChar=="/"){
		
		name = name.substr(0,name.length-1);
	}
	else
	{
		return name;
	}
	   return getBackslach(name);
	}
/* URL中最后一位如果是"/"，则将"/"去掉 */
function getIndexslach(name)
	{
   var lastChar=name.substr(0,1); 
	if(lastChar=="/"){
		
		name = name.substr(1,name.length);
	}
	else
	{
		return name;
	}
	   return getIndexslach(name);
	}

	
/* 验证email地址的合法性 */
	function isEmail(obj){   
		/*
		 * return true;
		 * reg=/^[a-z0-9]([a-z0-9-_\.]*[a-z0-9])*@([a-z0-9][a-z0-9-]{0,61}[a-z0-9]\.){1,3}[a-z]{2,6}([\.][a-z]{2,6})?$/;
		 * if(!reg.test(obj)){ return false; }else{ return true; }
		 */
		/* 新版本代码，解决被验证文字过多的时候导致浏览器反应过慢的问题 */
	var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (filter.test(obj)) {
	    return true;
	}
	return false;
		
	}   
	/* 验证邮箱验证码的合法性 */
	function isEmailVerificationCode(obj){
		
	if (obj.length==6 && ! isNaN(obj)) {
	    return true;
	}
	return false;  			
	}
	
	/* 验证手机号的合法性 */
	function isMobilePhoneNumber(obj){	   		   
	//var filter  = /^(1(([35][0-9])|(47)|[8][0123456789]))\d{8}$/;
	//增加4G号段
	var filter  = /^(1(([35][0-9])|(47)|(45)|[7][0678]|[8][0123456789]))\d{8}$/;
	if (filter.test(obj)) {
	    return true;
	}
	return false;
	
	}
	/* 验证短信验证码的合法性 */
	function isSmsVerificationCode(obj)
	{
		obj=$.trim(obj);
		if (obj.length==6 &&!isNaN(obj)) 
		{
		    return true;
		}
		return false;  			
	}
	/* 验证NickName地址的合法性 */
	function isNickName(obj)
	{  			
		// var reg = new
		// RegExp("[`%~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*|{}【】‘；：”“’。，、？]+");
	    if(obj==null||obj ==""){
	    return false;
	    }
	    if(obj.length<5||obj.length>25){
	    return false;
	    }
	   
	    if(obj.indexOf('\\')>0){
		
		return false;
	}
	    return /^[\-A-Za-z0-9_\u4E00-\u9FA5]+$/.test(obj);
	}
	/* 验证taskName的合法性 */
	function isTaskName(obj)
	{  			
		
		var reg = new RegExp("[`+~!@/#?%$^&*=|{}':;',\\[\\].<>《》~！@#￥……&*|{}【】‘；：”“’。，、？]+");
	    if(reg.test(obj)){
	    	// 如果包含了特殊字符，则返回，验证不通过的信息
	        return false;
	    }else{   
	        return true;
	    }

	}
	/*
	 * 说明：取客户端当前时间，格式为:HH:mm:ss，例如01:01:01或者23:59:59 作者：党章 时间：2012-12-06
	 * 18:39:50 返回：客户端当前时间的字符串
	 */  
function GetNowTime()  
 {  
	  var myDate,myTime;  
	  myDate = new Date();
	  var HH = myDate.getHours();// 取小时
	  if(HH<10)
	  {
	  	HH="0"+HH;
	  }
	  var mm= myDate.getMinutes();// 取分
	  if(mm<10)
	  {
	  	mm="0"+mm;
	  }  
	  var ss= myDate.getSeconds();// 取秒
	  if(ss<10)
	  {
	  	ss="0"+ss;
	  } 
	  myTime=HH+":"+mm+":"+ss;
	  return myTime;  
 }

/*
 * 说明：取客户端当前日期，格式为:yyyy-MM-DD 作者：党章 时间：2012-12-06 18:50:26 返回：客户端当前日期的字符串
 */ 
 
function GetNowDate()  // 今天
 {  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  var dd= myDate.getDate();// 取日
	  if(dd<10)
	  {
	  	dd="0"+dd;
	  } 
	  myDateStr=yyyy+"-"+MM+"-"+dd;
	  return myDateStr;  
 }


function GetNowDateByMonth()  // 今天
 {  

	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  myDateStr=yyyy+"-"+MM;
	  return myDateStr;  
 }

function GetBeforeDateByMonth()  // 今天
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth();//+1;// 取月份
	  if(MM==1){
		  yyyy=yyyy-1;
		  MM=12;
	  }else{
		  if(MM<10)
		  {
		  	MM="0"+MM;
		  }  
	  }
	  myDateStr=yyyy+""+MM;
	  return myDateStr;  
}


function GetBeforeMonthDate()  // 昨天用于选择条件
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM==1){
		  yyyy=yyyy-1;
		  MM=12;
	  }else{
		  if(MM<10)
		  {
		  	MM="0"+MM;
		  } 
	  }
	  myDateStr=yyyy+"-"+MM;
	  return myDateStr;  
}


function GetBDateByMonth()  // 上个月份
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth();// 取月份
	  if(MM==0){
		  yyyy=yyyy-1;
		  MM=12;
	  }else{
		  if(MM<10)
		  {
		  	MM="0"+MM;
		  }  
	  }
	  myDateStr=yyyy+""+MM;
	  return myDateStr;  
}

function GetDateForMonth()  //时间函数上个月
{  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth();// 取月份
	  if(MM==0){
		  yyyy=yyyy-1;
		  MM=12;
	  }else{
		  if(MM<10)
		  {
		  	MM="0"+MM;
		  }  
	  }
	  myDateStr=yyyy+"-"+MM;
	  return myDateStr;  
}
 function GetMonthByCurrent()  // 今天
 {  
	  var myDate,myDateStr;  
	  myDate = new Date();
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  myDateStr=yyyy+"-"+MM;
	  return myDateStr;  
 }

 function GetYesDate()  // 昨天
 {  
	  var myDate,myDateStr;  
	  myDate = new Date(new Date()-1000*60*60*24);
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  var dd= myDate.getDate();// 取日
	  if(dd<10)
	  {
	  	dd="0"+dd;
	  } 
	  myDateStr=yyyy+"-"+MM+"-"+dd;
	  return myDateStr;  
 }
 function GetLastWeekDate()  // 最近7天
 {  
	  var myDate,myDateStr;  
	  myDate = new Date(new Date()-1000*60*60*24*6);
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  var dd= myDate.getDate();// 取日
	  if(dd<10)
	  {
	  	dd="0"+dd;
	  } 
	  myDateStr=yyyy+"-"+MM+"-"+dd;
	  return myDateStr;  
 }
 
 function GetHalfMonthDate()  // 最近15天
 {  
	  var myDate,myDateStr;  
	   myDate = new Date(new Date()-1000*60*60*24*14);
	  var yyyy = myDate.getFullYear();// 取四位年份
	  var MM= myDate.getMonth()+1;// 取月份
	  if(MM<10)
	  {
	  	MM="0"+MM;
	  }  
	  var dd= myDate.getDate();// 取日
	  if(dd<10)
	  {
	  	dd="0"+dd;
	  } 
	  myDateStr=yyyy+"-"+MM+"-"+dd;
	  return myDateStr;  
 }
 function GetMonthDate(date)  // 当前日期的下一个月
 {  
	  
	 var arr = date.split('-');
     var year = arr[0]; //获取当前日期的年份
     var month = arr[1]; //获取当前日期的月份
     var day = arr[2]; //获取当前日期的日
     var days = new Date(year, month, 0);
     days = days.getDate(); //获取当前日期中的月的天数
     var year2 = year;
     var month2 = parseInt(month) + 1;
     if (month2 == 13) {
         year2 = parseInt(year2) + 1;
         month2 = 1;
     }
     var day2 = day;
     var days2 = new Date(year2, month2, 0);
     days2 = days2.getDate();
     if (day2 > days2) {
         day2 = days2;
     }
     if (month2 < 10) {
         month2 = '0' + month2;
     }
 
     var t2 = year2 + '-' + month2 + '-' + day2;
     return t2;
 }
	//字符串转换为date时间格式为yyy-MM-DD hh:mm:ss
 function getDateFormate(dataStr){
 	
 		var temp=dataStr.split(' ');// 分割
 	var yearMonDay=temp[0].split('-');// 分割
 	var year = parseInt(yearMonDay[0]);
 	var month = parseInt(yearMonDay[1])-1;
 	var day = parseInt(yearMonDay[2]);
 	
 	var hhmmss = temp[1].split(':');
 	var hour = parseInt(hhmmss[0]);
 	var minute =parseInt(hhmmss[1]);
 	var secondes =parseInt(hhmmss[2]);
 	//alert("时间："+year+" "+month+"  "+day+" "+hour+" "+minute+" "+secondes);
 	return new Date(year,month,day,hour,minute,secondes);
 	}
 
  	function getDateStrToUTC(dataStr){
  		var temp=dataStr.split(' ');// 分割
		var yearMonDay=temp[0].split('-');// 分割
		var year = parseInt(yearMonDay[0]);
		var month = parseInt(yearMonDay[1])-1;
		var day = parseInt(yearMonDay[2]);
		return Date.UTC(year, month, day,parseInt(temp[1]),0,0);
  	}
  	  	//字符串转换为date时间格式为yyy-MM-DD hh:mm:ss
  	function getDateStrToUTCFormate(dataStr){
  		var temp=dataStr.split(' ');// 分割
		var yearMonDay=temp[0].split('-');// 分割
		var year = parseInt(yearMonDay[0]);
		var month = parseInt(yearMonDay[1])-1;
		var day = parseInt(yearMonDay[2]);
		var hhmmss = temp[0].split(':');
		var hour = parseInt(hhmmss[0]);
		var minute =parseInt(hhmmss[1]);
		var secondes =parseInt(hhmmss[2]);
		return Date.UTC(year, month, day,hour,minute,secondes);
  	}
  	
  	function getDateStrToMileSeconds(dataStr){
  		var year=parseInt(dataStr.substring(0,4));
  		var month=parseInt(dataStr.substring(4,6));
  		var day=parseInt(dataStr.substring(6,8));
  		var hour=parseInt(dataStr.substring(8,10));
  		return new Date(year,month,day,hour,0,0).getTime();
		//return Date.UTC(year, month, day,parseInt(temp[1]),0,0);
  	}
  	function getDateStrToDate(dataStr){
  		if(dataStr==null||dataStr=="")
  		{
  			return "--";
  		}
  		var year=parseInt(dataStr.substring(0,4));
  		var month=parseInt(dataStr.substring(4,6));
  		var day=parseInt(dataStr.substring(6,8));
  		var hour=parseInt(dataStr.substring(8,10));
  		var minute=parseInt(dataStr.substring(10,12));
  		var seconds=parseInt(dataStr.substring(12,14));
  		if(minute<10)
  		{
  			minute="0"+minute;
  		}
  		//return new Date(year,month,day,hour,0,0).toLocaleString();
		return year+"/"+month+"/"+day+" "+hour+":"+minute+":"+seconds;
  	}
  	
  	function getDateStrToDateForh(dataStr){
  		if(dataStr==null||dataStr=="")
  		{
  			return "--";
  		}
  		var year=parseInt(dataStr.substring(0,4));
  		var month=parseInt(dataStr.substring(4,6));
  		var day=parseInt(dataStr.substring(6,8));
  		var hour=parseInt(dataStr.substring(8,10));
  		var minute=parseInt(dataStr.substring(10,12));
  		var seconds=parseInt(dataStr.substring(12,14));
  		if(minute<10)
  		{
  			minute="0"+minute;
  		}
  		if(month<10)
  		{
  			month="0"+month;
  		}
  		if(seconds<10)
  		{
  			seconds="0"+seconds;
  		}
  		if(hour<10)
  		{
  			hour="0"+hour;
  		}
  		//return new Date(year,month,day,hour,0,0).toLocaleString();
		return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+seconds;
  	}
  	
  	/*
	 * 设置时间格式为UTC格式
	 */
  	function setTimeToUTC(dataArray){
  		var temp=dataArray[0].split(' ');// 分割
		var yearMonDay=temp[0].split('-');// 分割
		var year = parseInt(yearMonDay[0]);
		var month = parseInt(yearMonDay[1])-1;
		var day = parseInt(yearMonDay[2]);
		// jAlert("-year"+year+"-month"+month+"-day"+day);
		 newDateObj = Date.UTC(year, month, day);// 将时间转换成UTC格式
		return Date.UTC(year, month, day,parseInt(temp[1]));
  	}
  	/*
	 * 
	 * 获取日期的方法 当前日期：GetDateStr(0) 昨天：GetDateStr(-1) 明天：GetDateStr(1)
	 */
  	function GetDateStr(AddDayCount) 
	{ 
		var dd = new Date(); 
		dd.setDate(dd.getDate()+AddDayCount);// 获取AddDayCount天后的日期
		var y = dd.getFullYear(); // 如果用getYear()的话，在firefox和chrome中会出错
		var m = dd.getMonth()+1;// 获取当前月份的日期
		if(m<=9)
		{
			m="0"+m;
		}
		var d = dd.getDate(); 
		if(d<=9)
		{
			d="0"+d;
		}
		return y+"-"+m+"-"+d; 
	}
  	function getDateCoor(startTime, endTime, type) 
	{
		// 将xxxx-xx-xx的时间格式，转换为 xxxx/xx/xx的格式
		startTime = startTime.replace(/\-/g, "/");
		endTime = endTime.replace(/\-/g, "/");
		// 将计算间隔类性字符转换为小写
		type = type.toLowerCase();
		var sTime = new Date(startTime);      // 开始时间
		var eTime = new Date(endTime);  // 结束时间
		// 作为除数的数字
		var num = 1;
		switch (type) 
		{ 
			case "second":
				num = 1000;
				 break;
			case "minute":
				num = 1000 * 60;
				break;
			case "hour":
				num = 1000 * 3600;
				break;
			case "day":
				num = 1000 * 3600 * 24;
				break;
			default:
				break;
		}
		return parseInt((eTime.getTime() - sTime.getTime()) / parseInt(num));
    }
 	// 格式化日期
	function formatDate(sDate)
	{
		var sDateStr = sDate.getFullYear()+"-"+(sDate.getMonth()+1)+"-"+(sDate.getDay()+1)+" "+sDate.getHours()+":"+sDate.getMinutes()+":"+sDate.getSeconds();
		return sDateStr;
	}
	Date.prototype.format = function(fmt) 
	{
	    //author: meizz 
	    var o =
	     { 
	        "M+" : this.getMonth() + 1, //月份 
	        "d+" : this.getDate(), //日 
	        "h+" : this.getHours(), //小时 
	        "m+" : this.getMinutes(), //分 
	        "s+" : this.getSeconds(), //秒 
	        "q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S" : this.getMilliseconds() //毫秒 
	     }; 
	    if (/(y+)/.test(fmt)) 
	         fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length)); 
	    for (var k in o) 
	        if (new RegExp("(" + k + ")").test(fmt)) 
	             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length))); 
	    return fmt; 
	}
	// 格式化日期YYYY-MM-DD hh:mm:ss
	function formatDateOne(sDate)
	{
		
		var yyyy = sDate.getFullYear();// 取四位年份
		  var MMS= sDate.getMonth()+1;// 取月份
		  var dd=sDate.getDate();
		  var hh=sDate.getHours();
		  var mm=sDate.getMinutes();
		  var ss=sDate.getSeconds();
		  if(MMS<10)
		  {
		  	MMS="0"+MMS;
		  }  
		  if(dd<10)
		  {
			  dd="0"+dd;
		  }
		  if(hh<10)
		  {
			  hh="0"+hh; 
		  }
		  if(mm<10)
		  {
			  mm="0"+mm; 
		  }
		  if(ss<10)
		  {
			  ss="0"+ss; 
		  }
		  
		var sDateStr = sDate.getFullYear()+"-"+(MMS)+"-"+(dd)+" "+hh+":"+mm+":"+ss;
		
		return sDateStr;
	}
 	// 格式化日期为yyyy-MM-DD HH:MM:SS
	function formatDate(sDate)
	{
		var sDateStr = sDate.getFullYear()+"-"+(sDate.getMonth()+1)+"-"+(sDate.getDay()+1)+" "+sDate.getHours()+":"+sDate.getMinutes()+":"+sDate.getSeconds();
		return sDateStr;
	}
	/*
	 * 去掉空格字符
	 */
	function jsTrim(str) 
	{
		return str.replace(/\ /g,"");
	}
	// 判断是否是验证码
	function isVerificationCode(obj){
		obj=$.trim(obj);
		if (obj.length==6 &&!isNaN(obj)) {
		    return true;
		}
		return false;  			
		}
	
	/* 跳转 */
	function doFunction(url)
	{
		location.href=url;
		return false;// 解决在ie6下不跳转的问题
	}
	// 跳转到默认首页
	function gotoHome()
		{
			location.href="<%=basePath %>";
		}

	
	 // CDN数据处理将NULL转化为--或者0
	 function isZ(msg){
		  var a;
		  if(msg==null){
			a="--";  
		  }else{
			  a=msg;
		  }
		  return a;
	  }  
	  
	  function NullToZ(msg){
		  var a;
		  if(msg==null){
			a=0;  
		  }else{
			  a=msg;
		  }
		  return a;
	  } 
	 
	  
		
		function compact(v1,v2){
		if(v1<v2){
		return -1;
		}else if(v1>v2){
		return 1;
		}else{
		return 0;
		}
		
		}

		
		
/********js校验**2014-1-7xuelei****start*********/

/*
用途：校验ip地址的格式
输入：strIP：ip地址
返回：如果通过验证返回true,否则返回false；

*/
function _isIP(strIP) {
if (_isNull(strIP)) return false;
var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g //匹配IP地址的正则表达式
if(re.test(strIP))
{
if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256) return true;
}
return false;
}

/*
用途：判断是否是内网IP
输入：strIP：ip地址
返回：如果通过验证返回true,否则返回false；
*/
function _isLanIP(strIP) {
if (!_isIP(strIP)) return false;
var first3char = strIP.substr(0,3);
//10.0.0.0-10.255.255.255和172.16.0.0-172.31.255.255和192.168.0.0-192.168.255.255为内网IP
var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g //匹配IP地址的正则表达式
if(re.test(strIP)){
if( RegExp.$1 ==10 || (RegExp.$1 == 192 && RegExp.$2 == 168) || (RegExp.$1 == 172 && RegExp.$2<=31 && RegExp.$2>=16) ) return true;
}
return false;
}

/*
用途：检查输入字符串是否为空或者全部都是空格
输入：str
返回：
如果全是空返回true,否则返回false
*/
function _isNull( str ){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}


/*
用途：检查输入对象的值是否符合整数格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isInteger( str ){
var regu = /^[-]{0,1}[0-9]{1,}$/;
return regu.test(str);
}
/*
用途：检查输入对象的值是否符合正整数格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isNonnegativeInteger( str ){
	var regu = /^[0-9]*[1-9][0-9]*$/;
	return regu.test(str);
	}
/*
用途：检查输入对象的值是否符合大于0小于100并且最多只有一位小数
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isOneDecimals( str ){

	//var regu = /^[-|+]?\d{0,2}([.]\d{0,1})?$/;
	var regu =/^([1-9]\d?(\.\d{1})?|0.[1-9])$/;
	return regu.test(str);
	}

/*
 * 是否包含特殊字符
 * @param str
 * @returns
 */
function _haveSpecialChar(str){
var regu=/[,.<>{}~!@#$%^&*]/;
return regu.test(str);
}
function _haveSpecialChar1(str){
	var regu=/[,<>{}~!@#$%^&*]/;
	return regu.test(str);
	}
/*
 * 是否包含中文及中文字符
 * @param str
 * @returns
 */
function _haveChiness(str){ 
var reg = /[^\x00-\xff]+/;
return reg.test(str);
} 

/*
用途：检查输入手机号码是否正确
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false


function _checkMobile( s ){
//var regu =/^[1][3][0-9]{9}$/;
var regu  = /^(1(([35][0-9])|(47)|(45)|[7][0678]|[8][0123456789]))\d{8}$/;
var re = new RegExp(regu);
if (re.test(s)) {
return true;
}else{
return false;
}
}
*/

/*
用途：检查输入字符串是否符合正整数格式
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isPositiveNumber( s ){
var regu = "^[0-9]+$";
var re = new RegExp(regu);
if (s.search(re) != -1) {
return true;
} else {
return false;
}
}

/*
用途：检查输入字符串是否是带小数的数字格式,可以是负数
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isDecimal( str ){
if(_isInteger(str)) return true;
var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
if (re.test(str)) {
if(RegExp.$1==0&&RegExp.$2==0) return false;
return true;
} else {
return false;
}
}

/*
用途：检查输入对象的值是否符合端口号格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isPort( str ){
return (_isPositiveNumber(str) && str<65536);
}

/*
用途：检查输入对象的值是否符合E-Mail格式
输入：str 输入的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isEmail( str ){
var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
if(myReg.test(str)) return true;
return false;
}

/*
用途：检查输入字符串是否符合金额格式
格式定义为带小数的正数，小数点后最多三位
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isMoney( s ){
var regu = "^[0-9]+[\.][0-9]{0,3}$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
} else {
return false;
}
}
/*
用途：检查输入字符串是否只由英文字母和数字和下划线组成
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isNumberOr_Letter( s ){//判断是否是数字或字母

var regu = "^[0-9a-zA-Z\_]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
}else{
return false;
}
}
/*
用途：检查输入字符串是否只由英文字母和数字组成
输入：
s：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isNumberOrLetter( s ){//判断是否是数字或字母

var regu = "^[0-9a-zA-Z]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
}else{
return false;
}
}
/*
用途：检查输入字符串是否只由汉字、字母、数字组成
输入：
value：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isChinaOrNumbOrLett( s ){//判断是否是汉字、字母、数字组成

var regu = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
}else{
return false;
}
}
/*验证Url地址的合法性(包含http头)*/
	function isUrlContainsProtocolHead(obj){   
	    //(http|https|ftp):(\\/\\/|\\\\)+([\\w-]+\\.)+[\\w-]+(/[\\w-   ./?%&=]*)?
	    reg=/^((http|https):\/\/)+(\w(\:\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?(\:[0-9]{2,6})?)((\/[^?#<>\/\\*":]*)+(\?[^#]*)?(#.*)?)?$/;
	    if(!reg.test(obj)){        
	        //jAlert("Please enter a correct email address!");   
	        return false;
	    }else{   
	        return true;
	    }
	} 
	/*验证Url地址的合法性(不包含http头)*/
	function isUrlNoneProtocolHead(obj){
	    reg=/^(\w(\:\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?(\:[0-9]{2,6})?)((\/[^?#<>\/\\*":]*)+(\?[^#]*)?(#.*)?)?$/;
	    if(!reg.test(obj)){  
	        return false;
	    }else{   
	        return true;
	    }
	} 
	
	/*
用途：检查是否是否由0-9 a-f A-F组成(十六进制)
输入：
value：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _isShiLiuJinZhi( s ){

var regu = "^[0-9a-fA-F]+$";
var re = new RegExp(regu);
if (re.test(s)) {
return true;
}else{
return false;
}
}


/*
用途：判断是否是日期
输入：date：日期；fmt：日期格式
返回：如果通过验证返回true,否则返回false
*/
function _isDate( date, fmt ) {
if (fmt==null) fmt="yyyyMMdd";
var yIndex = fmt.indexOf("yyyy");
if(yIndex==-1) return false;
var year = date.substring(yIndex,yIndex+4);
var mIndex = fmt.indexOf("MM");
if(mIndex==-1) return false;
var month = date.substring(mIndex,mIndex+2);
var dIndex = fmt.indexOf("dd");
if(dIndex==-1) return false;
var day = date.substring(dIndex,dIndex+2);
if(!isNumber(year)||year>"2100" || year< "1900") return false;
if(!isNumber(month)||month>"12" || month< "01") return false;
if(day>getMaxDay(year,month) || day< "01") return false;
return true;
}

function _getMaxDay(year,month) {
if(month==4||month==6||month==9||month==11)
return "30";
if(month==2)
if(year%4==0&&year%100!=0 || year%400==0)
return "29";
else
return "28";
return "31";
}

/*
用途：字符1是否以字符串2结束
输入：str1：字符串；str2：被包含的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isLastMatch(str1,str2)
{
var index = str1.lastIndexOf(str2);
if(str1.length==index+str2.length) return true;
return false;
}


/*
用途：字符1是否以字符串2开始
输入：str1：字符串；str2：被包含的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isFirstMatch(str1,str2)
{
var index = str1.indexOf(str2);
if(index==0) return true;
return false;
}

/*
用途：字符1是包含字符串2
输入：str1：字符串；str2：被包含的字符串
返回：如果通过验证返回true,否则返回false

*/
function _isMatch(str1,str2)
{
var index = str1.indexOf(str2);
if(index==-1) return false;
return true;
}


/*
用途：检查输入的起止日期是否正确，规则为两个日期的格式正确，
且结束如期>=起始日期
输入：
startDate：起始日期，字符串
endDate：结束如期，字符串
返回：
如果通过验证返回true,否则返回false

*/
function _checkTwoDate( startDate,endDate ) {
if( !_isDate(startDate) ) {
alert("起始日期不正确!");
return false;
} else if( !_isDate(endDate) ) {
alert("终止日期不正确!");
return false;
} else if( startDate > endDate ) {
alert("起始日期不能大于终止日期!");
return false;
}
return true;
}

/*
用途：检查输入的Email信箱格式是否正确
输入：
strEmail：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _checkEmail(strEmail) {
//var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/;
var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
if( emailReg.test(strEmail) ){
return true;
}else{
//alert("您输入的Email地址格式不正确！");
return false;
}
}

/*
用途：检查输入的电话号码格式是否正确
输入：
strPhone：字符串
返回：
如果通过验证返回true,否则返回false

*/
function _checkPhone( strPhone ) {
var phoneRegWithArea = /^[0][1-9]{2,3}-[0-9]{5,10}$/;
var phoneRegNoArea = /^[1-9]{1}[0-9]{5,8}$/;
var prompt = "您输入的电话号码不正确!"
if( strPhone.length > 9 ) {
if( phoneRegWithArea.test(strPhone) ){
return true;
}else{
//alert( prompt );
return false;
}
}else{
if( phoneRegNoArea.test( strPhone ) ){
return true;
}else{
//alert( prompt );
return false;
}
}
}
/********js校验**2014-1-7xuelei****end*********/

/**
 * @returns
 */
function getCountDays() {
    var curDate = new Date();
    /* 获取当前月份 */
    var curMonth = curDate.getMonth();
   /*  生成实际的月份: 由于curMonth会比实际月份小1, 故需加1 */
   curDate.setMonth(curMonth);
   /* 将日期设置为0, 这里为什么要这样设置, 我不知道原因, 这是从网上学来的 */
   curDate.setDate(0);
   /* 返回当月的天数 */
  
   return curDate.getDate();
}

/**
 * @param year
 * @param month
 * @returns 返回当前月份的的天数
 */
function getLastDay(year,month) {         
    var new_year = year;    //取当前的年份          
    var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）          
    if(month>12) {         
     new_month -=12;        //月份减          
     new_year++;            //年份增          
    }         
    var new_date = new Date(new_year,new_month,1);                //取当年当月中的第一天          
    return (new Date(new_date.getTime()-1000*60*60*24)).getDate();//获取当月最后一天日期          
}  

/*
 * 错误信息提示
 */
function errprMsg_em(id,errprMsgs){
	$(id).removeClass("ok-tip").addClass("table-icon error-tip c-f00");
	$(id).text(errprMsgs).css("color","#E74C3C");
}
/*
 * 从错误信息恢复
 */
function okMsg_em(id){
	$(id).removeClass("error-tip c-f00").addClass("table-icon ok-tip");
	$(id).text("").css({color:"#c5c5c5"});
}

/*
 * 获取字符串长度，中文算2个
 */
function getStrLength(str){
	  var count=0;
		var patten=	/^[!,@,#,$,%,^,&,*,(,),<,{,},>,0-9,a-z]*$/;
		var re = new RegExp(patten);
		for(var i=0;i<str.length;i++){
			
		if(re.test(str.charAt(i))){
				count++;
		}else{
			count=count+2;	
		}
	}
	return count;
}

function msgTips(status,txt,timeout){
	removeTips();
	var flag = status.match('loading')=='loading';
	var html = '<div class="msgbox_layer_wrap" id="msgTips"><span class="msgbox_layer"><span class="icon_clear"></span><span class="icon '+status+'"></span>'+txt+'<span class="icon_end"></span></span></div>';
	$('body').append(html);
	if (flag) {
		$("#msgTips .loading").removeClass('icon');
	}else{
		$("#msgTips .icon_clear").remove();
		setTimeout(this.removeTips,timeout||1200);
	};
}
function removeTips(){
	$("#msgTips").remove();
}


/**
 * 格式化金额.
 * @param num 金额
 * @returns 例如num=1.00返回1，num=1.10返回1.1，num=1.11返回1.11
 */
function formatNum(num){
	var str=num.toFixed(2);
	if(str.charAt(str.length-1)=='0'){
		str=str.substring(0,str.length-1);
	}
	var numAfterDot=str.split('.');
	
	var numLast=numAfterDot[numAfterDot.length-1];
	if(numLast.length==1 && numLast=='0'){
		str=str.substring(0,str.length-2);
	}
	return str;
}

/**
 * 获取字符串长度，中文算两个
 * @param str
 */
function getChineseStrLength(str){
	var len = str.match(/[^ -~]/g) == null ? str.length : str.length + str.match(/[^ -~]/g).length ;
	return len;
}

/* 2007-11-28 XuJian */ 
//从
//截取字符串 包含中文处理  
//(串,长度,增加...)  
function subStrForChinese(str, len, hasDot)  
{  
  var newLength = 0;  
  var newStr = "";  
  var chineseRegex = /[^\x00-\xff]/g;  
  var singleChar = "";  
  var strLength = str.replace(chineseRegex,"**").length;  
  for(var i = 0;i < strLength;i++)  
  {  
      singleChar = str.charAt(i).toString();  
      if(singleChar.match(chineseRegex) != null)  
      {  
          newLength += 2;  
      }      
      else  
      {  
          newLength++;  
      }  
      if(newLength > len)  
      {  
          break;  
      }  
      newStr += singleChar;  
  }  

  if(hasDot && strLength > len)  
  {  
      newStr += "...";  
  }  
  return newStr;  
}

function HashMap(){
    this.map = {};
}
HashMap.prototype = {
    put : function(key , value){
        this.map[key] = value;
    },
    get : function(key){
        if(this.map.hasOwnProperty(key)){
            return this.map[key];
        }
        return null;
    },
    remove : function(key){
        if(this.map.hasOwnProperty(key)){
            return delete this.map[key];
        }
        return false;
    },
    removeAll : function(){
        this.map = {};
    },
    keySet : function(){
        var _keys = [];
        for(var i in this.map){
            _keys.push(i);
        }
        return _keys;
    }
};
    
    function Hashtable() {
        this._hash = new Object();
        //add()
        this.add = function(key,value){
            if(typeof(key)!="undefined"){
                if(this.contains(key)==false){
                    this._hash[key]=typeof(value)=="undefined"?null:value;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        //remove()
        this.remove = function(key){delete this._hash[key];}
        //count
        this.count = function(){var i=0;for(var k in this._hash){i++;} return i;}
        //items
        this.items = function(key){return this._hash[key];}
        //contains
        this.contains = function(key){ return typeof(this._hash[key])!="undefined";}
        //clear
        this.clear = function(){for(var k in this._hash){delete this._hash[k];}}
    };
