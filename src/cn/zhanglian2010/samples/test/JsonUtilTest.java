package cn.zhanglian2010.samples.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.zhanglian2010.util.JsonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonUtilTest {
	
	public static void main(String[] args) throws JsonProcessingException {
		Student t = new Student();
		t.setId(11);
		t.setName("asdas");
		
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("k1", t);
		map.put("k2", new Student(111, "222"));
		
		
		String str = JsonUtil.fromObject(map);
		System.out.println(str);
		
		try {
			@SuppressWarnings("unchecked")
			Map<String, Student> tt = JsonUtil.toObject(str, Map.class);
			System.out.println(tt.get("k1").getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
