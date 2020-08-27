package com.dcoms.service.impl;

import com.dcoms.domain.Order;
import com.dcoms.service.IKitchenService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KitchenService extends UnicastRemoteObject implements IKitchenService {

    private static List<Order> OnGoingOrder = new ArrayList<>();

    public KitchenService() throws RemoteException {
        super();
    }

    @Override
    public void addOrder(Order order) {
        OnGoingOrder.add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        // Remove the current element from the iterator and the list.
        if( OnGoingOrder.removeIf(orderInLoop -> orderInLoop == order) == false){
            throw new RuntimeException("ERROR ! Did not found order !");
        };
    }

    @Override
    public Order getAndDeleteOrder(Order order) {
        Order result = null;
        for (Iterator<Order> iterator = OnGoingOrder.iterator(); iterator.hasNext();) {
            Order orderInLoop = iterator.next();
            if (orderInLoop == order) {
                result = orderInLoop;
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }
        if (result == null){
            throw new RuntimeException("ERROR ! Did not found order !");
        }
        return result;
    }

    @Override
    public List<Order> getOnGoingOrder() {
        return OnGoingOrder;
    }
}
