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
									    '<td><a class="arc-edit" href="javascript:;" data-sign="'+ res[i].id +'">修改</a> | <a class="arc-delete" href="javascript:;">删除</a></td>' +
									    '</tr>';
						}
						$(".arc-lists-tbody").html(stringTr);
						//调用datatables
//				        TableEditable.init();
						_that.useDataTable();
					}
				}else {
					
				}
			})
		},

		useDataTable: function() {

		    function filterColumn(i) {
		        $('#sample_editable_1').DataTable().column(i).search(
		            $('#col' + i + '_filter').val()
		        ).draw();
		    }

		    $(function() {
		        $('#sample_editable_1').DataTable({
			         "responsive": true,
			         "bInfo": false,         //页脚信息
			         "bLengthChange": false, //改变每页显示数据数量
			         "iDisplayLength": 10,    //每页显示数目
//			         "searching":false,
			         "bProcessing": true,    //加载数据时显示正在加载信息
			         "oLanguage": {
			             "sLengthMenu": "每页显示 _MENU_ 条记录",
			             "sZeroRecords": "抱歉， 没有找到",
			             "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
			             "sInfoEmpty": "没有数据",
			             "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
			             "sSearch": "搜索：",
			             "oPaginate": {
			                 "sFirst": "首页",
			                 "sPrevious": "前一页",
			                 "sNext": "后一页",
			                 "sLast": "尾页"
			             },
			             "sZeroRecords": "没有检索到数据",
			         }
			     });
		        $("#sample_editable_1_wrapper").find("div").eq(0).hide();
		        $('input.column_filter').on('keyup click', function() {
		            filterColumn($(this).parents('tr').attr('data-column'));
		        });
		    });
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