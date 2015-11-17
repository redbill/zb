!function() {
    var modules = {
    	allParam: function() {
    		return {
    			"cat" : {"品牌": "1000","产品":"1001", "活动":"1002", "客服": "1003", "联系我们": "1004", "其它": "1005"}
    		};
    	},
    	
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
                    console.log(result);
                    if (resLen > 0) {
                        for (var i = 0; i < resLen; i++) {
                            stringTr += '<tr class="" data-sign=' + res[i].id + '>' +
                                '<td>' + res[i].title + '</td>' +
                                '<td>' + res[i].nameModule + '</td>' +
                                '<td>' + _that.timestampFormat(res[i].createTime / 1000) + '</td>' +
                                '<td><a class="arc-edit" href="javascript:;" data-sign="' + res[i].id + '" data-cat="'+ _that.allParam().cat[$.trim(res[i].nameModule)] +'">修改</a> | <a class="arc-delete" href="javascript:;" data-sign="'+ res[i].id +'">删除</a></td>' +
                                '</tr>';
                        }
                        
                        $(".arc-lists-tbody").html(stringTr);

                        _that.useDataTable();
                    }else {
                    	stringTr = '<tr><td colspan="4" style="text-align: center;">暂无数据</td></tr>';
                    	$(".arc-lists-tbody").html(stringTr);
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
            var sign, cat;
            $(document.body).on("click", ".arc-edit", function() {
                sign = $(this).attr("data-sign");
                cat = $(this).attr("data-cat");
                location.href =  basePath + "mgr/addArticle?id=" + sign + "&cat=" + cat;
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
        	
        	$(document.body).on("click", "#delete-yes", function() {
              _that.commonAjax(basePath + "delArticle", {id: sign}, "POST", function(result) {
	            	if(result.isOK === "true") {
	            		$('#tip-pop > .modal-footer').hide();
	            		$(".modal-body").find("h4").text("文章删除成功");
	            		setTimeout(function() {
	            			$('#tip-pop').modal('hide');
		            		location.reload();
	            		}, 1400);
	            	} else {
	            		$('#tip-pop > .modal-footer').hide();
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
        	if(!!id && !!cat) {
        		_that.commonAjax(basePath + "getArticleById", {id: id}, "POST", function(result) {
        			if(result.isOK === "true"){
        				var data = result.jsonData,
        					len = data.length;
        				
        				if(data.codeModule == "1001") {
            				$("#img-up").show();
            				$("#img-show").show();
            				if(!!data.preImg) {
            					$("#img-show").show().find("img").attr("src", basePath + "uploadImg/" +data.preImg);
            				}
        					$("#img-up-home").show();
            				$("#img-show-home").show();
            				if(!!data.homeImg) {
            					$("#img-show-home").show().find("img").attr("src", basePath + "uploadImg/" +data.homeImg);
            				}
        					$("#img-up-small").show();
            				$("#img-show-small").show();
            				if(!!data.smallImg) {
            					$("#img-show-small").show().find("img").attr("src", basePath + "uploadImg/" +data.smallImg);
            				}
        				} else {
            				$("#img-up").hide();
            				$("#img-show").hide();
            				
            				$("#img-up-home").hide();
            				$("#img-show-home").hide();
            				
            				$("#img-up-small").hide();
            				$("#img-show-small").hide();
        				}
        				
        				
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
        	var msg = "文章添加成功！";
        	
        	$("#sava_arcticle").on("click", function() {
        		//标题不得为空
        		var title = $.trim($form.eq(0).find("input").val());
        		if(!!title) {
        			dataAddArcticle.title = title
        		}else {
        			$form.eq(0).find("span").text("标题不能为空！")
        			return;
        		}
        		
        		var productCode = $form.find("select").val();
        		dataAddArcticle.codeModule = productCode;
        		
        		//产品模块 需要传递preImg参数
        		if(productCode === '1001') {
        			dataAddArcticle.preImg = $("#hidFileID").attr('data-img');
        			dataAddArcticle.homeImg = $("#hidFileID-home").attr('data-img');
        			dataAddArcticle.smallImg = $("#hidFileID-small").attr('data-img');
        		}
        		
        		dataAddArcticle.content = editor.getContent() ? editor.getContent() : "";
        		
            	if(!!id) {
            		dataAddArcticle.id = id;
            		msg = "文章修改成功！"
            	}
            	
            	_that.commonAjax(
        			basePath + "addOrEditArticle", 
        			dataAddArcticle, 
					"POST", 
					function(result) {
		    			if(result.isOK === "true"){
		            		$('#tip-pop').modal();
		            		$('#tip-pop > .modal-footer').hide();
		            		$('#tip-pop > .modal-body').find("h4").text(msg);
		            		setTimeout(function() {
		            			$('#tip-pop').modal('hide');
		            			location.reload();
		            		}, 1200)
		    			} else {
		    				$('#tip-pop').modal();
		            		$('#tip-pop > .modal-footer').hide();
		            		$('#tip-pop > .modal-body').find("h4").text(result.msg);
		    			}
        			});
        	});
        	
        },
        //产品模块要上传单图片
        imgUploadShowOrHide: function() {
        	$("#cat-select").on("change", function() {
        		($(this).val() === '1001') ? (function() {
        			$("#img-up").show()
        			$("#img-show").show()
        			$("#img-up-home").show()
        			$("#img-show-home").show()
        			$("#img-up-small").show()
        			$("#img-show-small").show()
        		}()) : (function() {
        			$("#img-up").hide()
        			$("#img-show").hide()
        			$("#img-up-home").hide()
        			$("#img-show-home").hide()
        			$("#img-up-small").hide()
        			$("#img-show-small").hide()
        		}());
        	})
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
