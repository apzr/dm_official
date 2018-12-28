package com.dm.official.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonUtils {

	public static Gson JSON = new Gson();
	public static JsonParser PARSER = new JsonParser();
	
	@SuppressWarnings("unused")
	private static int search(String[] dataNames, String v) {
		for (int i = 0; i < dataNames.length; i++) {
			if(v.equals(dataNames[i]))
				return i;
		}
		return -1;
	}

	public static JsonElement getJson(String json){
		return PARSER.parse(json);
	}
	
	public static <T> T getObject(String json, Class<T> classOfT){
		return JSON.fromJson(json, classOfT);
	}
	
	public static String getAttr(JsonElement jElement, String attr) {
		String value = null;
		
		if(jElement ==null)
			return value;
		
		try {
			JsonObject jObject = jElement.getAsJsonObject();
			JsonElement params = jObject.get(attr);
			value = params.getAsString();
		} catch (NullPointerException e) {
			System.out.println("************************************");
			System.out.println(jElement.toString());
			System.out.println("消息中没有\t"+attr+"\t这个属性: ");
			System.out.println("************************************");
			value = null;
		}
		
		return value;
	}
	
	public static String getArray(String json) {
		return null;
	}
	
	public static String toJson(Object obj){
		return JSON.toJson(obj);
	}
	
}
