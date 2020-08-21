package com.dcoms.dao;

import com.dcoms.domain.Order;

import java.util.List;

public interface IOrderDao {

    Order findOrderById(String id);

    List<Order> findOrderByCustomerId(String id);

    void addOrder(Order order);

}
