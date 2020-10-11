package com.dcoms.service;

import com.dcoms.domain.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IKitchenService extends Remote {

    void setiOrderService(IOrderService iOrderService) throws RemoteException;

    List<Order> getOnGoingOrder() throws RemoteException;

    void addOrder(Order order) throws RemoteException;

    void cancelOrder(Order order) throws RemoteException;

    boolean completeOrder(Order order) throws RemoteException;

    boolean isOrderComplete(Order order) throws RemoteException;



}
