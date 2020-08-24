package com.dcoms.dao.impl;

import com.dcoms.dao.IOrderDao;
import com.dcoms.domain.Order;

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