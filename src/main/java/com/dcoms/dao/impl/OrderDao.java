package main.java.com.dcoms.dao.impl;

import main.java.com.dcoms.dao.IOrderDao;
import main.java.com.dcoms.domain.Order;

import java.util.List;

public class OrderDao implements IOrderDao {

    @Override
    public Order findOrderById(String id) {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public List<Order> findOrderByCustomerId(String id) {
        return null;
    }
}