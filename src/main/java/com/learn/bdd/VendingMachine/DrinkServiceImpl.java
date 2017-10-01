package com.learn.bdd.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;

public class DrinkServiceImpl implements DrinkService{	
		
	private final JdbcTemplate jdbcTemplate;
	
	public DrinkServiceImpl(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

	@Override
	public List<BigDecimal> fetchPrice(String drinkName){
		String query = "SELECT PRICE FROM STOCK WHERE DRINK = ?";
		Object[] params = {drinkName};
		return jdbcTemplate.query(query, params, new SingleColumnRowMapper<BigDecimal>());
	}
	
	public boolean initializeStock(){
		return false;
	}

	public Integer checkStock(String drinkName) {
		String query = "SELECT QTY FROM STOCK WHERE DRINK = ?";
		Object[] params = {drinkName};
		return jdbcTemplate.queryForObject(query, params, Integer.class);	
	}
}
