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

var totalDiamondData;   //获取所有关于砖石的数据

//重置条件
$('input[name="reset"]').click(function() {
    $(".select-box a").removeClass("un");
    $(".select-box1 a").removeClass("un");
    $(".select-box2 a").removeClass("un");
    $(".select-box :checkbox").attr("checked", false);
    $(".select-box2 :checkbox").attr("checked", false);
});

$(function() {
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
    
    //每页展示条数选择
    $(".result .f2 > a").on("click", function() {
    	var sign = 0;
    	$(this).addClass("on").siblings().removeClass("on");
    	sign = $(this).attr("data-sign");
    	getTablePage(sign, ".listtab");
    })
    
    //砖重和价格的排序
    $("#sortbyweight, #sortbyprice").on("click", function() {
    	var name =$(this).attr("data-name");
    	var flag = $(this).attr("data-order");
    	flag == 0 ? $(this).attr("data-order", 1) : $(this).attr("data-order", 0);
    	var len = 0;
    	var str = "";
    	var res;
    	var pagesize = $(".result .f2").find("a[class=on]").attr("data-sign");
    	if(flag == 1) {
        	res = bubble(totalDiamondData, name);
        	$(this).find("img").attr("src", basePath +"include/images/c_up.jpg")
    	}else {
    		res = bubble(totalDiamondData, name).reverse();
    		$(this).find("img").attr("src", basePath +"include/images/c_bottom.jpg")
    	}
		len = res.length;
		if(len > 0) {
    		for(var i = 0; i < len; i++) {
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
    		$("#searchList").html();
    		$("#searchList").html(str);
    		getTablePage(pagesize, ".listtab")
    		$(".tablepage").show();
		} else {
			$("#searchList").html('<tr><td colspan="16">暂无数据!</td></tr>');
		}
    })
    
    
    //获得砖石页面所有的数据
    $.ajax({
        url: basePath + "mgr/getPriceDatas",
        data: {},
        dataType: "json",
        type: "POST",
        success: function(result) {

            if(result.isOK === "true"){
            	var res = result.jsonData,
            		len = res.length,
            		str = "";
            	totalDiamondData = res;
            	
            	if(len > 0) {
            		for(var i = 0; i < len; i++) {
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
            		getTablePage(30, ".listtab")
            		$(".tablepage").show();
            	} else {
            		$("#searchList").html('<tr><td colspan="16">暂无数据!</td></tr>');
            	}
            }
        }
    })

});
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