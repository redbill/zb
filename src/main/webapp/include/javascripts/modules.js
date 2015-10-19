! function() {
    var modules = {
    	allParam: function() {
    		return {
    			"cat" : {"1000": "品牌","1001":"产品", "1002":"活动", "1003": "客服"}
    		};
    	},
        /**
         * ajax 共用
         */
        commonAjax: function(url, data, type, succFunc) {
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
        },
        /**
         * 所有文章列表展示
         */
        getArticleLists: function() {
            var _that = this;
            _that.commonAjax(basePath + "getArticleList", "", "GET", function(result) {
                if (result.isOK === "true") {
                    var res = result.jsonData,
                        resLen = res.length,
                        stringTr = "";
                    console.log("文章列表数据条数: " +resLen);
                    if (resLen > 0) {
                        for (var i = 0; i < resLen; i++) {
                            stringTr += '<tr class="" data-sign=' + res[i].id + '>' +
                                '<td>' + res[i].title + '</td>' +
                                '<td>' + res[i].nameModule + '</td>' +
                                '<td>' + _that.timestampFormat(res[i].createTime / 1000) + '</td>' +
                                '<td><a class="arc-edit" href="javascript:;" data-sign="' + res[i].id + '">修改</a> | <a class="arc-delete" href="javascript:;" data-sign="'+ res[i].id +'">删除</a></td>' +
                                '</tr>';
                        }
                        $(".arc-lists-tbody").html(stringTr);
                        //调用datatables
                        _that.useDataTable();
                    }
                } else {

                }
            })
        },
        /**
         * 调用datatables插件
         */
        useDataTable: function() {

            function filterColumn(i) {
                $('#sample_editable_1').DataTable().column(i).search(
                    $('#col' + i + '_filter').val()
                ).draw();
            }

            function filterSelect(i) {
                $('#sample_editable_1').DataTable().column(i).search(
                    $('#col' + i + '_filter').val()
                ).draw();
            }
            
            $(function() {
                $('#sample_editable_1').DataTable({
                    "responsive": true,
                    "bInfo": false, //页脚信息
                    "bLengthChange": false, //改变每页显示数据数量
                    "iDisplayLength": 10, //每页显示数目
                    //"searching":false,
                    "bProcessing": true, //加载数据时显示正在加载信息
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
                $("#sample_editable_1_wrapper").find("div").eq(0).hide(); //隐藏全局搜索框
                $('input.column_filter').on('keyup click', function() {
                    filterColumn($(this).parents('tr').attr('data-column'));
                });
                $("select.column_filter").on("change", function() {
                	filterColumn($(this).parents('tr').attr('data-column'));
                })
            });
        },
        /**
         * 修改文章
         */
        editArticleBtn: function() {
        	var _that = this;
            var sign;
            $(document.body).on("click", ".arc-edit", function() {
                sign = $(this).attr("data-sign");
                location.href =  basePath + "mgr/addArticle?id=" + sign;
            })
        },
        /**
         * 删除文章
         */
        deleteArticle: function() {
        	var _that = this;
            var sign;
        	$(document.body).on("click", ".arc-delete", function() {
        		sign = $(this).attr("data-sign");
        		$('#tip-pop').modal();
        	});
        	
        	$("#delete-yes").on("click", function() {
              _that.commonAjax(basePath + "delArticle", {id: sign}, "POST", function(result) {
	            	if(result.isOK === "true") {
	            		$('#tip-pop').modal('hide');
	            		location.href = basePath + "mgr/articleList";
//	            		 var res = result.jsonData,
//	                        resLen = res.length,
//	                        stringTr = "";
//
//	                    if (resLen > 0) {
//	                        for (var i = 0; i < resLen; i++) {
//	                            stringTr += '<tr class="" data-sign=' + res[i].id + '>' +
//	                                '<td>' + res[i].title + '</td>' +
//	                                '<td>' + _that.timestampFormat(res[i].createTime / 1000) + '</td>' +
//	                                '<td>' + res[i].nameModule + '</td>' +
//	                                '<td><a class="arc-edit" href="javascript:;" data-sign="' + res[i].id + '">修改</a> | <a class="arc-delete" href="javascript:;" data-sign="'+ res[i].id +'">删除</a></td>' +
//	                                '</tr>';
//	                        }
//	                        $(".arc-lists-tbody").html();
//	                        $(".arc-lists-tbody").html(stringTr);
//	                        //调用datatables
//	                        _that.useDataTable();
//	                    }
	            	} else {
	            		$(".modal-body").find("h4").text("删除文章失败");
	            	}
	            });
        	});
        	
        },
        /**
         * 编辑文章内容
         */
        editArticleContent: function() {
        	var _that = this;
        	if(!!id) {
        		_that.commonAjax(basePath + "getArticleById", {id: id}, "POST", function(result) {
        			if(result.isOK === "true"){
        				var data = result.jsonData,
        					len = data.length;
        				// {codeModule: "1001", content: "123", 
        				//createTime: 1444120129000, id: 1, title: "123"}
        				$(".m-wrap").val(data.title || "");
        				$("select.m-wrap > option[value="+ data.codeModule +"]").attr("selected", true);
        				editor.addListener("ready", function () { //ueditor 设置内容,必须等编辑器初始化完成
        	                editor.setContent(data.content);
        				});
        			} else {
        				console.log(result.msg)
        			}
        		});
        	}
        },
        /**
         * 添加文章
         */
        addArticleByAjax: function() {
        	var _that = this;
        	var dataAddArcticle = {};
        	var cat = _that.allParam().cat;
        	var $form =  $("#add_article_form > .control-group");
        	$("#sava_arcticle").on("click", function() {
        		dataAddArcticle.title = $form.find("input").val();
        		dataAddArcticle.codeModule = $form.find("select").val();
        		dataAddArcticle.content = editor.getContent();
            	console.log(dataAddArcticle);
            	if(!!id) {
            		dataAddArcticle.id = id;
            	}
            	_that.commonAjax(
            			basePath + "addOrEditArticle", 
            			dataAddArcticle, 
    					"POST", 
    					function(result) {
    		    			if(result.isOK === "true"){
    		            		$('#tip-pop').modal();
    		            		$('#tip-pop > .modal-footer').hide();
    		            		$('#tip-pop > .modal-body').find("h4").text("文章添加成功");
    		            		setTimeout(function() {
    		            			$('#tip-pop').modal('hide');
    		            			location.reload();
    		            		}, 1200)
    		    			} else {
    		    				$('#tip-pop').modal();
    		            		$('#tip-pop > .modal-footer').hide();
    		            		$('#tip-pop > .modal-body').find("h4").text("文章添加失败,请重新添加");
    		    			}
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
                moment.unix(timestamp || moment() / 1000)
            ).format(type || "YYYY-MM-DD HH:mm:ss");
        }


    };

    window.modules = modules;



}()
