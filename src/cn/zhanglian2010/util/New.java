package cn.zhanglian2010.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class New {

	public static <T> ArrayList<T> arrayList(){
		return new ArrayList<T>();
	}
	
	public static <T> ArrayList<T> arrayList(int initialCapacity){
		return new ArrayList<T>(initialCapacity);
	}
	
	public static <K, V> HashMap<K, V> hashMap() {
        return new HashMap<K, V>();
    }
	
	public static <K, V> HashMap<K, V> hashMap(int initialCapacity) {
        return new HashMap<K, V>(initialCapacity);
    }
	
	public static <T> HashSet<T> hashSet() {
        return new HashSet<T>();
    }
	
}
