package cn.zhanglian2010.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String fromObject(Object jsonObj) throws JsonProcessingException {
		return mapper.writeValueAsString(jsonObj);
	}
	
	public static <T> T toObject(String jsonStr, Class<T> clz) throws IOException {
		return mapper.readValue(jsonStr, clz);
	}

}
