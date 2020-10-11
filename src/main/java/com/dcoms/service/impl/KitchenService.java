package com.dcoms.service.impl;

import com.dcoms.domain.Order;
import com.dcoms.service.IKitchenService;
import com.dcoms.service.IOrderService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KitchenService extends UnicastRemoteObject implements IKitchenService {

    private static List<Order> OnGoingOrder = new ArrayList<>();
    private static List<Order> FinishedOrder = new ArrayList<>();
    private static List<Order> CancelledOrder = new ArrayList<>();

    private IOrderService iOrderService;

    public KitchenService() throws RemoteException {
        super();
    }

    public void setiOrderService(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    public void addOrder(Order order) {
        OnGoingOrder.add(order);
    }

    @Override
    public boolean completeOrder(Order order) throws RemoteException {
        try {
            FinishedOrder.add(getAndDeleteOrder(order));
            iOrderService.orderComplete(order);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Order> getOnGoingOrder() {
        return OnGoingOrder;
    }

    @Override
    public void cancelOrder(Order order) throws RemoteException {
        CancelledOrder.add(getAndDeleteOrder(order));
        iOrderService.cancelOrder(order);
    }

    @Override
    public boolean isOrderComplete(Order order) throws RemoteException {
        if (FinishedOrder.contains(order)){
            return true;
        }else{
            if (!OnGoingOrder.contains(order)){
                throw new RuntimeException("ORDER MISSING !!!!!");
            }else{
                return false;    
            }
        }
    }

    private Order getAndDeleteOrder(Order order) {
        Order result = null;
        
        for (Iterator<Order> iterator = OnGoingOrder.iterator(); iterator.hasNext();) {
            Order orderInLoop = iterator.next();
            
            if (orderInLoop.equals(order)) {
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
}
