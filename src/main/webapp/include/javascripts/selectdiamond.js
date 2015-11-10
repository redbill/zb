var level = {};
level[''] = '';
level['I'] = 'Ideal';
level['E'] = 'EX';
level['V'] = 'VG';
level['G'] = 'GD';
level['F'] = 'Fair';
level['P'] = 'Poor';
var fluor = {};
fluor[''] = '';
fluor['N'] = 'None';
fluor['F'] = 'Faint';
fluor['M'] = 'Medium';
fluor['S'] = 'Strong';
fluor['V'] = 'VS';

var curDiamondData;   
var totalDiamondDatas;//获取所有关于砖石的数据

//重置条件
$('input[name="reset"]').click(function() {
    $(".select-box a").removeClass("un");
    $(".select-box1 a").removeClass("un");
    $(".select-box2 a").removeClass("un");
    $(".select-box :checkbox").attr("checked", false);
    $(".select-box2 :checkbox").attr("checked", false);
});

$(function() {
	
	$("#carat-set").on("change",function(){
        var weightStr = $.trim($('#carat-set').val());
        var weightBigSmall = weightStr.split("-");
        $("#bigThanWeight").val(weightBigSmall[0]); 
        $("#smallThanWeight").val(weightBigSmall[1]);
    });
	
	
    $(".select-box a").click(function() {
        if ($(this).attr("class") == "un") {
            $(this).removeClass("un");
            $(this).next().attr("checked", false);
        } else {
            $(this).addClass("un");
            $(this).next().attr("checked", true);
        }
    });

    $(".select-box2 a").click(function() {
        if ($(this).attr("class") == "un") {
            $(this).removeClass("un");
            $(this).next().attr("checked", false);
        } else {
            $(this).addClass("un");
            $(this).next().attr("checked", true);
        }
    });


    $("#3EX").click(function() {
        if ($(this).attr("class") == "un") {
            $(this).removeClass("un");
            $("#exone").removeClass("un");
            $("#exonecheck").attr("checked", false);
            $("#extwo").removeClass("un");
            $("#extwocheck").attr("checked", false);
            $("#exthree").removeClass("un");
            $("#exthreecheck").attr("checked", false);
            $("#flnone").removeClass("un");
            $("#flnonecheck").attr("checked", false);
        } else {
            $(this).addClass("un");
            $("#exone").addClass("un");
            $("#exonecheck").attr("checked", true);
            $("#extwo").addClass("un");
            $("#extwocheck").attr("checked", true);
            $("#exthree").addClass("un");
            $("#exthreecheck").attr("checked", true);
            $("#flnone").addClass("un");
            $("#flnonecheck").attr("checked", true);
        }
    });

    $("#3EXVG").click(function() {
        if ($(this).attr("class") == "un") {
            $(this).removeClass("un");
            $("#exone").removeClass("un");
            $("#exonecheck").attr("checked", false);
            $("#extwo").removeClass("un");
            $("#extwocheck").attr("checked", false);
            $("#exthree").removeClass("un");
            $("#exthreecheck").attr("checked", false);
            $("#vgone").removeClass("un");
            $("#vgonecheck").attr("checked", false);
            $("#vgtwo").removeClass("un");
            $("#vgtwocheck").attr("checked", false);
            $("#vgthree").removeClass("un");
            $("#vgthreecheck").attr("checked", false);
        } else {
            $(this).addClass("un");
            $("#exone").addClass("un");
            $("#exonecheck").attr("checked", true);
            $("#extwo").addClass("un");
            $("#extwocheck").attr("checked", true);
            $("#exthree").addClass("un");
            $("#exthreecheck").attr("checked", true);
            $("#vgone").addClass("un");
            $("#vgonecheck").attr("checked", true);
            $("#vgtwo").addClass("un");
            $("#vgtwocheck").attr("checked", true);
            $("#vgthree").addClass("un");
            $("#vgthreecheck").attr("checked", true);
        }
    });

    $("#without").click(function() {
        if ($(this).attr("class") == "un") {
            $(this).removeClass("un");
            $('#withoutInput').attr("checked", false);
        } else {
            $(this).addClass("un");
            $('#withoutInput').attr("checked", true);
        }
    });
    
   
    
    //砖重和价格的排序
    $("#sortbyweight, #sortbyprice").on("click", function() {
    	var name =$(this).attr("data-name");
    	var flag = $(this).attr("data-order");
    	flag == 0 ? $(this).attr("data-order", 1) : $(this).attr("data-order", 0);
    	var len = 0;
    	var str = "";
    	var res;
    	//var pagesize = $(".result .f2").find("a[class=on]").attr("data-sign");
    	searchDT();
    	if(flag == 1) {
        //	res = bubble(curDiamondData, name);
        	$(this).find("img").attr("src", basePath +"include/images/c_up.jpg")
    	}else {
    	//	res = bubble(curDiamondData, name).reverse();
    		$(this).find("img").attr("src", basePath +"include/images/c_bottom.jpg")
    	}
		
    })
    
    
     //每页展示条数选择
    $(".result .f2 > a").on("click", function() {
    	$(this).addClass("on").siblings().removeClass("on");
    	 searchDT();
    })
    
  searchDT();

});

