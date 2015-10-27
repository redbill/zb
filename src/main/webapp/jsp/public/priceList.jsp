<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
        <%
    String path = request.getContextPath();
    String paths = request.getScheme() + "://" + request.getServerName() + path + "/";
    if (request.getServerPort() != 80) {
        paths = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    }
    %>

   <!--主体-->
    <div class="warp">
        <form method="post" action="" name="searchFrm">
            <div class="" style="width:980px; margin:0 auto;">
                <div class="title">
                    <h3>祼钻库存</h3>
                </div>
                <div class="maincon">
                    <div class="selectwarp">
                        <div class="select-box"> <span>形状<br>
          Shape</span>
                            <ul class="shape-list">
                                <li class="shape_1">
                                    <a href="javascript:void(0);" title="圆形"></a>
                                    <input type="checkbox" name="shape[1]" value="ROUND">
                                </li>
                                <li class="shape_2">
                                    <a href="javascript:void(0);" title="公主方"></a>
                                    <input type="checkbox" name="shape[2]" value="PRINCESS">
                                </li>
                                <li class="shape_3">
                                    <a href="javascript:void(0);" title="梨形"></a>
                                    <input type="checkbox" name="shape[3]" value="PEAR">
                                </li>
                                <li class="shape_4">
                                    <a href="javascript:void(0);" title="心形"></a>
                                    <input type="checkbox" name="shape[4]" value="HEART">
                                </li>
                                <li class="shape_5">
                                    <a href="javascript:void(0);" title="橄榄"></a>
                                    <input type="checkbox" name="shape[5]" value="MARQUISE">
                                </li>
                                <li class="shape_6">
                                    <a href="javascript:void(0);" title="椭圆"></a>
                                    <input type="checkbox" name="shape[6]" value="OVAL">
                                </li>
                                <li class="shape_7">
                                    <a href="javascript:void(0);" title="祖母绿"></a>
                                    <input type="checkbox" name="shape[7]" value="EMERALD">
                                </li>
                                <li class="shape_8">
                                    <a href="javascript:void(0);" title="雷蒂恩"></a>
                                    <input type="checkbox" name="shape[8]" value="RADIANT">
                                </li>
                                <li class="shape_9">
                                    <a href="javascript:void(0);" title="垫形"></a>
                                    <input type="checkbox" name="shape[9]" value="CUSHION">
                                </li>
                                <li class="shape_10">
                                    <a href="javascript:void(0);" title="三角形"></a>
                                    <input type="checkbox" name="shape[10]" value="TRIANGLE">
                                </li>
                                <li class="shape_11">
                                    <a href="javascript:void(0);" title="三角形"></a>
                                    <input type="checkbox" name="shape[11]" value="TRIANGULAR">
                                </li>
                            </ul>
                        </div>
                        <div class="select-box"> <span>重量<br>
          Carat</span>
                            <div class="carat">
                                <input type="text" name="carat_1" class="carat-input" maxlength="10" id="bigThanWeight" onblur="checkNum(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')"> -
                                <input type="text" name="carat_2" class="carat-input" maxlength="10" id="smallThanWeight" onblur="checkNum(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')"> 克拉&nbsp;&nbsp;&nbsp;&nbsp;重量可选范围
                                <select id="carat-set">
                                    <option value="">请选择...</option>
                                    <option value="0.1-0.19">0.1-0.19</option>
                                    <option value="0.2-0.29">0.2-0.29</option>
                                    <option value="0.3-0.39">0.3-0.39</option>
                                    <option value="0.4-0.49">0.4-0.49</option>
                                    <option value="0.5-0.59">0.5-0.59</option>
                                    <option value="0.6-0.69">0.6-0.69</option>
                                    <option value="0.7-0.79">0.7-0.79</option>
                                    <option value="0.8-0.89">0.8-0.89</option>
                                    <option value="0.9-0.99">0.9-0.99</option>
                                    <option value="1.00-1.09">1.00-1.09</option>
                                    <option value="1.1-1.49">1.1-1.49</option>
                                    <option value="1.5-1.99">1.5-1.99</option>
                                    <option value="2.0-2.99">2.0-2.99</option>
                                    <option value="3.0-3.99">3.0-3.99</option>
                                    <option value="4.0-4.99">4.0-4.99</option>
                                    <option value="5.0-20">5.0-20</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="selectwarp">
                        <div class="select-box"> <span>颜色<br>
          Color</span>
                            <ul id="colorUl" class="color-list">
                                <li>
                                    <a href="javascript:void(0);" title="D">D</a>
                                    <input type="checkbox" name="color[1]" value="D">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="E">E</a>
                                    <input type="checkbox" name="color[2]" value="E">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="F">F</a>
                                    <input type="checkbox" name="color[3]" value="F">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="G">G</a>
                                    <input type="checkbox" name="color[4]" value="G">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="H">H</a>
                                    <input type="checkbox" name="color[5]" value="H">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="I">I</a>
                                    <input type="checkbox" name="color[6]" value="I">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="J">J</a>
                                    <input type="checkbox" name="color[7]" value="J">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="K">K</a>
                                    <input type="checkbox" name="color[8]" value="K">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="L">L</a>
                                    <input type="checkbox" name="color[9]" value="L">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="M">M</a>
                                    <input type="checkbox" name="color[10]" value="M">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="N">N</a>
                                    <input type="checkbox" name="color[11]" value="N">
                                </li>
                            </ul>
                        </div>
                        <div class="select-box2"> <span>切工<br>
          Cut</span>
                            <ul id="cutUl" class="cut-list">
                                <li>
                                    <a href="javascript:void(0);" title="Ideal">Ideal</a>
                                    <input type="checkbox" name="cut[1]" value="I">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="EX" id="exone">EX</a>
                                    <input type="checkbox" id="exonecheck" name="cut[2]" value="E">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="VG" id="vgone">VG</a>
                                    <input type="checkbox" id="vgonecheck" name="cut[3]" value="V">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="GD">GD</a>
                                    <input type="checkbox" name="cut[4]" value="G">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="Fair">Fair</a>
                                    <input type="checkbox" name="cut[5]" value="F">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="Poor">Poor</a>
                                    <input type="checkbox" name="cut[6]" value="P">
                                </li>
                            </ul>
                        </div>
                        <div class="select-box1">
                            <ul class="fast-list">
                                <li><a href="javascript:void(0);" id="3EX" title="3EX None">3EX None</a>
                                </li>
                                <li><a href="javascript:void(0);" id="3EXVG" title="Faint">3EXVG</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="selectwarp">
                        <div class="select-box"> <span>净度<br>
          Clarity</span>
                            <ul id="clarityUl" class="clarity-list">
                                <li>
                                    <a href="javascript:void(0);" title="FL">FL</a>
                                    <input type="checkbox" name="clarity[1]" value="FL">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="IF">IF</a>
                                    <input type="checkbox" name="clarity[2]" value="IF">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="VVS1">VVS1</a>
                                    <input type="checkbox" name="clarity[3]" value="VVS1">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="VVS2">VVS2</a>
                                    <input type="checkbox" name="clarity[4]" value="VVS2">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="VS1">VS1</a>
                                    <input type="checkbox" name="clarity[5]" value="VS1">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="VS2">VS2</a>
                                    <input type="checkbox" name="clarity[6]" value="VS2">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="SI1">SI1</a>
                                    <input type="checkbox" name="clarity[7]" value="SI1">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="SI2">SI2</a>
                                    <input type="checkbox" name="clarity[8]" value="SI2">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="SI3">SI3</a>
                                    <input type="checkbox" name="clarity[9]" value="SI3">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="I1">I1</a>
                                    <input type="checkbox" name="clarity[10]" value="I1">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="I2">I2</a>
                                    <input type="checkbox" name="clarity[11]" value="I2">
                                </li>
                            </ul>
                        </div>
                        <div class="select-box2"> <span>抛光<br>
          Polish</span>
                            <ul id="polishUl" class="polish-list">
                                <li>
                                    <a name="polish_a" num="1" href="javascript:void(0);" title="Ideal">Ideal</a>
                                    <input type="checkbox" name="polish[1]" value="I">
                                </li>
                                <li>
                                    <a name="polish_a" num="2" href="javascript:void(0);" title="EX" id="extwo">EX</a>
                                    <input type="checkbox" id="extwocheck" name="polish[2]" value="E">
                                </li>
                                <li>
                                    <a name="polish_a" num="3" href="javascript:void(0);" title="VG" id="vgtwo">VG</a>
                                    <input type="checkbox" id="vgtwocheck" name="polish[3]" value="V">
                                </li>
                                <li>
                                    <a name="polish_a" num="4" href="javascript:void(0);" title="GD">GD</a>
                                    <input type="checkbox" name="polish[4]" value="G">
                                </li>
                                <li>
                                    <a name="polish_a" num="5" href="javascript:void(0);" title="Fair">Fair</a>
                                    <input type="checkbox" name="polish[5]" value="F">
                                </li>
                                <li>
                                    <a name="polish_a" num="6" href="javascript:void(0);" title="Poor">Poor</a>
                                    <input type="checkbox" name="polish[6]" value="P">
                                </li>
                            </ul>
                        </div>
                        <div class="select-box1">
                            <ul class="fast-list">
                                <li>
                                    <a href="javascript:void(0);" id="without" title="排除奶咖">排除奶咖</a>
                                    <input id="withoutInput" type="checkbox" name="without" value="1">
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="selectwarp">
                        <div class="select-box">
                            <span>证书<br>Cert</span>
                            <ul id="certUl" class="clarity-list">
                                <li>
                                    <a href="javascript:void(0);" title="GIA">GIA</a>
                                    <input type="checkbox" name="cert[1]" value="GIA">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="HRD">HRD</a>
                                    <input type="checkbox" name="cert[2]" value="HRD">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="IGI">IGI</a>
                                    <input type="checkbox" name="cert[3]" value="IGI">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="国检">国检</a>
                                    <input type="checkbox" name="cert[4]" value="国检">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="统包货">统包货</a>
                                    <input type="checkbox" name="cert[5]" value="统包货">
                                </li>
                            </ul>
                            <span class="f1" style="margin-left: 15px;">证书号码</span>
                            <input type="text" name="certificate" class="item-input" maxlength="30" id="certNo">
                        </div>
                        <div class="select-box"> <span>对称<br>
          Symmetry</span>
                            <ul id="symmetryUl" class="cut-list">
                                <li>
                                    <a name="symmetry_a" num="1" href="javascript:void(0);" title="Ideal">Ideal</a>
                                    <input type="checkbox" name="symmetry[1]" value="I">
                                </li>
                                <li>
                                    <a name="symmetry_a" num="2" href="javascript:void(0);" title="EX" id="exthree">EX</a>
                                    <input type="checkbox" id="exthreecheck" name="symmetry[2]" value="E">
                                </li>
                                <li>
                                    <a name="symmetry_a" num="3" href="javascript:void(0);" title="VG" id="vgthree">VG</a>
                                    <input type="checkbox" id="vgthreecheck" name="symmetry[3]" value="V">
                                </li>
                                <li>
                                    <a name="symmetry_a" num="4" href="javascript:void(0);" title="GD">GD</a>
                                    <input type="checkbox" name="symmetry[4]" value="G">
                                </li>
                                <li>
                                    <a name="symmetry_a" num="5" href="javascript:void(0);" title="Fair">Fair</a>
                                    <input type="checkbox" name="symmetry[5]" value="F">
                                </li>
                                <li>
                                    <a name="symmetry_a" num="6" href="javascript:void(0);" title="Poor">Poor</a>
                                    <input type="checkbox" name="symmetry[6]" value="P">
                                </li>
                            </ul>
                            <span class="f1">价格</span>
                            <input type="text" name="price" id="price" class="item-input" maxlength="5" style="width:60px" onblur="checkNum(this)"  onkeyup="this.value=this.value.replace(/[^0-9.]/g,'')" >
                        </div>
                    </div>
                    <div class="selectwarp">
                        <div class="select-box"> <span>荧光<br>
          Fluor</span>
                            <ul id="fluorUl" class="fluor-list">
                                <li>
                                    <a href="javascript:void(0);" title="None" id="flnone">None</a>
                                    <input type="checkbox" id="flnonecheck" name="fluor[1]" value="N">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="Faint">Faint</a>
                                    <input type="checkbox" name="fluor[2]" value="F">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="Medium">Medium</a>
                                    <input type="checkbox" name="fluor[3]" value="M">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="Strong">Strong</a>
                                    <input type="checkbox" name="fluor[4]" value="S">
                                </li>
                                <li>
                                    <a href="javascript:void(0);" title="VS">VS</a>
                                    <input type="checkbox" name="fluor[5]" value="V">
                                </li>
                            </ul>
                        </div>
                        <div class="search">
                            <input name="page" value="1" type="hidden">
                            <input name="offset" value="30" type="hidden">
                            <input name="o_t" value="" type="hidden">
                            <input name="o_s" value="" type="hidden">
                            <input name="submit" class="search-bnt" value="确认搜索" type="button" onclick="searchDT()">
                            <input name="reset" class="search-bnt" value="重置搜索条件" type="reset">
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <div class="table-data-show">
            <div class="result"> 
	            <span class="f1">为您筛选出<i id="total">238131</i>  颗钻石</span> 
	            <span class="f2">每页显示：
	            <a href="javascript:;" class="on" id="hundred" data-sign="100">100</a> 
	            <a href="javascript:;" id="fifty" data-sign="50">50</a> 
	            <a href="javascript:;" id="thirty" data-sign="30">30</a>
	            </span> 
            </div>
            <div class="result-list">
                <table cellspacing="0" id="tb" class="listtab" cellpadding="0" border="0" id="">
                    <thead>
                        <tr>
                            <td class="w_50">形状</td>
                            <td class="w_30">奶</td>
                            <td class="w_30">咖</td>
                            <td class="w_50">
                                <a title="按钻重排序" href="javascript:;" data-name="carat" data-order="0" id="sortbyweight">
              钻重
              <img src="<%=paths%>include/images/c_up.jpg" width="7" height="8">
            </a>
                            </td>
                            <td class="w_30">颜色</td>
                            <td class="w_40">净度</td>
                            <td class="w_30">切工</td>
                            <td class="w_30">抛光</td>
                            <td class="w_30">对称</td>
                            <td class="w_40">荧光</td>
                            <td class="w_30">
                                <font color="blue">心箭</font>
                            </td>
                            <td class="w_40">直径</td>
                            <td class="w_40">深度</td>
                            <td class="w_40">台面</td>
                            <td class="w_85">证书号码</td>
                            <td class="w_40">证书</td>
                            <td class="w_65">
                                <a title="按价格排序" href="javascript:;" data-name="price" data-order="0" id="sortbyprice">
              折后价(RMB)
              <img src="<%=paths%>include/images/c_up.jpg" width="7" height="8">
            </a>
                            </td>
                            <!-- <td class="w_65">操作</td> -->
                        </tr>
                    </thead>
                    <tbody id="searchList">
