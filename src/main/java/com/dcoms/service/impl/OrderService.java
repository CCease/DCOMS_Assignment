package com.dcoms.service.impl;

import com.dcoms.dao.IOrderDao;
import com.dcoms.domain.Account;
import com.dcoms.domain.Food;
import com.dcoms.domain.Order;
import com.dcoms.service.IOrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class OrderService extends UnicastRemoteObject implements IOrderService {

    IOrderDao iOrderDao;

    public OrderService() throws RemoteException {
        super();
    }

    @Override
    public void setIOrderDao(IOrderDao iOrderDao) throws RemoteException {
        this.iOrderDao = iOrderDao;
    }

    @Override
    public void orderComplete(Order order) {
        order.setTimeResolved(System.currentTimeMillis());
        order.setSuccess(true);
        iOrderDao.addOrder(order);
    }

    @Override
    public void cancelOrder(Order order) {
        order.setTimeResolved(System.currentTimeMillis());
        order.setSuccess(false);
        iOrderDao.addOrder(order);
    }

    @Override
    public Order findOrderById(String id) {
        return iOrderDao.findOrderById(id);

    }

    @Override
    public List<Order> findOrderByCustomerId(String id) {
        return iOrderDao.findOrderByCustomerId(id);
    }
}
