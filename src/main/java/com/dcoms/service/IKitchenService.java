package com.dcoms.service;

import com.dcoms.domain.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IKitchenService extends Remote {

    void addOrder(Order order) throws RemoteException;

    void deleteOrder(Order order) throws RemoteException ;

    Order getAndDeleteOrder(Order order) throws RemoteException ;

    List<Order> getOnGoingOrder() throws RemoteException ;

}
