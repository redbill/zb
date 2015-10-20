package com.bianlide.zb.common.severlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.com.hugedata.web.fsm.user.model.UserInfo;


/**
 * 
 * @author Administrator 文件上传 具体步骤： 1）获得磁盘文件条目工厂 DiskFileItemFactory 要导包 2） 利用
 *         request 获取 真实路径 ，供临时文件存储，和 最终文件存储 ，这两个存储位置可不同，也可相同 3）对
 *         DiskFileItemFactory 对象设置一些 属性 4）高水平的API文件上传处理 ServletFileUpload
 *         upload = new ServletFileUpload(factory); 目的是调用
 *         parseRequest（request）方法 获得 FileItem 集合list ，
 * 
 *         5）在 FileItem 对象中 获取信息， 遍历， 判断 表单提交过来的信息 是否是 普通文本信息 另做处理 6） 第一种. 用第三方
 *         提供的 item.write( new File(path,filename) ); 直接写到磁盘上 第二种. 手动处理
 * 
 */
public class fileUpload extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	response.setContentType("application/json;charset=utf-8");
        response.setContentType("text/html");
        String msgString = "上传成功";
        boolean bIsOK = true;
        int loginStatus = 1;// 默认设置为登录正常
        String fileName = "";
        PrintWriter pw = response.getWriter();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);// 设置缓存大小为1M
        ServletFileUpload upload = new ServletFileUpload(factory);// 定义上传servlet
        upload.setSizeMax(1024 * 1024);
        int FILE_MAX_SIZE = 1024 * 500;// 设置最大为500K
        // 获取当前登录用户信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(
                "UserInfo");
        //模块code
        String codeModule = request.getParameter("codeModule");
        String nameModule = request.getParameter("nameModule");
//        if (!UserManager.CurrentUserIsLogin(request))
//        {
//            bIsOK = false;
//            msgString = LocaleConfig.getLocale().getString("loginOut");// 未登录或登录已超时，请登录后使用此功能。
//            loginStatus = LoginStatus.TIMEOUTS.getIndex();// 设置登录状态为登录超时
//        }
//        else
//        {
            try
            {
                Iterator<FileItem> iterator = upload.parseRequest(request)
                        .iterator();

                while (iterator.hasNext())
                {
                    FileItem item = iterator.next();
                    if (item.isFormField())
                    {// 判断是否为文件

                    }
                    else
                    {
                        fileName = item.getName();
                        // 后台验证文件的大小和格式
                        if (item.getSize() > FILE_MAX_SIZE)
                        {
                            bIsOK = false;
                            msgString = "图片大小超过了允许的范围。请返回重新上传。";
                        }
                        else if (fileName != "")
                        {
                        	String contextRealPath =request.getSession( ).getServletContext( ).getRealPath( "/uploadImg/" );
                        	
                        	
//                             String contextRealPath = getServletContext()
//                             .getRealPath("/public/modules/upload");
//                            String contextRealPath = ReportUtil.getProperty(
//                                    "uploadFile.properties", "rootPath");
                            int fileIndex = fileName.lastIndexOf("\\") + 1;
                            fileName = fileName.substring(fileIndex)
                                    .toLowerCase();
                            // 将文件的后缀名转换为小写
                            // 上传文件后缀过滤判断
                            if (fileName.endsWith(".jpg")
                                    || fileName.endsWith(".gif")
                                    || fileName.endsWith(".png")
                                    || fileName.endsWith(".jpeg")
                                    || fileName.endsWith(".bmp"))
                            {
                                // 随机生成文件的名称
                                UUID uuidNumber = java.util.UUID.randomUUID();
                                String reName = uuidNumber.toString();
                                String nameEnd = fileName.substring(
                                        fileName.indexOf("."),
                                        fileName.length());
                                // 生成新的文件名
                                fileName = reName + nameEnd;
                                // 图片上传到服务器上的upload文件中
                                FileOutputStream outputStream = new FileOutputStream(
                                        contextRealPath + "/" + fileName);
                                InputStream inputStream = item.getInputStream();
                                byte pool[] = new byte[1024];
                                int len = -1;
                                while ((len = inputStream.read(pool, 0,
                                        pool.length)) != -1)
                                {
                                    outputStream.write(pool, 0, len);
                                }
                                outputStream.flush();
                                outputStream.close();
                                inputStream.close();

                            }
                            else
                            // 否则格式不允许
                            {
                                bIsOK = false;
                                msgString = "图片格式不正确,请返回重新上传!";
                            }

                        }
                    }
                }
            }
            catch (FileUploadException e)
            {
                fileName = "";
                bIsOK = false;
                msgString = "上传附件过程中出错，错误信息";
            }
//        }
        // 定义返回结果
       
        pw.println("{\"isOK\":\"" + bIsOK + "\",\"msg\":\"" + msgString
                + "\",\"fileName\":\"" + fileName + "\",\"loginStatus\":\""
                + loginStatus + "\"}");
        
    }
}