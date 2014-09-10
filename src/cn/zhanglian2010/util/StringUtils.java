package cn.zhanglian2010.util;

public class StringUtils {
	
	public static final String EMPTY = "";

	public static boolean isEmpty(String str){
		return str == null || str.trim().length() == 0;
	}
	
	public static String cNull(String str){
		return str == null ? EMPTY : str.trim();
	}
	
}
