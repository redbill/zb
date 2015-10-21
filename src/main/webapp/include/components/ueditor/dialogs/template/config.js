/**
 * Created with JetBrains PhpStorm.
 * User: xuheng
 * Date: 12-8-8
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
var templates = [
//    {
//        "pre":"pre0.png",
//        'title':lang.blank,
//        'preHtml':'<p class="ue_t">&nbsp;欢迎使用UEditor！</p>',
//        "html":'<p class="ue_t">欢迎使用UEditor！</p>'
//
//    },
//    {
//        "pre":"pre1.png",
//        'title':lang.blog,
//        'preHtml':'<h1 label="Title center" name="tc" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;"><span style="color:#c0504d;">深入理解Range</span></h1><p style="text-align:center;"><strong class=" ">UEditor二次开发</strong></p><h3><span class=" " style="font-family:幼圆">什么是Range</span></h3><p style="text-indent:2em;">对于“插入”选项卡上的库，在设计时都充分考虑了其中的项与文档整体外观的协调性。 </p><br /><h3><span class=" " style="font-family:幼圆">Range能干什么</span></h3><p style="text-indent:2em;">在“开始”选项卡上，通过从快速样式库中为所选文本选择一种外观，您可以方便地更改文档中所选文本的格式。</p>',
//        "html":'<h1 class="ue_t" label="Title center" name="tc" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;"><span style="color:#c0504d;">[键入文档标题]</span></h1><p style="text-align:center;"><strong class="ue_t">[键入文档副标题]</strong></p><h3><span class="ue_t" style="font-family:幼圆">[标题 1]</span></h3><p class="ue_t"  style="text-indent:2em;">对于“插入”选项卡上的库，在设计时都充分考虑了其中的项与文档整体外观的协调性。 您可以使用这些库来插入表格、页眉、页脚、列表、封面以及其他文档构建基块。 您创建的图片、图表或关系图也将与当前的文档外观协调一致。</p><h3><span class="ue_t" style="font-family:幼圆">[标题 2]</span></h3><p class="ue_t"  style="text-indent:2em;">在“开始”选项卡上，通过从快速样式库中为所选文本选择一种外观，您可以方便地更改文档中所选文本的格式。 您还可以使用“开始”选项卡上的其他控件来直接设置文本格式。大多数控件都允许您选择是使用当前主题外观，还是使用某种直接指定的格式。 </p><h3><span class="ue_t" style="font-family:幼圆">[标题 3]</span></h3><p class="ue_t">对于“插入”选项卡上的库，在设计时都充分考虑了其中的项与文档整体外观的协调性。 您可以使用这些库来插入表格、页眉、页脚、列表、封面以及其他文档构建基块。 您创建的图片、图表或关系图也将与当前的文档外观协调一致。</p><p class="ue_t"><br /></p>'
//
//    },
/*    {
        "pre":"pre2.png",
        'title':lang.resume,
        'preHtml':'<h1 label="Title left" name="tl" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;"><span style="color:#e36c09;" class=" ">WEB前端开发简历</span></h1><table width="100%" border="1" bordercolor="#95B3D7" style="border-collapse:collapse;"><tbody><tr><td width="100" style="text-align:center;"><p><span style="background-color:transparent;">插</span><br /></p><p>入</p><p>照</p><p>片</p></td><td><p><span style="background-color:transparent;"> 联系电话：</span><span class="ue_t" style="background-color:transparent;">[键入您的电话]</span><br /></p><p><span style="background-color:transparent;"> 电子邮件：</span><span class="ue_t" style="background-color:transparent;">[键入您的电子邮件地址]</span><br /></p><p><span style="background-color:transparent;"> 家庭住址：</span><span class="ue_t" style="background-color:transparent;">[键入您的地址]</span><br /></p></td></tr></tbody></table><h3><span style="color:#E36C09;font-size:20px;">目标职位</span></h3><p style="text-indent:2em;" class=" ">WEB前端研发工程师</p><h3><span style="color:#e36c09;font-size:20px;">学历</span></h3><p><span style="display:none;line-height:0px;" id="_baidu_bookmark_start_26">﻿</span></p><ol style="list-style-type:decimal;"><li><p><span class="ue_t">[起止时间]</span> <span class="ue_t">[学校名称] </span> <span class="ue_t">[所学专业]</span> <span class="ue_t">[所获学位]</span></p></li></ol><h3><span style="color:#e36c09;font-size:20px;" class="ue_t">工作经验</span></h3><p><br /></p>',
        "html":'<h1 label="Title left" name="tl" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;"><span style="color:#e36c09;" class="ue_t">[此处键入简历标题]</span></h1><p><span style="color:#e36c09;"><br /></span></p><table width="100%" border="1" bordercolor="#95B3D7" style="border-collapse:collapse;"><tbody><tr><td width="200" style="text-align:center;" class="ue_t">【此处插入照片】</td><td><p><br /></p><p> 联系电话：<span class="ue_t">[键入您的电话]</span></p><p><br /></p><p> 电子邮件：<span class="ue_t">[键入您的电子邮件地址]</span></p><p><br /></p><p> 家庭住址：<span class="ue_t">[键入您的地址]</span></p><p><br /></p></td></tr></tbody></table><h3><span style="color:#e36c09;font-size:20px;">目标职位</span></h3><p style="text-indent:2em;" class="ue_t">[此处键入您的期望职位]</p><h3><span style="color:#e36c09;font-size:20px;">学历</span></h3><p><span style="display:none;line-height:0px;" id="_baidu_bookmark_start_26">﻿</span></p><ol style="list-style-type:decimal;"><li><p><span class="ue_t">[键入起止时间]</span> <span class="ue_t">[键入学校名称] </span> <span class="ue_t">[键入所学专业]</span> <span class="ue_t">[键入所获学位]</span></p></li><li><p><span class="ue_t">[键入起止时间]</span> <span class="ue_t">[键入学校名称]</span> <span class="ue_t">[键入所学专业]</span> <span class="ue_t">[键入所获学位]</span></p></li></ol><h3><span style="color:#e36c09;font-size:20px;" class="ue_t">工作经验</span></h3><ol style="list-style-type:decimal;"><li><p><span class="ue_t">[键入起止时间]</span> <span class="ue_t">[键入公司名称]</span> <span class="ue_t">[键入职位名称]</span> </p></li><ol style="list-style-type:lower-alpha;"><li><p><span class="ue_t">[键入负责项目]</span> <span class="ue_t">[键入项目简介]</span></p></li><li><p><span class="ue_t">[键入负责项目]</span> <span class="ue_t">[键入项目简介]</span></p></li></ol><li><p><span class="ue_t">[键入起止时间]</span> <span class="ue_t">[键入公司名称]</span> <span class="ue_t">[键入职位名称]</span> </p></li><ol style="list-style-type:lower-alpha;"><li><p><span class="ue_t">[键入负责项目]</span> <span class="ue_t">[键入项目简介]</span></p></li></ol></ol><p><span style="color:#e36c09;font-size:20px;">掌握技能</span></p><p style="text-indent:2em;"> &nbsp;<span class="ue_t">[这里可以键入您所掌握的技能]</span><br /></p>'

    },*/
