package com.dcoms.service;

import com.dcoms.domain.Account;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;

import java.rmi.Remote;
import java.util.List;

public interface IOrderService extends Remote {

    void orderComplete(Order order);

    void cancelOrder(Order order);

    Order findOrderById(String id);

    List<Order> findOrderByCustomerId(String id);

}