<!--                         <tr>
                            <td>垫形</td>
                            <td></td>
                            <td></td>
                            <td>0.360</td>
                            <td>F</td>
                            <td>I1</td>
                            <td>VG</td>
                            <td>VG</td>
                            <td>VG</td>
                            <td>Faint</td>
                            <td>
                                <font color="blue"></font>
                            </td>
                            <td><a href="javascript:;" title="4.12 x 3.96 x 2.75">4.12</a></td>
                            <td>69.50</td>
                            <td>61.00</td>
                            <td>
                                <font color="red"></font>
                            </td>
                            <td>
                                <font color="red">统包货</font>
                            </td>
                            <td>
                                <font color="blue">703</font>
                            </td>
                        </tr> -->
                    </tbody>
                </table>
                <p class="tablepage">
					<span id="sjzl"></span> 
					<span id="btn0"></span>
					<!--  <input id="pageSize" type="text" size="1" maxlength="2" value="getDefaultValue()"/><a> 条 </a> 
					<a href="javascript:;" id="pageSizeSet">设置</a>-->
					<a  href="javascript:;" id="btn1">首页</a>
					<a  href="javascript:;" id="btn2">上一页</a>
					<a  href="javascript:;" id="btn3">下一页</a>
					<a  href="javascript:;" id="btn4">尾页</a> 
					<span> 转到 </span>
					<input id="changePage" type="text" size="1" maxlength="4"/>
					<span>页 </span>
					<a href="javascript:;" id="btn5">跳转</a>
				 </p>
            </div>

        </div>
    </div>
    <script language="javascript" type="text/javascript" src="<%=paths%>include/javascripts/selectdiamond.js"></script>
