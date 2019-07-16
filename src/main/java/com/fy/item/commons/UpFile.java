package com.fy.item.commons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传与下载
 */
public class UpFile {

	/**
	 * 上传
	 * @projectname 项目名称: ssm-one
	 * @packageclass 包及类名: com.mr.util.UpFile.java
	 * @description 功能描述:
	 * @author  作 者: H17
	 * @param	参 数: @param img
	 * @param	参 数: @param request
	 * @param	参 数: @return
	 * @return 返回类型: String
	 * @createdate 建立日期: 2019年4月16日下午3:58:58
	 */
	public static String realPath = null;
	public static String upFile(MultipartFile img,HttpServletRequest request,String folder) {
		// 获取文件名
		String url = img.getOriginalFilename();
		// 起新的文件名
		String newName = UUID.randomUUID().toString()+"_"+url;
		// 获取项目绝对路径
		realPath = request.getServletContext().getRealPath("/"+folder+"/");
		// 创建一个文件夹
		File file = new File(realPath+newName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();//创建父级文件路径
			try {
				file.createNewFile();//创建文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			img.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/"+folder+"/"+newName;
	}

	/**
	 * 下载
	 * @projectname 项目名称: goods-ssm
	 * @packageclass 包及类名: com.mr.utils.UpFile.java
	 * @description 功能描述:
	 * @author  作 者: H17
	 * @param	参 数: @param response
	 * @param	参 数: @param request
	 * @param	参 数: @param url
	 * @return 返回类型: void
	 * @createdate 建立日期: 2019年4月23日下午11:09:45
	 */
	public static void download(HttpServletResponse response,HttpServletRequest request,String url) {
		// 1. 获得文件的真实路径
		String path = request.getServletContext().getRealPath("")+url;
		// 2. 实例化 文件对象
		File f = new File(path);
		// 3. 获得文件名
		String fileName = f.getName();
		// 4. 定义输入输出流
		BufferedInputStream buffIn = null;
		BufferedOutputStream buffOut = null;
		try {
			// 5. 获得输入流
			buffIn = new BufferedInputStream(new FileInputStream(f));
			// 6. 获得 response  和  request (获得 request 和 response )
			// 7. 获得输入流       response.getOutputStream() 是servlet的输出流  浏览器的输出流
			buffOut = new BufferedOutputStream(response.getOutputStream());

			// 8. 对浏览器进行设置========================================================
			//解决浏览器兼容问题
			if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
				fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
			} else {
				// 对文件名进行编码处理中文问题
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
				fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
			}
			response.reset();
			response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型
			// inline在浏览器中直接显示，不提示用户下载
			// attachment弹出对话框，提示用户进行下载保存本地
			// 默认为inline方式
			response.setHeader("Content-Disposition", "attachment;filename="+fileName);
			//==========================================================================
			// 9. 循环 读写 赋值
			byte[] b = new byte[1024];
			int s = 0;
			while((s=buffIn.read(b))!=(-1)){
				buffOut.write(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(buffIn!=null){
					buffIn.close();
				}
				if(buffOut!=null){
					buffOut.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