function showTableByData(res){
	var str="";
	if(res && res.length > 0) {
		for(var i = 0; i < res.length; i++) {
			str += '<tr>' +
        		    '<td>'+ res[i].shape +'</td>' +
        		    '<td>'+ res[i].nai +'</td>' +
        		    '<td>'+ res[i].ka +'</td>' +
        		    '<td>'+ res[i].carat +'</td>' +
        		    '<td>'+ res[i].color +'</td>' +
        		    '<td>'+ res[i].clarity +'</td>' +
        		    '<td>'+ res[i].cut +'</td>' +
        		    '<td>'+ res[i].polish +'</td>' +
        		    '<td>'+ res[i].semmetry +'</td>' +
        		    '<td>'+ res[i].fluor +'</td>' +
        		    '<td>' +
        		        '<font color="blue">'+ res[i].xinJian +'</font>' +
        		    '</td>' +
        		    '<td><a href="javascript:;" title="">'+ res[i].zhiJing +'</a></td>' +
        		    '<td>'+ res[i].depth +'</td>' +
        		    '<td>'+ res[i].taiMian +'</td>' +
        		    '<td>' +
        		        '<font color="red">'+ res[i].certNo +'</font>' +
        		    '</td>' +
        		    '<td>' +
        		        '<font color="red">'+ res[i].cert +'</font>' +
        		    '</td>' +
        		    '<td>' +
        		        '<font color="blue">'+ res[i].price +'</font>' +
        		    '</td>' +
        		'</tr>';
		}
		$("#searchList").html(str);
		getTablePage(100, ".listtab")
		$(".tablepage").show();
	} else {
		 document.getElementById("total").innerHTML = "0";
		$("#searchList").html('<tr><td colspan="16">暂无数据!</td></tr>');
	}
}
	//1 升序 0 降序
	function arraySortByType(arr, type) {
		arr.sort(function(a, b) {
			return a[type] < b[type];
		})
	}

	function bubble(arr, type) {
		var len = arr.length;
		for(var i = 0; i < len-1; i++){
			for(var j = 0; j< len-i-1; j++) {
				if(parseInt(arr[j][type], 10) > parseInt(arr[j+1][type], 10)) {
					var swap = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = swap;
				}
			}
		}
		return arr;
	}

    //分页函数
    function getTablePage(pageSize, id) {
        var pageSize = pageSize ? pageSize : 10, //每页显示的记录条数
            curPage = 0, //当前页
            lastPage, //最后页
            direct = 0, //方向 下一页为1, 上一页为-1
            len, //总行数
            page, //总页数
            begin,
            end;

        len = $(id + " tr").length - 1; // 求这个表的总行数，
        page = len % pageSize == 0 ? len / pageSize : Math.ceil(len / pageSize); //根据记录条数，计算页数
        curPage = 1; // 设置当前为第一页
        displayPage(); //显示第一页
        document.getElementById("btn0").innerHTML = "当前 " + curPage + "/" + page + " 页    "; // 显示当前多少页
        //document.getElementById("sjzl").innerHTML = "共 " + len + " 条记录"; // 显示数据量
        document.getElementById("total").innerHTML = len;
        //           document.getElementById("pageSize").value = pageSize;

        $("#btn1").click(function() { // 首页
            curPage = 1;
            direct = 0;
            displayPage();
        });
        $("#btn2").click(function() { // 上一页
            direct = -1;
            len = $(id + " tr").length - 1; // 求这个表的总行数，剔除第一行介绍
            page = len % pageSize == 0 ? len / pageSize : Math.ceil(len / pageSize); //根据记录条数，计算页数
            displayPage();
        });
        $("#btn3").click(function() { // 下一页
            direct = 1;
            len = $(id + " tr").length - 1; // 求这个表的总行数，剔除第一行介绍
            page = len % pageSize == 0 ? len / pageSize : Math.ceil(len / pageSize); //根据记录条数，计算页数
            
            displayPage();
        });
        $("#btn4").click(function() { // 尾页
            curPage = page;
            direct = 0;
            displayPage();
        });
        $("#btn5").click(function changePage() { // 转页
            curPage = document.getElementById("changePage").value * 1;
            if (!/^[1-9]\d*$/.test(curPage)) {
                alert("请输入正整数");
                return;
            }
            len = $(id + " tr").length - 1; // 求这个表的总行数，剔除第一行介绍
            page = len % pageSize == 0 ? len / pageSize : Math.ceil(len / pageSize); //根据记录条数，计算页数
            console.debug(curPage);
            console.debug(page);
            if (curPage > page) {
                alert("超出总页数");
                return;
            }
            direct = 0;
            displayPage();
        });

        /**
         * curpage 当前页
         * direct 上一页是 -1, 下一页是1
         * page 总页数
         * len 需要分页数据的条数
         */
        function displayPage() {
            if (curPage <= 1 && direct == -1) {
                direct = 0;
                return;
            } else if (curPage >= page && direct == 1) {
                direct = 0;
                return;
            }

            //           lastPage = curPage;

            // 修复当len=1时，curPage计算得0的bug
            if (len > pageSize) {
                curPage = ((curPage + direct + len) % len);
            } else {
                curPage = 1;
            }

            document.getElementById("btn0").innerHTML = "当前 " + curPage + "/" + page + " 页   "; // 显示当前多少页

            begin = (curPage - 1) * pageSize + 1; // 起始记录号
            end = begin + 1 * pageSize - 1; // 末尾记录号

            if (end > len) {
                end = len;
            }
            $(id + " tr").hide(); // 首先，设置这行为隐藏
            $(id + " tr").each(function(i) { // 然后，通过条件判断决定本行是否恢复显示
                if ((i >= begin && i <= end) || i == 0) //显示begin<= x <=end的记录
                    $(this).show();
            });
        }
    }
    
    function searchDT(page){
    	//后台分页显示
    	//获取约束条件数据
    	// <span id="dataLoadTips" class="f1">为您筛选出<i id="total">----</i>  颗钻石</span> 
    	$("#dataLoadTips").html("数据查询中，请稍等！");
    	var searchCondition = getSearchCondition();
    	//
    	var data = new Object();
    	data.searchCondition = encodeURI(JSON.stringify(searchCondition));
    	
    	var curPageSize = $("#pageSize a.on");
    	if(curPageSize && curPageSize.length > 0){
    		data.pageSize = curPageSize.eq(0).attr("data-sign");	
    	}else{
    		data.pageSize = 50;
    	}
    		
    	var rand = Math.random();
		if(page!=null && page!=""){
			data.pageNo=page;
		}
		data.rand = rand;
		
		$("#price_ajax_page").whpage({
			url:basePath+'mgr/getPriceDatas',
			data: data,
			showNum:5,
		//	type: 'java',
			pagesize: data.pageSize,
			cur: 'cur',
			action:'post',
			format: function(data){
				console.log(data);
				var page = page || 1;
				//var data = data.jsonData;
				var t = {};
				//
				var records = parseInt(data.total);
				$("#dataLoadTips").html('为您筛选出<i id="total">'+data.total+'</i>  颗钻石');
				pageCount = Math.ceil(data.total / data.pageSize);
				t['cur'] = data.pageNo;;
				t['pageCount'] = pageCount;
				t['records'] = records;
				 insertData(data);
				if(parseInt(data.total) > parseInt(data.pageSize)){
					$("#price_ajax_page").css('display','block');
					$("#price_ajax_page").parent().removeClass("hide");
				}else{
					$("#price_ajax_page").css('display','none');
					$("#price_ajax_page").parent().removeClass("hide").addClass("hide");
				}
				return t;	
			}
	    });
		
		
		
    	//
    	 
    	
    	
    }
    
    insertData=function(data){
//    	console.log(data);
//    	return false;
    	if(data.isOK=="true"){
    		//请求成功
    		var str = "";
    	//	$("#readNum2").text(data.count2);
    		var res = data.jsonData;
//    			$(".no-msg").removeClass("hide").addClass("hide");
//    			$("#msgBox").removeClass("hide");
//    			$("#tit").removeClass("hide");
//    			$("#alarmMessage_ajax_page").parent().removeClass("hide");
    			if(res!=[]&&res!=""&&res.length!=0) {
    				for(var i = 0; i < res.length; i++) {
    					str += '<tr>' +
    		        		    '<td>'+ res[i].shape +'</td>' +
    		        		    '<td>'+ (typeof(res[i].nai) == "undefined"?" ":res[i].nai) +'</td>' +
    		        		    '<td>'+ (typeof(res[i].ka) == "undefined"?" ":res[i].ka) +'</td>' +
    		        		    '<td>'+ res[i].carat +'</td>' +
    		        		    '<td>'+ res[i].color +'</td>' +
    		        		    '<td>'+ res[i].clarity +'</td>' +
    		        		    '<td>'+ res[i].cut +'</td>' +
    		        		    '<td>'+ res[i].polish +'</td>' +
    		        		    '<td>'+ res[i].semmetry +'</td>' +
    		        		    '<td>'+ res[i].fluor +'</td>' +
    		        		    '<td>' +
    		        		        '<font color="blue">'+ res[i].xin_jian +'</font>' +
    		        		    '</td>' +
    		        		    '<td><a href="javascript:;" title="">'+ res[i].zhi_jing +'</a></td>' +
    		        		    '<td>'+ res[i].depth +'</td>' +
    		        		    '<td>'+ res[i].tai_mian +'</td>' +
    		        		    
    		        		    '<td>' +
    		        		        '<font color="red">'+ res[i].cert +'</font>' +
    		        		    '</td>' +
    		        		    '<td>' +
    		        		        '<font color="blue">'+ res[i].price +'</font>' +
    		        		    '</td>' +
    		        		'</tr>';
    				}
    				$("#searchList").html(str);
//    				getTablePage(100, ".listtab")
//    				$(".tablepage").show();
    			} else {
    				 document.getElementById("total").innerHTML = "0";
    				$("#searchList").html('<tr><td colspan="16">暂无数据!</td></tr>');
    			}
//    			$("#data").html(str);
    		//	isBatch();
    		 			
    	}else{
    	//	MU.msgTips("warn",data.msg);
    	}
    }
    
    function getSearchCondition(){
    	var searchCondition = {};
    	var checkedShape = $('.shape-list li a.un');
    	if(checkedShape && checkedShape.length > 0){
    		var shapeCondition = new Array();
    		
    		for(var i=0;i< checkedShape.length ; i++){
    		 shapeCondition.push(checkedShape.eq(i).attr("title"));	
    		}
    		searchCondition.shapeCondition = shapeCondition;
    		console.log(shapeCondition);
    	}
    	
    	
    	var bigThanWeight =$('#bigThanWeight').val();
    	console.log(bigThanWeight);
    	if(bigThanWeight){
    		searchCondition.bigThanWeight = bigThanWeight
    	}
    	
    	var smallThanWeight =$('#smallThanWeight').val();
    	console.log(smallThanWeight);
    	if(smallThanWeight){
    		searchCondition.smallThanWeight = smallThanWeight
    	}
    	
    	var checkedColor = $('#colorUl li a.un');
    	if(checkedColor && checkedColor.length > 0){
    		var colorCondition = new Array();
    		
    		for(var i=0;i< checkedColor.length ; i++){
    			colorCondition.push(checkedColor.eq(i).attr("title"));	
    		}
    		searchCondition.colorCondition = colorCondition;
    		console.log(colorCondition);
    	}
    	
    	var checkedCut = $('#cutUl li a.un');
    	if(checkedCut && checkedCut.length > 0){
    		var cutCondition = new Array();
    		
    		for(var i=0;i< checkedCut.length ; i++){
    			cutCondition.push(checkedCut.eq(i).attr("title"));	
    		}
    		searchCondition.cutCondition = cutCondition;
    		console.log(cutCondition);
    	}
    	
    	
    	var checkedClarity = $('#clarityUl li a.un');
    	if(checkedClarity && checkedClarity.length > 0){
    		var clarityCondition = new Array();
    		
    		for(var i=0;i< checkedClarity.length ; i++){
    			clarityCondition.push(checkedClarity.eq(i).attr("title"));	
    		}
    		searchCondition.clarityCondition = clarityCondition;
    		console.log(clarityCondition);
    	}
    	
    	var checkedPolish = $('#polishUl li a.un');
    	if(checkedPolish && checkedPolish.length > 0){
    		var polishCondition = new Array();
    		
    		for(var i=0;i< checkedPolish.length ; i++){
    			polishCondition.push(checkedPolish.eq(i).attr("title"));	
    		}
    		searchCondition.polishCondition = polishCondition;
    		console.log(polishCondition);
    	}
    	
    	var checkedCert = $('#certUl li a.un');
    	if(checkedCert && checkedCert.length > 0){
    		var certCondition = new Array();
    		
    		for(var i=0;i< checkedCert.length ; i++){
    			certCondition.push(checkedCert.eq(i).attr("title"));	
    		}
    		searchCondition.certCondition = certCondition;
    		console.log(certCondition);
    	}
    	
    	var certNo = $('#certNo').val();
    	if(certNo){
    		searchCondition.certNo = certNo;
    		console.log("certNo:"+certNo);
    	}
    	
    	var checkedSymmetry = $('#symmetryUl li a.un');
    	if(checkedSymmetry && checkedSymmetry.length > 0){
    		var symmetryCondition = new Array();
    		
    		for(var i=0;i< checkedSymmetry.length ; i++){
    			symmetryCondition.push(checkedSymmetry.eq(i).attr("title"));	
    		}
    		searchCondition.symmetryCondition = symmetryCondition;
    		console.log(searchCondition.symmetryCondition);
    	}
    	
    	var price = $('#price').val();
    	if(price){
    		searchCondition.price = price;
    		console.log("price:"+price);
    	}
    	
    	var checkedFluor = $('#fluorUl li a.un');
    	if(checkedFluor && checkedFluor.length > 0){
    		var fluorCondition = new Array();
    		
    		for(var i=0;i< checkedFluor.length ; i++){
    			fluorCondition.push(checkedFluor.eq(i).attr("title"));	
    		}
    		searchCondition.fluorCondition = fluorCondition;
    		console.log(searchCondition.fluorCondition);
    	}
    	
    	if($('#without').hasClass('un')){
    		searchCondition.withoutNK = true;
    	}else{
    		searchCondition.withoutNK = false;
    	}
    	
    	searchCondition.sortbyweight = $("#sortbyweight").attr("data-order");
    	searchCondition.sortbyprice = $("#sortbyprice").attr("data-order");
    	console.log(searchCondition.withoutNK);
    	
    	
    	return searchCondition;
    	
    	
    	
//    	
//    	
//    	
//    	mycars[0]="Saab"
//    		mycars[1]="Volvo"
//    		mycars[2]="BMW"
    }
    
    function checkNum(e) { 
        var re = /^\d+(?=\.{0,1}\d+$|$)/ 
        if (e.value != "") { 
            if (!re.test(e.value)) { 
               // alert("请输入正确的数字"); 
                e.value = ""; 
                e.focus(); 
            } 
        } 
    } 
    
    
    
    