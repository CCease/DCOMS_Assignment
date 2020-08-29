package com.dcoms.service;

import com.dcoms.dao.IOrderDao;
import com.dcoms.domain.Account;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IOrderService extends Remote {

    void setIOrderDao(IOrderDao iOrderDao) throws RemoteException ;

    void orderComplete(Order order) throws RemoteException;

    void cancelOrder(Order order) throws RemoteException ;

    Order findOrderById(String id) throws RemoteException ;

    List<Order> findOrderByCustomerId(String id) throws RemoteException ;

}
