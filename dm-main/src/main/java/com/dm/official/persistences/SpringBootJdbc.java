package com.dm.official.persistences;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by tom on 2016/5/21.
 */
@Component("dao")
public class SpringBootJdbc {

	private final Logger LOGGER = LoggerFactory.getLogger(SpringBootJdbc.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SpringBootJdbc() {
		super();
	}

	public SpringBootJdbc(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbc.class, args);
	}

	public Map<String, Object> queryForMap(String sql) {
		return jdbcTemplate.queryForMap(sql);
	}

	public void execute(String sql) {
		LOGGER.debug("SQL->["+sql+"]");
		jdbcTemplate.execute(sql);
	}

}