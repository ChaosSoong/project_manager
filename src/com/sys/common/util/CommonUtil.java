package com.sys.common.util;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;

import com.sys.log.LogFactory;

public class CommonUtil {

	/**
	 * 如果字符为空或者null 那么返回true反之false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str)) ? true : false;
	}

	/**
	 * 如果字符不为空和null 那么返回true反之false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null && !"".equals(str)) ? true : false;
	}

	/**
	 * 防止出现中文乱码问题，把String重新生成UTF-8编码
	 * 
	 * @param str
	 * @return
	 */
	public static String genUTF8String(String str) {
		String newStr = null;
		try {
			newStr = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			LogFactory.getLogger().error(e);
		}
		return newStr;
	}

	/**
	 * 根据传入的字符串，把他们连接起来组成一个新的字符串，参数为不定参数
	 * 
	 * @param strings
	 * @return
	 */
	public static String buildString(String... strings) {
		String[] args = strings;
		if (args == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (String temp : args) {
			sb.append(temp);
		}
		return sb.toString();
	}

	/**
	 * 代替System.out.println的功能，往控制台打印
	 * 
	 * @param o
	 */
	public static void out(Object o) {
		System.out.println(o.toString());
	}

	public static String getRootPath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	public static String getFileSuffix(String fileName) {
		String suffix = "";
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			suffix = fileName.substring(index, fileName.length());
		}
		return suffix;
	}

	public static long getFileSize(File f) // 取得文件夹大小
	{
		try{
			long s=0; 
			if (f.exists()) { 
			FileInputStream fis = null; 
			fis = new FileInputStream(f); 
			s= fis.available(); 
			} else { 
			f.createNewFile(); 
			System.out.println("文件不存在"); 
			} 
			return s; 
		}catch(Throwable e) {
			return -1;
		}
	}
}
