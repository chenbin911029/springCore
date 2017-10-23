package com.spring.controller;

import com.spring.dao.CustomerDAO;
import com.spring.pojo.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJdbcController {
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-module.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("jdbcCustomerDAOSupport");

        Customer customer = new Customer(27, "1018",27);
        //customerDAO.insert(customer);
        customerDAO.insertNamedParameter(customer);

        Customer customer1 = customerDAO.findByCustomerId(23);
        System.out.println(String.format("id:%s,name:%s,age:%s",
                String.valueOf(customer1.getCustId()),
                customer1.getName(),
                customer1.getAge()));
        List<Customer> list =  customerDAO.findAll();
        if (list != null && list.size() > 0) {
            for (Customer customer2 :list) {
                System.out.println(String.format("age:%s,cust_id:%s,name:%s",
                        customer2.getAge(),
                        customer2.getCustId(),
                        customer2.getName()));
            }
        }
        String name = customerDAO.findCustomerNameById(1);
        System.out.println(name);

        /*Customer customer1 = new Customer(25, "yiibai25",21);
        Customer customer3 = new Customer(26, "yiibai26",22);
        Customer customer2 = new Customer(37, "yiibai27",23);

        List<Customer> customers = new ArrayList<Customer>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        customerDAO.insertBatch(customers);*/
    }
}
