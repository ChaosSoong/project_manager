package com.sys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sys.log.LogFactory;


public class DateUtil {
	
	public static final String PATTERN_TIME = "yyyy-MM-dd HH:mm:ss";
	
	public static Date strToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			LogFactory.getLogger().error(e);
		}
		return null;
	}
	
	public static Date strToDateByPattern(String date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		}catch(Exception e) {
			LogFactory.getLogger().error(e.getMessage());
		}
		return null;
	}
	
	public static String dateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			return sdf.format(date);
		}catch(Exception e) {
			LogFactory.getLogger().error(e.getMessage());
		}
		return "";
	}
	
	public static String dateToStrByPattern(Date date,String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			return sdf.format(date);
		}catch(Exception e) {
			LogFactory.getLogger().error(e.getMessage());
		}
		return "";
	}
	
	

}
