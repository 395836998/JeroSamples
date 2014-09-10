package cn.zhanglian2010.util;

public class MethodUtils {

	public static String getCurrMethodName(){
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}
}
