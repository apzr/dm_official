package com.dm.official.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.dm.official.dto.StaticParam;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JsonUtils {

	public static Gson JSON = new Gson();
	public static JsonParser PARSER = new JsonParser();
	
//	public static void main(String args[]) {
//		String jsonStr = 	" { "+
//							"    \"task_id\": \"4\","+
//							"    \"tool_id\": \"3\","+
//							"    \"send_time\": \"2017-10-22 09:43:00\","+
//							"    \"is_re_verify\": \"1\","+
//							"    \"params\": {"+
//							"        \"data\": ["+
//							"            {"+
//							"                \"value\": \"name1|name2|name3\""+
//							"            },"+
//							"            {"+
//							"                \"value\": \"192.168.1.1|8080|AH\""+
//							"            },"+
//							"            {"+
//							"                \"value\": \"192.168.2.1|80|ZJ\""+
//							"            },"+
//							"            {"+
//							"                \"value\": \"192.168.3.1|8081|AH\""+
//							"            }"+
//							"        ],"+
//							"        \"plugins\": ["+
//							"            {"+
//							"                \"id\": \"1\","+
//							"                \"index\": \"1\","+
//							"                \"level\": \"1\","+
//							"                \"type\":\"1\","+
//							"                \"language\":\"1\","+							
//							"                \"param\": \"plugin1_in1|name1,plugin1_in2|name2,plugin1_in3|name3###plugin1_out1,plugin1_out2,plugin1_out3\""+
//							"            },"+
//							"            {"+
//							"                \"id\": \"2\","+
//							"                \"index\": \"2\","+
//							"                \"level\": \"2\","+
//							"                \"type\":\"1\","+
//							"                \"language\":\"1\","+									
//							"                \"param\": \"plugin2_in1|plugin1_out2,plugin2_in2|plugin1_out3###plugin2_out1,plugin2_out2\""+
//							"            },"+
//							"           {"+
//							"                \"id\":\"1,3\","+
//							"                \"index\":\"3\","+
//							"                \"level\":\"0\","+
//							"                \"type\":\"3\","+
//							"                \"language\":\"0\","+	
//							"                \"param\":\"\""+
//							"            }"+
//							"        ]"+
//							"    }"+
//							" } ";
//		//JsonElement element = getJson(jsonStr);
//		//LinkedList<Plugin> plugins = getPlugins(element);
//		//LinkedList<Data> datas = getDatas(element);
//		//String jsondata = getJsonDataByParams(datas, plugins.get(0));
//		
//	}
	
	
	@SuppressWarnings("unused")
	private static int search(String[] dataNames, String v) {
		for (int i = 0; i < dataNames.length; i++) {
			if(v.equals(dataNames[i]))
				return i;
		}
		return -1;
	}

	/**
	 * 
	 * @param paramExpression
	 * @return
	 */
	public static Map<String, String> getInParamList(String paramExpression) {
		//paramExpression = "plugin1_in1|name1,plugin1_in2|name2,plugin1_in3|name3###plugin1_out1,plugin1_out2,plugin1_out3";
		Map<String, String> paramList = new LinkedHashMap<String, String>();
		
		String[] input = paramExpression.split(StaticParam.PARAM_IN_OUT)[0].split(StaticParam.PARAM_SPILT);
		for (int i = 0; i < input.length; i++) {
			String[] paramInfo = input[i].split(StaticParam.PARAM_MAPPING);
			paramList.put(paramInfo[0], paramInfo[1]);
		}
		
		return paramList;
	}
	
	public static String[] getOutParamList(String paramExpression) {
		return paramExpression.split(StaticParam.PARAM_IN_OUT)[1].split(StaticParam.PARAM_SPILT);
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
