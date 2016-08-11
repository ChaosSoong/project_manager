package com.sys.common.util;

import java.util.Calendar;

public class StringUtils {

	public static boolean isNotEmpty(String value) {
		return (value != null && value.trim().length() > 0);
	}

	public static boolean isEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}

	public static String getRandomStringNumber() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer(18);
		sb.append(cal.get(cal.YEAR));
		sb.append(cal.get(cal.MONTH));
		sb.append(cal.get(cal.DATE));
		sb.append(cal.get(cal.HOUR));
		sb.append(cal.get(cal.MINUTE));
		sb.append(cal.get(cal.SECOND));
		sb.append(cal.get(cal.MILLISECOND));
		return sb.toString();
	}

	public static String StringArr2String(String[] str) {
		StringBuffer sb = new StringBuffer();
		if (str != null && str.length > 0) {
			for (int i = 0; i < str.length; i++) {
				sb.append(str[i]).append(";");
			}
		}
		if (sb.length() > 0)
			sb.delete(sb.length() - 1, sb.length());
		return sb.toString();
	}
	
	public static String[] String2StringArr(String str, String decimal) {
		if(CommonUtil.isEmpty(str)) {
			return null;
		}
		return str.split(decimal);
	}
}
