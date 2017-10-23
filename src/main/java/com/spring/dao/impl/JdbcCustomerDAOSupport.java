package com.spring.dao.impl;

import com.spring.dao.CustomerDAO;
import com.spring.pojo.Customer;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcCustomerDAOSupport extends JdbcDaoSupport implements CustomerDAO {
    public void insert(Customer customer) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        getJdbcTemplate().update(sql, new Object[] { customer.getCustId(),
                customer.getName(),customer.getAge()
        });
    }

    public Customer findByCustomerId(int custId) {
        //BeanPropertyRowMapper
        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
        Customer customer = (Customer) getJdbcTemplate().queryForObject(
                sql,new Object[]{custId},new BeanPropertyRowMapper(Customer.class));
        //CustomerRowMapper()
        /*Customer customer = (Customer) getJdbcTemplate().queryForObject(
                sql,new Object[]{custId},new CustomerRowMapper()
        );*/
       /* List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        if (list != null && list.size() > 0) {
            for (Map<String, Object> map :list) {
                Object age = map.get("AGE");
                Object cust_id = map.get("CUST_ID");
                Object name = map.get("NAME");
                System.out.println(String.format("age:%s,cust_id:%s,name:%s",age,cust_id,name));
            }
        }*/
        return customer;
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM CUSTOMER";
        List<Customer>  customers = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Customer.class));

        /*
        List<Customer> customers = new ArrayList<Customer>();
        List<Map> rows = getJdbcTemplate().queryForList(sql);
        for (Map row:rows) {
            Customer customer = new Customer();
            customer.setCustId(Integer.valueOf((row.get("CUST_ID").toString())));
            customer.setName((String)row.get("NAME"));
            customer.setAge((Integer)row.get("AGE"));
            customers.add(customer);
        }*/
        return customers;
    }

    public String findCustomerNameById(int custId) {
        String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";
        String name = (String) getJdbcTemplate().queryForObject(sql,
                new Object[]{custId},
                String.class);
        return name;
    }

    public int findTotalCustomer() {
        String sql = "SELECT COUNT(*) FROM CUSTOMER";
        //int total = getJdbcTemplate().queryForInt(sql);
        return 0;
    }

    public void insertBatch(final List<Customer> customers) {
        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Customer customer = customers.get(i);
                ps.setInt(1,customer.getCustId());
                ps.setString(2,customer.getName());
                ps.setInt(3,customer.getAge());
            }

            public int getBatchSize() {
                return customers.size();
            }
        });
    }

    public void insertNamedParameter(Customer customer) {

    }
}
