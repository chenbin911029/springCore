package com.spring.dao.impl;

import com.spring.dao.CustomerDAO;
import com.spring.pojo.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Component
public class JdbcTemplateCustomerDAO implements CustomerDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Customer customer) {

        String sql = "INSERT INTO CUSTOMER " +
                "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";

        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[]{customer.getCustId(),
                customer.getName(), customer.getAge()
        });

    }

    public Customer findByCustomerId(int custId) {
        //String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
        String sql = "SELECT * FROM CUSTOMER";
        jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if (list != null && list.size() > 0) {
            for (Map<String, Object> map :list) {
                Object age = map.get("AGE");
                Object cust_id = map.get("CUST_ID");
                Object name = map.get("NAME");
                System.out.println(String.format("age:%s,cust_id:%s,name:%s",age,cust_id,name));
            }
        }

        return null;
    }

    public List<Customer> findAll() {
        return null;
    }

    public String findCustomerNameById(int custId) {
        return null;
    }

    public int findTotalCustomer() {
        return 0;
    }
    public void insertBatch(List<Customer> customers) {

    }

    public void insertNamedParameter(Customer customer) {

    }
}
