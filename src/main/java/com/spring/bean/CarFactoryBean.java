package com.spring.bean;

import com.spring.bean.helloworld.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by chenbin on 2018\3\4 0004.
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car getObject() throws Exception {
        return new Car("tianma",brand,500,500000);
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
