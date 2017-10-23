package com.spring.dao.impl;

import com.spring.pojo.Customer;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustId(rs.getInt("CUST_ID"));
        customer.setName(rs.getString("NAME"));
        customer.setAge(rs.getInt("AGE"));
        return customer;
    }
}