//    {
//        "pre":"pre3.png",
//        'title':lang.richText,
//        'preHtml':'<h1 label="Title center" name="tc" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;" class="ue_t">[此处键入文章标题]</h1><p><img src="http://img.baidu.com/hi/youa/y_0034.gif" width="150" height="100" border="0" hspace="0" vspace="0" style="width:150px;height:100px;float:left;" />图文混排方法</p><p>图片居左，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居左对齐，然后即可在右边输入多行文</p><p><br /></p><p><img src="http://img.baidu.com/hi/youa/y_0040.gif" width="100" height="100" border="0" hspace="0" vspace="0" style="width:100px;height:100px;float:right;" /></p><p>还有没有什么其他的环绕方式呢？这里是居右环绕</p><p><br /></p><p>欢迎大家多多尝试，为UEditor提供更多高质量模板！</p>',
//        "html":'<p><br /></p><h1 label="Title center" name="tc" style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;text-align:center;margin:0px 0px 20px;" class="ue_t">[此处键入文章标题]</h1><p><img src="http://img.baidu.com/hi/youa/y_0034.gif" width="300" height="200" border="0" hspace="0" vspace="0" style="width:300px;height:200px;float:left;" />图文混排方法</p><p>1. 图片居左，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居左对齐，然后即可在右边输入多行文本</p><p><br /></p><p>2. 图片居右，文字围绕图片排版</p><p>方法：在文字前面插入图片，设置居右对齐，然后即可在左边输入多行文本</p><p><br /></p><p>3. 图片居中环绕排版</p><p>方法：亲，这个真心没有办法。。。</p><p><br /></p><p><br /></p><p><img src="http://img.baidu.com/hi/youa/y_0040.gif" width="300" height="300" border="0" hspace="0" vspace="0" style="width:300px;height:300px;float:right;" /></p><p>还有没有什么其他的环绕方式呢？这里是居右环绕</p><p><br /></p><p>欢迎大家多多尝试，为UEditor提供更多高质量模板！</p><p><br /></p><p>占位</p><p><br /></p><p>占位</p><p><br /></p><p>占位</p><p><br /></p><p>占位</p><p><br /></p><p>占位</p><p><br /></p><p><br /></p>'
//    },
//    {
//        "pre":"pre4.png",
//        'title':lang.sciPapers,
//        'preHtml':'<h2 style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;text-align:center;" class="ue_t">[键入文章标题]</h2><p><strong><span style="font-size:12px;">摘要</span></strong><span style="font-size:12px;" class="ue_t">：这里可以输入很长很长很长很长很长很长很长很长很差的摘要</span></p><p style="line-height:1.5em;"><strong>标题 1</strong></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">这里可以输入很多内容，可以图文混排，可以有列表等。</span></p><p style="line-height:1.5em;"><strong>标题 2</strong></p><ol style="list-style-type:lower-alpha;"><li><p class="ue_t">列表 1</p></li><li><p class="ue_t">列表 2</p></li><ol style="list-style-type:lower-roman;"><li><p class="ue_t">多级列表 1</p></li><li><p class="ue_t">多级列表 2</p></li></ol><li><p class="ue_t">列表 3<br /></p></li></ol><p style="line-height:1.5em;"><strong>标题 3</strong></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">来个文字图文混排的</span></p><p style="text-indent:2em;"><br /></p>',
//        'html':'<h2 style="border-bottom-color:#cccccc;border-bottom-width:2px;border-bottom-style:solid;padding:0px 4px 0px 0px;margin:0px 0px 10px;text-align:center;" class="ue_t">[键入文章标题]</h2><p><strong><span style="font-size:12px;">摘要</span></strong><span style="font-size:12px;" class="ue_t">：这里可以输入很长很长很长很长很长很长很长很长很差的摘要</span></p><p style="line-height:1.5em;"><strong>标题 1</strong></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">这里可以输入很多内容，可以图文混排，可以有列表等。</span></p><p style="line-height:1.5em;"><strong>标题 2</strong></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">来个列表瞅瞅：</span></p><ol style="list-style-type:lower-alpha;"><li><p class="ue_t">列表 1</p></li><li><p class="ue_t">列表 2</p></li><ol style="list-style-type:lower-roman;"><li><p class="ue_t">多级列表 1</p></li><li><p class="ue_t">多级列表 2</p></li></ol><li><p class="ue_t">列表 3<br /></p></li></ol><p style="line-height:1.5em;"><strong>标题 3</strong></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">来个文字图文混排的</span></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">这里可以多行</span></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">右边是图片</span></p><p style="text-indent:2em;"><span style="font-size:14px;" class="ue_t">绝对没有问题的，不信你也可以试试看</span></p><p><br /></p>'
//    },
    {
        "pre":"pre4.png",
        'title': "自定义1",
        'preHtml':'自定义模板1 - 四列展示',
        'html':'<div id="dd" style="position: relative;z-index: 0; width:1000px; font-size: 13px; background: #e9daab; color:#526351;">' +
		    '<div style="float:left; width: 245px;min-height: 470px;border: 1px solid #33672d; background: #e9daab;">' +
		        '<h1 class="ct"><img src="" width="227" height="35"></h1>' +
		        '<div>' +
		            '<p>&nbsp;</p>' +
		            '<p style="padding:1px 10px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;从一家实力雄厚的国际钻石贸易商到蜚声国际零售订制珠宝品牌，MONETA的传奇故事有如一个童话。而这个美丽传奇始于1990年的一次邂逅。</p>' +
		            '<p style="padding:1px 10px;">' +
		                '<br> &nbsp;&nbsp;&nbsp;MONETA在意大利语中，是瑰丽晨曦的意思，而MONETA,也是一名美丽意大利女孩的名字......</p>' +
		            '<p style="padding:1px 10px;">' +
		                '<br> &nbsp; 1990年，MONETA品牌的创始人，30岁的FEANCIS IBERT（小伊贝尔特）继承了家族传承百年的钻石国际贸易和钻石工厂业务，并始终关注着高级定制珠宝的终端市场，这位眼光高远的年轻人一直密切关注着高端零售珠宝的发展，他希望将自己的才华更大限度的得到释放，更加贴近客户的需求。为了考察市场，更准确地把握瞬息万变的珠宝潮流，伊贝尔特开始了游历欧洲的旅程。</p>' +
		        '</div>' +
		    '</div>' +
		    '<div style="float:left; width: 245px;min-height: 470px;border: 1px solid #33672d; background: #e9daab;">' +
		        '<p>&nbsp;</p>' +
		        '<p>&nbsp;</p>' +
		        '<p style="padding:1px 10px;">&nbsp;&nbsp;&nbsp;&nbsp;' +
		            '<br> &nbsp;&nbsp;&nbsp;&nbsp; 伊贝尔特在意大利拿波里期间，邂逅了一位女郎，随即沉浸在了爱河之中，爱情不仅孕育出了MONETA的品牌传奇，更带给伊贝尔特一种从未有过的自信，创作了传世制作—“日出”，一件2.99克拉艳彩粉色钻石戒指，作为铭记他们爱情的信物。爱情的灵感，让小伊贝尔特终于明确了自己奋斗的目标-将百年家族传统沉淀彩色钻石加工为主的经营方式融合珠宝私人会所销售方式为客户进行量身珠宝定制服务，建立了私人高级珠宝定制会所。坚定了信心后，小伊贝尔特于1992年，在欧洲建立了第一家高级钻石私人定制会所，并以爱人的名字MONETA命名了品牌名称。</p>' +
		        '<p style="padding:1px 10px;">&nbsp;&nbsp;' +
		            '<br> &nbsp;&nbsp;&nbsp;&nbsp;MONETA,是晨曦，是爱人的名字，也是希腊神话中女神的名字，如果说白钻代表着持久的爱情，那么，瑰丽而独一无二的彩色钻石，代表的是浪漫与炙热以及永不停息的爱，是比白色钻石更加瑰丽的爱情讼诗。</p>' +
		    '</div>' +
		    '<div style="float:left; width: 245px;min-height: 470px;border: 1px solid #33672d; background: #e9daab;">' +
		        '<p>&nbsp;</p>' +
		        '<p>&nbsp;</p>' +
		        '<p style="padding:1px 10px;">' +
		            '<br> &nbsp; &nbsp;小伊贝尔的MONET品牌主要以做工精良的彩钻首饰为主产品。他不断在唯一、传世的定制理念下创造出更多的精美的珠宝作品。伊贝尔特的创新之举在欧洲创造了一个全新的家族商业模式，并在上流社会取得了良好口碑。MONETA品牌就此正式诞生。2002年，MONETA品牌建立10周年之季，伊贝尔特把“日出”作为镇馆之宝永久地保存起来。这枚象征了美好爱情的钻饰，也象蒸蒸日上的朝阳一样，为MONETA品牌演绎着一个又一个MONETA的品牌传奇。&nbsp;</p>' +
		    '</div>' +
		    '<div style="float:left; width: 245px;min-height: 470px;border: 1px solid #33672d; background: #e9daab;">' +
		        '<p>&nbsp;</p>' +
		        '<p>' +
		            '<br>' +
		            '<br> <img alt="" width="220" height="275" src="" style="padding-left: 10px"></p>' +
		    '</div>' +
		    '<div style="clear:both"></div>' +
		'</div>'
    },
    {
        "pre":"pre4.png",
        'title': "自定义2",
        'preHtml':'自定义模板2 - 四列展示',
        'html':'<div style="position: relative;z-index: 0; width:1000px; font-size: 13px; background: #e9daab; color:#526351;">' +
		    '<div style="float:left; width: 245px;min-height: 470px; border: 1px solid #33672d; background: #e9daab;">' +
		        '<h1><img src="" width="227" height="35"></h1>' +
		        '<!--<h2>企业介绍</h2>-->' +
		        '<div>' +
		            '<p style="padding:1px 10px;">&nbsp;&nbsp;&nbsp; xxxxxx</p>' +
		            '<p style="padding:1px 10px;">&nbsp; &nbsp;xxxxxxx</p>' +
		            '<p style="padding:1px 10px;">&nbsp; &nbsp;xxxxxxx</p>' +
		            '<p style="padding:1px 10px;">&nbsp; &nbsp; &nbsp;xxxxxxx</p>' +
		        '</div>' +
		    '</div>' +
		    '<div style="float:left; width: 245px;min-height: 470px; border: 1px solid #33672d; background: #e9daab;">' +
		        '<p style="padding:2px">&nbsp;&nbsp;</p>' +
		        '<p style="padding:1px 10px;">' +
		            '<br> &nbsp;&nbsp; &nbsp;经过与中国合作伙伴的长时间沟通与研讨下，伊贝尔特家族决定，将MONETA定位于一线高端专业彩色钻石品牌以及私人高级珠宝定制会所，将会所唯一、传世、私密的理念的有机的融合在零售业务当中，为中国客户带来世界级的珠宝，并提供更加细致和周到的客户体验及服务。</p>' +
		        '<p style="padding:1px 10px;">&nbsp; &nbsp;2006年MONTA璀璨之夜发布会，正式将MONETA品牌展现给了中国，由此开始了中国的绚烂发展之旅。</p>' +
		    '</div>' +
		    '<div style="float:left; width: 245px;min-height: 470px; border: 1px solid #33672d; background: #e9daab;">' +
		        '<p>' +
		            '<br>' +
		            '<br>' +
		            '<br> &nbsp;<img alt="" width="227" height="275" src=""></p>' +
		    '</div>' +
		    '<div style="float:left; width: 245px;min-height: 470px; border: 1px solid #33672d; background: #e9daab;">' +
		        '<p>' +
		            '<br>' +
		            '<br>' +
		            '<br> &nbsp;<img alt="" width="227" height="275" src=""></p>' +
		    '</div>' +
		    '<div style="clear:both"></div>' +
		'</div>'
    },
    {
        "pre":"pre4.png",
        'title': "自定义3",
        'preHtml':'自定义模板3 - 四列展示',
        'html':'<div style="position: relative;z-index: 0; width:1000px; font-size: 13px; background: #e9daab; color:#526351;">' +
		        '<div style="float:left; width: 245px;min-height: 470px; border: 1px solid #33672d; background: #e9daab;"><img src="" width="250" height="470"></div>' +
		        '<div style="float:left; width: 245px;min-height: 470px; border: 1px solid #33672d; background: #e9daab;">' +
		            '<div style="text-align: center">' +
		                '<a href="" title="5" class="lightbox"><img src="" width="227" height="140" style="margin-top: 1px;"></a>' +
		            '</div>' +
		            '<div style="text-align: center; padding-top: 13px;">' +
		                '<a href="" title="" class="lightbox"><img src="" width="227" height="140" style="margin-top: 1px;"></a>' +
		                '<div class="pbox" style="padding:2px 10px;">' +
		                    '<p class="ct"></p>' +
		                    'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>' +
		            '</div>' +
		        '</div>' +
		        '<div style="float:left; width: 245px; border: 1px solid #33672d;min-height: 470px; background: #e9daab;">' +
		            '<div style="text-align: center">' +
		                '<a href="" title="1" class="lightbox"><img src="" width="227" height="140" style="margin-top: 1px;"></a>' +
		            '</div>' +
		            '<div style="text-align: center; padding-top: 13px;">' +
		                '<a href="" title="" class="lightbox"><img src="" width="227" height="140" style="margin-top: 1px;"></a>' +
		            '</div>' +
		            '<div style="text-align: center; padding-top: 13px;">' +
		                '<a href="" title="" class="lightbox"><img src="" width="227" height="140" style="margin-top: 1px;"></a>' +
		            '</div>' +
		        '</div>' +
		        '<div style="float:left; width: 245px; border: 1px solid #33672d;min-height: 470px; background: #e9daab;">' +
		            '<div style="text-align: center">' +
		                '<a href="" title="4" class="lightbox"><img src="" width="227" height="295" style="margin-top: 1px;"></a>' +
		            '</div>' +
		            '<div style="text-align: center; padding-top: 13px;">' +
		                '<a href="" title="" class="lightbox"><img src="" onload="resizePic(this,227,140)" width="227" height="140" style="margin-top: 1px;"></a>' +
		            '</div>' +
		        '</div>' +
		        '<div style="clear:both"></div>' +
		    '</div>'
    },
    {
        "pre":"pre4.png",
        'title': "自定义3",
        'preHtml':'自定义模板3 - 四列展示',
        'html':'<div style="position: relative;z-index: 0; width:1000px; font-size: 13px; background: #e9daab; color:#526351;">' +
		        '<div style="float:left;text-align: left;padding-top: 15px;background: #e9daab;width: 245px;min-height: 470px;padding: 0;border: 1px solid #33672d; ">' +
		            '<h1 style="text-align: center;"><img src="" width="227" height="35"></h1>' +
		            '<div>' +
		                '<h2>&nbsp;</h2>' +
		                '<h2>&nbsp; Marika设计师介绍</h2>' +
		                '<p style="padding:2px 10px">&nbsp;&nbsp;&nbsp; Marika，以色列籍国际著名的珠宝设计师，在她的一生中，艺术和色彩充满了整个生活，除了珠宝，MARIKA还从事着高级时装设计。' +
		                    '<br> &nbsp; &nbsp;1997年，MARIKA巧妙的将金、钻、彩色宝石运用手工制作，巧妙融合，采用最高端的珠宝缎面制作技术，成为世界级珠宝行业出色的设计师，被誉为“花后”。' +
		                    '<br> &nbsp; &nbsp;2006年正式签约MONETA为主管设计师。' +
		                    '<br> &nbsp;xxxxxxxxxxxxxxxxxxxxxxx</p>' +
		            '</div>' +
		        '</div>' +
		        '<div style="float:left;text-align: left;padding-top: 15px;background: #e9daab;width: 245px;min-height: 470px;padding: 0;border: 1px solid #33672d;">' +
		            '<p style="text-align: center">' +
		                '<br>' +
		                '<br> <img alt="" align="middle" src="" width="220" height=348></p>' +
		            '<p style="text-align: center"><span style="color: #008080"><strong>&nbsp;</strong><span style="color: #000000"><strong>Marika</strong></span></span>' +
		            '</p>' +
		        '</div>' +
		        '<div style="float:left; padding: 2px 15px;text-align: left;padding-top: 15px;background: #e9daab;width: 245px;min-height: 470px;padding: 0;border: 1px solid #33672d;">' +
		            '<p>&nbsp;</p>' +
		            '<p>&nbsp;</p>' +
		            '<h2>&nbsp; Palmiero设计师介绍</h2>' +
		            '<p style="padding:2px 10px">&nbsp;&nbsp;&nbsp; 1956年生于意大利珠宝名城Valenza，自幼起便深受Valenza艺术的熏陶和培养。' +
		                '<br> &nbsp; &nbsp;Carlo Palmiero：当代珠宝的艺术家，被誉为珠宝设计界的“高迪”' +
		                '<br> xxxxxx。' +
		                '<br> &nbsp; &nbsp;xxxxxxxxxxxxxxxxxxxxxxxxxx</p>' +
		            '<p>&nbsp;</p>' +
		        '</div>' +
		        '<div style="float:left;text-align: left;padding-top: 15px;background: #e9daab;width: 245px;min-height: 470px;padding: 0;border: 1px solid #33672d;">' +
		            '<p style="text-align: center">&nbsp;</p>' +
		            '<p style="text-align: center; ">' +
		                '<br> <img align="middle" width="218" height="356" alt="" src=""></p>' +
		            '<p style="text-align: center; "><span style="color: rgb(0, 128, 128); "><strong>&nbsp;</strong><span style="color: rgb(0, 0, 0); "><strong>Palmiero</strong></span></span>' +
		            '</p>' +
		            '<p>&nbsp;</p>' +
		        '</div>' +
		        '<div style="clear:both"></div>' +
		    '</div>'

    }
];