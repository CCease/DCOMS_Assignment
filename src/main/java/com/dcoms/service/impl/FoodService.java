package com.dcoms.service.impl;

import com.dcoms.dao.IFoodDao;
import com.dcoms.domain.Food;
import com.dcoms.service.IFoodService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FoodService extends UnicastRemoteObject implements IFoodService {

    private IFoodDao iFoodDao;

    public FoodService(IFoodDao iFoodDao) throws RemoteException {
        super();
        this.iFoodDao = iFoodDao;
    }

    @Override
    public List<Food> findAllFood() {
        return iFoodDao.findAllFood();
    }

    @Override
    public List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound) {
        return iFoodDao.findFoodByPriceRange(upperBound,lowerBound);
    }

    @Override
    public List<Food> findFoodByKeyword(String keyword) {
        return iFoodDao.findFoodByKeyword(keyword);
    }
}
