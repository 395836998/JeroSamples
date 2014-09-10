package cn.zhanglian2010.util;

public class ArrayUtils {

	public static Object resize(Object oldArray, int newSize) {
		Class<?> elementType = oldArray.getClass().getComponentType();
		Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
		int oldSize = java.lang.reflect.Array.getLength(oldArray);
		int preserveLength = Math.min(oldSize, newSize);
		if (preserveLength > 0){
			System.arraycopy (oldArray, 0, newArray, 0, preserveLength);
		}
		return newArray;
	}

	public static void reverse(Object[] array) {
		if (array == null) {
			return;
		}
		int i = 0;
		int j = array.length - 1;
		Object tmp;
		while (j > i) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
			j--;
			i++;
		}
	}

	public static void reverse(int[] array) {
		if (array == null) {
			return;
		}
		int i = 0;
		int j = array.length - 1;
		int tmp;
		while (j > i) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
			j--;
			i++;
		}
	}
}
