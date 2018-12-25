package com.dm.official.dto;

public class STATIC {
	
	/**
	 * 0	未分类
	 * 1	业务范围
	 * 2	新闻公告
	 * 3	合作伙伴
	 * 4	企业动态
	 * 5	代表案件
	 */
	public static final String TYPE_UNDEFINED = "0";
	public static final String TYPE_SCOPE = "1";
	public static final String TYPE_NEWS = "2";
	public static final String TYPE_PARTNER = "3";
	public static final String TYPE_RECENT = "4";
	public static final String TYPE_CLASSIC = "5";
	
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
	
}
