package com.dcoms.service.impl;

import com.dcoms.dao.IFoodDao;
import com.dcoms.domain.Food;
import com.dcoms.service.IFoodService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FoodService extends UnicastRemoteObject implements IFoodService {

    private IFoodDao iFoodDao;

    public FoodService() throws RemoteException  {
        super();
    }

    @Override
    public void setIFoodDao(IFoodDao iFoodDao) throws RemoteException {
        this.iFoodDao = iFoodDao;
    }

    @Override
    public List<Food> findAllFood() throws RemoteException {
        return iFoodDao.findAllFood();
    }

    @Override
    public List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound) throws RemoteException  {
        return iFoodDao.findFoodByPriceRange(upperBound,lowerBound);
    }

    @Override
    public List<Food> findFoodByKeyword(String keyword) throws RemoteException  {
        return iFoodDao.findFoodByKeyword(keyword);
    }

    @Override
    public Food findFoodById(String id) throws RemoteException {
        return iFoodDao.findFoodById(id);
    }
}
