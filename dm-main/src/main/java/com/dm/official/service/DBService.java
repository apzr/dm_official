package com.dm.official.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dm.official.persistences.BaseService;
import com.dm.official.persistences.JDBC;
import com.dm.official.util.DateUtils;
import com.google.gson.Gson;

@Service
@Qualifier("dbService")
public class DBService extends BaseService {


	public String test(){
		ResultSet rs = excute("SELECT * FROM tb_filterone");
		return getJson(rs);
	}
	
	public ResultSet excute(String sql){
		return JDBC.excuteQuery(sql);
	}
	
	
	public String getJson(ResultSet rs) {
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
			
			return new Gson().toJson(dataList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
