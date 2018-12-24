package com.dm.official.dto;

public class StaticParam {
	
	/**
	 * db
	 */
	public static final String DB_BLACK = "plugin_black_type_language_id";
	public static final String DB_WHITE = "plugin_white_type_language_id";
	public static final String DB_GRAY = "plugin_gray_type_language_id";
	public static final String PLUGIN_RETURN_DATA_SPLIT = "\\|";
	
	/**
	 * Topic
	 */
	public static final String TOPIC_PERFIX = "topic";
	public static final String TOPIC_SEPARATOR = "_";
	public static final String TOPIC_LEVEL = "level";
	public static final String TOPIC_TASK = "task";
	public static final String TOPIC_NAME_DISPOSE = "topic_plugin_Handle";//处置插件Topic
	public static final String TOPIC_NAME_DB = "topic_plugin_db";//db Topic
	
	/**
	 * 拼jsondata时的占位符
	 */
	public static final String DATA_REMOVE_TAG = "toRemove";
	
	/**
	 * 插件实现语言, 对应language属性
	 */
	public static final String FRAME_TYPE_JAVA = "1";
	public static final String FRAME_TYPE_PYTHON = "2";
	public static final String FRAME_TYPE_C = "3";
	
	/**
	 * 插件实现语言对应的名称
	 */
	public static final String FRAME_NAME_JAVA = "java";
	public static final String FRAME_NAME_PYTHON = "python";
	public static final String FRAME_NAME_C = "c";
	
	public static String getLanguage(String language){
		if(language.equals(StaticParam.FRAME_TYPE_JAVA))
			return StaticParam.FRAME_NAME_JAVA;
		if(language.equals(StaticParam.FRAME_TYPE_PYTHON))
			return StaticParam.FRAME_NAME_PYTHON;
		if(language.equals(StaticParam.FRAME_TYPE_C))
			return StaticParam.FRAME_NAME_C;
		return null;
	}
	
	/**
	 * 插件类型, 对应type属性
	 */
	public static final String PLUGIN_TYPE_PLUGIN = "1";
	public static final String PLUGIN_TYPE_FILTER = "2";
	public static final String PLUGIN_TYPE_DISPOSE = "3";
	
	/**
	 * 升级类型
	 */
	public static final String FLAG_UPDATE = "1";
	public static final String FLAG_DELETE = "2";
	
	/**
	 * 验证类型, 对应verify_id属性
	 */
	public static final String VERIFY_TYPE_FIRST = "0";
	public static final String VERIFY_TYPE_MORE = "1";
	
	/**
	 * 分别对应:
	 * 	插件输入输出分隔符
	 * 	插件输入参数对应分隔符
	 * 	插件参数之间的分隔符
	 * 
	 * 例: plugin1_in1|name1,plugin1_in2|name2,plugin1_in3|name3###name1,name2,name3,nameaaa
	 */
	public static final String PARAM_MAPPING = "\\|";
	public static final String PARAM_IN_OUT = "###";
	public static final String PARAM_SPILT = ",";
	/**
	 * 
	 */
	public static final String JOB_INDEX_DB = "0";
	
}
