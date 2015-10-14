/**  
 * @Title: ValidationUtil.java
 * @Package com.tsinghua.network.awareness.util
 * @Description: 一些验证的工具
 * @author Dangzhang
 * @date 2012-10-23 下午5:02:41
 * @version V0.1  
 * ****************************************************
 * Update Logs:
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package cn.com.hugedata.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	/**
	 * 验证IP地址的合法性(仅限IPv4)
	 * 
	 * @param str
	 *            要进行验证的String
	 * @return 如果返回值为true，则是合法，否则，表示不合法
	 */
	public static Boolean isIP(String str) {
		if (str.length() < 7) {
			return false;
		}
		// 不能以网络号和广播地址为结尾
		int lidx = str.indexOf("255");
		if (-1 != lidx) {
			// 如果包含255，则认为是错误的（包括广播地址）
			return false;
		}
		// int lidx = str.lastIndexOf(".255");
		// if ((str.length() - 4) == lidx)
		// {
		// // 如果.255在最后
		// return false;
		// }
		lidx = str.lastIndexOf(".0");
		if ((str.length() - 2) == lidx) {
			// 如果0在最后
			return false;
		}

		// 简单的不可用的IP地址的判断
		// 一些简单的IP地址
		if ((str.equals("127.0.0.1")) || (str.equals("0.0.0.0"))
				|| (str.equals("255.255.255.255"))) {

			return false;
		}
		// 去掉内网ip
		/*
		 * 10.0.0.0~10.255.255.255 172.16.0.0~172.31.255.255
		 * 192.168.0.0~192.168.255.255
		 */
		if ((str.indexOf("10.") == 0) || (str.indexOf("172.16.") == 0)
				|| (str.indexOf("172.17.") == 0)
				|| (str.indexOf("172.18.") == 0)
				|| (str.indexOf("172.19.") == 0)
				|| (str.indexOf("172.20.") == 0)
				|| (str.indexOf("172.21.") == 0)
				|| (str.indexOf("172.22.") == 0)
				|| (str.indexOf("172.23.") == 0)
				|| (str.indexOf("172.24.") == 0)
				|| (str.indexOf("172.25.") == 0)
				|| (str.indexOf("172.26.") == 0)
				|| (str.indexOf("172.27.") == 0)
				|| (str.indexOf("172.28.") == 0)
				|| (str.indexOf("172.29.") == 0)
				|| (str.indexOf("172.30.") == 0)
				|| (str.indexOf("172.31.") == 0)
				|| (str.indexOf("192.168.") == 0)) {
			//
			return false;
		}
		// 正则表达式判断
		Boolean isMatched = false;
		if ((str == null) || (str.equals(""))) {
			return false;
		} else {
			String check = "^((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|[1-9])(\\.((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)){3}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(str);
			isMatched = matcher.matches();
		}

		return isMatched;
	}

	/**
	 * 对URL的string进行验证
	 * 
	 * @param urlString
	 *            要进行验证的url的String
	 * @return 如果返回值为true，则是合法的URL，否则，表示不是标准的URL
	 */
	public static Boolean isURL(String urlString) {
		Boolean isMatched = false;
		if ((urlString == null) || (urlString.equals(""))) {
			return false;
		} else {
			//
			// String check =
			// "(http|https|ftp):(\\/\\/|\\\\)+([\\w-]+\\.)+[\\w-]+(/[\\w-   ./?%&=]*)?";
			String check = "^((http|https):\\/\\/){1}(\\w(\\:\\w)?@)?([0-9a-z_-]+\\.)*?([a-z0-9-]+\\.[a-z]{2,6}(\\.[a-z]{2})?(\\:[0-9]{2,6})?)((\\/[^?#<>\\/\\\\*\":]*)+(\\?[^#]*)?(#.*)?)?$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(urlString);
			isMatched = matcher.matches();
		}

		return isMatched;
	}

	/**
	 * 对昵称进行验证
	 * 
	 * @param urlString
	 *            昵称必须是中英文-_和数字
	 * @return 如果返回值为true，则是合法的昵称，否则，表示不是合法的昵称
	 */
	public static Boolean isNickName(String nickName) {
		Boolean isMatched = false;
		if ((nickName == null) || (nickName.equals(""))) {
			System.out.println(nickName);
			return false;
		} else {

			//
			// String check =
			// "(http|https|ftp):(\\/\\/|\\\\)+([\\w-]+\\.)+[\\w-]+(/[\\w-   ./?%&=]*)?";
			// String check =
			// "^((http|https):\\/\\/){1}(\\w(\\:\\w)?@)?([0-9a-z_-]+\\.)*?([a-z0-9-]+\\.[a-z]{2,6}(\\.[a-z]{2})?(\\:[0-9]{2,6})?)((\\/[^?#<>\\/\\\\*\":]*)+(\\?[^#]*)?(#.*)?)?$";
			String check = "^[-A-Za-z0-9_\u4E00-\u9FA5]+";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(nickName);
			isMatched = matcher.matches();
		}

		return isMatched;
	}

	/**
	 * 对URL的string进行验证不含http://、https://、ftp://等协议头
	 * 
	 * @param urlString
	 *            要进行验证的url的String
	 * @return 如果返回值为true，则是合法的URL，否则，表示不是标准的URL
	 */
	public static Boolean isURLNoneProtocolHead(String urlString) {
		Boolean isMatched = false;
		if ((urlString == null) || (urlString.equals(""))) {
			return false;
		} else {
			String check = "^(\\w(\\:\\w)?@)?([0-9a-z_-]+\\.)*?([a-z0-9-]+\\.[a-z]{2,6}(\\.[a-z]{2})?(\\:[0-9]{2,6})?)((\\/[^?#<>\\/\\\\*\":]*)+(\\?[^#]*)?(#.*)?)?$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(urlString);
			isMatched = matcher.matches();
		}

		return isMatched;
	}

	/**
	 * 对URL的进行域名验证
	 * 
	 * @param urlString
	 *            要进行验证的url的String
	 * @return 如果返回值为true，则是合法的域名，否则，表示不是标准的域名
	 */
	public static Boolean isDomain(String urlString) {
		Boolean isMatched = false;
		if ((urlString == null) || (urlString.equals(""))) {
			return false;
		} else {
			String check = "^(\\w(\\:\\w)?@)?([0-9a-z_-]+\\.)*?([a-z0-9-]+\\.[a-z]{2,6}(\\.[a-z]{2})?)$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(urlString);
			isMatched = matcher.matches();
		}

		return isMatched;
	}

	/**
	 * 对字符串的特殊字符进行验证
	 * 
	 * @param isSpecificCharacter1
	 *            要进行验证的String
	 * @return 特别注意！！！！！@@@@如果返回值为true，则是包含特殊子否，否则，表示不包含特殊字符@@@@
	 */
	public static Boolean isSpecificCharacter1(String str) {
		Boolean isMatched = false;
		if (str.indexOf("\\") > 0) {
			return true;
		}
		if (str.indexOf(" ") > 0) {
			return true;
		}
		if ((str == null) || (str.equals(""))) {
			return false;
		} else {
			String check = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*|{}【】‘；：”“’。，、？]";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(str);

			isMatched = matcher.find();
		}

		return isMatched;
	}

	/**
	 * 对字符串的特殊字符进行验证
	 * 
	 * @param isSpecificCharacter
	 *            要进行验证的String
	 * @return 特别注意！！！！！@@@@如果返回值为true，则是包含特殊子否，否则，表示不包含特殊字符@@@@
	 */
	public static Boolean isSpecificCharacter(String str) {
		Boolean isMatched = false;
		if (str.indexOf("\\") > 0) {
			return true;
		}

		if ((str == null) || (str.equals(""))) {
			return false;
		} else {
			String check = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*|{}【】‘；：”“’。，、？]";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(str);

			isMatched = matcher.find();
		}

		return isMatched;
	}

	/**
	 * @Title: isMobilePhoneNumber
	 * @Description: 验证一个字符串是否是手机号码
	 * @author Dangzhang
	 * @param str
	 * @return
	 * @throws
	 */
	public static Boolean isMobilePhoneNumber(String str) {
		Boolean isMatched = false;
		if ((str == null) || (str.equals(""))) {
			return false;
		} else {
			String check = "^(1(([35][0-9])|(47)|(45)|[7][0678]|[8][0123456789]))\\d{8}$";
			
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(str);
			isMatched = matcher.matches();
		}

		return isMatched;
	}

	//
	/**
	 * @Title: isEmail
	 * @Description:验证一个字符串是否是合法的Email地址
	 * @author Dangzhang
	 * @param email
	 *            需要验证的Email
	 * @return 返回true表示email地址合法，否则表示email地址不合法
	 * @throws
	 */
	public static boolean isEmail(String email) {
		boolean isMatched = false;
		// 电子邮件
		// String check =
		// "^[a-z0-9]([a-z0-9-_\\.]*[a-z0-9])*@([a-z0-9][a-z0-9-]{0,61}[a-z0-9]\\.){1,3}[a-z]{2,6}([\\.][a-z]{2,6})?$";
		String check = "^([a-zA-Z0-9_\\-\\.])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		isMatched = matcher.matches();
		return isMatched;
	}

	//

	/**
	 * @Title: isPort
	 * @Description:验证一个字符串是否是合法的端口号
	 * @author Dangzhang
	 * @param port
	 *            需要验证的端口号
	 * @return 返回true表示合法，否则表示不合法
	 * @throws
	 */
	public static boolean isPort(String port) {
		boolean isMatched = false;
		// 端口号
		String check = "(^[1-9]\\d{0,3}$)|(^[1-5]\\d{4}$)|(^6[0-4]\\d{3}$)|(^65[0-4]\\d{2}$)|(^655[0-2]\\d$)|(^6553[0-5]$)";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(port);
		isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * @Title: isSignlessInteger
	 * @Description:验证一个字符串是否是正整数
	 * @author Dangzhang
	 * @param port
	 *            需要验证的内容
	 * @return 返回true表示合法，否则表示不合法
	 * @throws
	 */
	public static boolean isSignlessInteger(String str) {
		boolean isMatched = false;
		String check = "^[1-9]\\d*$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(str);
		isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * @Title: isNonnegativeInteger
	 * @Description:验证一个字符串是否是非负整数（正整数和零
	 * @author Dangzhang
	 * @param port
	 *            需要验证的内容
	 * @return 返回true表示合法，否则表示不合法
	 * @throws
	 */
	public static boolean isNonnegativeInteger(String str) {
		boolean isMatched = false;
		String check = "\\d+$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(str);
		isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * @Title: isNonnegativeInteger
	 * @Description:验证一个字符串最后是否以"/"结尾，并去掉最后所有的"/"
	 * @author Yinting
	 * @param port
	 *            需要验证的内容
	 * @return 返回去掉后"/"的字符串
	 * @throws
	 */
	public static String delBackslach(String str) {
		// String lastChar = str.substring(str.length()-1);
		if (str.endsWith("/")) {
			str.substring(0, str.length() - 2);
		} else {
			return str;
		}
		return delBackslach(str);
	}

	/**
	 * @Title: isNonnegativeInteger
	 * @Description:验证一个URL中第一位是否以"/"结尾，并去掉最后所有的"/"
	 * @author Yinting
	 * @param port
	 *            需要验证的内容
	 * @return 返回去掉后"/"的字符串
	 * @throws
	 */
	public static String getIndexslach(String str) {
		// String lastChar = str.substring(str.length()-1);

		if (str.startsWith("/")) {
			str.substring(1, str.length() - 1);
		} else {
			return delBackslach(str);
		}
		return getIndexslach(str);
	}
	
	/** 
     * 解析出url参数中的键值对 
     * 如 "Action=del&id=123"，解析出Action:del,id:123存入map中 
     * @param url url地址 
     * @return url请求参数部分 
     */ 
     public static Map<String, String> urlParameterCut(String url) 
     { 
     Map<String, String> mapRequest = new HashMap<String, String>(); 
     String[] arrSplit=null; 
     String strUrlParam=url; 
     if(strUrlParam==null || "".equals(strUrlParam.trim())) 
     { 
     return mapRequest; 
     } 
     //每个键值为一组 
     arrSplit=strUrlParam.split("[&]"); 
     for(String strSplit:arrSplit) 
     { 
     String[] arrSplitEqual=null; 
     arrSplitEqual= strSplit.split("[=]"); 
     //解析出键值 
     if(arrSplitEqual.length>1) 
     { 
     //正确解析 
     mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]); 
     } 
     else 
     { 
     if(arrSplitEqual[0]!="") 
     { 
     //只有参数没有值，不加入 
     mapRequest.put(arrSplitEqual[0], ""); 
     } 
     } 
     } 
     return mapRequest; 
     } 
     
     /** 
      * 解析出url参数中的键值对 
      * 如 下，解析出Action:del,id:123存入map中 
     * http请求头格式
     * name:value
     * name2:value2
     * name3:value3
     *
      * @param url url地址 
      * @return url请求参数部分 
      */ 
      public static Map<String, String> formParameterCut(String url) 
      { 
      Map<String, String> mapRequest = new HashMap<String, String>(); 
      String[] arrSplit=null; 
      String strUrlParam=url; 
      if(strUrlParam==null || "".equals(strUrlParam.trim()) )
      { 
      return mapRequest; 
      } 
      //每个键值为一组 
      arrSplit=strUrlParam.split("[\n]"); 
      for(String strSplit:arrSplit) 
      { 
      String[] arrSplitEqual=null; 
      arrSplitEqual= strSplit.split("[:]"); 
      //解析出键值 
      if(arrSplitEqual.length>1) 
      { 
      //正确解析 
      mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]); 
      } 
      else 
      { 
      if(arrSplitEqual[0]!="") 
      { 
      //只有参数没有值，不加入 
      mapRequest.put(arrSplitEqual[0], ""); 
      } 
      } 
      } 
      return mapRequest; 
      } 
}
