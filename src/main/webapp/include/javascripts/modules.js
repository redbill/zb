!function(){
	var modules = {
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
	};
	modules.commonAjax(basePath + "getArticleList","", "GET", function(result) {
		console.log(result)
	})
}()