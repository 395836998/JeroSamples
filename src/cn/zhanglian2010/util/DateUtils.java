package cn.zhanglian2010.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String FORMAT_YMD = "yyyy-MM-dd";
	
	public static final String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	
	public static String getDateStr(){
		return getDateStr(new Date());
	}
	
	public static String getDateStr(Date date){
		return getDateStr(date, FORMAT_YMDHMS);
	}
	
	public static String getDateStr(Date date, String format){
		DateFormat f = new SimpleDateFormat(format);
		return f.format(date);
	}
	
	public static Timestamp getDateTimestamp(){
		return Timestamp.valueOf(getDateStr());
	}
	
	public static Date parseDate(String dateStr) throws ParseException{
		DateFormat f = new SimpleDateFormat(FORMAT_YMDHMS);
		return f.parse(dateStr);
	}
	
	public static Date parseDate(String dateStr, String format) throws ParseException{
		DateFormat f = new SimpleDateFormat(format);
		return f.parse(dateStr);
	}
	
	public static java.sql.Date parseSqlDate(Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
}
