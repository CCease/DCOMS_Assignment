package main.java.com.dcoms.service;

import main.java.com.dcoms.domain.Account;
import main.java.com.dcoms.domain.Food;
import main.java.com.dcoms.domain.Order;

import java.rmi.Remote;
import java.util.List;

public interface IOrderService extends Remote {

    void orderComplete(Order order);

    void cancelOrder(Order order);

    Order findOrderById(String id);

    List<Order> findOrderByCustomerId(String id);

}
