package com.dcoms.service;

import com.dcoms.dao.IFoodDao;
import com.dcoms.domain.Food;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IFoodService extends Remote {

    void setIFoodDao(IFoodDao iFoodDao) throws RemoteException;

    List<Food> findAllFood() throws RemoteException;

    List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound) throws RemoteException;

    List<Food> findFoodByKeyword(String keyword) throws RemoteException;

    Food findFoodById(String id) throws RemoteException;

}
