!function(){
	var modules = {
			/**
			 * ajax 共用
			 */
		commonAjax: function(url, data, type, succFunc) {
			return $.ajax({
				url: url || "",
				data: data || {},
				type: type || "GET",
				success: succFunc || function(res){console.log("url= "+ url +" succ方法传入错误")},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
                    console.log(XMLHttpRequest.status);
                    console.log(XMLHttpRequest.readyState);
                    console.log(textStatus);
                }
			});
		},
		/**
		 * 所有文章列表展示
		 */
		getArticleLists: function() {
			var _that = this;
			_that.commonAjax(basePath + "getArticleList","", "GET", function(result) {
				if(result.isOK === "true"){
					var res = result.jsonData,
						resLen = res.length,
						stringTr = "";
					
					if(resLen > 0) {
						for(var i = 0; i < resLen; i++){
							stringTr = '<tr class="" data-sign='+ res[i].id  +'>' +
									    '<td>'+ res[i].title +'</td>' +
									    '<td>'+ _that.timestampFormat( res[i].createTime / 1000 ) +'</td>' +
									    '<td>'+ res[i].nameModule +'</td>' +
									    '<td><a class="arc-edit" href="javascript:;">修改</a> | <a class="arc-delete" href="javascript:;">删除</a></td>' +
									    '</tr>';
						}
						$(".arc-lists-tbody").html(stringTr);
						//调用datatables
				        TableEditable.init();
					}
				}else {
					
				}
			})
		},
		/**
		 * 使用moment插件 格式化时间戳成特定形式的时间
		 * @timestamp 时间戳 单位秒
		 * @type 展示的时间形式
		 */
		timestampFormat: function(timestamp, type) {
			return moment(
							moment.unix( timestamp || moment() / 1000 )
							).format( type || "YYYY-MM-DD HH:mm:ss" );
		}
		
		
	};
	
	modules.getArticleLists();
	
	
	
	
	
}()