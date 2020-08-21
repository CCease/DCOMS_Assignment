package com.dcoms.service;

import com.dcoms.domain.Food;

import java.rmi.Remote;
import java.util.List;

public interface IFoodService extends Remote {

    List<Food> findAllFood();

    List<Food> findFoodByPriceRange(Double upperBound, Double lowerBound);

    List<Food> findFoodByKeyword(String keyword);

}
