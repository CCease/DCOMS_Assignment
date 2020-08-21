package main.java.com.dcoms.service.impl;

import main.java.com.dcoms.dao.IOrderDao;
import main.java.com.dcoms.domain.Account;
import main.java.com.dcoms.domain.Food;
import main.java.com.dcoms.domain.Order;
import main.java.com.dcoms.service.IOrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class OrderService extends UnicastRemoteObject implements IOrderService {

    IOrderDao iOrderDao;

    public OrderService(IOrderDao iOrderDao) throws RemoteException {
        super();
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
