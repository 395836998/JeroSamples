package cn.zhanglian2010.util;

import java.lang.reflect.Field;

public class PropertyUtils {

	/**
	 * 深拷贝字段，默认将源对象的所有字段拷贝到目标对象中
	 * @param sourceBean
	 * @param destinationBean
	 */
	public static void copyProperties(Object sourceBean, Object destinationBean) {
		copyProperties(sourceBean.getClass(), sourceBean, destinationBean);
	}
	
	/**
	 * 深拷贝字段
	 * @param type 指定的原型类，该类及其父类中声明的字段才会被拷贝
	 * @param sourceBean
	 * @param destinationBean
	 */
	public static void copyProperties(Class<?> type, Object sourceBean, Object destinationBean) {
		copyProperties(type, sourceBean, destinationBean, true);
	}
	
	/**
	 * 浅拷贝字段
	 * @param type 指定的原型类，该类中声明的字段才会被拷贝
	 * @param sourceBean
	 * @param destinationBean
	 */
	public static void copyPropertiesShallow(Class<?> type, Object sourceBean, Object destinationBean){
		copyProperties(type, sourceBean, destinationBean, false);
	}
	
	private static void copyProperties(Class<?> type, Object sourceBean, 
			Object destinationBean, boolean deepCopy){
		
		Class<?> parent = type;
		while (parent != null) {
			final Field[] fields = parent.getDeclaredFields();
			for(Field field : fields) {
				try {
					field.setAccessible(true);
					field.set(destinationBean, field.get(sourceBean));
				} catch (Exception e) {
					// Nothing useful to do, will only fail on final fields, which will be ignored.
				}
			}
			parent = deepCopy ? parent.getSuperclass() : null;
		}
	}

}
