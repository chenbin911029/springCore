package com.spring.dao;

import com.spring.pojo.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public List<Customer> findAll();
    public String findCustomerNameById(int custId);
    public int findTotalCustomer();
    public void insertBatch(final List<Customer> customers);
    public void insertNamedParameter(Customer customer);
}
