package com.dm.official.persistences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dm.official.util.DateUtils;
import com.google.gson.Gson;

public class JDBC {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://127.0.0.1:3306/ct?useUnicode=true&characterEncoding=utf-8";
	private static String userName = "root";
	private static String userPassword = "root";

	public static void main(String[] args) {
		excuteQuery("SELECT * FROM tb_filterone");
	}

	public static String getJson(ResultSet rs) {
		try {
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			Map<String, Object> result;
			if(rs!=null){
				result = new HashMap<String, Object>();
				ResultSetMetaData data = rs.getMetaData();
				while (rs.next()) {
					for (int i = 1; i < data.getColumnCount()+1; i++) {
						String key = data.getColumnLabel(i);
						System.out.println(key);
						Object value = rs.getObject(key);
						if(value instanceof Date){
							System.out.println(DateUtils.formatDateTime((Date) value));
						}
						//result.put(key, value.toString().length()>10?value.toString().substring(0, 10):value.toString());
						result.put(key, value);
					}
					dataList.add(result);
				}
			}
			
			System.out.println();
			
			return new Gson().toJson(dataList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * JDBC 建立 SQL Server数据库连接
	 */
	public static ResultSet excuteQuery(String sql) {

		Connection connection = null;
		Statement sta = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, userPassword);
			System.out.println("Connection Success !");

			sta = connection.createStatement();
			rs = sta.executeQuery(sql);
			
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			Map<String, Object> result;
			if(rs!=null){
				result = new HashMap<String, Object>();
				ResultSetMetaData data = rs.getMetaData();
				while (rs.next()) {
					for (int i = 1; i < data.getColumnCount()+1; i++) {
						String key = data.getColumnLabel(i);
						//System.out.println(key);
						Object value = rs.getObject(key);
						if(value instanceof Timestamp){
							Date d = ((Timestamp) value);
							value = DateUtils.formatDateTime(d);
							System.out.println(value);
						}
						result.put(key, value);
					}
					dataList.add(result);
				}
			}
			
			System.out.println();
			
			System.out.println(new Gson().toJson(dataList));
			
		} catch (Exception e) {
			System.out.println("Connection Fail !");
			e.printStackTrace();
		}

		/**
		 * 关闭数据库
		 * 
		 * @param connection
		 */
		finally {
			try {

				if (null != sta) {
					sta.close();
					sta = null;
					System.out.println("Statement 关闭成功");
				}

				if (null != connection) {
					connection.close();
					connection = null;
					System.out.println("Connection 关闭成功");
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return rs;
	}
}